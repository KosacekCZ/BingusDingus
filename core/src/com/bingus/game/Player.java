package com.bingus.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends Entity {

    public float projectileSpeed = 1;
    float x = 0;
    float y = 0;
    float speed = 1f;
    int shotsFired = 8;
    int firerate = 60; // shoots every x frames
    int shotDamage = 1;
    final float speed = 8;

    public void update(){
        if (Gdx.input.isKeyPressed(Input.Keys.D)) x+=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x-=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) y+=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) y-=speed;
        SpriteManager.getInstance().draw("player", x, y);
    }

    public void onCollide(Entity e) {
        //TODO kolize
    }
}

