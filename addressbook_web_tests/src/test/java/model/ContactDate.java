package model;

public record ContactDate (String id, String firstName, String middleName, String lastName, String nickName) {

    public ContactDate() {
        this("", "", "", "", "");
    }
    public ContactDate withId (String id) {
        return new ContactDate (id, this.firstName, this.lastName, this.middleName, this.nickName);
    }

    public ContactDate withFirstName (String firstName) {
        return new ContactDate (this.id, firstName, this.lastName, this.middleName, this.nickName);
    }

    public ContactDate withMiddleName (String middleName) {
        return new ContactDate (this.id, middleName, this.lastName, this.firstName, this.nickName);
    }

    public ContactDate withLastName (String lastName) {
        return new ContactDate (this.id, lastName, this.firstName, this.middleName, this.nickName);
    }

    public ContactDate withNickName (String nickName) {
        return new ContactDate (this.id, nickName, this.lastName, this.middleName, this.firstName);
    }
}
