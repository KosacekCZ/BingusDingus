package com.bingus.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class BingusGame extends ApplicationAdapter {
	SpriteManager sm;
	EntityManager etm;
	PlayerManager pm;
	
	@Override
	public void create () {
		sm = SpriteManager.getInstance();
		etm = EntityManager.getInstance();
		pm = PlayerManager.getInstance();
		etm.spawnPlayer(new Player());


		sm.loadSprite("Bingus.png", "");
		sm.loadSprite("background.png", "background");
		sm.loadSprite("gradient.png", "gradient");
		sm.loadSprite("healthbar.png", "healthbar");
		sm.loadSprite("heart.png", "heart");
		sm.loadSprite("piskel.png", "piskel");
		sm.loadSprite("bullet.png", "bullet");
		sm.loadSprite("missing.png", "missing");
		sm.loadSprite("projektyl.png", "projectile");
		sm.loadSprite("projektyl.png", "projectile2");
		sm.loadSprite("blueProjectile.png", "blueProjectile");
		sm.loadSprite("zhulus_3.png", "zhulus");
		sm.loadSprite("Mercedus.png", "player");
		sm.loadSprite("Peenus.png", "peenus");
	}


	@Override
	public void render () {
		ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1);

		sm.batchBegin();
		// tady se dělá všechno renderování
		SpriteManager.getInstance().draw("background", 0, 0, 2, 2.2f);

		etm.update();



		SpriteManager.getInstance().draw("gradient", 0, 800, 8, 2.2f);
		SpriteManager.getInstance().draw("gradient", 0, 250, 8, -2.2f);
		pm.drawHealth();
		// end
		sm.batchEnd();
	}
	
	@Override
	public void dispose () {
		sm.dispose();
	}
}
