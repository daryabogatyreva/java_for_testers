package tests.Groups;

import model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GroupRemovalTests extends TestBase {

    @Test
    public void canDeleteGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupDate("name", "header", "footer"));
        }
        int groupCount = app.groups().getCount();
        app.groups().deleteGroup();
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount - 1, newGroupCount);
    }

    @Test
    void canDeleteAllGroupsAtOnce() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupDate("name", "header", "footer"));
        }
        app.groups().deleteAllGroups();
        Assertions.assertEquals(0, app.groups().getCount());
    }
}
