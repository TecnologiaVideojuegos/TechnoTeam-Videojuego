package utils;

import java.util.HashMap;
import modelos.Enemigo;
import org.newdawn.slick.SlickException;
import principal.SpriteGeneral;

public class BBDD_Enemigos {

    public static HashMap<Integer, Enemigo> enemyData() throws SlickException {
        HashMap<Integer, Enemigo> enemyData = new HashMap<Integer, Enemigo>() {
            {
                //400 Orc
                put(400, new Enemigo("Medusa", 400,(5*15+500),(6*10),(5*10), (3*10), new SpriteGeneral(400, 1), 1296, 560));
                //400 Orc
                put(401, new Enemigo("Orc", 401,(5*15+500),(6*10),(5*10), (3*10), new SpriteGeneral(401, 0), 1184, 224));
                //400 Orc
                put(402, new Enemigo("Orc", 402,(5*15+500),(6*10),(5*10), (3*10), new SpriteGeneral(402, 1), 1024, 464));
                //400 Orc
                put(403, new Enemigo("Orc", 403,(5*15+500),(6*10),(5*10), (3*10), new SpriteGeneral(403, 0), 640, 432));
                //400 Orc
                put(404, new Enemigo("Orc", 404,(5*15+500),(6*10),(5*10), (3*10), new SpriteGeneral(404, 2), 544, 592));
            }
        };
        return enemyData;
    }
}
