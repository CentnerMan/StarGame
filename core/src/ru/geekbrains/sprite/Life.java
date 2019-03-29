package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Life extends Sprite {

    protected Rect worldBounds;
    private final float FULL = 0.25f;
    public float currHP = FULL;

    public Life(TextureRegion region) {
        super(region);
        setHeightProportion(0.02f);
        setWidth(FULL);

    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        pos.y = worldBounds.getTop() - 0.02f;
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        setWidth(currHP);
    }

    public void setCurrHP(float chipHP) {
        this.currHP = chipHP * FULL;
    }
}
