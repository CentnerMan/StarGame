package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.base.Base2DScreen;
import ru.geekbrains.stargame.chips.Hero;


public class MenuScreen extends Base2DScreen {
    private SpriteBatch batch;
    private Texture background;
    private Vector2 touch;
    private Hero hero;
    private static float MOVE_STEP = 20f;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        background = new Texture("background.jpg");
        hero = new Hero(45, 78, 0.05f);
        touch = new Vector2(Gdx.graphics.getWidth() / 2, hero.getHeroPix().getHeight() / 2); // base chip place
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        Gdx.gl.glClearColor(0.51f, 0.34f, 0.64f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        // background
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // hero chip
        hero.render(batch);

        batch.end();
    }

    public void update() {
        hero.moveToXY(touch.x, touch.y);
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println("touch x = " + touch.x + " touch.y = " + touch.y);
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean keyDown(int keycode) {
        touch.set(hero.getX(), Gdx.graphics.getHeight() - hero.getY());
        switch (keycode) {

            case 19: // up
                touch.x = hero.getX() + (float) hero.getHeroPix().getWidth() / 2;
                touch.y = hero.getY() + (float) hero.getHeroPix().getHeight() / 2 + MOVE_STEP;
                super.keyDown(keycode);
                break;

            case 20: // down
                touch.x = hero.getX() + (float) hero.getHeroPix().getWidth() / 2;
                touch.y = hero.getY() + (float) hero.getHeroPix().getHeight() / 2 - MOVE_STEP;
                super.keyDown(keycode);
                break;

            case 21: // left
                touch.x = hero.getX() + (float) hero.getHeroPix().getWidth() / 2 - MOVE_STEP;
                touch.y = hero.getY() + (float) hero.getHeroPix().getHeight() / 2;
                super.keyDown(keycode);
                break;

            case 22: // right
                touch.x = hero.getX() + (float) hero.getHeroPix().getWidth() / 2 + MOVE_STEP;
                touch.y = hero.getY() + (float) hero.getHeroPix().getHeight() / 2;
                super.keyDown(keycode);
                break;
        }
        return super.keyDown(keycode);
    }
}

