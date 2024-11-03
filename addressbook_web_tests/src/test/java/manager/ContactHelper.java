package manager;

import model.ContactDate;
import model.GroupDate;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public static Comparator<ContactDate> getContactDateComparator() {
        Comparator<ContactDate> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        return compareById;
    }

    public void create(ContactDate contact, GroupDate group) {
        openNewContactPage();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        openHomePage();
    }

    private void selectGroup(GroupDate group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
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
        attach(By.name("photo"), contact.photo());
    }

    private void openNewContactPage() {
        click(By.linkText("add new"));
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

    public void deleteContactFromGroup(ContactDate contact, GroupDate group) {
        openHomePage();
        selectGroupFromList(group);
        selectContact(contact);
        removeFromGroup();
    }

    private void removeFromGroup() {
        click(By.name("remove"));
    }

    private void selectGroupFromList(GroupDate group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }
}
