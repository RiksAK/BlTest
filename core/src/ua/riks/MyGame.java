package ua.riks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import ua.riks.objects.Background;
import ua.riks.screens.MainMenuScreen;
import ua.riks.utils.RelatedWorldScreen;

/**
 * Created by Riks on 26.09.2017.
 */

public class MyGame extends Game {
    public Background background;
    private RelatedWorldScreen coordinats;

    public BitmapFont font, levels;
    private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";

    public MyGame() {
        super();
    }
    @Override
    public void create() {


        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/capture_it.ttf"));
        FreeTypeFontParameter param = new FreeTypeFontParameter();
        param.size = Gdx.graphics.getHeight() / 18;
        param.characters = FONT_CHARACTERS;
        font = generator.generateFont(param);
        param.size = Gdx.graphics.getHeight() / 20;
        levels = generator.generateFont(param);
        font.setColor(Color.WHITE);
        levels.setColor(Color.WHITE);
        generator.dispose();


        background = new Background();
        background.setPosition(0, 0);


        this.setScreen(new MainMenuScreen(this));

    }



    @Override
    public void render() {
        super.render();
    }

}
