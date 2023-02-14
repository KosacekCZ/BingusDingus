package com.bingus.game;

public abstract class Projectile extends Entity {

    public float x;
    public float y;
    public float degreesDirection;
    protected int damage;
    protected float speed;

    public Projectile() {
        damage = dmg;
        speed = spd;
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public void update() {
        x += Math.cos(degreesDirection) * speed;
        y += Math.sin(degreesDirection) * speed;
        SpriteManager.getInstance().draw("missing", x, y);
    }
    public void onCollide(Entity e) {
    }
}
