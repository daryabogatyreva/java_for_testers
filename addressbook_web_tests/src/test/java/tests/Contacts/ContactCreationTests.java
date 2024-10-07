package tests.Contacts;

import model.ContactDate;
import org.junit.jupiter.api.Test;
import tests.Groups.TestBase;

public class ContactCreationTests  extends TestBase {

    @Test
    public void canCreateContact() {
        TestBase.app.contacts().createContact(
                new ContactDate("Name", "Last Name", "Middle", "Nick"));
    }

    @Test
    public void canCreateContactWithNameOnly() {
        TestBase.app.contacts().createContact(new ContactDate().withFirstName("OnlyName"));
    }
}
