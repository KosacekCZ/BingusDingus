package com.bingus.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;

public class BingusGame extends ApplicationAdapter {
	SpriteManager sm;
	EntityManager em;
	PlayerManager pm;
	SpawnManager sp;
	GameManager gm;
	WaveManager wm;
	ObjectAnimator oa;
	BitmapFont font;
	private float t;
	private float t2;

	
	@Override
	public void create () {
		sm = SpriteManager.getInstance();
		em = EntityManager.getInstance();
		pm = PlayerManager.getInstance();
		sp = SpawnManager.getInstance();
		wm = WaveManager.getInstance();
		gm = GameManager.getInstance();
		oa = ObjectAnimator.getInstance();
		em.spawnPlayer(new Player());

		font = generateFont(48);
		pm.setFont(generateFont(24));

		wm.nextWave();
		em.getPlayer().setWeapon(AttackType.BASIC);
		sm.loadSprite("Bingus.png", "");
		sm.loadSprite("background.png", "background");
		sm.loadSprite("gradient.png", "gradient");
		sm.loadSprite("healthbar.png", "healthbar");
		sm.loadSprite("panel.png", "panel");
		sm.loadSprite("heart.png", "heart");
		sm.loadSprite("heart2.png", "heart2");
		sm.loadSprite("zhulus1.png", "piskel");
		sm.loadSprite("bullet.png", "bullet");
		sm.loadSprite("missing.png", "missing");
		sm.loadSprite("projektyl.png", "projectile");
		sm.loadSprite("projectile3.png", "projectile3");
		sm.loadSprite("blueProjectile.png", "blueProjectile");
		sm.loadSprite("zhulus_3.png", "zhulus");
		sm.loadSprite("Mercedus.png", "player");
		sm.loadSprite("Peenus.png", "peenus");
		sm.loadSprite("shadow.png", "shadow");
		sm.loadSprite("mogus/mogus1.png", "mogus1");
		sm.loadSprite("mogus/mogus2.png", "mogus2");
		sm.loadSprite("mogus/mogus3.png", "mogus3");
		sm.loadSprite("coin.png", "coin");
		sm.loadSprite("coin_animated.png", "coin_animated");
		sm.loadSprite("amogus_walking.png", "amogus_walking");
		sm.loadSprite("amogus_still.png", "amogus_still");
	}


	@Override
	public void render () {
		t += 0.05f;
		ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1);

		sm.batchBegin();
		oa.update();
		// Frame render start

		// Gameplay render & update
		if(gm.isStartGame()) {
			SpriteManager.getInstance().draw("background", 0, 0, 2, 2.2f);
			em.update();
			sp.update();


			sm.draw("gradient", 0, 800, 8, 2.2f);
			sm.draw("gradient", 0, 250, 8, -2.2f);
			pm.drawHealth();
			pm.drawInventory();


			// Draw main menu
		} else if (!gm.isStartGame() && !gm.isPlayerDead()) {
			sm.draw("background", 0, 0, 2, 2.2f);
			sm.draw("gradient", 0, 50, 8, 8.2f);
			font.draw(sm.batch,"Press ENTER to start!", (1920/2) - 400, (int)((800) + (Math.sin(t) * 30)));
			sm.draw("shadow", (1920/2) - 90, (1080/2) - 90);
			if (Math.cos(t * 4) < -0.5) {
				sm.draw("mogus2", (1920/2) - 64, (1080/2) - 64 );
			} else if (Math.cos(t * 4) > 0.5) {
				sm.draw("mogus3", (1920/2) - 64, (1080/2) - 64 );
			} else {
				sm.draw("mogus1", (1920/2) - 64, (1080/2) - 60 );
			}
			if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) gm.setStartGame(true);
		}


		// Exit Game
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) Gdx.app.exit();
		// end
		sm.batchEnd();

		t = (t % 60 == 0 ? 0 : t);
	}
	
	@Override
	public void dispose () {
		sm.dispose();
	}

	private BitmapFont generateFont(int size) {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("assets/font/slkscrb.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = size;
		parameter.borderWidth = 0;
		parameter.color = Color.WHITE;
		parameter.shadowOffsetX = 4;
		parameter.shadowOffsetY = 4;
		parameter.shadowColor = new Color(0.2f, 0.2f, 0.2f, 0.85f);
		BitmapFont customFont = generator.generateFont(parameter); // font size 24 pixels
		generator.dispose();
		return customFont;
	}
}
