package model;

public record ContactDate (String id, String firstName, String lastName, String middleName, String nickName, String photo, String home,
                           String mobile, String work, String phone2) {

    public ContactDate() {
        this("", "", "", "", "", "", "", "", "", "");
    }
    public ContactDate withId (String id) {
        return new ContactDate (id, this.firstName, this.lastName, this.middleName, this.nickName, this.photo, this.home, this.mobile,
                                this.work, this.phone2);
    }

    public ContactDate withFirstName (String firstName) {
        return new ContactDate (this.id, firstName, this.lastName, this.middleName, this.nickName, this.photo, this.home, this.mobile,
                                this.work, this.phone2);
    }

    public ContactDate withMiddleName (String middleName) {
        return new ContactDate (this.id, this.firstName, this.lastName, middleName, this.nickName, this.photo, this.home, this.mobile,
                                this.work, this.phone2);
    }

    public ContactDate withLastName (String lastName) {
        return new ContactDate (this.id, this.firstName, lastName, this.middleName, this.nickName, this.photo, this.home, this.mobile,
                                this.work, this.phone2);
    }

    public ContactDate withNickName (String nickName) {
        return new ContactDate (this.id, this.firstName, this.lastName, this.middleName, nickName, this.photo, this.home, this.mobile,
                                this.work, this.phone2);
    }

    public ContactDate withPhoto (String photo) {
        return new ContactDate (this.id, this.firstName, this.lastName, this.middleName, this.nickName, photo, this.home, this.mobile,
                                this.work, this.phone2);
    }

    public ContactDate withHome (String home) {
        return new ContactDate (this.id, this.firstName, this.lastName, this.middleName, this.nickName, photo, "", this.mobile,
                                this.work, this.phone2);
    }

    public ContactDate withMobile (String mobile) {
        return new ContactDate (this.id, this.firstName, this.lastName, this.middleName, this.nickName, photo, this.home, "",
                                this.work, this.phone2);
    }

    public ContactDate withWork (String work) {
        return new ContactDate (this.id, this.firstName, this.lastName, this.middleName, this.nickName, photo, this.home, this.mobile,
                                "", this.phone2);
    }

    public ContactDate withSecondary (String secondary) {
        return new ContactDate (this.id, this.firstName, this.lastName, this.middleName, this.nickName, photo, this.home, this.mobile,
                                this.work, "");
    }
}
