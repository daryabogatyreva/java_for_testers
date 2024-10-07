package tests;

import model.GroupDate;
import org.junit.jupiter.api.Test;


public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        TestBase.app.groups().createGroup(new GroupDate("name", "header", "footer"));
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        TestBase.app.groups().createGroup(new GroupDate().withName("name"));
    }
}