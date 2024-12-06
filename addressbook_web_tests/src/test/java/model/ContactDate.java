package model;

public record ContactDate(String id, String firstName, String lastName, String middleName, String nickName, String home,
                          String mobile, String work, String phone2, String address) {

    public ContactDate() {
        this("", "", "", "", "", "", "", "", "", "");
    }

    public ContactDate withId(String id) {
        return new ContactDate(id, this.firstName, this.lastName, this.middleName, this.nickName, this.home, this.mobile,
                               this.work, this.phone2, this.address);
    }

    public ContactDate withFirstName(String firstName) {
        return new ContactDate(this.id, firstName, this.lastName, this.middleName, this.nickName, this.home, this.mobile,
                               this.work, this.phone2, this.address);
    }

    public ContactDate withMiddleName(String middleName) {
        return new ContactDate(this.id, this.firstName, this.lastName, middleName, this.nickName, this.home, this.mobile,
                               this.work, this.phone2, this.address);
    }

    public ContactDate withLastName(String lastName) {
        return new ContactDate(this.id, this.firstName, lastName, this.middleName, this.nickName, this.home, this.mobile,
                               this.work, this.phone2, this.address);
    }

    public ContactDate withNickName(String nickName) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, nickName, this.home, this.mobile,
                               this.work, this.phone2, this.address);
    }

    public ContactDate withHome(String home) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, "", this.mobile,
                               this.work, this.phone2, this.address);
    }

    public ContactDate withMobile(String mobile) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, this.home, "",
                               this.work, this.phone2, this.address);
    }

    public ContactDate withWork(String work) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, this.home, this.mobile,
                               "", this.phone2, this.address);
    }

    public ContactDate withPhone2(String phone2) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, this.home, this.mobile,
                               this.work, "", this.address);
    }

    public ContactDate withAddress(String address) {
        return new ContactDate(this.id, this.firstName, this.lastName, this.middleName, this.nickName, this.home, this.mobile,
                               this.work, this.phone2, address);
    }

}
