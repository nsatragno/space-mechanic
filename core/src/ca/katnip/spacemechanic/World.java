package ca.katnip.spacemechanic;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class World {

	private Player player;
	private Ship ship;
	private ArrayList<Entity> entities;
	private OrthographicCamera camera;
	
	public World() {
		camera = new OrthographicCamera(Main.WIDTH, Main.HEIGHT);
		entities = new ArrayList<>();
		player = new Player();
		ship = new Ship();
		entities.add(player);
	}
	
	public void draw() {
		ship.draw(camera);
		entities.forEach(entity -> entity.draw(camera));
	}

	public void update(float delta) {
		if (camera.position.x - camera.viewportWidth / 2 < 0)
			camera.position.x = camera.viewportWidth / 2;
		if (camera.position.y - camera.viewportHeight / 2 < 0)
			camera.position.y = camera.viewportHeight / 2;
		camera.update();
		
		ship.update(delta);
		entities.forEach(entity -> entity.update(delta));
	}

	public OrthographicCamera getCamera() {
		return camera;
	}
}
