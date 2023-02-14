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
	EntityManager etm = EntityManager.getInstance();
	ProjectileManager pm;
	
	@Override
	public void create () {
		sm = SpriteManager.getInstance();
		em = new EnemyManager();
		etm.addEntity(new Player());
		pm = new ProjectileManager();

		sm.loadSprite("characters/Bingus.png", "player");
		sm.loadSprite("characters/piskel.png", "piskel");
		sm.loadSprite("bullet.png", "bullet");
		sm.loadSprite("missing.png", "missing");
		sm.loadSprite("characters/projektyl.png", "projectile");
		sm.loadSprite("characters/zhulus_3.png", "zhulus");
	}


	@Override
	public void render () {
		ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1);

		// tady se dělá všechno renderování
		sm.batchBegin();
		// tady se dělá všechno renderování
		pl.update();
		em.update(pl);
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
