package personaje;

import principal.Estado_Juego;
import org.newdawn.slick.SlickException;
import estados.Estado_1_PLAY;

public class Portales {

    public void isEnter(Estado_Juego gameStatus, int playerCenterX, int playerCenterY) throws SlickException {
        for (int i = 0; i < gameStatus.portalMapList.size(); i++) {
            
            if (((Estado_Juego.pos_x_hero >= gameStatus.portalMapList.get(i).getxStart()) && (Estado_Juego.pos_x_hero <= gameStatus.portalMapList.get(i).getxEnd()))
                    && ((Estado_Juego.pos_y_hero >= gameStatus.portalMapList.get(i).getyStart()) && (Estado_Juego.pos_y_hero <= gameStatus.portalMapList.get(i).getyEnd()))) {
                Estado_Juego.levelID = gameStatus.portalMapList.get(i).getLevelID();
                Estado_Juego.pos_x_hero = gameStatus.portalMapList.get(i).getxNew();
                Estado_Juego.pos_y_hero = gameStatus.portalMapList.get(i).getyNew();
                Estado_1_PLAY.needToMapUpdate = true;
            }else if(!Estado_Juego.enemys.get(Estado_Juego.levelID).isMuerto()&&(Estado_Juego.enemys.get(Estado_Juego.levelID)!=null)&&((Estado_Juego.pos_x_hero >= (Estado_Juego.enemys.get(Estado_Juego.levelID).getX_pos()-30))&&(Estado_Juego.pos_x_hero <= (Estado_Juego.enemys.get(Estado_Juego.levelID).getX_pos()+48)))&&((Estado_Juego.pos_y_hero >= Estado_Juego.enemys.get(Estado_Juego.levelID).getY_pos()-30)&&(Estado_Juego.pos_y_hero <= Estado_Juego.enemys.get(Estado_Juego.levelID).getY_pos()+48))){
                Estado_1_PLAY.dialogo=true;
            }
        }
    }
}
