package ua.riks.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import ua.riks.userdata.BallUserData;
import ua.riks.utils.GlobalConstants;
import ua.riks.utils.RelatedWorldScreen;

/**
 * Created by Riks on 28.09.2017.
 */

public class BallActor extends GameActor  {

    private static Texture ball = new Texture(Gdx.files.internal("ball1.png"));
    private Body body;
    private Sprite sprite;
    private RelatedWorldScreen coordinats;
    private float sizeX;
    private float sizeY;


    public BallActor(Body body){
        super(body);
        this.body = body;
        this.sizeX = GlobalConstants.BALL_RADIUS*2;
        this.sizeY = GlobalConstants.BALL_RADIUS*2;
        this.sprite = new Sprite(ball);
        this.coordinats = new RelatedWorldScreen();
    }
    @Override
    public BallUserData getUserData() {
        return (BallUserData) userData;
    }

    @Override
    public void draw(Batch batch, float alpha) {

        super.draw(batch, alpha);



        sprite.setOriginCenter();
        Vector2 sizeS = coordinats.getSizeScreen(sizeX, sizeY);
        sprite.setSize(sizeS.x, sizeS.y);
        Vector2 position = body.getPosition();
        float x = coordinats.getScreenX(position.x)-sprite.getWidth()/2;
        float y = coordinats.getScreenY(position.y)-sprite.getHeight()/2;
        sprite.setPosition(x ,y);
        sprite.setRotation(MathUtils.radiansToDegrees * body.getAngle());
        sprite.draw(batch);
    }
    @Override
    public void act(float delta) {

    }

}
