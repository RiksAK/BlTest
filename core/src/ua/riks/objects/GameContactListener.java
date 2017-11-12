package ua.riks.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.WorldManifold;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

import ua.riks.screens.PlayScreen;

/**
 * Created by Riks on 03.10.2017.
 */

public class GameContactListener implements ContactListener {


    private static final String TAG = "GameWorld";
    private GameWorld model;
    private PlayScreen screen;
    private int count;
    private Array<Body> bodiesArr = new Array<Body>();



    public GameContactListener(GameWorld parent){
        this.model = parent;
    }

    private void  ChangeScr(){model.win = true;}

    @Override
    public void beginContact(Contact contact) {

        if (contact.getFixtureA().getBody().getUserData() == model.sliderSprite && contact.getFixtureB().getBody().getUserData() == model.ballSprite) {
            //Gdx.app.log(TAG, "Contact1");
            Vector2 maxVelocity = new Vector2(60f, 60f);
            Vector2 velocity = model.bodyBall.getLinearVelocity();
            model.bodyBall.setLinearVelocity(velocity.x, velocity.y*1.5f);
            model.bodyBall.applyLinearImpulse(10f, -10f, model.bodyBall.getPosition().x, model.bodyBall.getPosition().y, true);
            if(Math.abs(velocity.y) > Math.abs(maxVelocity.y)){
                model.bodyBall.setLinearVelocity(velocity.x, velocity.y/1.5f);}
        }
        if (contact.getFixtureB().getBody().getUserData() == model.ballSprite) {
          //  Gdx.app.log(TAG, "Contact");
        }

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        WorldManifold manifold = contact.getWorldManifold();
        for(int j = 0; j < manifold.getNumberOfContactPoints(); j++) {

        }
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

        Body body = null;
        Actor actor = null;
        Sprite sprite = null;
        int id = 0;
        if((contact.getFixtureA() != null) && (contact.getFixtureA().getUserData() != null)  &&  (contact.getFixtureA().getBody().getFixtureList().get(0).getUserData().equals("bb")) ) {
            body = contact.getFixtureA().getBody();
            Gdx.app.log(TAG, "Contact11");
            Gdx.app.log(TAG, Integer.toString(count));
            if(count == 1){
                ChangeScr();
            }
        }
            //id = contact.getFixtureA().getBody().getUserData();
           // actor = screen.brickActor;

        if((contact.getFixtureB() != null) && (contact.getFixtureB().getUserData() != null)  && (contact.getFixtureB().getBody().getFixtureList().get(0).getUserData().equals("bb"))) {
            body = contact.getFixtureB().getBody();
            Gdx.app.log(TAG, "Contact22");
        }
        if(body != null){
          count = 0;
          sprite = (Sprite) body.getUserData();
            body.setActive(false);
            sprite.setAlpha(0);

            model.world.destroyBody(body);
            model.world.getBodies(bodiesArr);
            for (Body b : bodiesArr) {
                // Get the body's user data - in this example, our user
                // data is an instance of the Entity class

                String e = (String)  b.getFixtureList().get(0).getUserData();;

                if (e == "bb") {
                    count = count + 1;

                }
            }

        }
    }
}
