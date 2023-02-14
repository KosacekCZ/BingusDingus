package com.bingus.game;


public class PlayerProjectile extends Projectile {

    public PlayerProjectile(Player projectileOrigin, float degreesDirection) {
        super(projectileOrigin.x, projectileOrigin.y, projectileOrigin.shotDamage, projectileOrigin.projectileSpeed, degreesDirection, EntityType.PLAYERBULLET);
        texture = "bullet";
    }
}
