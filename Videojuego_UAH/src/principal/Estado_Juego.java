package principal;

import java.util.ArrayList;
import java.util.HashMap;
import modelos.Enemigo;
import modelos.Frase;
import modelos.Heroe;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.tiled.TiledMap;
import utils.BBDD_Dialogo;
import utils.BBDD_Enemigos;

/**
 * @author Techno team
 */

/** 
 * Estado inicial del Juego, ocurre despu�s de la Intro
 *
 */
public class Estado_Juego extends Analisis_Mapa {

	
	//---------------------------------------------
	//Atributos
	//---------------------------------------------

    public static boolean musicOn;
    public static Sound music;

    public static int levelID;
    public TiledMap map;
    public String mapPath;
    public static int pos_x_hero, pos_y_hero;

    public static int spriteNumber;
    public static SpriteHeroe sprite;
    public static Heroe hero;
    public static boolean huir = false;
    public static boolean ganar = false;
    public static boolean escena_final = false;
    
    public ArrayList<modelos.Portal> portalMapList;
    public static HashMap<Integer, Enemigo> enemys;
    public static HashMap<Integer, Frase> dialogo;

	//---------------------------------------------
	//Metodos
	//---------------------------------------------
	
    
    /**
     * Crea el mapa inicial y pone al heroe en su posici�n inicial
     * @throws SlickException
     */
    public Estado_Juego() throws SlickException {
        musicOn = true;
        music = new Sound("music/cancion_intro_al_juego.ogg");
        if (!music.playing()) {
            music.play();
        }

        levelID = 400;
        mapPath = "graphic/map/" + Integer.toString(levelID) + ".tmx";
        map = new TiledMap(mapPath);
        
        spriteNumber = 1;

        sprite = new SpriteHeroe();

        pos_x_hero = 500;
        pos_y_hero = 520;
        
        this.portalMapList = new ArrayList<>();
        enemys = BBDD_Enemigos.enemyData();
        if(hero!=null){
            dialogo = BBDD_Dialogo.dialogoData();
        }
        

        updateEntityFieldList(map);
        updatePortalMapList(portalMapList);
    }
}

