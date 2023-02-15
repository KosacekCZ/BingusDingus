package com.bingus.game;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<Entity> tempBuffer = new ArrayList<>();
    private int t = 0;
    private static EntityManager instance;
    private Player player;

    public static EntityManager getInstance() {
        if (instance == null) instance = new EntityManager();
        return instance;
    }

    public void addEntity(Entity e) {
        tempBuffer.add(e);
    }

    public void update() {
        for (Entity e: entities) {
            e.update();
          for (Entity f : entities) {
              // System.out.println("E:" + e.x + " " + e.y + " " + " " + e.width + " " + e.height + " " + e.getType() + " F: " + f.x + " " + f.y + " " + " " + f.width + " " + f.height + " " + f.getType());
                 if (((e.getType() == EntityType.PLAYER && f.getType() != EntityType.PLAYER) ||
                         (e.getType() != EntityType.PLAYER && f.getType() == EntityType.PLAYER)) &&
                         e.x < f.x + f.width &&
                         e.x + e.width > f.x &&
                         e.y < f.y + f.height &&
                         e.y + e.height > f.y) {

                     // System.out.println(e + " is colliding with " + f);
                     e.onCollide(f);
                 }
            }
        }
        entities.removeIf(Entity::isDestroy);

        if (++t %60 == 0) {
            SpawnManager.getInstance().spawnEntities();
        }
        entities.addAll(tempBuffer);
        tempBuffer.clear();
    }

    public Player getPlayer() {
        return player;
    }

    public void spawnPlayer(Player player) {
        this.player = player;
        addEntity(player);
    }
}
