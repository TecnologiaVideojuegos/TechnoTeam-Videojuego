package core;

import model.Hero;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class GameStatus {
    public static boolean musicOn;

    public static int levelID;
    public TiledMap map;
    public String mapPath;
    public static int x, y;
    public static int money;

    public static int spriteNumber;
    public static Hero hero;

    public GameStatus() throws SlickException {
        musicOn = true;
        this.hero = new Hero();
    }
}
