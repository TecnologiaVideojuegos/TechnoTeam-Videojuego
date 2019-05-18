package personaje;

import principal.Sprite;
import principal.Game;
import principal.GameStatus;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import estados.Play;

/**
 * 
 * Guarda datos sobre los movimientos y las colisiones 
 *
 */
public class Event {

    private MovimientoPersonaje movement;
    private Colisiones collisionFields;
    private Portales portals;

    public Event(Sprite sprite) throws SlickException {
        this.movement = new MovimientoPersonaje();
        this.collisionFields = new Colisiones();
        this.portals = new Portales();
    }

    public void update(GameContainer container, StateBasedGame sbg, int delta, GameStatus gs, Input input, int xPos, int yPos) throws SlickException {

        int oldX = GameStatus.pos_x_hero;
        int oldY = GameStatus.pos_y_hero;
        
        Keys.functionalKeyHandler(container, sbg, input, GameStatus.sprite.heroWidth, GameStatus.sprite.heroHeight);

        movement.go(input, gs, delta, GameStatus.sprite);

        principal.LoadEntity.recPlayer = new Rectangle(GameStatus.pos_x_hero, GameStatus.pos_y_hero, GameStatus.sprite.heroWidth, GameStatus.sprite.heroHeight - 5);
        
        int playerCenterX = GameStatus.pos_x_hero + (GameStatus.sprite.heroWidth / 2) - 7;
        int playerCenterY = GameStatus.pos_y_hero + (GameStatus.sprite.heroHeight / 2);
        
        portals.isEnter(sbg, gs, playerCenterX, playerCenterY);

        collisionFields.isCollision(gs, oldX, oldY);

    }
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException{
    	
    	//Detecta la colisión con un enemigo
    	for (int i = 0; i < GameStatus.portalMapList.size(); i++) {
                if((GameStatus.enemys.get(GameStatus.levelID)!=null)&&(GameStatus.pos_x_hero >= (GameStatus.enemys.get(GameStatus.levelID).getX_pos()-30))&&((GameStatus.pos_y_hero >= GameStatus.enemys.get(GameStatus.levelID).getY_pos())&&(GameStatus.pos_y_hero <= GameStatus.enemys.get(GameStatus.levelID).getY_pos()+30))){
                	sbg.enterState(1);
                	System.out.println("---------------------------->>>>He chocado contra enemigo "+i);
                }}
    }
}
