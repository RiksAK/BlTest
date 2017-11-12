package ua.riks.utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import ua.riks.userdata.BallUserData;
import ua.riks.userdata.BrickUserData;
import ua.riks.userdata.FloorUserData;
import ua.riks.userdata.RoofUserData;
import ua.riks.userdata.SliderUserData;
import ua.riks.userdata.WallUserData;

/**
 * Created by Riks on 22.10.2017.
 */

public class WorldUtils {

    public static World createWorld(){
        return new World(GlobalConstants.WORLD_GRAVITY, true);
    }

    public static Body createRoof(World world){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(GlobalConstants.ROOF_POSITION);
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(GlobalConstants.ROOF_WIDTH, GlobalConstants.ROOF_HEIGHT);
        body.createFixture(shape, GlobalConstants.ROOF__DENSITY);
        body.setUserData(new RoofUserData());
        shape.dispose();
        return body;
    }

    public static Body createFloor(World world) {
        // create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(GlobalConstants.FLOOR_POSITION);
        // add it to the world
        Body body = world.createBody(bodyDef);
        // set the shape (here we use a box )
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(GlobalConstants.FLOOR_WIDTH, GlobalConstants.FLOOR_HEIGHT);
        // create the physical object in our body)
        // without this our body would just be data in the world
        body.createFixture(shape, GlobalConstants.FLOOR_DENSITY);
        // we no longer use the shape object here so dispose of it.
        body.setUserData(new FloorUserData());
        shape.dispose();
        return body;
    }

    public static Body createWallLeft(World world){
        // create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(GlobalConstants.WALL_LEFT_POSITION);
        // add it to the world
        Body body = world.createBody(bodyDef);
        // set the shape (here we use a box )
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(GlobalConstants.WALL_LEFT_WIDTH, GlobalConstants.WALL_LEFT_HEIGHT);
        // create the physical object in our body)
        // without this our body would just be data in the world
        body.createFixture(shape, GlobalConstants.WALL_LEFT_DENSITY);
        // we no longer use the shape object here so dispose of it.
        body.setUserData(new WallUserData());
        shape.dispose();
        return body;
    }

    public static Body createWallRight(World world){
        // create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(GlobalConstants.WALL_RIGHT_POSITION);
        // add it to the world
        Body body = world.createBody(bodyDef);
        // set the shape (here we use a box )
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(GlobalConstants.WALL_RIGHT_WIDTH, GlobalConstants.WALL_RIGHT_HEIGHT);
        // create the physical object in our body)
        // without this our body would just be data in the world
        body.createFixture(shape, GlobalConstants.WALL_RIGHT_DENSITY);
        // we no longer use the shape object here so dispose of it.
        body.setUserData(new WallUserData());
        shape.dispose();
        return body;
    }

    public static Body createSlider(World world){
        // create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(GlobalConstants.SLIDER_POSITION);
        // add it to the world
        Body body = world.createBody(bodyDef);
        // set the shape (here we use a box )
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(GlobalConstants.SLIDER_WIDTH, GlobalConstants.SLIDER_HEIGHT);
        // create the physical object in our body)
        // without this our body would just be data in the world
        body.createFixture(shape, GlobalConstants.SLIDER_DENSITY);
        // we no longer use the shape object here so dispose of it.
        body.setUserData(new SliderUserData());
        shape.dispose();
        return body;
    }

    public static Body createBall(World world){
        //create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(GlobalConstants.BALL_POSITION);
        // add it to the world
        Body body = world.createBody(bodyDef);
        // set the shape (here we use a box 50 meters wide, 1 meter tall )
        CircleShape shape = new CircleShape();
        shape.setRadius(GlobalConstants.BALL_RADIUS);
        // set the properties of the object ( shape, weight, restitution(bouncyness)
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = GlobalConstants.BALL_DENSITY;
        fixtureDef.restitution =GlobalConstants.BALL_RESTITUTION;
        fixtureDef.friction = GlobalConstants.BALL_FRICTION;
        // create the physical object in our body)
        // without this our body would just be data in the world
        //body.setLinearVelocity(0f, -5f);
        body.createFixture(fixtureDef);
        // we no longer use the shape object here so dispose of it.
        body.setUserData(new BallUserData());
        shape.dispose();
        return body;
    }

    public static Body createBrick(World world ,float posX, float posY){

        // create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(posX, posY);
        // add it to the world
        Body body  = world.createBody(bodyDef);
        // set the shape (here we use a box 50 meters wide, 1 meter tall )
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(GlobalConstants.BRIK_WIDTH, GlobalConstants.BRIK_HEIGHT);
        // create the physical object in our body)
        // without this our body would just be data in the world
        body.createFixture(shape, GlobalConstants.BRIK_DENSITY);
        //body.getFixtureList().get(0).setUserData("bb");
        body.setUserData(new BrickUserData());
        // we no longer use the shape object here so dispose of it.
        shape.dispose();
        return body;
    }

}
