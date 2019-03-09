package ru.geekbrains.stargame;

import com.badlogic.gdx.Game;


public class StarGame extends Game {
    @Override
    public void create() {
        setScreen(new ru.geekbrains.stargame.screen.MenuScreen());
    }
}


