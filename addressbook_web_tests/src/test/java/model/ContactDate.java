package model;

public record ContactDate(String id, String firstName, String lastName, String middleName, String nickName, String photo, String home,
                          String mobile, String work, String phone2, String address, String email, String email2, String email3) {

    public ContactDate() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactDate withId(String id) {
        return new ContactDate(id, this.firstName, this.lastName, this.middleName, this.nickName, this.photo, this.home, this.mobile,
                               this.work, this.phone2, this.address, this.email, this.email2, this.email3);
    }

    public ContactDate withFirstName(String firstName) {
        return new ContactDate(this.id, firstName, this.lastName, this.middleName, this.nickName, this.photo, this.home, this.mobile,
                               this.work, this.phone2, this.address, this.email, this.email2, this.email3);
    }

    public ContactDate withMiddleName(String middleName) {
        return new ContactDate(this.id, this.firstName, this.lastName, middleName, this.nickName, this.photo, this.home, this.mobile,
                               this.work, this.phone2, this.address, this.email, this.email2, this.email3);
    }

    public ContactDate withLastName(String lastName) {
        return new ContactDate(this.id, this.firstName, lastName, this.middleName, this.nickName, this.photo, this.home, this.mobile,
                               this.work, this.phone2, this.address, this.email, this.email2, this.email3);
    }

    public ContactDate withNickName(String nickName) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, nickName, this.photo, this.home, this.mobile,
                               this.work, this.phone2, this.address, this.email, this.email2, this.email3);
    }

    public ContactDate withPhoto(String photo) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, "", this.home, this.mobile,
                               this.work, this.phone2, this.address, this.email, this.email2, this.email3);
    }

    public ContactDate withHome(String home) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, this.photo, "", this.mobile,
                               this.work, this.phone2, this.address, this.email, this.email2, this.email3);
    }

    public ContactDate withMobile(String mobile) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, this.photo, this.home, "",
                               this.work, this.phone2, this.address, this.email, this.email2, this.email3);
    }

    public ContactDate withWork(String work) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, this.photo, this.home, this.mobile,
                               "", this.phone2, this.address, this.email, this.email2, this.email3);
    }

    public ContactDate withPhone2(String phone2) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, this.photo, this.home, this.mobile,
                               this.work, "", this.address, this.email, this.email2, this.email3);
    }

    public ContactDate withAddress(String address) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, this.photo, this.home, this.mobile,
                               this.work, this.phone2, "", this.email, this.email2, this.email3);
    }

    public ContactDate withEmail(String email) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, this.photo, this.home, this.mobile,
                               this.work, this.phone2, this.address, "", this.email2, this.email3);
    }

    public ContactDate withEmail2(String email2) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, this.photo, this.home, this.mobile,
                               this.work, this.phone2, this.address, this.email, "", this.email3);
    }

    public ContactDate withEmail3(String email3) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, this.photo, this.home, this.mobile,
                               this.work, this.phone2, this.address, this.email, this.email2, "");
    }
}
