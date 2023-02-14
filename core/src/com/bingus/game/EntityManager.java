package com.bingus.game;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Entity> entities = new ArrayList<>();
    private int t = 0;
    private static EntityManager instance;

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
           /* for (Entity f : entities) {
                 if (e != f && (e.x < f.x))
            } */
        }
        entities.removeIf(Entity::isDestroy);
    }

}
