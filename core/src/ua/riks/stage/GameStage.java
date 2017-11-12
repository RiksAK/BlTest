package ua.riks.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import ua.riks.objects.Background;
import ua.riks.objects.BallActor;
import ua.riks.objects.BrickActor;
import ua.riks.objects.FloorActor;
import ua.riks.objects.SliderActor;
import ua.riks.objects.WallActor;
import ua.riks.utils.BodyUtils;
import ua.riks.utils.GlobalConstants;
import ua.riks.utils.WorldUtils;

/**
 * Created by Riks on 22.10.2017.
 */

public class GameStage extends Stage implements ContactListener {


    private static final int VIEWPORT_WIDTH = 32;
    private static final int VIEWPORT_HEIGHT = 54;

    //final MyGame game;
    public Background background;
    private World world;
    private FloorActor floorActor;
    private FloorActor roof;
    private WallActor wallActor;
    private SliderActor slider;
    private BallActor ballActor;
    private BrickActor brickActor;

    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;

    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;

    public GameStage() {
        setUpWorld();
        setupCamera();
        renderer = new Box2DDebugRenderer();

    }

    private void setUpSlider(){
        slider = new SliderActor(WorldUtils.createSlider(world));
        addActor(slider);
    }

    private void setUpWorld(){
        world = WorldUtils.createWorld();
        setUpBackground();
        setUpBrick();
        setUpBall();
        setUpWallLeft();
        setUpWallRight();
        setUpFloor();
        setUpRoof();
        setUpSlider();
    }

    private void setUpBackground(){
        background = new Background();
        background.setPosition(0, 0);
        addActor(background);
    }

    private void setUpRoof(){
        roof = new FloorActor(WorldUtils.createRoof(world), GlobalConstants.ROOF_WIDTH*2, GlobalConstants.ROOF_HEIGHT*2);
        addActor(roof);
    }

    private void setUpFloor(){
        floorActor = new FloorActor(WorldUtils.createFloor(world), GlobalConstants.FLOOR_WIDTH*2, GlobalConstants.FLOOR_HEIGHT*2);
        addActor(floorActor);

    }

    private void setUpWallLeft(){
        wallActor = new WallActor(WorldUtils.createWallLeft(world));
       addActor(wallActor);

    }

    private void setUpWallRight(){
        wallActor = new WallActor(WorldUtils.createWallRight(world));
        addActor(wallActor);
    }

    private void setUpBall(){
        ballActor = new BallActor(WorldUtils.createBall(world));
        addActor(ballActor);

    }

    private void setUpBrick(){
        Vector2 pos = new Vector2(-10f, 15f);
        int id = 0;
        for (int i=0; i<5; i++){

            brickActor = new BrickActor(WorldUtils.createBrick(world, pos.x, pos.y));
            pos.x +=5f;
            addActor(brickActor);
            id++;
        }
        pos.x = -10f;
        pos.y = 11f;
        for (int i=0; i<5; i++){

            brickActor = new BrickActor(WorldUtils.createBrick(world, pos.x, pos.y));
            pos.x +=5f;
            addActor(brickActor);
            id++;
        }
    }

    private void setupCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        //camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        // Fixed timestep
        accumulator += delta;

        while (accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }

        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            slider.moveSlider(touchPos);
           // bodySlider.setTransform((touchPos.x - offsetX)/ defX, -22, 0);
        }
        //TODO: Implement interpolation

    }

    @Override
    public void draw() {
        super.draw();
        renderer.render(world, camera.combined);
    }

    @Override
    public void beginContact(Contact contact) {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if(BodyUtils.bodyIsBall(a)&&BodyUtils.bodyIsSlider(b)|| BodyUtils.bodyIsSlider(a)&&BodyUtils.bodyIsBall(b)){

        }

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}



