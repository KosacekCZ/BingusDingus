package com.bingus.game;

import java.util.ArrayList;

public class EnemyManager {
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private int t = 0;

    public void spawn(int count) {
        for (int i = 0; i < count; i++) {
            enemies.add(new Bingus((float)Math.random() * 1920,
                                    (float)Math.random() * 1080,
                                    (float) (Math.random() * 2) + 1));

            enemies.add(new Dingus((float)Math.random() * 1920,
                                    (float)Math.random() * 1080,
                                    (float) (Math.random() * 2) + 1));
        }
    }

    public void update(Player player) {
        if (++t % 60 == 0) {
            spawn(1);
        }

        for (Enemy e : enemies) {
            e.update(player);
        }
    }
}
