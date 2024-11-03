package manager;

import model.GroupDate;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcHelper extends HelperBase {

    public JdbcHelper(ApplicationManager manager) {
        super(manager);
    }

    public List<GroupDate> getGroupList() {
        var groups = new ArrayList<GroupDate>();
        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statment = conn.createStatement();
             var result = statment.executeQuery("SELECT group_id, group_name, group_header, group_footer FROM group_list")) {
            while (result.next()) {
                groups.add(new GroupDate()
                        .withId(result.getString("group_id"))
                        .withName(result.getString("group_name"))
                        .withHeader(result.getString("group_header"))
                        .withFooter(result.getString("group_footer")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }

    public void checkConsistency() {
        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statment = conn.createStatement();
             var result = statment.executeQuery(
                     "SELECT * FROM `address_in_groups` ag LEFT JOIN `addressbook` ab ON ab.id = ag.id WHERE ab.id is NULL")) {
            if (result.next()) {
                throw new IllegalStateException("DB is corrupted");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
