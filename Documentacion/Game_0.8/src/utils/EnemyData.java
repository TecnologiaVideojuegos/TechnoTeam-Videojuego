package utils;

import java.util.HashMap;
import modelos.Enemy;
import org.newdawn.slick.SlickException;
import principal.SpriteGeneral;


/**
 * Crea a los enemigos
 * Indica el tipo de enemigo, el mapa y su posición
 *
 */

public class EnemyData {

    public static HashMap<Integer, Enemy> enemyData() throws SlickException {
        HashMap<Integer, Enemy> enemyData = new HashMap<Integer, Enemy>() {
            {
            	
            	// Mapa(400),400(colisión),imagen(400,1),posición, la ruta no hace nada
            	//Solo se puede 1 enemigo por mapa
            	
                //400 Goblin
                put(400, new Enemy("Goblin", 400, new SpriteGeneral(401, 0), 200, 560, "graphic/enemySprite/avatars400.png"));
                
//                put(400, new Enemy("Goblin", 400, new SpriteGeneral(400, 0), 1096, 560, "graphic/enemySprite/avatars400.png"));
                
                
                put(401, new Enemy("Squeleton", 400, new SpriteGeneral(402, 1), 896, 460, "graphic/enemySprite/avatars401.png"));
            }
        };
        return enemyData;
    }
}
