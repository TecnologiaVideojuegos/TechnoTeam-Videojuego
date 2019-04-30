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
import states.CrearProtagonista;
import states.Creditos;
import states.Menu;
import states.OptionsState;
import states.PlayState;

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

    public Game() {
        super(GAMENAME);
        this.addState(new Menu());
        this.addState(new OptionsState());
        this.addState(new Creditos());
        this.addState(new CrearProtagonista());
        this.addState(new PlayState());
        this.addState(new states.PauseState());
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