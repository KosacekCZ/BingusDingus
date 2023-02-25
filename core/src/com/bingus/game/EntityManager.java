package com.bingus.game;

import java.util.ArrayList;

public class EntityManager {
    private final ArrayList<Entity> entities = new ArrayList<>();
    private final ArrayList<Entity> tempBuffer = new ArrayList<>();
    private long t = 0;
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
            //System.out.println(entities.size());

            // Collision check for each entity in list
          for (Entity f : entities) {
                 if (e != f &&
                         e.x < f.x + f.w &&
                         e.x + e.w > f.x &&
                         e.y < f.y + f.h &&
                         e.y + e.h > f.y) {

                     e.onCollide(f);
                 }
            }
        }
        // Despawn of "dead" entities
        entities.removeIf(Entity::isDestroy);
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

    public boolean isEnemiesDead() {
        int enemies = 0;
        for (Entity e : entities) {
            if(e.getType() == EntityType.ENEMY) enemies++;
        }

        return (enemies == 0);
    }
}
