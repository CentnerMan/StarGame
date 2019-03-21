package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;

import static ru.geekbrains.math.Rnd.rnd;

/*
Необходимо реализовать настраиваемый класс для вражеского корабля.
Так как объекты вражеских кораблей будут использоваться повторно, то необходимо сделать возможность
задавать кораблю текстуру, скорость, количество жизней, наносимый урон,
скорость пули корабля и размер.

Реализовать для корабля все необходимые методы (update, draw, resize).

Отображать вражеский корабль пока не нужно,
так как он будет инициализироваться из пула объектов (тема следующего вебинара)
 */

public class EnemyShip extends Sprite {

    private static final float MIN_X = 0.01f;
    private static final float MIN_Y = -0.1f;
    private static final float MAX_Y = -0.05f;

    private static final String[] TEXTURES = {"enemy0", "enemy1", "enemy2"};

    private float speed = 0.1f;
    private int lives = 3;
    private int damage = 1;
    private float bullSpeed = 0.01f;
    private float size;

    private TextureAtlas atlas;
    private Rect worldBounds;

    private Vector2 v = new Vector2();

    public EnemyShip(TextureAtlas atlas) {
        super(atlas.findRegion(TEXTURES[rnd(0, 2)]), 1, 2, 2);
        this.atlas = atlas;
        setHeightProportion(0.15f);
        float vX = Rnd.nextFloat(-MIN_X, MIN_X);
        float vY = Rnd.nextFloat(MIN_Y, MAX_Y);
        v.set(vX, vY);
    }

    public EnemyShip(TextureAtlas atlas, int textura) {
        super(atlas.findRegion(TEXTURES[textura]), 1, 2, 2);
        this.atlas = atlas;
        setHeightProportion(0.15f);
        float vX = Rnd.nextFloat(-MIN_X, MIN_X);
        float vY = Rnd.nextFloat(MIN_Y, MAX_Y);
        v.set(vX, vY);
    }

    public EnemyShip(TextureAtlas atlas, float speed, int lives, int damage, float bullSpeed, float size) {
        super(atlas.findRegion(TEXTURES[rnd(0, 2)]), 1, 2, 2);
        this.atlas = atlas;
        this.speed = speed;
        this.lives = lives;
        this.damage = damage;
        this.bullSpeed = bullSpeed;
        this.size = size;
        setHeightProportion(0.15f);
        float vX = Rnd.nextFloat(-MIN_X, MIN_X);
        float vY = -speed;
        v.set(vX, vY);
    }

    public EnemyShip(TextureAtlas atlas, int textura, float speed, int lives, int damage, float bullSpeed, float size) {
        super(atlas.findRegion(TEXTURES[textura]), 1, 2, 2);
        this.atlas = atlas;
        this.speed = speed;
        this.lives = lives;
        this.damage = damage;
        this.bullSpeed = bullSpeed;
        this.size = size;
        setHeightProportion(0.15f);
        float vX = Rnd.nextFloat(-MIN_X, MIN_X);
        float vY = -speed;
        v.set(vX, vY);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        float posX = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
        float posY = worldBounds.getTop();
        pos.set(posX, posY);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(v, delta);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    public void shoot() {
    }
}
