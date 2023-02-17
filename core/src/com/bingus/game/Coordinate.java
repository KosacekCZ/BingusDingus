package com.bingus.game;

public class Coordinate {
    public float x;
    public float y;
    public float w;
    public float h;
    public float dir;

    public Coordinate(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public Coordinate(float x, float y, float w, float h, float dir) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dir = (float) (dir * Math.PI);
    }

}
