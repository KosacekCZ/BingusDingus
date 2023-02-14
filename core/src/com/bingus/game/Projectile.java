package com.bingus.game;

public abstract class Projectile extends Entity {

    public float x;
    public float y;
    public float degreesDirection;
    protected String texture;
    protected int damage;
    protected float speed;
    private EntityType type;


    public Projectile(float x, float y, int dmg, float spd, float degreesDirection, EntityType type) {
        damage = dmg;
        speed = spd;
        this.degreesDirection = degreesDirection;
        this.x = x;
        this.y = y;
        this.type = type;
        texture = "missing";
    }

    public void update() {
        x += Math.cos(degreesDirection) * speed;
        y += Math.sin(degreesDirection) * speed;
        SpriteManager.getInstance().draw(texture, x, y);
    }

    public void onCollide(Entity e) {
    }

    public EntityType getType() {
        return type;
    }
}
