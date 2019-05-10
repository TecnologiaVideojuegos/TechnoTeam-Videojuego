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
                Play.needToMapUpdate = true;
            }
        }
    }
}
