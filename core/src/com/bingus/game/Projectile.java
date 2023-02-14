package com.bingus.game;

public class Projectile extends Entity {
    public int damage;
    private final float speed;
    private final float direction;
    public float x;
    public float y;
    private EntityType type;

    public Projectile(float x, float y, int dmg, float spd, float direction, EntityType type) {
        damage = dmg;
        speed = spd;
        this.direction = direction;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void update() {
        x += Math.cos(direction) * speed;
        y += Math.sin(direction) * speed;
        SpriteManager.getInstance().draw("projectile", x, y);

        if (x < 0 || x > 1920 || y < 0 || y > 1080) destroy();
    }

    public void onCollide(Entity e) {
    }

    public EntityType getType() {
        return type;
    }
}
