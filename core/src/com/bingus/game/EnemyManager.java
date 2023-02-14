package com.bingus.game;

import java.util.ArrayList;

public class EnemyManager {
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private int t = 0;

    public void spawn(int count) {
        for (int i = 0; i < count; i++) {
            enemies.add(new Bingus((float) Math.random() * 1920,
                    (float) Math.random() * 1080,
                    (float) (Math.random() * 2) + 1));
        }
    }

    public void update(Player player) {
        if (++t % 60 == 0) {
            spawn(1);
        }

        for (Enemy e : enemies) {
            e.update(player, SpriteManager.getInstance());
        }
    }

    public Enemy findEnemyClosestTo(float x, float y) {
        Enemy closestEnemy = null;
        double shortestDistance = Float.MAX_VALUE;

        for (Enemy e :
                enemies) {

            double distance = Math.sqrt(Math.pow(x - e.x, 2) + Math.pow(y - e.y, 2));
            if (distance < shortestDistance) {
                shortestDistance = distance;
                closestEnemy = e;
            }
        }

        if (shortestDistance==Float.MAX_VALUE){
            return null;
        }
        else return closestEnemy;
    }
}
