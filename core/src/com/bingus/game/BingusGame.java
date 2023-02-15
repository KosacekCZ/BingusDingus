package com.bingus.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

// uprav to
public class BingusGame extends ApplicationAdapter {
	Player pl = new Player();
	SpriteManager sm;
	EntityManager etm = EntityManager.getInstance();
	ProjectileManager pm;
	
	@Override
	public void create () {
		sm = SpriteManager.getInstance();

		etm.spawnPlayer(new Player());
		pm = new ProjectileManager();


		sm.loadSprite("characters/Bingus.png", "");
		sm.loadSprite("characters/piskel.png", "piskel");
		sm.loadSprite("bullet.png", "bullet");
		sm.loadSprite("missing.png", "missing");
		sm.loadSprite("characters/projektyl.png", "projectile");
		sm.loadSprite("characters/zhulus_3.png", "zhulus");
		sm.loadSprite("characters/Mercedus.png", "player");
		sm.loadSprite("characters/Peenus.png", "peenus");
	}


	@Override
	public void render () {
		ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1);


		sm.batchBegin();
		// tady se dělá všechno renderování
		pl.update();
		pm.update(pl);
		etm.update();




		// end
		sm.batchEnd();
	}
	
	@Override
	public void dispose () {
		sm.dispose();
	}
}
