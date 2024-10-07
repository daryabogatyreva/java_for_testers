package tests.Groups;

import model.GroupDate;
import org.junit.jupiter.api.Test;


public class GroupRemovalTests extends TestBase {

    @Test
    public void canDeleteGroup() {
        if (!app.groups().isGroupPresent()) {
            app.groups().createGroup(new GroupDate("name", "header", "footer"));
        }
        app.groups().deleteGroup();
    }
}
