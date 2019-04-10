/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import state.GameOverState;
import state.GameState;

/**
 *
 * @author Sengo
 */
public class Game extends StateBasedGame{
    
    public static void run() throws SlickException{
        AppGameContainer app = new AppGameContainer(new Game("Fire Emblem"));
        
        app.setDisplayMode(900, 600, false);
        app.setAlwaysRender(true);
        app.setVSync(true);
        
        app.start();
    }

    public Game(String title) {
        super(title);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.addState(new GameState());
        this.addState(new GameOverState());
    }
    
}
