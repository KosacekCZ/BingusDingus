package com.bingus.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

// uprav to
public class BingusGame extends ApplicationAdapter {
	Texture img;
	Player pl = new Player();
	Bingus b = new Bingus(10, 10, 2);
	SpriteManager sm;
	EnemyManager em;
	ProjectileManager pm;
	
	@Override
	public void create () {
		sm = SpriteManager.getInstance();
		em = new EnemyManager();
		pm = new ProjectileManager();

		sm.loadSprite("characters/Bingus.png", "player");
		sm.loadSprite("characters/piskel.png", "piskel");
		sm.loadSprite("bullet.png", "bullet");
		sm.loadSprite("missing.png", "missing");
	}


	@Override
	public void render () {

		ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1);

		// tady se dělá všechno renderování
		sm.batchBegin();
		pl.update(sm);
		em.update(pl);
		pm.update(pl);

		sm.batchEnd();







	}
	
	@Override
	public void dispose () {
		sm.dispose();
	}
}
