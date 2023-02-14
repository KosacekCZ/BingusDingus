package com.bingus.game;


public class PlayerProjectile extends Projectile {


    public PlayerProjectile(Player projectileOrigin, float degreesDirection) {
        super(projectileOrigin.x, projectileOrigin.y, projectileOrigin.shotDamage, projectileOrigin.projectileSpeed, degreesDirection, EntityType.PLAYERBULLET);
    }

    public void update(SpriteManager sm) {
        x += Math.cos(degreesDirection) * speed;
        y += Math.sin(degreesDirection) * speed;

        // TODO: if overlaps with enemy

        sm.draw("bullet", x, y);
    }

}
