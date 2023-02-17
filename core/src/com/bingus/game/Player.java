package com.bingus.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.bingus.game.projectiles.PlayerProjectile;

public class Player extends Entity {

    final float speed = 8;
    private int t = 0;

    public Player() {
        this.w = 10f;
        this.h = 10f;
        this.health = 100;
    }

    public void update(){
        if (Gdx.input.isKeyPressed(Input.Keys.D)) x+=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x-=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) y+=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) y-=speed;
        SpriteManager.getInstance().draw("player", x, y);



        if (++t % 120 == 0) attack(AttackType.BURST);
    }

    public void onCollide(Entity e) {
        if(e.getType() == EntityType.ENEMYBULLET) receiveDamage(e.damage);
    }

    public EntityType getType() {
        return EntityType.PLAYER;
    }

    public void receiveDamage(int damage) {
        health -= damage;
        System.out.println(damage);
    }

    public void attack(AttackType at) {
        EntityManager em = EntityManager.getInstance();
        if(at == AttackType.BASIC) {
            for (float i = 0; i < 2f; i += 0.25f) {
                em.addEntity(new PlayerProjectile(new Coordinate(this.x, this.y, 5, 5, i), 20, 10, "projectile2"));
            }

        } else if (at == AttackType.BURST) {
            for (float i = 0; i < 2f; i += 0.25f) {
                em.addEntity(new PlayerProjectile(new Coordinate(this.x, this.y, 5, 5, i + 0.0f), 20, 9, "projectile2"));
                em.addEntity(new PlayerProjectile(new Coordinate(this.x, this.y, 5, 5, i + 0.1f), 20, 10, "projectile2"));
                em.addEntity(new PlayerProjectile(new Coordinate(this.x, this.y, 5, 5, i - 0.1f), 20, 8, "projectile2"));
            }
        }
    }
}