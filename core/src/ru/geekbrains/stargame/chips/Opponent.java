package ru.geekbrains.stargame.chips;

public class Opponent {

    private float x;
    private float y;
    private float Vx;
    private float Vy;

    public Opponent(float x, float y, float vx, float vy) {
        this.x = x;
        this.y = y;
        Vx = vx;
        Vy = vy;
    }

    public Opponent(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
