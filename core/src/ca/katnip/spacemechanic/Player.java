package ca.katnip.spacemechanic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player implements Entity {
	
	private final Texture sprite;
	private final float speed = 200;
	
	private float x;
	private float y;

	public Player() {
		sprite = new Texture("sprites/player.png");
		x = 0;
		y = 0;
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(sprite, x, y);
	}

	@Override
	public void update(float delta) {
		float dx = 0, dy = 0;
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			dx = -1;
		} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			dx = 1;
		}
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			dy = 1;
		} else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			dy = -1;
		}
		
		x += delta * dx * speed;
		y += delta * dy * speed;
	}

}
