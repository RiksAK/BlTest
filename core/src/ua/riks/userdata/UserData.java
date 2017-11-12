package ua.riks.userdata;

import ua.riks.enums.UserDataType;

/**
 * Created by Riks on 25.10.2017.
 */

public abstract class UserData {
    protected UserDataType userDataType;

    public UserData() {

    }

    public UserDataType getUserDataType() {
        return userDataType;
    }

}
