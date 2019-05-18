package principal;

import java.util.ArrayList;
import java.util.HashMap;
import modelos.NPC;
import modelos.Hero;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import utils.EnemyData;
import personaje.Ataque;


public class GameStatus extends LoadEntity {


    public static boolean musicOn;

    public static int levelID;
    public TiledMap map;
    public String mapPath;
    public static int pos_x_hero, pos_y_hero;

    public static int spriteNumber;
    public static Sprite sprite;
    public static Ataque ataque1;
    public static Hero hero;
    public Image fondo = new Image ("graphic/enemysprite/bocadillo1.png");
    
    public ArrayList<modelos.Portal> portalMapList;
    public static HashMap<Integer, NPC> enemys;

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
        
        ataque1 = new Ataque(50,50,"Roldán","hola",50);
        
        this.portalMapList = new ArrayList<>();
        enemys = EnemyData.enemyData();

        updateEntityFieldList(map);
        updatePortalMapList(portalMapList);
    }
}

