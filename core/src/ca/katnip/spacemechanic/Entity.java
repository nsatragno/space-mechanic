package ca.katnip.spacemechanic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Entity {
	public void update();
	public void draw(SpriteBatch batch);
}
