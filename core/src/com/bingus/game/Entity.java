package com.bingus.game;

public abstract class Entity {
    protected float x;
    protected float y;
    protected float w;
    protected float h;
    protected float scale;
    protected float t = 0;
    protected float speed;
    private boolean destroy = false;
    protected int health;
    protected int damage;

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
