package personaje;

import principal.SpriteHeroe;
import principal.Estado_Juego;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Techno team
 */

/** 
 * Colisiones del Protagonista con los portales
 *
 */
public class Evento {

	//---------------------------------------------
	//Atributos
	//---------------------------------------------
	
    private MovimientoPersonaje movement;
    private Colisiones collisionFields;
    private Portales portals;

	//---------------------------------------------
	//Métodos
	//---------------------------------------------
    
    /**
     * Constructor
     * @param sprite
     * @throws SlickException
     */
    public Evento(SpriteHeroe sprite) throws SlickException {
        this.movement = new MovimientoPersonaje();
        this.collisionFields = new Colisiones();
        this.portals = new Portales();
    }

    /**
     * Actualiza la posición del Protagonista constantemente
     * para ver si se ha chocado con algun portal
     * @param container
     * @param sbg
     * @param delta
     * @param gs
     * @param input
     * @param xPos
     * @param yPos
     * @throws SlickException
     */
    public void update(GameContainer container, StateBasedGame sbg, int delta, Estado_Juego gs, Input input, int xPos, int yPos) throws SlickException {

        int oldX = Estado_Juego.pos_x_hero;
        int oldY = Estado_Juego.pos_y_hero;
        
        Teclas.functionalKeyHandler(container, sbg, input, Estado_Juego.sprite.heroWidth, Estado_Juego.sprite.heroHeight);

        movement.go(input, gs, delta, Estado_Juego.sprite);

        principal.Analisis_Mapa.recPlayer = new Rectangle(Estado_Juego.pos_x_hero, Estado_Juego.pos_y_hero, Estado_Juego.sprite.heroWidth, Estado_Juego.sprite.heroHeight - 5);

        int playerCenterX = Estado_Juego.pos_x_hero + (Estado_Juego.sprite.heroWidth / 2) - 7;
        int playerCenterY = Estado_Juego.pos_y_hero + (Estado_Juego.sprite.heroHeight / 2);
        
        portals.isEnter(gs, playerCenterX, playerCenterY);

        collisionFields.isCollision(gs, oldX, oldY);

    }
}
