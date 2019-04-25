package core;

import java.util.HashMap;
import model.Hero;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class GameStatus extends core.LoadEntity {


    public static boolean musicOn;

    public static int levelID;
    public TiledMap map;
    public String mapPath;
    public static int pos_x_hero, pos_y_hero;

    public static int spriteNumber;
    public static Sprite sprite;
    public static Hero hero;


    LoadEntity loadEntity;

    public GameStatus() throws SlickException {
        musicOn = true;

        levelID = 200;
        mapPath = "graphic/map/" + Integer.toString(levelID) + ".tmx";
        map = new TiledMap(mapPath);

        spriteNumber = 1;

        sprite = new Sprite();

        pos_x_hero = 238;
        pos_y_hero = 200;

        hero = new Hero();

        updateEntityFieldList(map);
    }
}

