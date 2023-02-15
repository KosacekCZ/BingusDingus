package com.bingus.game;

public class Bingus extends Enemy{
    float x;
    float y;
    float speed;
    private int t = 0;

    public Bingus(float spawnX, float spawnY, float speed) {
        x = spawnX;
        y = spawnY;
        this.speed = speed;
    }

    public void update(Player pl) {
        float direction = (float) (Math.atan2(pl.x - x, -(pl.y - y)) - (Math.PI / 2));
        x += Math.cos(direction) * speed;
        y += Math.sin(direction) * speed;

        SpriteManager.getInstance().draw("piskel", x, y);

        if (++t % 180 == 0) {
            // attack
            EntityManager.getInstance().addEntity(new Projectile(x, y, 0, 10, direction));
        }
    }

    public void attack() {

    }
}
