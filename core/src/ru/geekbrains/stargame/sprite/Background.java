package ru.geekbrains.stargame.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.stargame.base.Sprite;

public class Background extends Sprite {

    public Background(TextureRegion region) {
        super(region);
        setSize(200f, 200f);
    }

    public void update() {
    }
}
