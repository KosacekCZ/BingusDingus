package com.bingus.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class PlayerManager {
    public static PlayerManager instance;
    private Player player;
    private float scale = 2f;
    private float height = 12;
    private BitmapFont font;

    public void update() {
        this.player.update();
    }

    public Coordinate getCds() {
        return new Coordinate(player.x, player.y, player.w, player.h);
    }

    public static PlayerManager getInstance() {
        if(instance == null) instance = new PlayerManager();
        return instance;
    }

    public void drawHealth() {
        EntityManager em = EntityManager.getInstance();
        SpriteManager sm = SpriteManager.getInstance();
        sm.draw("panel", 1350, 10, 2.2f, 1f);

        if (em.getPlayer().health >= 80) {
            sm.draw("heart", 1580, height, scale, scale);
            sm.draw("heart", 1640, height, scale, scale);
            sm.draw("heart", 1700, height, scale, scale);
            sm.draw("heart", 1760, height, scale, scale);
            sm.draw("heart", 1820, height, scale, scale);

        } else if (em.getPlayer().health >= 60) {
            sm.draw("heart", 1580, height, scale, scale);
            sm.draw("heart", 1640, height, scale, scale);
            sm.draw("heart", 1700, height, scale, scale);
            sm.draw("heart", 1760, height, scale, scale);
            sm.draw("heart2", 1820, height, scale, scale);

        } else if (em.getPlayer().health >= 40) {
            sm.draw("heart", 1580, height, scale, scale);
            sm.draw("heart", 1640, height, scale, scale);
            sm.draw("heart", 1700, height, scale, scale);
            sm.draw("heart2", 1760, height, scale, scale);
            sm.draw("heart2", 1820, height, scale, scale);

        } else if (em.getPlayer().health >= 20) {
            sm.draw("heart", 1580, height, scale, scale);
            sm.draw("heart", 1640, height, scale, scale);
            sm.draw("heart2", 1700, height, scale, scale);
            sm.draw("heart2", 1760, height, scale, scale);
            sm.draw("heart2", 1820, height, scale, scale);

        } else if (em.getPlayer().health > 0) {
            sm.draw("heart", 1580, height, scale, scale);
            sm.draw("heart2", 1640, height, scale, scale);
            sm.draw("heart2", 1700, height, scale, scale);
            sm.draw("heart2", 1760, height, scale, scale);
            sm.draw("heart2", 1820, height, scale, scale);
        } else {
            sm.draw("heart2", 1580, height, scale, scale);
            sm.draw("heart2", 1640, height, scale, scale);
            sm.draw("heart2", 1700, height, scale, scale);
            sm.draw("heart2", 1760, height, scale, scale);
            sm.draw("heart2", 1820, height, scale, scale);
        }
        font.draw(sm.batch, "Health: " + em.getPlayer().health, 1370, height + 40);
    }

    public void drawInventory() {

    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }


}
