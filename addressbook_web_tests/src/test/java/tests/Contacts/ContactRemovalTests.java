package tests.Contacts;

import model.ContactDate;
import model.GroupDate;
import org.junit.jupiter.api.Test;
import tests.Groups.TestBase;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canDeleteContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactDate("name", "last", "middle", "nick"));
        }
        app.contacts().deleteContact();
    }
}
