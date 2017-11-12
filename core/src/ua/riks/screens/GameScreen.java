package ua.riks.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import ua.riks.MyGame;
import ua.riks.stage.GameStage;

/**
 * Created by Riks on 22.10.2017.
 */

public class GameScreen implements Screen {

    private GameStage stage;
    final MyGame game;

    public GameScreen(final MyGame gam) {
        game =gam;
        final MyGame game;
        stage = new GameStage();
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update the stage
        stage.draw();
        stage.act(delta);

        if(Gdx.input.isKeyPressed(Input.Keys.BACK )){
            // Do back button handling (show pause menu?)
            game.setScreen(new MainMenuScreen(game));
            //Gdx.app.exit(); //This will exit the app but you can add other options here as well
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
       // batch.dispose();
    }
}
