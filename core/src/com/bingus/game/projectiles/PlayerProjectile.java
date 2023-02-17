package com.bingus.game.projectiles;
import com.bingus.game.*;
import com.bingus.game.projectiles.Projectile;

public class PlayerProjectile extends Projectile {

    private final AttackType atype;
    public PlayerProjectile(Coordinate c, int damage, float speed, String texture, AttackType type) {
        super(c, damage, speed, texture);
        this.atype = type;
    }

    @Override
    public void update() {
        t += 0.1f;
        if (atype == AttackType.SPINNING) {
            Player pl = EntityManager.getInstance().getPlayer();
            //float direction = (float) (Math.atan2((pl.getX() + t * 10) - x, -(pl.getY() - y)) - (Math.PI / 2));

            x = (float)(pl.getX() + (Math.cos(t) * t * speed));
            y = (float)(pl.getY() + (Math.sin(t) * t * speed));

            SpriteManager.getInstance().draw("blueProjectile", x, y);
        } else {
            x += Math.cos(direction) * (speed + t);
            y += Math.sin(direction) * (speed + t);
            SpriteManager.getInstance().draw("projectile", x, y);
        }

        checkDestruction();
    }

    public void onCollide(Entity e) {

    }

    public EntityType getType() {
        return EntityType.PLAYERBULLET;
    }
}
