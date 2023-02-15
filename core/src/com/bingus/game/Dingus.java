package com.bingus.game;

public class Dingus extends Entity{
    public float speed;
    private int t = 0;
    private float scale = 0.1f;
    private boolean exploding = false;

    public Dingus(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.width = 10f;
        this.height = 10f;
        this.speed = speed;
        this.health = 50;
    }

    public void update() {
        Player pl = EntityManager.getInstance().getPlayer();
        float direction = (float) (Math.atan2(pl.x - x, -(pl.y - y)) - (Math.PI / 2));
        x += Math.cos(direction) * speed;
        y += Math.sin(direction) * speed;

        if (++t %60 == 0) {
            // System.out.println("Dingus | x: " + x + " y: " + y);
        }



        if (exploding && scale < 1) {
            scale += 0.01f;
            SpriteManager.getInstance().draw("peenus", x, y, scale, scale);
        } else if(scale >= 1) {
            destroy();
        } else {
                SpriteManager.getInstance().draw("zhulus", x, y, scale, scale);
            }
        }

    public void onCollide(Entity e) {
        // System.out.println("colliding with " + e.getType());
        if (e.getType() == EntityType.PLAYER) exploding = true;
    }

    public EntityType getType() {
        return EntityType.ENEMY;
    }

    public EntityType getType() {
        return EntityType.ENEMY;
    }
}
