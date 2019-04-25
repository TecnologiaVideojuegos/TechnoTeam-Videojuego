package core;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.tiled.TiledMap;

public class Camera {

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

    public Camera(GameContainer gc, TiledMap map) {
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
        cameraX = x - gc.getWidth() / 2;
        cameraY = y - (gc.getHeight() / 2) ;

        if (cameraX < 0) {
            cameraX = 0;
        }
        if (cameraX + Game.WIDTH > mapWidth) {
            cameraX = mapWidth - gc.getWidth();
        }

        if (cameraY < 0) {
            cameraY = 0;
        }
        if (cameraY + Game.HEIGHT > (mapHeight + 120)) {
            cameraY = (mapHeight + 120) - gc.getHeight() ;
        }
        
        if (mapWidth < core.Game.WIDTH) {
            cameraX = ((mapWidth / 2) - (core.Game.WIDTH / 2));
        }
        if (mapHeight < core.Game.HEIGHT) {
            cameraY = ((mapHeight / 2) + 80 - (core.Game.HEIGHT / 2));
        }
    }

    public void centerOn(float x, float y, float height, float width) {
        this.centerOn(x + width / 2, y + height / 2);
    }

    public void centerOn(Shape shape) {
        this.centerOn(shape.getCenterX(), shape.getCenterY());
    }

    public void drawMap(int layer) {
        this.drawMap(0, 0, layer);
    }

    public void drawMap(int offsetX, int offsetY, int layer) {
        //calculate the offset to the next tile (needed by TiledMap.render())
        int tileOffsetX = (int) -(cameraX % tileWidth);
        int tileOffsetY = (int) -(cameraY % tileHeight);

        //calculate the index of the leftmost tile that is being displayed
        int tileIndexX = (int) (cameraX / tileWidth);
        int tileIndexY = (int) (cameraY / tileHeight);

        //finally draw the section of the MAP on the screen
        map.render(
                tileOffsetX + offsetX,
                tileOffsetY + offsetY,
                tileIndexX,
                tileIndexY,
                (gc.getWidth() - tileOffsetX) / tileWidth + 1,
                (gc.getHeight() - tileOffsetY) / tileHeight + 1, layer, false);
    }

    public void translateGraphics() {
        gc.getGraphics().translate(-cameraX, -cameraY);
    }

    public void untranslateGraphics() {
        gc.getGraphics().translate(cameraX, cameraY);
    }

}
