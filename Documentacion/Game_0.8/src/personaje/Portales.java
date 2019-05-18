package personaje;

import principal.GameStatus;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.AppGameContainer;


import combat_interface.Goblin_fight;
import combat_interface.interfaz2;
import combat_interface.Sprite;
import estados.Play;




/**
 * Te permite iniciar un combate o una conversación al acercarte a un npc
 * Detecta la colisión con un npc e inicia un evento
 * 
 * @param sbg
 * @param gameStatus
 * @param playerCenterX
 * @param playerCenterY
 * @throws SlickException
 */

public class Portales {
	 private static boolean encuentro = true;
	 
	    private boolean colision;
	    
	    private int estado;
	    private Sprite puntero;
	    
	    private Graphics g;



	public void isEnter(StateBasedGame sbg, GameStatus gameStatus, int playerCenterX, int playerCenterY) throws SlickException {
        for (int i = 0; i < gameStatus.portalMapList.size(); i++) {
            
            if (((GameStatus.pos_x_hero >= gameStatus.portalMapList.get(i).xStart) && (GameStatus.pos_x_hero <= gameStatus.portalMapList.get(i).xEnd))
                    && ((GameStatus.pos_y_hero >= gameStatus.portalMapList.get(i).yStart) && (GameStatus.pos_y_hero <= gameStatus.portalMapList.get(i).yEnd))) {
                GameStatus.levelID = gameStatus.portalMapList.get(i).levelID;
                GameStatus.pos_x_hero = gameStatus.portalMapList.get(i).xNew;
                GameStatus.pos_y_hero = gameStatus.portalMapList.get(i).yNew;
                Play.needToMapUpdate = true;
                
                //Si colisiona con un enemigo empieza un combate
            }else if((GameStatus.enemys.get(GameStatus.levelID)!=null)&&(GameStatus.pos_x_hero >= (GameStatus.enemys.get(GameStatus.levelID).getX_pos()-30))&&((GameStatus.pos_y_hero >= GameStatus.enemys.get(GameStatus.levelID).getY_pos())&&(GameStatus.pos_y_hero <= GameStatus.enemys.get(GameStatus.levelID).getY_pos()+30))){
                System.out.println("---------------------------->>>>He chocado contra enemigo "+i);
                
                //Entra en la interfaz de combate al chocar con el enemigo
                sbg.enterState(11);  //7
                
                /*               encuentro=true;
                
                
                    combat_interface.ClaseEstatica.getPersonaje().getAnimD().stop();
                    g.drawString("Â¿QUIERES ENFRENTARTE AL TEMIBLE LUIS FONSI?", 50, 620);
                    g.drawString("Si, no tengo miedo", 50, 654);
                    g.drawString("Nooo, no estoy preparado", 500, 654);
                    if (estado == 0) {
                        puntero.draw(221, 654);
                    } else if (estado == 1) {
                        puntero.draw(723, 654);
                    }*/

                
            }
        }
//        encuentro=false;
    }

	public static boolean getEncuentro() {
		return encuentro;
	}

	public void setEncuentro(boolean encuentro) {
		this.encuentro = encuentro;
	}


}
