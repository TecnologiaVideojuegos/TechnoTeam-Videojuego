package principal;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.tiled.TiledMap;

public class Camara {

    public TiledMap map;

    protected int numTilesX;

    protected int numTilesY;

    public static int mapHeight;

    public static int mapWidth;

    protected int tileWidth;

    protected int tileHeight;

    protected GameContainer gc;

    protected float cameraX;

    protected float cameraY;

    public Camara(GameContainer gc, TiledMap map) {
        this.map = map;

        this.numTilesX = map.getWidth();
        this.numTilesY = map.getHeight();

        this.tileWidth = map.getTileWidth();
        this.tileHeight = map.getTileHeight();

        mapHeight = this.numTilesX * this.tileWidth;
        mapWidth = this.numTilesY * this.tileHeight;

        this.gc = gc;
    }

    public void centerOn(float x, float y) {
        cameraX = 0;
        cameraY = 0;
    }

    public void centerOn(Shape shape) {
        this.centerOn(shape.getCenterX(), shape.getCenterY());
    }

    public void drawMap(int layer) {
        map.render(0, 0, layer);
    }

}
