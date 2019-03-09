package ru.geekbrains.stargame.chips;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Hero {

    private float x;
    private float y;
    private float speed;
    private Vector2 currentPosition;
    private Vector2 velocity;
    private Vector2 targetPosition;

    private Texture heroPix = new Texture("spaceship.png");


    public Hero(float x, float y, float speed) {
        this.x = x - (float) heroPix.getWidth() / 2;
        this.y = y - (float) heroPix.getHeight() / 2;
        this.speed = speed;
    }

    public Hero(float x, float y) {
        this.x = x - (float) heroPix.getWidth() / 2;
        this.y = y - (float) heroPix.getHeight() / 2;
        speed = 0;
    }

    public Hero(Vector2 currentPosition, Vector2 velocity) {
        this.currentPosition = currentPosition;
        this.velocity = velocity;
    }

    public void render(SpriteBatch batch) {
        batch.draw(getHeroPix(), getX(), getY());
    }

    public void updateXY(float x, float y) {
        this.x = x - (float) heroPix.getWidth() / 2;
        this.y = y - (float) heroPix.getHeight() / 2;
    }

    public void moveToXY(float x, float y) {
        currentPosition = new Vector2(getX(), getY());
        targetPosition = new Vector2(x - (float) heroPix.getWidth() / 2, y - (float) heroPix.getHeight() / 2);
        currentPosition.add(new Vector2().set(targetPosition.sub(currentPosition)).scl(speed));
        this.x = currentPosition.x;
        this.y = currentPosition.y;
    }

    public Texture getHeroPix() {
        return heroPix;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
