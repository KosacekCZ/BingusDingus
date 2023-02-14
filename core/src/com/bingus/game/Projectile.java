package com.bingus.game;

public abstract class Projectile extends Entity {

    public float x;
    public float y;
    public float degreesDirection;
    protected int damage;
    protected float speed;
    private EntityType type;

    public Projectile(float x, float y, int dmg, float spd, float direction, EntityType type) {
        damage = dmg;
        speed = spd;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void update() {
        x += Math.cos(degreesDirection) * speed;
        y += Math.sin(degreesDirection) * speed;
        SpriteManager.getInstance().draw("missing", x, y);
    }

    public void onCollide(Entity e) {
    }

    public EntityType getType() {
        return type;
    }
}
