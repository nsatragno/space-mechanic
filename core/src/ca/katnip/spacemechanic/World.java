package ca.katnip.spacemechanic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class World implements Entity {

	private Player player;
	private ArrayList<Entity> entities;
	
	World() {
		entities = new ArrayList<>();
		player = new Player();
		entities.add(player);
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		entities.forEach(entity -> entity.draw(batch));
	}

	@Override
	public void update() {
		entities.forEach(entity -> entity.update());
	}

}
