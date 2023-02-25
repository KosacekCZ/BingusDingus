package com.bingus.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

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
        Texture t = textures.get(name);

        batch.draw(t, x, y, t.getWidth() * 2, t.getHeight() * 2);
    }

    public void draw(TextureRegion textureRegion, float x, float y, float w, float h) {
        batch.draw(textureRegion, x, y, textureRegion.getRegionWidth()*2*w, textureRegion.getRegionHeight()*2*h);
    }

    public void draw(String name, float x, float y, float w, float h) {
        Texture t = textures.get(name);
        batch.draw(t, x, y, t.getWidth()*2*w, t.getHeight()*2*h);
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
