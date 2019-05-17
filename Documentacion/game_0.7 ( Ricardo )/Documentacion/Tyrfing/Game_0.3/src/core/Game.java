/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Sengo
 */
public class Game extends StateBasedGame {

    public static final String GAMENAME = "Tyrfing";
    
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    
    public static final int MENU = 0;
    public static final int OPTIONS = 2;

    public Game() {
        super(GAMENAME);
        this.addState(new states.Menu());
        this.addState(new states.OptionsState(OPTIONS));
        this.addState(new states.Creditos());
        this.addState(new states.CrearProtagonista());
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        enterState(MENU);
    }

    public static void run() {
        try {
            AppGameContainer app = new AppGameContainer(new Game());
            app.setDisplayMode(WIDTH, HEIGHT, false);
            app.setTargetFrameRate(100);
            app.setShowFPS(false);
            
            app.start();
        } catch (SlickException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}