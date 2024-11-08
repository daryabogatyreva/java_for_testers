package tests.Contacts;

import model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

import static manager.ContactHelper.getContactDateComparator;

public class ContactModificationTests extends TestBase {
    @Test
    void canModifyContact() {
        if (app.hbm().getContactsCount() == 0) {
            app.hbm().createContact(new ContactDate(
                    "", "FName", "LName", "MName", "NName", "", "", "", "", ""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testDate = new ContactDate().withFirstName("modified FName").withPhoto("src/test/resources/images/apple.jpg");
        app.contacts().modifyContact(oldContacts.get(index), testDate);
        var newContacts = app.hbm().getContactList();
        oldContacts.set(index, testDate.withId(oldContacts.get(index).id()));
        newContacts = newContacts.stream()
                .map(c -> c.withPhoto(""))
                .collect(Collectors.toList());
        oldContacts = oldContacts.stream()
                .map(c -> c.withPhoto(""))
                .collect(Collectors.toList());
        Comparator<ContactDate> compareById = getContactDateComparator();
        newContacts.sort(compareById);
        oldContacts.sort(compareById);
        Assertions.assertEquals(newContacts, oldContacts);
    }
}
