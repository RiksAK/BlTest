package ua.riks.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ua.riks.MyGame;

/**
 * Created by Riks on 27.09.2017.
 */

public class LevelScreen implements Screen {

    final MyGame game;

    private Stage stage;
    private Table table;
    private Label.LabelStyle labelStyle;
    private TextButton level;

    private Array<String> levels;

    public LevelScreen(MyGame gam) {
        game = gam;

        stage = new Stage(new ScreenViewport());

        Skin skin = new Skin();
        TextureAtlas buttonAtlas = new TextureAtlas(Gdx.files.internal("images/game/images.pack"));
        skin.addRegions(buttonAtlas);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        //textButtonStyle.font = game.levels;
        textButtonStyle.up = skin.getDrawable("level-up");
        textButtonStyle.down = skin.getDrawable("level-down");
        textButtonStyle.checked = skin.getDrawable("level-up");

        TextButtonStyle lockButtonStyle = new TextButtonStyle();
       // lockButtonStyle.font = game.levels;
        lockButtonStyle.up = skin.getDrawable("level-lock");
        lockButtonStyle.down = skin.getDrawable("level-lock");
        lockButtonStyle.checked = skin.getDrawable("level-lock");




        //stage.addActor(game.background);
    }

    @Override
    public void render(float delta) {
        // Clear screen to black color
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // draw scene
        //stage.act(delta);
        //stage.draw();
    }
    @Override
    public void resize(int width, int height) {}

    @Override
    public void show() {}

    @Override
    public void hide() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {
        // Destroy scene and game object
        //stage.dispose();
        //game.dispose();
    }
}
