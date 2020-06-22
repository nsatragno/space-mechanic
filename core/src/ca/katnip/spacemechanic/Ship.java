package ca.katnip.spacemechanic;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Ship implements Entity {

	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	
	public Ship() {
		map = new TmxMapLoader().load("maps/example-map.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void draw(OrthographicCamera camera) {
		renderer.setView(camera);
		renderer.render();
	}

}
