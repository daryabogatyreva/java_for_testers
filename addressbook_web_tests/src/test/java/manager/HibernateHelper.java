package manager;


import io.qameta.allure.Step;
import model.ContactDate;
import model.GroupDate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.stream.Collectors;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager manager) {
        super(manager);
        sessionFactory = new Configuration()
                .addAnnotatedClass(ContactRecord.class)
                .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook?zeroDateTimeBehavior=convertToNull")
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    static List<GroupDate> convertGroupList(List<GroupRecord> records) {
        return records.stream().map(HibernateHelper::convert).collect(Collectors.toList());
    }

    private static GroupDate convert(GroupRecord record) {
        return new GroupDate("" + record.id, record.name, record.header, record.footer);
    }

    private static GroupRecord convert(GroupDate data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }

    public List<GroupDate> getGroupList() {
        return convertGroupList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }

    public long getGroupCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupRecord", Long.class).getSingleResult();
        });
    }

    public void createGroup(GroupDate groupDate) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(groupDate));
            session.getTransaction().commit();
        });
    }

    static List<ContactDate> convertContactList(List<ContactRecord> records) {
        return records.stream().map(HibernateHelper::convert).collect(Collectors.toList());
    }

    private static ContactDate convert(ContactRecord record) {
        return new ContactDate("" + record.id,
                               record.firstname,
                               record.lastname,
                               record.middlename,
                               record.nickname,
                               record.home,
                               record.mobile,
                               record.work,
                               record.phone2,
                               record.address);
    }

    private static ContactRecord convert(ContactDate data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new ContactRecord(Integer.parseInt(id),
                data.firstName(),
                data.lastName(),
                data.middleName(),
                data.nickName());
    }

    public List<ContactDate> getContactsInGroup(GroupDate group) {
        return sessionFactory.fromSession(session -> {
            return convertContactList(session.get(GroupRecord.class, group.id()).contacts);
        });
    }

    @Step
    public List<ContactDate> getContactList() {
        return convertContactList(sessionFactory.fromSession(session -> {
            return session.createQuery("from ContactRecord", ContactRecord.class).list();
        }));
    }

    public long getContactsCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from ContactRecord", Long.class).getSingleResult();
        });
    }

    public void createContact(ContactDate contactDate) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(contactDate));
            session.getTransaction().commit();
        });
    }
}
