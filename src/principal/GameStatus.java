package principal;

import java.util.ArrayList;
import modelos.Hero;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class GameStatus extends LoadEntity {


    public static boolean musicOn;

    public static int levelID;
    public TiledMap map;
    public String mapPath;
    public static int pos_x_hero, pos_y_hero;

    public static int spriteNumber;
    public static Sprite sprite;
    public static Hero hero;
    
    public ArrayList<modelos.Portal> portalMapList;

    public GameStatus() throws SlickException {
        musicOn = true;

        levelID = 400;
        mapPath = "graphic/map/" + Integer.toString(levelID) + ".tmx";
        map = new TiledMap(mapPath);
        
        spriteNumber = 1;

        sprite = new Sprite();

        pos_x_hero = 500;
        pos_y_hero = 520;

        hero = new Hero();
        
        this.portalMapList = new ArrayList<>();

        updateEntityFieldList(map);
        updatePortalMapList(portalMapList);
    }
}

