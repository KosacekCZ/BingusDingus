package com.bingus.game;

public abstract class Projectile {

    public float x;
    public float y;
    public float degreesDirection;
    protected int damage;
    protected float speed;

    public Projectile() {

    }

    public void update(SpriteManager sm) {
        x += Math.cos(degreesDirection) * speed;
        y += Math.sin(degreesDirection) * speed;

        sm.draw("missing", x, y);
    }
}
