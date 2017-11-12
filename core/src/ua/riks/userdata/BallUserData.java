package ua.riks.userdata;

import com.badlogic.gdx.math.Vector2;

import ua.riks.enums.UserDataType;

/**
 * Created by Riks on 25.10.2017.
 */

public class BallUserData extends UserData {

    private Vector2 linearVelocity;

    public BallUserData(){
        super();
        userDataType = UserDataType.BALL;
    }
    public void setLinearVelocity(Vector2 linearVelocity) {
        this.linearVelocity = linearVelocity;
    }

    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }
}
