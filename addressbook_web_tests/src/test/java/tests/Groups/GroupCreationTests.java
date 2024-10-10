package tests.Groups;

import model.GroupDate;
import org.junit.jupiter.api.Test;


public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        app.groups().createGroup(new GroupDate("name", "header", "footer"));
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().createGroup(new GroupDate().withName("name"));
    }
}