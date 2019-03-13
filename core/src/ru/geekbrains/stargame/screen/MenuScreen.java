package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.base.Base2DScreen;
import ru.geekbrains.stargame.sprite.Background;
import ru.geekbrains.stargame.sprite.BadLogic;

public class MenuScreen extends Base2DScreen {

    private BadLogic badLogic;
    private Texture img;
    private Background back;
    private Texture background;

    @Override
    public void show() {
        super.show();
        background = new Texture("background.jpg");
        back = new Background(new TextureRegion(background));
        img = new Texture("spaceship.png");
        badLogic = new BadLogic(new TextureRegion(img));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        back.draw(batch);
        badLogic.draw(batch);
        batch.end();
        back.update();
        badLogic.update();
    }

    @Override
    public void dispose() {
        img.dispose();
        background.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        badLogic.touchDown(touch, pointer);
        return false;
    }
}
