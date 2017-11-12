package ua.riks.userdata;

import ua.riks.enums.UserDataType;

/**
 * Created by Riks on 25.10.2017.
 */

public class WallUserData extends UserData {
    public WallUserData(){
        super();
        userDataType = UserDataType.WALL;
    }
}
