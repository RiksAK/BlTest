package ua.riks.objects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


/**
 * Created by Riks on 04.10.2017.
 */

public class GameWorld {

    private static final String TAG = "GameWorld";
    private float defX = Gdx.graphics.getWidth()/32;
    private float defY = Gdx.graphics.getHeight()/52;
    private float offsetX = Gdx.graphics.getWidth()/2;
    private float offsetY = Gdx.graphics.getHeight()/2;
    public GameContactListener gameContactListener;
    public World world;
    public Body bodyFloor;
    public Body bodyWallLeft;
    public Body bodyWallRight;
    public Body bodyRoof;
    public Body bodyBall;
    public Body bodyk;
    public Body bodySlider;
    public Body bodyBrick;
    public Sprite ballSprite;
    public Sprite wallSprite;
    public Sprite sliderSprite;
    public Sprite brickSprite;
    public boolean win = false;





    public GameWorld(){
        world = new World(new Vector2(0,-5f), true);
        gameContactListener = new GameContactListener(this);
        world.setContactListener(gameContactListener);
        createFloor();
        createWallLeft();
        createWallRight();
        createRoof();
        createSlider();
        createBall();
        //createMovingObject();
        //createBrick();

    }

    private void createFloor() {

        // create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0, -26);

        // add it to the world
        bodyFloor = world.createBody(bodyDef);

        // set the shape (here we use a box 50 meters wide, 1 meter tall )
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(30, 2f);

        // create the physical object in our body)
        // without this our body would just be data in the world
        bodyFloor.createFixture(shape, 0.0f);

        // we no longer use the shape object here so dispose of it.
        shape.dispose();
    }
    private void createRoof(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0, 25);


        bodyRoof = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(29, 3f);

        bodyRoof.createFixture(shape, 0.0f);

        shape.dispose();
    }

    private void createWallLeft(){
        wallSprite = new Sprite();
        //wallSprite.setOriginCenter();
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(-16, 0);

        bodyWallLeft = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(0.5f, 30);

        bodyWallLeft.createFixture(shape, 0.0f);
        bodyWallLeft.setUserData(wallSprite);
        shape.dispose();
    }

    private void createWallRight(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(16, 0);

        bodyWallRight = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(0.5f, 30);

        bodyWallRight.createFixture(shape, 0.0f);

        shape.dispose();
    }

    private void createSlider(){
        sliderSprite = new Sprite();
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(0, -22);

        bodySlider = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(5f, 1f);

        bodySlider.createFixture(shape, 0.0f);
        bodySlider.setUserData(sliderSprite);

        shape.dispose();
    }



    private void createBall(){

        ballSprite = new Sprite();


        //create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0,0);


        // add it to the world
        bodyBall = world.createBody(bodyDef);
        // set the shape (here we use a box 50 meters wide, 1 meter tall )
        CircleShape shape = new CircleShape();
        shape.setRadius(1f);


        // set the properties of the object ( shape, weight, restitution(bouncyness)
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 2f;
        fixtureDef.restitution =1f;
        fixtureDef.friction = 1f;

        // create the physical object in our body)
        // without this our body would just be data in the world
        bodyBall.setLinearVelocity(0f, -5f);
        bodyBall.createFixture(fixtureDef);
        bodyBall.setUserData(ballSprite);

       // Gdx.app.log(TAG,"BallActor");
        // we no longer use the shape object here so dispose of it.
        shape.dispose();

    }

    private void createMovingObject(){

        //create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0,-5);


        // add it to the world
        bodyk = world.createBody(bodyDef);

        // set the shape (here we use a box 50 meters wide, 1 meter tall )
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(1,1);

        // set the properties of the object ( shape, weight, restitution(bouncyness)
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.restitution = 1f;

        // create the physical object in our body)
        // without this our body would just be data in the world
        bodyk.createFixture(fixtureDef);

        // we no longer use the shape object here so dispose of it.
        shape.dispose();

        bodyk.setLinearVelocity(-5f, 30f);
       // bodyk.applyLinearImpulse(new Vector2(0,5f),new Vector2(0,0), true);
    }

    public Body getBodyBrick(float posX, float posY){

        // create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;

        bodyDef.position.set(posX, posY);

        // add it to the world
        Body body  = world.createBody(bodyDef);

        // set the shape (here we use a box 50 meters wide, 1 meter tall )
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(2.5f, 1f);

        // create the physical object in our body)
        // without this our body would just be data in the world
        body.createFixture(shape, 0.0f);
        body.getFixtureList().get(0).setUserData("bb");

        // we no longer use the shape object here so dispose of it.
        shape.dispose();
        return body;
    }




    // our game logic here
    public void logicStep(float delta){

        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            bodySlider.setTransform((touchPos.x - offsetX)/ defX, -22, 0);
        }
        world.step(delta , 3, 3);
    }

}





