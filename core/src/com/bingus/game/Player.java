package com.bingus.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player {

    float x = 0;
    float y = 0;
    float speed = 3;

    public void update(SpriteManager sm){
        if (Gdx.input.isKeyPressed(Input.Keys.D)) x+=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x-=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) y+=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) y-=speed;

        sm.draw("player", x, y);

    }
}