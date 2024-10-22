package tests.Contacts;

import model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {
    @Test
    void canModifyContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactDate(
                    "", "FName", "LName", "MName", "NName", ""));
        }
        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testDate = new ContactDate().withFirstName("modified FName");
        app.contacts().modifyContact(oldContacts.get(index), testDate);
        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testDate.withId(oldContacts.get(index).id()));
        Comparator<ContactDate> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }
}
