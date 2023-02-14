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
	EnemyManager em;
	
	@Override
	public void create () {
		sm = SpriteManager.getInstance();
		em = new EnemyManager();

		sm.loadSprite("characters/Bingus.png", "player");
		sm.loadSprite("characters/piskel.png", "piskel");
	}


	@Override
	public void render () {

		ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1);

		// tady se dělá všechno renderování
		sm.batchBegin();
		pl.update(sm);
		em.update(pl);

		sm.batchEnd();







	}
	
	@Override
	public void dispose () {
		sm.dispose();
	}
}
