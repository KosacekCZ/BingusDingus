package com.bingus.game;

public abstract class Entity {
    protected float x;
    protected float y;
    protected float length;
    protected float height;
    private boolean destroy = false;

    public abstract void update();

    public abstract void onCollide(Entity e);

    public void destroy() {
        destroy = true;
    }

    public boolean isDestroy() {
        return destroy;
    }
}
