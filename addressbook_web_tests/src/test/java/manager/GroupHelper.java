package manager;

import model.GroupDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }
    public void createGroup(GroupDate group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnGroupsPage();
    }

    public void deleteGroup(GroupDate group) {
        openGroupsPage();
        selectGroup(group);
        removeSelectedGroups();
        returnGroupsPage();
    }

    public void modifyGroup(GroupDate group, GroupDate modifyGroup) {
        openGroupsPage();
        selectGroup(group);
        initGroupModification();
        fillGroupForm(modifyGroup);
        submitGroupModification();
        returnGroupsPage();
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

    private void removeSelectedGroups() {
        click(By.name("delete"));
    }
    
    private void returnGroupsPage() {
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

    private void selectGroup(GroupDate group) {
        click(By.cssSelector(String.format("input[value='%s']", group.id())));
    }

    public int getCount() {
        openGroupsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void deleteAllGroups() {
        openGroupsPage();
        selectAllGroups();
        removeSelectedGroups();
    }

    private void selectAllGroups() {
        manager.driver
                .findElements(By.name("selected[]"))
                .forEach(WebElement::click);
    }

    public List<GroupDate> getList() {
        openGroupsPage();
        var spans = manager.driver.findElements(By.cssSelector("span.group"));
        return spans.stream()
             .map(span -> {
                 var name = span.getText();
                 var checkbox = span.findElement(By.name("selected[]"));
                 var id = checkbox.getAttribute("value");
                 return new GroupDate().withId(id).withName(name);
             })
                .collect(Collectors.toList());
    }
}
