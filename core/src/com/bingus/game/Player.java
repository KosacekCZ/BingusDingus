package com.bingus.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends Entity {

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