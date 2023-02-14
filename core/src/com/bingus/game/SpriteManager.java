package com.bingus.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class SpriteManager {

    private static SpriteManager instance;

    public static SpriteManager getInstance() {
        if (instance == null) {
            instance = new SpriteManager();
        }

        return instance;
    }

    SpriteBatch batch;
    HashMap<String, Texture> textures = new HashMap<>();

    public SpriteManager(){
        batch = new SpriteBatch();
    }

    public void loadSprite(String path, String name) {
        textures.put(name, new Texture(path));

    }

    public void draw(String name, float x, float y) {
        batch.draw(textures.get(name), x, y, 64f, 64f);
    }

    public void batchBegin() {
        batch.begin();

    }

    public void batchEnd() {
        batch.end();

    }

    public void dispose() {
        batch.dispose();
        for (Texture t: textures.values()) {
            t.dispose();
        }

    }
}
