package personaje;

import principal.Estado_Juego;
import principal.Analisis_Mapa;

/**
 * @author Techno team
 */

/** 
 * Colisiones del Protagonista con el Mapa
 *
 */
public class Colisiones {
    
	//---------------------------------------------
	//Métodos
	//---------------------------------------------
	
    public Colisiones() {
    }

    public void isCollision(Estado_Juego gs, int oldX, int oldY) {
        int iter = 0;

        while (Analisis_Mapa.collisions.size() > iter) {
            if (Analisis_Mapa.recPlayer.intersects(Analisis_Mapa.collisions.get(iter))) {
                Estado_Juego.pos_x_hero = oldX;
                Estado_Juego.pos_y_hero = oldY;
            }
            iter++;
        }
    }
}
