package com.bingus.game;

public class GameManager {
    public static GameManager instance;
    public static GameManager getInstance() {
        if (instance == null) instance = new GameManager();
        return instance;
    }

    private boolean startGame = false;
    private boolean playerDied = false;




    public boolean isStartGame() {
        return this.startGame;
    }

    public void setStartGame(boolean state) {
        this.startGame = state;
    }

    public boolean isPlayerDead() {
        return this.playerDied;
    }

    public void setPlayerDead(boolean state) {
        this.playerDied = state;
    }
}
