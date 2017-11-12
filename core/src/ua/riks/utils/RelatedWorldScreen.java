package ua.riks.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Riks on 09.10.2017.
 */

public class RelatedWorldScreen {

    private float defX = Gdx.graphics.getWidth()/GlobalConstants.WORLD_TO_SCREEN_X;
    private float defY = Gdx.graphics.getHeight()/GlobalConstants.WORLD_TO_SCREEN_Y;
    private float offsetX = Gdx.graphics.getWidth()/2;
    private float offsetY = Gdx.graphics.getHeight()/2;


    public float getWorldX(float x){

        float wordlX = (x - offsetX)/defX;
        return wordlX;
    }
    public float getWorldY(float y){

        float wordlY = (y - offsetY)/defY;
        return wordlY;
    }

    public float getScreenX(float x){
        float screenX = x * defX + offsetX;
        return screenX;
    }
    public float getScreenY(float y){
        float screenY = y * defY + offsetY;
        return screenY;
    }
    public Vector2 getSizeWorld(float sizeX,float sizeY){
        Vector2 sizeWorld = new Vector2();
        sizeWorld.x = sizeX/defX;
        sizeWorld.y = sizeY/defY;

        return sizeWorld;
    }
    public Vector2 getSizeScreen(float sizeX,float sizeY){
        Vector2 sizeScreen = new Vector2();
        sizeScreen.x = sizeX*defX;
        sizeScreen.y = sizeY*defY;

        return sizeScreen;
    }

}