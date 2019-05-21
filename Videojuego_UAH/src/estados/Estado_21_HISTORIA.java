/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estados;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import principal.Estado_Juego;

/**
 * @author Techno team
 */

/** 
 * Dialogos de los NPC
 *
 */
public class Estado_21_HISTORIA extends BasicGameState {
	
	//---------------------------------------------
	//Atributos
	//---------------------------------------------
	
	
    public static final int ID = 21;
    private Image introimg;
    private float posy;
    private final float vel = (float) 0.015;
    private boolean movimiento;
    private int msFinal;

	//---------------------------------------------
	//M�todos
	//---------------------------------------------
	
    /**
     * ID de la clase usado para cambiar entre estados
     * @return 
     */
    @Override
    public int getID() {
        return ID;
    }

    /**
     * Crea los dialogos
     * @param container
     * @param game
     * @throws org.newdawn.slick.SlickException
     */
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        posy = 0;

        movimiento = true;
        msFinal = 0;
    }

    /**
     * Pinta los dialogos
     * @param container
     * @param game
     * @param g
     * @throws org.newdawn.slick.SlickException
     */
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        introimg = new Image("graphic/historia/"+Estado_Juego.levelID+".png");
        introimg.draw(0, -posy);
    }

    /**
     * Actualiza el Juego y cambia entre dialogos
     * 
     * @param container
     * @param game
     * @param delta
     */
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        if (movimiento) {
            if (Keyboard.isKeyDown(Input.KEY_RETURN)) {
                posy += (vel * 2.5) * delta;
            } else {
                posy += (vel) * delta;
            }
            if (posy >= 340) {
                posy = 340;
                movimiento = false;
            }
        } else {

            if (Keyboard.isKeyDown(Input.KEY_RETURN)) {
                msFinal += delta;
            } else {
                msFinal += delta * 2;
            }
            if (posy >= 365) {
                movimiento = false;
            }
        }

        if (Keyboard.isKeyDown(Input.KEY_ESCAPE) || msFinal >= 3000) {
            if (Estado_Juego.levelID == 402) {
                game.enterState(0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            } else {
                game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            }
        }

    }
}
