package com.bingus.game;
import com.bingus.game.projectiles.*;

public class Bingus extends Entity{

    public Bingus(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.w = 40;
        this.h = 40;
        this.speed = speed;
        this.health = 50;
        this.damage = 5;
    }

    public void update() {
        Player pl = EntityManager.getInstance().getPlayer();
        float direction = (float) (Math.atan2(pl.x - x, -(pl.y - y)) - (Math.PI / 2));
        x += Math.cos(direction) * speed;
        y += Math.sin(direction) * speed;
        SpriteManager.getInstance().draw("piskel", x, y);

        if (++t % Math.floor(Math.random() * 270) + 120 == 0) {
            // attack
        }

        if (t % 60 == 0) {
            this.damage = 10;
        } else {
            this.damage = 0;
        }

        if (health <= 0) destroy();
    }

    @Override
    public void onCollide(Entity e) {
        if (e.getType() == EntityType.PLAYERBULLET) {
            health -= e.damage;
            e.destroy();
        }
    }

    public EntityType getType() {
        return EntityType.ENEMY;
    }
}
