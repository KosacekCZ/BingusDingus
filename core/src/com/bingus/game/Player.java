package com.bingus.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.bingus.game.projectiles.PlayerProjectile;

public class Player extends Entity {
    private boolean attackSwitch = false;

    final float speed = 8;
    private int t = 0;
    private float r = 0f;
    private AttackType weapon = AttackType.SPINNING;

    public Player() {
        this.w = 10f;
        this.h = 10f;
        this.health = 100;
        this.scale = 1.3f;
    }

    public void update(){
        if (Gdx.input.isKeyPressed(Input.Keys.D)) x+=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x-=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) y+=speed;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) y-=speed;
        SpriteManager.getInstance().draw("player", x, y, scale, scale);



        if (t % 5 == 0) attack(weapon);
        if (health <= 0) destroy();
        t++;
        r += r >= 2f ? -r : 0.115f;
    }

    public void onCollide(Entity e) {
        if(e.getType() == EntityType.ENEMYBULLET) receiveDamage(e.damage);
        if(e.getType() == EntityType.ENEMY) receiveDamage(e.damage);
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
            if (attackSwitch) {
                for (float i = 0; i < 2f; i += 0.25f) {
                    em.addEntity(new PlayerProjectile(new Coordinate(this.x, this.y, 5, 5, i + r), 20, 8, "projectile2", null));
                }
            }
            attackSwitch = !attackSwitch;

        } else if (at == AttackType.BURST) {
            for (float i = 0; i < 2f; i += 0.25f) {
                em.addEntity(new PlayerProjectile(new Coordinate(this.x, this.y, 8, 8, i + 0.0f), 30, 9.5f, "projectile2", null));
                em.addEntity(new PlayerProjectile(new Coordinate(this.x, this.y, 8, 8, i + 0.1f), 30, 10f, "projectile2", null));
                em.addEntity(new PlayerProjectile(new Coordinate(this.x, this.y, 8, 8, i - 0.1f), 30, 8.5f, "projectile2", null));
            }
        } else if (at == AttackType.RAPID) {

        } else if (at == AttackType.SPINNING) {
            em.addEntity(new PlayerProjectile(new Coordinate(this.x, this.y, 8, 8, this.t + 0.0f), 30, 9.5f, "projectile2", AttackType.SPINNING));

        }
    }

    public void setWeapon(AttackType weapon) {
        this.weapon = weapon;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
}