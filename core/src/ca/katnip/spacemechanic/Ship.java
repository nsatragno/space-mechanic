package ca.katnip.spacemechanic;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * The player's ship.
 */
public class Ship implements Entity {
	
	private static class CellWithCoordinates {
		private int x;
		private int y;
		private Cell cell;
		
		public CellWithCoordinates(int x, int y, Cell cell) {
			this.x = x;
			this.y = y;
			this.cell = cell;
		}
	}

	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private TiledMapTileLayer foreground;
	
	public Ship() {
		map = new TmxMapLoader().load("maps/example-map.tmx");
		foreground = (TiledMapTileLayer) map.getLayers().get("foreground");
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

	/**
	 * Determines whether an object is colliding in this frame with a map surface.
	 * @param object the object tested for collision.
	 * @param dv the speed at which the object is traveling.
	 * @return true if they collide, false otherwise.
	 */
	public boolean collides(HasCoordinates object, Vector2 dv) {
		ArrayList<CellWithCoordinates> cells = new ArrayList<>();
		
		// Obtain all the tiles in the rectangle formed between the object's coordinates and dv.
		Vector2 bottomLeft = new Vector2();
		Vector2 topRight = new Vector2();
		if (dv.x > 0) {
			// dv points right.
			bottomLeft.x = object.getX();
			topRight.x = object.getX() + dv.x;
		} else {
			// dv points left.
			bottomLeft.x = object.getX() + dv.x;
			topRight.x = object.getX();
		}
		if (dv.y > 0) {
			// dv points up.
			bottomLeft.y = object.getY();
			topRight.y = object.getY() + dv.y;
		} else {
			// dv points down.
			bottomLeft.y = object.getY() + dv.y;
			topRight.y = object.getY();
		}
		
		// Assumes tiles are square.
		bottomLeft.scl(1 / foreground.getTileWidth());
		topRight.scl(1 / foreground.getTileWidth());
		
		for (int x = (int)bottomLeft.x; x <= (int)topRight.x; ++x) {
			for (int y = (int)bottomLeft.y; y <= (int)topRight.y; ++y) {
				Cell cell = foreground.getCell(x, y);
				if (cell != null) {
					cells.add(new CellWithCoordinates(x, y, cell));
				}
			}
		}

		return cells.stream().anyMatch(cell -> {
			return Intersector.intersectSegmentRectangle(
					bottomLeft, topRight, new Rectangle(cell.x, cell.y, 1, 1));
		});
	}

	/**
	 * Returns a vector that when added to the object x and y coordinates, puts the object on the
	 * surface it would have collided with.
	 * @param player
	 * @param dv
	 * @return
	 */
	public Vector2 clipVectorToSurface(HasCoordinates object, Vector2 dv) {
		return new Vector2();
	}

}
