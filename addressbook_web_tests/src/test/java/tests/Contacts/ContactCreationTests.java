package tests.Contacts;

import model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tests.Groups.TestBase;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactDate> contactProvider() {
        var result = new ArrayList<ContactDate>();
        for (var firstName : List.of("", "contact name")) {
            for (var lastName : List.of("", "contact lastName")) {
                for (var middleName : List.of("", "contact middleName")) {
                    for (var nickName : List.of("", "contact nickName")) {
                        result.add(new ContactDate(firstName, lastName, middleName, nickName));
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactDate(randomString(i), randomString(i), randomString(i), randomString(i)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactDate contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }
}
