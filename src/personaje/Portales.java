package personaje;

import principal.GameStatus;
import org.newdawn.slick.SlickException;
import estados.Play;

public class Portales {

    public void isEnter(GameStatus gameStatus, int playerCenterX, int playerCenterY) throws SlickException {
        for (int i = 0; i < gameStatus.portalMapList.size(); i++) {
            
            if (((GameStatus.pos_x_hero >= gameStatus.portalMapList.get(i).xStart) && (GameStatus.pos_x_hero <= gameStatus.portalMapList.get(i).xEnd))
                    && ((GameStatus.pos_y_hero >= gameStatus.portalMapList.get(i).yStart) && (GameStatus.pos_y_hero <= gameStatus.portalMapList.get(i).yEnd))) {
                GameStatus.levelID = gameStatus.portalMapList.get(i).levelID;
                GameStatus.pos_x_hero = gameStatus.portalMapList.get(i).xNew;
                GameStatus.pos_y_hero = gameStatus.portalMapList.get(i).yNew;
                System.out.println("PORTALES: "+GameStatus.pos_x_hero+" "+ GameStatus.pos_y_hero);
                Play.needToMapUpdate = true;
            }else if((GameStatus.enemys.get(GameStatus.levelID)!=null)&&(GameStatus.pos_x_hero >= (GameStatus.enemys.get(GameStatus.levelID).getX_pos()-30))&&((GameStatus.pos_y_hero >= GameStatus.enemys.get(GameStatus.levelID).getY_pos())&&(GameStatus.pos_y_hero <= GameStatus.enemys.get(GameStatus.levelID).getY_pos()+30))){
                System.out.println("---------------------------->>>>He chocado contra enemigo "+i);
            }
        }
    }
}
