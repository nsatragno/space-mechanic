package ca.katnip.spacemechanic;

import com.badlogic.gdx.graphics.OrthographicCamera;

public interface Entity {
	public void update(float delta);
	public void draw(OrthographicCamera camera);
}
