package tests;

import model.GroupDate;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class GroupTests extends TestBase {

    @Test
    @Order(0)
    public void canCreateGroup() {
        TestBase.app.openGroupsPage();
        TestBase.app.createGroup(new GroupDate("name", "header", "footer"));
    }

    @Test
    @Order(1)
    public void canCreateGroupWithNameOnly() {
        TestBase.app.openGroupsPage();
        var emptyGroup = new GroupDate();
        var groupWithNameOnly = emptyGroup.withName("name");
        TestBase.app.createGroup(groupWithNameOnly);
    }

    @Test
    @Order(2)
    public void canDeleteGroup() {
        TestBase.app.openGroupsPage();
        TestBase.app.deleteGroup();
    }
}