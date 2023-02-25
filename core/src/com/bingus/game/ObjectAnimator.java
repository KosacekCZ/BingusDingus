package com.bingus.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ObjectAnimator {
    public static ObjectAnimator instance;
    public static ObjectAnimator getInstance() {
        if (instance == null) instance = new ObjectAnimator();
        return instance;
    }

    SpriteManager sm = SpriteManager.getInstance();
    private int t = 0;

    public void update() {
        t = (++t % 60 == 0 ? 0 : t);
    }

    public TextureRegion animationManager(String textureName) {
        Texture tx = sm.textures.get(textureName);
        int w = tx.getWidth();
        int h = tx.getHeight();
        if (t > 0 && t <= 10) {
            return new TextureRegion(tx, 0, 0, (w / 6), h);
        } else if (t > 10 && t <= 20) {
            return new TextureRegion(tx, (w / 6), 0, (w / 6), h);
        } else if (t > 20 && t <= 30) {
            return new TextureRegion(tx, (w / 6) * 2,  0, (w / 6), h);
        } else if (t > 30 && t <= 40) {
            return new TextureRegion(tx, (w / 6) * 3, 0, (w / 6), h);
        } else if (t > 40 && t <= 50) {
            return new TextureRegion(tx, (w / 6) * 4, 0, (w / 6), h);
        } else {
            return new TextureRegion(tx, (w / 6) * 5, 0, (w / 6), h);
        }
    }
}
