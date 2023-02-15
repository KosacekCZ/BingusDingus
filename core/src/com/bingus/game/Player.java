package com.bingus.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends Entity {

    final float speed = 8;
    private int t = 0;

    public Player() {
        this.width = 10f;
        this.height = 10f;
        this.health = 100;
    }

    public void update(){
        if (Gdx.input.isKeyPressed(Input.Keys.D)) x+=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x-=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) y+=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) y-=speed;
        SpriteManager.getInstance().draw("player", x, y);



        if (++t %60 == 0) {
            // System.out.println("Player | x: " + x + " y: " + y);
        }
    }

    public void onCollide(Entity e) {

        switch (e.getType()) {
            case ENEMYBULLET:
                receiveDamage(20);
                break;
        }


    }

    public EntityType getType() {
        return EntityType.PLAYER;
    }

    public void receiveDamage(int damage) {
        health -= damage;
        System.out.println(damage);
    }
}