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
    EntityManager em = EntityManager.getInstance();

    public void update() {
        t++;

        if (t % 180 == 0) {
            if(spawnedBatch < (wm.getWave() + 1) * 10) {
                spawnEntities(1);
                spawnedBatch++;
            } else if (spawnedBatch >= (wm.getWave() + 1) * 10){
                if (em.isEnemiesDead()) {
                    wm.nextWave();
                    spawnedBatch = 0;
                }
            }
        }

        t = (t % 3600 == 0 ? 0 : t);
    }

    public void spawnEntities(int amount) {
        for (int i = 0; i < amount; i++) {
            boolean switcher = Math.random() > 0.5;

            switch(wm.getWave()){
                case 0:
                    spawnBingus(switcher);
                    break;
                case 1:
                    spawnBingus(switcher);
                    spawnDingus(switcher);
                    break;
                case 2:
                    spawnBingus(switcher);
                    spawnDingus(switcher);
                    spawnBingus(switcher);
                    spawnDingus(switcher);
                    break;
                case 3:
                    spawnBingus(switcher);
                    spawnDingus(switcher);
                    spawnBingus(switcher);
                    spawnDingus(switcher);
                    spawnBingus(switcher);
                    spawnDingus(switcher);
                    break;

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