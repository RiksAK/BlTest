package ua.riks.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ua.riks.MyGame;
import ua.riks.objects.BallActor;
import ua.riks.objects.BrickActor;
import ua.riks.objects.FloorActor;
import ua.riks.objects.GameWorld;
import ua.riks.objects.SliderActor;
import ua.riks.objects.WallActor;
import ua.riks.stage.PlayStage;
import ua.riks.utils.GlobalConstants;

/**
 * Created by Riks on 27.09.2017.
 */

public class PlayScreen implements Screen {

    final MyGame game;
    public PlayStage stage;
    private static final int VIEWPORT_WIDTH = GlobalConstants.APP_WIDTH_MIN;
    private static final int VIEWPORT_HEIGHT = GlobalConstants.APP_HEIGHT_MIN;
    private Image imgslider;
    private BallActor ballActor;
    private WallActor wallActorLeft;
    private WallActor wallActorRight;
    private FloorActor floorActor;
    private FloorActor roof;
    public BrickActor brickActor;
    private SliderActor sliderActor;
    private GameWorld modelWorld;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera cam;
    private SpriteBatch batch;
    //private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;
    private SpriteBatch spriteBatch;
    public boolean win = false;



    public PlayScreen(final MyGame gam /*,String strLevel, String strNextLevel*/) {

        game = gam;


        //camera = new OrthographicCamera(GlobalConstants.APP_WIDTH_MIN, GlobalConstants.APP_HEIGHT_MIN);
        //renderer = new Box2DDebugRenderer(true,true,true,true,true,true);

        stage = new PlayStage(new ScreenViewport());
        //resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //Gdx.graphics.setWindowedMode(GlobalConstants.APP_WIDTH, GlobalConstants.APP_HEIGHT);
        //stage.getCamera();

        //stage.setVie

        stage.addActor(game.background);
        Skin skin = new Skin();
        //float w = GlobalConstants.APP_WIDTH;
       // float h = GlobalConstants.APP_HEIGHT;
        modelWorld = new GameWorld();
        cam = new OrthographicCamera(GlobalConstants.WORLD_TO_SCREEN_X, GlobalConstants.WORLD_TO_SCREEN_Y);
        //cam.position.set(GlobalConstants.WORLD_TO_SCREEN_X/2, GlobalConstants.WORLD_TO_SCREEN_Y/2, 0);
       // cam.setToOrtho(true, GlobalConstants.WORLD_TO_SCREEN_X, GlobalConstants.WORLD_TO_SCREEN_Y);
        //debugRenderer = new Box2DDebugRenderer(true,true,true,true,true,true);
        debugRenderer = new Box2DDebugRenderer(false,false,false,false,false,false);
        cam.update();
        //camera.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
        //camera.update();


        Texture texture = new Texture(Gdx.files.internal("wyvern.png"));

        Image image1 = new Image(texture);
        image1.setOrigin(image1.getWidth()/2,image1.getHeight()/2);
        image1.setPosition(Gdx.graphics.getWidth()/2-image1.getWidth()/2,Gdx.graphics.getHeight()/2-image1.getHeight()/2);

        stage.addActor(image1);



        ballActor = new BallActor(modelWorld.bodyBall);
        stage.addActor(ballActor);
        //stage.addActor(b);
        wallActorLeft = new WallActor(modelWorld.bodyWallLeft);
        stage.addActor(wallActorLeft);

        wallActorRight = new WallActor(modelWorld.bodyWallRight);
        stage.addActor(wallActorRight);

        floorActor = new FloorActor(modelWorld.bodyFloor, 60f, 4f);
        stage.addActor(floorActor);

        roof =new FloorActor(modelWorld.bodyRoof, 60f, 6f);
        stage.addActor(roof);

        sliderActor = new SliderActor(modelWorld.bodySlider);
        stage.addActor(sliderActor);

        createBrick();

        Gdx.input.setCatchBackKey(true);


    }

    private void createBrick(){
        Vector2 pos = new Vector2(-10f, 15f);
        int id = 0;
        for (int i=0; i<5; i++){

            brickActor = new BrickActor(modelWorld.getBodyBrick(pos.x, pos.y));
            pos.x +=5f;
            stage.addActor(brickActor);
            id++;
        }
        pos.x = -10f;
        pos.y = 11f;
        for (int i=0; i<5; i++){

            brickActor = new BrickActor(modelWorld.getBodyBrick(pos.x, pos.y));
            pos.x +=5f;
            stage.addActor(brickActor);
            id++;
        }
    }
    public void youWin(){

        win = true;

    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //ballActor.act(delta);
        modelWorld.logicStep(delta);
        stage.act(delta);
        stage.draw();


       // renderer.render(model.world, camera.combined);
        debugRenderer.render(modelWorld.world, cam.combined);

        //spriteBatch = new SpriteBatch();
       // spriteBatch.begin();
       // model.ballSprite.draw(spriteBatch);
       // spriteBatch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.BACK )){
            // Do back button handling (show pause menu?)
            game.setScreen(new MainMenuScreen(game));
            //Gdx.app.exit(); //This will exit the app but you can add other options here as well
        }
        win = modelWorld.win;

        if(win == true){
            game.setScreen(new WinScreen(game));

        }


    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        stage.dispose();
        batch.dispose();
         game.dispose();


    }
}