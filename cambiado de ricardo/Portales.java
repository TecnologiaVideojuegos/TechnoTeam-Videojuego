package personaje;

import modelos.sprite;
import principal.GameStatus;
import org.newdawn.slick.SlickException;
import estados.Play;
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.RotateTransition;
import org.newdawn.slick.state.transition.SelectTransition;


public class Portales {




	public void isenter(StateBasedGame sbg, GameStatus gameStatus, int playerCenterX, int playerCenterY) throws SlickException {
        for (int i = 0; i < gameStatus.portalMapList.size(); i++) {
            
            if (((GameStatus.pos_x_hero >= gameStatus.portalMapList.get(i).xStart) && (GameStatus.pos_x_hero <= gameStatus.portalMapList.get(i).xEnd))
                    && ((GameStatus.pos_y_hero >= gameStatus.portalMapList.get(i).yStart) && (GameStatus.pos_y_hero <= gameStatus.portalMapList.get(i).yEnd))) {
                GameStatus.levelID = gameStatus.portalMapList.get(i).levelID;
                GameStatus.pos_x_hero = gameStatus.portalMapList.get(i).xNew;
                GameStatus.pos_y_hero = gameStatus.portalMapList.get(i).yNew;
                Play.needToMapUpdate = true;
            }else if((GameStatus.enemys.get(GameStatus.levelID)!=null)&&(GameStatus.pos_x_hero >= (GameStatus.enemys.get(GameStatus.levelID).getX_pos()-30))&&((GameStatus.pos_y_hero >= GameStatus.enemys.get(GameStatus.levelID).getY_pos())&&(GameStatus.pos_y_hero <= GameStatus.enemys.get(GameStatus.levelID).getY_pos()+30))){
                System.out.println("---------------------------->>>>He chocado contra enemigo "+i);
                sbg.enterState(7);
            }
        }
    }
 

}
