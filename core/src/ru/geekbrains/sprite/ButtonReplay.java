package ru.geekbrains.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.ScaledButton;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.GameScreen;

public class ButtonReplay extends ScaledButton {

    private Game game;

    public ButtonReplay(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("button_new_game"));
        this.game = game;
        setHeightProportion(0.08f);
    }

    @Override
    public void resize(Rect worldBounds) {
        // Place to screen center
    }

    @Override
    protected void action() {
        game.setScreen(new GameScreen(game));
    }
}
