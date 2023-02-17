package com.bingus.game.projectiles;
import com.bingus.game.Coordinate;
import com.bingus.game.Entity;
import com.bingus.game.EntityType;
import com.bingus.game.projectiles.Projectile;

public class PlayerProjectile extends Projectile {


    public PlayerProjectile(Coordinate c, int damage, float speed, String texture) {
        super(c, damage, speed, texture);
    }

    public void onCollide(Entity e) {

    }

    public EntityType getType() {
        return EntityType.PLAYERBULLET;
    }
}
