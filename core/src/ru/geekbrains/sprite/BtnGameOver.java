package ru.geekbrains.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.ScaledButton;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.GameScreen;
import ru.geekbrains.screen.MenuScreen;

public class BtnGameOver extends ScaledButton {

    private Game game;

    public BtnGameOver(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("message_game_over"));
        this.game = game;
        setHeightProportion(0.08f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setTop(worldBounds.getTop() - 0.02f);
    }

    @Override
    protected void action() {
        game.setScreen(new MenuScreen(game));

    }

}
