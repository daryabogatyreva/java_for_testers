package tests.Contacts;

import model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test
    void testContactInfo() {
        var contacts = app.hbm().getContactList();
        var expectedPhones = contacts.stream().collect(Collectors.toMap(ContactDate::id, ContactInfoTests::phonesStream));
        var expectedAddress = contacts.stream().collect(Collectors.toMap(ContactDate::id, ContactInfoTests::addressStream));
        var expectedEmails = contacts.stream().collect(Collectors.toMap(ContactDate::id, ContactInfoTests::emailsStream));
        var phones = app.contacts().getPhones();
        var address = app.contacts().getAddresses();
        var emails = app.contacts().getEmails();
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedPhones, phones),
                () -> Assertions.assertEquals(expectedAddress, address),
                () -> Assertions.assertEquals(expectedEmails, emails)
        );
    }

    private static String phonesStream(ContactDate contact) {
        return Stream.of(contact.home(), contact.mobile(), contact.work(), contact.phone2())
                     .filter(s -> s != null && !s.isEmpty())
                     .collect(Collectors.joining("\n"));
    }

    private static String addressStream(ContactDate contact) {
        return Stream.of(contact.address())
                     .filter(s -> s != null && !s.isEmpty())
                     .collect(Collectors.joining());
    }

    private static String emailsStream(ContactDate contact) {
        return Stream.of(contact.email(), contact.email2(), contact.email3())
                     .filter(s -> s != null && !s.isEmpty())
                     .collect(Collectors.joining("\n"));
    }
}
