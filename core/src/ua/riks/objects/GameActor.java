package ua.riks.objects;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ua.riks.userdata.UserData;

/**
 * Created by Riks on 22.10.2017.
 */

public abstract class GameActor extends Actor {

    protected Body body;
    protected UserData userData;

    public GameActor(Body body) {
        this.body = body;
        this.userData = (UserData) body.getUserData();
    }

    public abstract UserData getUserData();

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
