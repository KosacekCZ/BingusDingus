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
        EntityManager em = EntityManager.getInstance();
        if (e.getType() == EntityType.ENEMY && this.atype == AttackType.EXPLOSIVE) {
            for (float i = 0; i < 2f; i += 0.25f) {
                em.addEntity(new PlayerProjectile(new Coordinate(this.x + (40 * (float) Math.cos(i)), this.y + (40 * (float) Math.cos(i)), 10, 10, i), 20, 8, "projectile3", null));
            }
        }
    }

    public EntityType getType() {
        return EntityType.PLAYERBULLET;
    }
}
