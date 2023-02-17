package com.bingus.game;

public class SpawnManager {
    public static SpawnManager instance;
    public static SpawnManager getInstance() {
        if (instance == null) instance = new SpawnManager();
        return instance;
    }

    public void spawnEntities() {
        if (Math.random() > 0.5) {
            EntityManager.getInstance().addEntity(new Bingus(
                    Interval.randInInterval(-100, 2070),
                    Interval.randInInterval(-100, -50, 1250, 1350),
                    (float)(Math.random() * 2) + 1));

            EntityManager.getInstance().addEntity(new Dingus(
                    Interval.randInInterval(-100, 2070),
                    Interval.randInInterval(-100, -50, 1080, 1350),
                    (float)(Math.random() * 2) + 1));
        } else {
            EntityManager.getInstance().addEntity(new Bingus(
                    Interval.randInInterval(-100, -50, 1970, 2070),
                    Interval.randInInterval(-100, 1350),
                    (float)(Math.random() * 2) + 1));

            EntityManager.getInstance().addEntity(new Dingus(
                    Interval.randInInterval(-100, -50, 1920, 2070),
                    Interval.randInInterval(-100, 1350),
                    (float)(Math.random() * 2) + 1));
        }
    }
}
