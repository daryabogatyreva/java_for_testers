package model;

public record ContactDate (String firstName, String middleName, String lastName, String nickName) {

    public ContactDate() {
        this("", "", "", "");
    }

    public ContactDate withFirstName (String firstName) {
        return new ContactDate (firstName, this.lastName, this.middleName, this.nickName);
    }

    public ContactDate withMiddleName (String middleName) {
        return new ContactDate (middleName, this.lastName, this.firstName, this.nickName);
    }

    public ContactDate withLastName (String lastName) {
        return new ContactDate (lastName, this.firstName, this.middleName, this.nickName);
    }

    public ContactDate withNickName (String nickName) {
        return new ContactDate (nickName, this.lastName, this.middleName, this.firstName);
    }
}
