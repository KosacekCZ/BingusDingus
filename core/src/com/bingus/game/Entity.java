package com.bingus.game;

public abstract class Entity {
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    private boolean destroy = false;
    protected int health;
    private EntityType type;

    public abstract void update();

    public abstract void onCollide(Entity e);

    public void destroy() {
        destroy = true;
    }

    public boolean isDestroy() {
        return destroy;
    }

    public abstract EntityType getType();
}
