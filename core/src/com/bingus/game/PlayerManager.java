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


}
