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
            System.out.println(entities.size());
          for (Entity f : entities) {
              // System.out.println("E:" + e.x + " " + e.y + " " + " " + e.w + " " + e.h + " " + e.getType() + " F: " + f.x + " " + f.y + " " + " " + f.w + " " + f.h + " " + f.getType());
                 if (e != f &&
                         e.x < f.x + f.w &&
                         e.x + e.w > f.x &&
                         e.y < f.y + f.h &&
                         e.y + e.h > f.y) {

                     e.onCollide(f);
                 }
            }
        }
        entities.removeIf(Entity::isDestroy);

        if (++t %60 == 0) {
            //SpawnManager.getInstance().spawnEntities();
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
