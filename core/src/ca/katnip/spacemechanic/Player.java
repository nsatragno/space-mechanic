package ca.katnip.spacemechanic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * The player-controller avatar.
 */
public class Player implements Entity, HasCoordinates {
	
	private final Texture sprite;
	private final float speed = 200;
	private final Ship ship;
	
	private SpriteBatch batch;
	private float x = 64;
	private float y = 64;

	public Player(Ship ship) {
		this.ship = ship;
		sprite = new Texture("sprites/player.png");
		batch = new SpriteBatch();
	}
	
	@Override
	public void draw(OrthographicCamera camera) {
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		batch.draw(sprite, x, y);
		batch.end();
	}

	@Override
	public void update(float delta) {
		Vector2 dv = new Vector2();
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			dv.x = -1;
		} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			dv.x = 1;
		}
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			dv.y = 1;
		} else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			dv.y = -1;
		}
		
		dv.scl(speed * delta);
		
		if (ship.collides(this, dv)) {
			dv = ship.clipVectorToSurface(this, dv);
		}
		
		x += dv.x;
		y += dv.y;
	}

	@Override
	public float getX() {
		return x;
	}
	
	@Override
	public float getY() {
		return y;
	}
}
