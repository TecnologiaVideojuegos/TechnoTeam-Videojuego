package estados;

import personaje.Event;
import principal.GameStatus;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import personaje.Ataque;
import combat_interface.ClaseEstatica;
import combat_interface.Personaje;
import modelos.Enemy;

/**   
 *   Pinta el mapa, el personaje, los npc y los enemigos
 * 
 *
 */

public class Play extends BasicGameState {

    public static boolean needToMapUpdate = false;

    public static GameStatus gameStatus;

    private Event event;
    
    
    public Play() {
    }

    @Override
    public int getID() {
        return 1;
    }

    //Crea el protagonista
    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        gameStatus = new GameStatus();
        event = new personaje.Event(GameStatus.sprite);
        

    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {

        Input input = container.getInput();
        int xPos = Mouse.getX();
        int yPos = Mouse.getY();

        event.update(container, sbg, delta, gameStatus, input, xPos, yPos);

        if (needToMapUpdate) {

            updateGameStatus(container);
        }
    }

    //Pinta el mapa, el personaje, los npc y los enemigos
    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {

        try {
            gameStatus.map = new TiledMap("graphic/map/" + Integer.toString(GameStatus.levelID) + ".tmx");
            gameStatus.map.render(0, 0, 0);

            gameStatus.updateEntityFieldList(gameStatus.map);

        } catch (SlickException e) {
            System.out.println("Error en updateGameStatus playState");
        }
        GameStatus.sprite.avatar.draw(GameStatus.pos_x_hero, GameStatus.pos_y_hero);
        

        //Pinta a los NPC
        if (GameStatus.enemys.get(GameStatus.levelID) != null) {
            GameStatus.enemys.get(GameStatus.levelID).getSprite().avatar.draw(GameStatus.enemys.get(GameStatus.levelID).getX_pos(), GameStatus.enemys.get(GameStatus.levelID).getY_pos());
        }
        
        
        
        event.render( container, sbg, g);
    }
    
    
/*   public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        ClaseEstatica.setEnemigo(Goblin);
//        mover=false;
//        this.x = 571; 
//        this.y = 257;
    }*/

    //Te permite cambiar entre mapas
    public void updateGameStatus(GameContainer container) {
        needToMapUpdate = false;
        gameStatus.updatePortalMapList(gameStatus.portalMapList);
    }
}
