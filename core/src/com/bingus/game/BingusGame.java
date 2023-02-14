package com.bingus.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

// uprav to
public class BingusGame extends ApplicationAdapter {
	Texture img;
	Player pl = new Player();
	Bingus b = new Bingus(10, 10, 2);
	SpriteManager sm;
	EntityManager etm = EntityManager.getInstance();
	
	@Override
	public void create () {
		sm = SpriteManager.getInstance();
		etm.spawnPlayer(new Player());

		sm.loadSprite("characters/Bingus.png", "");
		sm.loadSprite("characters/piskel.png", "piskel");
		sm.loadSprite("characters/projektyl.png", "projectile");
		sm.loadSprite("characters/zhulus_3.png", "zhulus");
		sm.loadSprite("characters/Mercedus.png", "player");
	}


	@Override
	public void render () {
		ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1);


		sm.batchBegin();
		// tady se dělá všechno renderování
		pl.update();
		etm.update();




		// end
		sm.batchEnd();
	}
	
	@Override
	public void dispose () {
		sm.dispose();
	}
}
