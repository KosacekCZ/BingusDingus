package com.bingus.game;

public abstract class Enemy {
    float x;
    float y;

    public abstract void attack();
    public abstract void update(Player pl);

}
