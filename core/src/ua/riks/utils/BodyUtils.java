package ua.riks.utils;

/**
 * Created by Riks on 25.10.2017.
 */

import com.badlogic.gdx.physics.box2d.Body;

import ua.riks.enums.UserDataType;
import ua.riks.userdata.UserData;


public class BodyUtils {

    public static boolean bodyIsBall(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.BALL;
    }
    public static boolean bodyIsFloor(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.FLOOR;
    }
    public static boolean bodyIsRoof(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.ROOF;
    }
    public static boolean bodyIsWall(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.WALL;
    }
    public static boolean bodyIsSlider(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.SLIDER;
    }
    public static boolean bodyIsBrick(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.BRICK;
    }
}