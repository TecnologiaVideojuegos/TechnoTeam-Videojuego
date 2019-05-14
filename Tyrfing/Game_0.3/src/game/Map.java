package game;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Map {
	private TiledMap tiledMap;
	
	public void init() throws SlickException {
		this.tiledMap = new TiledMap("resources/maps/6.tmx");
	}
	
	public void render() {
		this.tiledMap.render(0, 0);
	}
	
	public TiledMap getTiledMap() {
		return this.tiledMap;
	}
	
	public int getTileId(int x, int y, int layer) {
		return tiledMap.getTileId(x, y, layer);
	}
	
	public String getTileProperty(int id, String prop, String def) {
		return tiledMap.getTileProperty(id, prop, def);
	}
}
