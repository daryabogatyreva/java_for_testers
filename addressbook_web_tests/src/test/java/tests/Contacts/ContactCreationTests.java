package tests.Contacts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Common;
import manager.ContactHelper;
import model.ContactDate;
import model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tests.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import static manager.ContactHelper.getContactDateComparator;

public class ContactCreationTests extends TestBase {

    public static List<ContactDate> contactProvider() throws IOException {
        var result = new ArrayList<ContactDate>();
//        for (var firstName : List.of("", "name")) {
//            for (var lastName : List.of("", "lastName")) {
//                        result.add(new ContactDate()
//                                .withFirstName(firstName)
//                                .withLastName(lastName)
//                                .withMiddleName("")
//                                .withNickName("")
//                                .withPhoto("src/test/resources/images/ava.png"));
//                    }
//                }
//        for (int i = 0; i < 20; i++) {
//            result.add(new ContactDate()
//                    .withFirstName(Common.randomString(i))
//                    .withLastName(Common.randomString(i))
//                    .withMiddleName(Common.randomString(i))
//                    .withNickName(Common.randomString(i))
//                    .withPhoto(randomFile("src/test/resources/images")));
//        }
        var json = Files.readString(Paths.get("contacts.json"));
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<ContactDate>>() {
        });
        result.addAll(value);
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactDate contact) {
        var oldContactList = app.hbm().getContactList();
        app.hbm().createContact(contact);
        var newContactList = app.hbm().getContactList();
        oldContactList = oldContactList.stream()
                .map(c -> c.withPhoto(""))
                .collect(Collectors.toList());
        newContactList = newContactList.stream()
                .map(c -> c.withPhoto(""))
                .collect(Collectors.toList());
        Comparator<ContactDate> compareById = getContactDateComparator();
        oldContactList.sort(compareById);
        newContactList.sort(compareById);
        var expectedList = new ArrayList<>(oldContactList);
        expectedList.add(contact
                .withId(newContactList.get(newContactList.size() - 1).id())
                .withPhoto(""));
        Assertions.assertEquals(newContactList, expectedList);
    }

    @Test
    public void canCreateContactInGroup() {
        var contact = new ContactDate()
                .withFirstName(Common.randomString(5))
                .withLastName(Common.randomString(5))
                .withPhoto(randomFile("src/test/resources/images"));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupDate("", "name", "header", "footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().create(contact, group);
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
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }

    @Test
    public void addContactToGroup() {
        if (app.hbm().getContactsCount() == 0) {
            app.hbm().createContact(new ContactDate()
                                            .withFirstName(Common.randomString(5))
                                            .withLastName(Common.randomString(5)));
        }
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupDate().withName(Common.randomString(5))
                                                 .withHeader(Common.randomString(5))
                                                 .withFooter(Common.randomString(5)));
        }
        var rnd = new Random();
        var groupIndex = rnd.nextInt(app.hbm().getGroupList().size());
        var contactIndex = rnd.nextInt(app.hbm().getContactList().size());
        var group = app.hbm().getGroupList().get(groupIndex);
        var contact = app.hbm().getContactList().get(contactIndex);
        app.contacts().addContactToGroup(contact, group);
        Assertions.assertTrue(app.hbm().getContactsInGroup(group).contains(contact));
    }
}
