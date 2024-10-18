package tests.Contacts;

import model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tests.Groups.TestBase;

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
                                .withNickName(""));
                    }
                }
        for (int i = 0; i < 20; i++) {
            result.add(new ContactDate()
                    .withFirstName(randomString(i))
                    .withLastName(randomString(i))
                    .withMiddleName(randomString(i))
                    .withNickName(randomString(i)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactDate contact) {
        var oldContactList = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContactList = app.contacts().getList();
        Comparator<ContactDate> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContactList.sort(compareById);
        var expectedList = new ArrayList<>(oldContactList);
        expectedList.add(contact.withId(newContactList.get(newContactList.size() - 1).id()).withMiddleName("").withNickName(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContactList, expectedList);
    }
}
