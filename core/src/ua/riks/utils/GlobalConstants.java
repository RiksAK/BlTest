package ua.riks.utils;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Riks on 09.10.2017.
 */

public class GlobalConstants {

    public static final int APP_WIDTH_MAX = 1080;
    public static final int APP_HEIGHT_MAX = 1920;
    public static final int APP_WIDTH_MIN = 480;
    public static final int APP_HEIGHT_MIN = 800;
    public static final float WORLD_TO_SCREEN_X = 32;
    public static final float WORLD_TO_SCREEN_Y = 54;

    public static final Vector2 WORLD_GRAVITY = new Vector2(0f, -5f);

    public static final Vector2 ROOF_POSITION = new Vector2(0f, 25f);
    public static final float ROOF_WIDTH = 29f;
    public static final float ROOF_HEIGHT = 3f;
    public static final float ROOF__DENSITY = 0f;

    public static final Vector2 FLOOR_POSITION = new Vector2(0f, -26f);
    public static final float FLOOR_WIDTH = 30f;
    public static final float FLOOR_HEIGHT = 2f;
    public static final float FLOOR_DENSITY = 0f;

    public static final Vector2 WALL_LEFT_POSITION = new Vector2(-16f, 0f);
    public static final float WALL_LEFT_WIDTH = 0.5f;
    public static final float WALL_LEFT_HEIGHT = 30f;
    public static final float WALL_LEFT_DENSITY = 0f;

    public static final Vector2 WALL_RIGHT_POSITION = new Vector2(16f, 0f);
    public static final float WALL_RIGHT_WIDTH = 0.5f;
    public static final float WALL_RIGHT_HEIGHT = 30f;
    public static final float WALL_RIGHT_DENSITY = 0f;

    public static final Vector2 BALL_POSITION = new Vector2(0f,0f);
    public static final float BALL_RADIUS = 1f;
    public static final float BALL_DENSITY = 1f;
    public static final float BALL_RESTITUTION = 1f;
    public static final float BALL_FRICTION = 1f;

    public static final Vector2 SLIDER_POSITION  = new Vector2(0f,-22f);
    public static final float SLIDER_WIDTH = 5f;
    public static final float SLIDER_HEIGHT = 1f;
    public static final float SLIDER_DENSITY = 0f;


    public static final float BRIK_WIDTH = 2.5f;
    public static final float BRIK_HEIGHT = 1f;
    public static final float BRIK_DENSITY = 0f;






}
