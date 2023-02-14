package com.bingus.game;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Entity> entities = new ArrayList<>();
    private int t = 0;
    private static EntityManager instance;
    private Player player;

    public static EntityManager getInstance() {
        if (instance == null) instance = new EntityManager();
        return instance;
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void update() {
        for (Entity e: entities) {
            e.update();
          for (Entity f : entities) {
                 if (e != f && (e.x < f.x + f.length && e.x + e.length > f.x) && (e.y < f.y + f.height && e.y + e.height > f.y)) {
                     e.onCollide(f);
                 }
            }
        }
        entities.removeIf(Entity::isDestroy);
    }

    public Player getPlayer() {
        return player;
    }

    public void spawnPlayer(Player player) {
        this.player = player;
        addEntity(player);
    }
}
