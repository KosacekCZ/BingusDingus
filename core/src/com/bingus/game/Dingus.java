package com.bingus.game;

public class Dingus extends Entity{
    float x;
    float y;
    float speed;
    private int t = 0;
    public final EntityType type = EntityType.ENEMY;

    public Dingus(float spawnX, float spawnY, float speed) {
        x = spawnX;
        y = spawnY;
        this.speed = speed;
    }

    public void update() {
        Player pl = EntityManager.getInstance().getPlayer();
        float direction = (float) (Math.atan2(pl.x - x, -(pl.y - y)) - (Math.PI / 2));
        x += Math.cos(direction) * speed;
        y += Math.sin(direction) * speed;

        SpriteManager.getInstance().draw("zhulus", x, y);

        if ((x + 10 == pl.x || x - 10 == pl.x) && (y + 10 == pl.y || y - 10 == pl.y)) {
            for (int i = 0; i < 500; i++) {
                SpriteManager.getInstance().draw("zhulus", x, y, 128f + i, 128f + i);
            }

        }
    }

    @Override
    public void onCollide(Entity e) {

    }
}
