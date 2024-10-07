package manager;

import model.GroupDate;
import org.openqa.selenium.By;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }
    public void createGroup(GroupDate group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returntGroupsPage();
    }

    public void deleteGroup() {
        openGroupsPage();
        selectGroup();
        removeSelectedGroup();
        returntGroupsPage();
    }

    public void modifyGroup(GroupDate modifyGroup) {
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(modifyGroup);
        submitGroupModification();
        returntGroupsPage();
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void initGroupCreation() {
        click(By.name("new"));
    }

    private void removeSelectedGroup() {
        click(By.name("delete"));
    }

    public boolean isGroupPresent() {
        openGroupsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }
    
    private void returntGroupsPage() {
        click(By.linkText("group page"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void fillGroupForm(GroupDate group) {
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
    }

    private void initGroupModification() {
        click(By.name("edit"));
    }

    private void selectGroup() {
        click(By.name("selected[]"));
    }

}
