/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import estados.Estado_14_CREAR_PROTEGONISTA;
import estados.Estado_8_CREDITOS;
import estados.Estado_20_INTRODUCCION;
import estados.Estado_0_MENU;
import estados.Estado_2_OPCIONES;
import estados.Estado_9_PAUSE;
import estados.Estado_1_PLAY;
import estados.Estado_21_HISTORIA;
import estados.Estado_7_BATALLA;

/**
 *
 * @author Sengo
 */
public class Game extends StateBasedGame {

    public static final String GAMENAME = "Tyrfing";
    
    public static final int WIDTH = 1344;
    public static final int HEIGHT = 720;
    
    public static final int MENU = 0;
    public static final int OPTIONS = 2;
    
    public static AppGameContainer app;

    public Game() {
        super(GAMENAME);
        this.addState(new Estado_0_MENU());
        this.addState(new Estado_2_OPCIONES());
        this.addState(new Estado_8_CREDITOS());
        this.addState(new Estado_14_CREAR_PROTEGONISTA());
        this.addState(new Estado_1_PLAY());
        this.addState(new Estado_9_PAUSE());
        this.addState(new Estado_20_INTRODUCCION());
        this.addState(new Estado_21_HISTORIA());
        this.addState(new Estado_7_BATALLA());
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        enterState(MENU);
    }

    public static void run() {
        try {
            app = new AppGameContainer(new Game());
            app.setDisplayMode(WIDTH, HEIGHT, false);
            app.setTargetFrameRate(100);
            app.setShowFPS(false);
            
            app.start();
        } catch (SlickException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}