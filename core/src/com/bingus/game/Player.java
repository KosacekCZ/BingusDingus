package com.bingus.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player {

    public float projectileSpeed = 1;
    float x = 0;
    float y = 0;
    float speed = 1f;
    int shotsFired = 8;
    int firerate = 60; // shoots every x frames
    int shotDamage = 1;

    public void update(SpriteManager sm){
        if (Gdx.input.isKeyPressed(Input.Keys.D)) x+=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x-=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) y+=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) y-=speed;

        sm.draw("player", x, y);

    }
}
