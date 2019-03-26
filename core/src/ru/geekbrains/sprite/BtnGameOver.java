package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.ScaledButton;
import ru.geekbrains.math.Rect;

public class BtnGameOver extends ScaledButton {

    public BtnGameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
        setHeightProportion(0.08f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setTop(worldBounds.getTop() - 0.02f);
    }

    @Override
    protected void action() {

    }

}
