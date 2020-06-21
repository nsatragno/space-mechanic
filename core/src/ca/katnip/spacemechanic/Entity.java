package ca.katnip.spacemechanic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Entity {
	public void update(float delta);
	public void draw(SpriteBatch batch);
}
