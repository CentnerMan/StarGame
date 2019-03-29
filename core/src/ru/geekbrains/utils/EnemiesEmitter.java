package ru.geekbrains.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;
import ru.geekbrains.pool.EnemyPool;
import ru.geekbrains.sprite.Enemy;

import static ru.geekbrains.math.Rnd.rnd;

public class EnemiesEmitter {

    private static final float[] ENEMY_HEIGHT = {0.1f, 0.15f, 0.2f};
    private static final float[] ENEMY_BULLET_HEIGHT = {0.01f, 0.03f, 0.05f};
    private static final float[] ENEMY_BULLET_VY = {-0.3f, -0.25f, -0.25f};
    private static final int[] ENEMY_DAMAGE = {1, 2, 5};
    private static final float[] ENEMY_RELOAD_INTERVAL = {3f, 4f, 5f};
    private static final int[] ENEMY_HP = {1, 5, 10};
    private static final String[] TEXTURES = {"enemy0", "enemy1", "enemy2"};

    private Rect worldBounds;

    private float generateInterval = 4f;
    private float generateTimer;

    private TextureRegion[] enemySmallRegion;
    private TextureRegion[] enemyMediumRegion;
    private TextureRegion[] enemyBigRegion;
    private TextureRegion[] enemyRegion;

    private Vector2[] enemyV = {new Vector2(0f, -0.2f), new Vector2(0f, -0.05f), new Vector2(0f, -0.01f)};

    private TextureRegion bulletRegion;

    private EnemyPool enemyPool;

    private int level;

    public EnemiesEmitter(TextureAtlas atlas, Rect worldBounds, EnemyPool enemyPool) {
        this.worldBounds = worldBounds;
        this.enemyPool = enemyPool;
        this.enemySmallRegion = Regions.split(atlas.findRegion(TEXTURES[0]), 1, 2, 2);
        this.enemyMediumRegion = Regions.split(atlas.findRegion(TEXTURES[1]), 1, 2, 2);
        this.enemyBigRegion = Regions.split(atlas.findRegion(TEXTURES[2]), 1, 2, 2);
        this.bulletRegion = atlas.findRegion("bulletEnemy");
    }

    public void generate(float delta, int frags) {
        level = frags / 10 + 1;
        generateTimer += delta;
        if (generateTimer >= generateInterval) {
            generateTimer = 0f;
            int shipType;
            Enemy enemy = enemyPool.obtain();
            // 0-49 - small, 60-84 - medium, 85-99 - large
            int randomHundred = rnd(0, 99);
            if (randomHundred < 50) shipType = 0;
            else if (randomHundred < 85) shipType = 1;
            else shipType = 2;

            switch (shipType) {
                case 0: {
                    enemyRegion = enemySmallRegion;
                    break;
                }
                case 1: {
                    enemyRegion = enemyMediumRegion;
                    break;
                }
                case 2: {
                    enemyRegion = enemyBigRegion;
                    break;
                }
            }
            enemy.set(
                    enemyRegion,
                    enemyV[shipType],
                    bulletRegion,
                    ENEMY_BULLET_HEIGHT[shipType],
                    ENEMY_BULLET_VY[shipType],
                    ENEMY_DAMAGE[shipType] * level,
                    ENEMY_RELOAD_INTERVAL[shipType],
                    ENEMY_HEIGHT[shipType],
                    ENEMY_HP[shipType]
            );
            enemy.pos.x = Rnd.nextFloat(worldBounds.getLeft() + enemy.getHalfWidth(), worldBounds.getRight() - enemy.getHalfWidth());
            enemy.setBottom(worldBounds.getTop());
        }
    }

    public int getLevel() {
        return level;
    }
}
