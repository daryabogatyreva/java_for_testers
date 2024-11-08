package tests.Contacts;

import common.Common;
import model.ContactDate;
import model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

import static manager.ContactHelper.getContactDateComparator;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canDeleteContact() {
        if (app.hbm().getContactsCount() == 0) {
            app.hbm().createContact(new ContactDate("", "fName", "lName", "mName",
                                                    "nName", "", "", "", "", "",
                                                    "", "", "", ""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().deleteContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    public void canDeleteContactFromGroup(){
        var contact = new ContactDate()
                .withFirstName(Common.randomString(5))
                .withLastName(Common.randomString(5))
                .withPhoto(randomFile("src/test/resources/images"));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupDate("", "name", "header", "footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        app.contacts().create(contact, group);
        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().deleteContactFromGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Comparator<ContactDate> compareById = getContactDateComparator();
        oldRelated.sort(compareById);
        newRelated.sort(compareById);
        oldRelated = oldRelated.stream()
                .map(c -> c.withPhoto(""))
                .collect(Collectors.toList());
        newRelated = newRelated.stream()
                .map(c -> c.withPhoto(""))
                .collect(Collectors.toList());
        Assertions.assertEquals(oldRelated, newRelated);
    }
}
