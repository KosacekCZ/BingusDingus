package com.bingus.game;

public class WaveManager {
    public static WaveManager instance;
    public static WaveManager getInstance() {
        if (instance == null) instance = new WaveManager();
        return instance;
    }

    private int coins = 0;
    private int score = 0;
    private int wave = 0;


    public int getCoins() {
        return this.coins;
    }

    public void addCoins(int value) {
        this.coins += value;
    }

    public int getScore() {
        return this.score;
    }

    public void addScore(int value) {
        this.score += value;
    }

    public int getWave() {
        return this.wave;
    }

    public void setWave(int wave) {
        this.wave += wave;
    }
}
