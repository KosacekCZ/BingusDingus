package com.bingus.game.projectiles;

import com.bingus.game.*;

public abstract class Projectile extends Entity {

    protected final float direction;
    protected String texture;


    public Projectile(Coordinate c, int damage, float speed, String texture) {
        this.damage = damage;
        this.speed = speed;
        this.texture = texture;
        this.x = c.x;
        this.y = c.y;
        this.w = c.w;
        this.h = c.h;
        this.direction = c.dir;
    }


    public void update() {
        x += Math.cos(direction) * speed;
        y += Math.sin(direction) * speed;
        SpriteManager.getInstance().draw(texture, x, y);
        checkDestruction();
    }

    public abstract void onCollide(Entity e);

    public abstract EntityType getType();

    private void checkDestruction() {
        if ((this.x < 0 || this.x > 1920) || (this.y < 0 || this.y > 1080)) destroy();
    }
}
