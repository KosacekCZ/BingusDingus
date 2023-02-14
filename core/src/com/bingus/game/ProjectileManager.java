package com.bingus.game;

import java.util.ArrayList;


public class ProjectileManager {
    private ArrayList<Projectile> projectiles = new ArrayList<>();
    private int t = 0;

    public void spawn(Player projectileOrigin) {
        for (int i = 0; i < projectileOrigin.shotsFired; i++) { // FIXME: střílí to 2x2 projektily s neúměrnou vzdáleností mezi nima
            projectiles.add(new PlayerProjectile(projectileOrigin, (float) 360 / projectileOrigin.shotsFired * i));
        }
    }

    public void update(Player pl) {
        t++;
        if (t % pl.firerate == 0) {
            spawn(pl);
        }

        for (Projectile p : projectiles) {
            p.update();
        }
    }
}
