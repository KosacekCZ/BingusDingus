package com.bingus.game.projectiles;

import com.bingus.game.Coordinate;
import com.bingus.game.Entity;
import com.bingus.game.EntityType;

public class EnemyProjectile extends Projectile {


    public EnemyProjectile(Coordinate c, int damage, int speed, String texture) {
        super(c, damage, speed, texture);
    }

    public EntityType getType() {
        return EntityType.ENEMYBULLET;
    }

    public void onCollide(Entity e) {
        if (e.getType() == EntityType.PLAYER) {
            destroy();
        }
    }


}
