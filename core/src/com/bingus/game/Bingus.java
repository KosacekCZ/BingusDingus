package com.bingus.game;

public class Bingus extends Enemy{
    float x;
    float y;
    float speed;

    public Bingus(float spawnX, float spawnY, float speed) {
        x = spawnX;
        y = spawnY;
        this.speed = speed;
    }

    public void update(Player pl, SpriteManager sm) {
        float direction = (float) (Math.atan2(pl.x - x, -(pl.y - y)) - (Math.PI / 2));
        x += Math.cos(direction) * speed;
        y += Math.sin(direction) * speed;

        sm.draw("piskel", x, y);
    }

    public void attack() {
        //TODO Attack
    }
}
