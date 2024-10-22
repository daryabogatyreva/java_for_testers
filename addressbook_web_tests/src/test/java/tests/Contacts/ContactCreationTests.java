package tests.Contacts;

import common.Common;
import model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tests.TestBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactDate> contactProvider() {
        var result = new ArrayList<ContactDate>();
        for (var firstName : List.of("", "name")) {
            for (var lastName : List.of("", "lastName")) {
                        result.add(new ContactDate()
                                .withFirstName(firstName)
                                .withLastName(lastName)
                                .withMiddleName("")
                                .withNickName("")
                                .withPhoto("src/test/resources/images/ava.png"));
                    }
                }
        for (int i = 0; i < 20; i++) {
            result.add(new ContactDate()
                    .withFirstName(Common.randomString(i))
                    .withLastName(Common.randomString(i))
                    .withMiddleName(Common.randomString(i))
                    .withNickName(Common.randomString(i))
                    .withPhoto(randomFile("src/test/resources/images")));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactDate contact) {
        var oldContactList = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContactList = app.contacts().getList();
        oldContactList.forEach(c -> c.withPhoto(""));
        newContactList.forEach(c -> c.withPhoto(""));
        Comparator<ContactDate> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        oldContactList.sort(compareById);
        newContactList.sort(compareById);
        var expectedList = new ArrayList<>(oldContactList);
        expectedList.add(contact
                .withId(newContactList.get(newContactList.size() - 1).id())
                .withMiddleName("")
                .withNickName("")
                .withPhoto(""));
        Assertions.assertEquals(newContactList, expectedList);
    }
}
