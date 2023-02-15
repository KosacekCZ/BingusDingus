package com.bingus.game;

public class Bingus extends Entity{
        public float speed;
    private int t = 0;

    public Bingus(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.width = 10;
        this.height = 10;
        this.speed = speed;
        this.health = 50;
    }

    public void update() {
        Player pl = EntityManager.getInstance().getPlayer();
        float direction = (float) (Math.atan2(pl.x - x, -(pl.y - y)) - (Math.PI / 2));
        x += Math.cos(direction) * speed;
        y += Math.sin(direction) * speed;

        SpriteManager.getInstance().draw("piskel", x, y);

        if (++t % Math.floor(Math.random() * 270) == 0) {
            // attack
            EntityManager.getInstance().addEntity(new Projectile(x, y, 0, 10, direction, EntityType.ENEMYBULLET));
        }
    }

    @Override
    public void onCollide(Entity e) {

    }

    public EntityType getType() {
        return EntityType.ENEMY;
    }
}
