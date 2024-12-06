package manager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "addressbook")
public class ContactRecord {

    @Id
    public int id;
    public String firstname;
    public String lastname;
    public String middlename;
    public String nickname;
    public String company = "компания";
    public String title = "название";
    public String address;
    public String home = "";
    public String mobile = "";
    public String work = "";
    public String phone2 = "";
    public String fax = "-";
    public String homepage = "-";

    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String lastname, String middlename, String nickname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.nickname = nickname;
    }
}
