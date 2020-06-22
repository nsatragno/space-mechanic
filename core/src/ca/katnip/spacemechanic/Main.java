package ca.katnip.spacemechanic;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class Main extends Game {
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 360;

	private World world;
	
	@Override
	public void create() {
		this.setScreen(new PlatformerScreen(this));
		world = new World();
	}
	
	public World getWorld() {
		return world;
	}
	
	@Override
	public void render() {
		world.update(Gdx.graphics.getDeltaTime());
		super.render();
	}
}
