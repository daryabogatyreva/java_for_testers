package manager;

import model.ContactDate;
import org.openqa.selenium.By;

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

    public void deleteContact() {
        openHomePage();
        selectContact();
        removeSelectedContact();
        openHomePage();
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
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
}
