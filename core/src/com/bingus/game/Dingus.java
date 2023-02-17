package com.bingus.game;

public class Dingus extends Entity{

    private float scale = 0.1f;
    private boolean exploding = false;

    public Dingus(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.w = 10f;
        this.h = 10f;
        this.speed = speed;
        this.health = 50;
    }

    public void update() {
        Player pl = EntityManager.getInstance().getPlayer();
        float direction = (float) (Math.atan2(pl.x - x, -(pl.y - y)) - (Math.PI / 2));
        x += Math.cos(direction) * speed;
        y += Math.sin(direction) * speed;

        if (exploding && scale < 1.3f) {
            scale += 0.01f;
            SpriteManager.getInstance().draw("peenus", x, y, scale, scale);
        } else if(scale >= 1.2f) {
            destroy();
        } else {
                SpriteManager.getInstance().draw("zhulus", x, y, scale, scale);
            }

        if (health <= 0) destroy();
        }

    public void onCollide(Entity e) {
        if (e.getType() == EntityType.PLAYER) exploding = true;
        else if (e.getType() == EntityType.PLAYERBULLET) {
            health -= e.damage;
            e.destroy();
        }
    }

    public EntityType getType() {
        return EntityType.ENEMY;
    }

}
