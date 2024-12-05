package ru.stqa.mantis.model;

import io.swagger.client.model.AccessLevel;

public record UserData(String realName, String userName, String password, String email, Boolean enabled,
                       AccessLevel accessLevel) {
    public UserData() {
        this("", "", "", "", true, null);
    }

    public UserData withRealName(String realName) {
        return new UserData(realName, this.userName, this.password, this.email, true, null);
    }

    public UserData withUserName(String userName) {
        return new UserData(this.realName, userName, this.password, this.email, true, null);
    }

    public UserData withPassword(String password) {
        return new UserData(this.realName, this.userName, password, this.email, true, null);
    }

    public UserData withEmail(String email) {
        return new UserData(this.realName, this.userName, this.password, email, true, null);
    }
}
