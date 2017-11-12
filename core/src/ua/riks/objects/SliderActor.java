package ua.riks.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;

import ua.riks.userdata.SliderUserData;
import ua.riks.utils.GlobalConstants;
import ua.riks.utils.RelatedWorldScreen;

/**
 * Created by Riks on 13.10.2017.
 */

public class SliderActor extends GameActor {
    private static Texture slider = new Texture(Gdx.files.internal("slider.png"));
    private Body body;
    private Sprite sprite;
    private RelatedWorldScreen coordinats;
    private float sizeX;
    private float sizeY;


    public SliderActor(Body body){
        super(body);

        this.body = body;
        this.sizeX = GlobalConstants.SLIDER_WIDTH*2;
        this.sizeY = GlobalConstants.SLIDER_HEIGHT*2;
        this.sprite = new Sprite(slider);
        this.coordinats = new RelatedWorldScreen();
    }

    public void moveSlider(Vector3 position){
        float x = coordinats.getWorldX(position.x);
        body.setTransform(x, GlobalConstants.SLIDER_POSITION.y, 0);

    }

    @Override
    public SliderUserData getUserData() {
        return (SliderUserData) userData;
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
