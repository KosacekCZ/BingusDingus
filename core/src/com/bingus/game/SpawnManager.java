package com.bingus.game;

public class SpawnManager {
    public static SpawnManager instance;
    public static SpawnManager getInstance() {
        if (instance == null) instance = new SpawnManager();
        return instance;
    }
    private int t = 0;
    private int spawnedBatch = 0;
    WaveManager wm = WaveManager.getInstance();

    public void update() {
        t++;


        if (t % 240 == 0) {
            if(spawnedBatch < (wm.getWave() + 1) * 10) {
                spawnEntities(1);
                spawnedBatch++;
            }
        }
    }

    public void spawnEntities(int amount) {
        for (int i = 0; i < amount; i++) {
            boolean switcher = Math.random() > 0.5;
            if (wm.getWave() == 0) {
                spawnBingus(switcher);
            } else if (wm.getWave() == 1) {
                spawnBingus(switcher);
                spawnDingus(switcher);
            }
        }
    }

    private void spawnBingus(boolean switcher) {
        EntityManager.getInstance().addEntity(new Bingus(
                Interval.randInInterval(-100, (switcher ? 0 : -50), (switcher ? 0 : 1970), 2070),
                Interval.randInInterval(-100, (!switcher ? 0 : -50), (!switcher ? 0 : 1250), 1350),
                (float)(Math.random() * 2) + 1));
    }

    private void spawnDingus(boolean switcher) {
        EntityManager.getInstance().addEntity(new Dingus(
                Interval.randInInterval(-100,(switcher ? 0 : -50), (switcher ? 0 : 1970), 2070),
                Interval.randInInterval(-100, (!switcher ? 0 : -50), (!switcher ? 0 : 1080), 1350),
                (float)(Math.random() * 2) + 1));
    }
}