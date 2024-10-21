package manager;

import model.ContactDate;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }
    public void createContact(ContactDate contact) {
        openNewContactPage();
        fillContactForm(contact);
        submitContactCreation();
        openHomePage();
    }

    public void deleteContact(ContactDate contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContacts();
        openHomePage();
    }

    private void removeSelectedContacts() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void selectContact(ContactDate contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void openHomePage() {
        click(By.linkText("home"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void fillContactForm(ContactDate contact) {
        type(By.name("firstname"), contact.firstName());
        type(By.name("middlename"), contact.middleName());
        type(By.name("lastname"), contact.lastName());
        type(By.name("nickname"), contact.nickName());
    }

    private void openNewContactPage() {
        click(By.linkText("add new"));
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void initContactModification(ContactDate contact) {
        click(By.cssSelector(String.format("[href = 'edit.php?id=%s']", contact.id())));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    public List<ContactDate> getList() {
        var contacts = new ArrayList<ContactDate>();
        var rows = manager.driver.findElements(By.name("entry"));
        for (var row : rows) {
            var cells = row.findElements(By.tagName("td"));
            var firstName = cells.get(2).getText();
            var lastName = cells.get(1).getText();
            var checkbox = row.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("id");
            contacts.add(new ContactDate().withId(id).withFirstName(firstName).withLastName(lastName));
        }
        return contacts;
    }

    public void modifyContact(ContactDate contact, ContactDate modifyContact) {
        initContactModification(contact);
        fillContactForm(modifyContact);
        submitContactModification();
        openHomePage();
    }
}
