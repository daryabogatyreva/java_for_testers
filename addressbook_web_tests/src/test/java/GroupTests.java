import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class GroupTests extends TestBase {

    @Test
    @Order(0)
    public void canCreateGroup() {
        openGroupsPage();
        createGroup();
    }

    @Test
    @Order(1)
    public void canDeleteGroup() {
        openGroupsPage();
        deleteGroup();
    }

}