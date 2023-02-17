package com.bingus.game;

public class PlayerManager {
    public static PlayerManager instance;
    private Player player;

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
        SpriteManager.getInstance().draw("healthbar", 1580, 1000, 2f, 2f);

        if (em.getPlayer().health >= 80) {
            SpriteManager.getInstance().draw("heart", 1580, 1005, 2f, 2f);
            SpriteManager.getInstance().draw("heart", 1640, 1005, 2f, 2f);
            SpriteManager.getInstance().draw("heart", 1700, 1005, 2f, 2f);
            SpriteManager.getInstance().draw("heart", 1760, 1005, 2f, 2f);
            SpriteManager.getInstance().draw("heart", 1820, 1005, 2f, 2f);

        } else if (em.getPlayer().health >= 60) {
            SpriteManager.getInstance().draw("heart", 1580, 1005, 2f, 2f);
            SpriteManager.getInstance().draw("heart", 1640, 1005, 2f, 2f);
            SpriteManager.getInstance().draw("heart", 1700, 1005, 2f, 2f);
            SpriteManager.getInstance().draw("heart", 1760, 1005, 2f, 2f);

        } else if (em.getPlayer().health >= 40) {
            SpriteManager.getInstance().draw("heart", 1580, 1005, 2f, 2f);
            SpriteManager.getInstance().draw("heart", 1640, 1005, 2f, 2f);
            SpriteManager.getInstance().draw("heart", 1700, 1005, 2f, 2f);

        } else if (em.getPlayer().health >= 20) {
            SpriteManager.getInstance().draw("heart", 1580, 1005, 2f, 2f);
            SpriteManager.getInstance().draw("heart", 1640, 1005, 2f, 2f);

        } else if (em.getPlayer().health >= 0) {
            SpriteManager.getInstance().draw("heart", 1580, 1005, 2f, 2f);

        } else {

        }
    }


}
