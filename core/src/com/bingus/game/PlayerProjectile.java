package com.bingus.game;

public class PlayerProjectile extends Projectile {


    public PlayerProjectile(Player projectileOrigin, float degreesDirection) {
        super();
        this.damage = projectileOrigin.shotDamage;
        this.speed = projectileOrigin.projectileSpeed;
        this.degreesDirection = degreesDirection;
        this.x = projectileOrigin.x;
        this.y = projectileOrigin.y;
    }

    public void update(SpriteManager sm) {
        x += Math.cos(degreesDirection) * speed;
        y += Math.sin(degreesDirection) * speed;

        // TODO: if overlaps with enemy

        sm.draw("bullet", x, y);
    }

}
