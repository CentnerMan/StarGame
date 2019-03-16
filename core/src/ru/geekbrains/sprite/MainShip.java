package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

import static java.lang.Math.abs;

public class MainShip extends Sprite {

    private static float V_LEN = 0.005f;

    private Rect worldBounds;
    private float height = 0.15f;
    private float speed = 0.02f;

    private Vector2 velocity;
    private Vector2 targetPosition;


    public MainShip(TextureAtlas atlas) {
                super(atlas.findRegion("main_ship_one"));
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        setHeightProportion(height);

        if (targetPosition != null && velocity != null) {
            if ((abs(pos.x - targetPosition.x) <= V_LEN) && (abs(pos.y - targetPosition.y) <= V_LEN)) {
                pos.set(targetPosition);
            } else {
                pos.add(velocity);
            }
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        pos.x = 0f;
        pos.y = worldBounds.getBottom() + height / 2;
    }

    public boolean touchDown(Vector2 touch, int pointer) {
        targetPosition = touch;
        velocity = touch.cpy().sub(pos).setLength(V_LEN);
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer) {
        targetPosition = touch;
        velocity = touch.cpy().sub(pos).setLength(V_LEN);
        return false;
    }
}
