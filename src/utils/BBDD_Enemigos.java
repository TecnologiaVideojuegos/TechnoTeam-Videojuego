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
                put(400, new Enemigo("Orc", 400, new SpriteGeneral(400, 1), 1296, 560, "graphic/heroSprite/avatar2.png"));
                //400 Orc
                put(401, new Enemigo("Orc", 401, new SpriteGeneral(401, 0), 1184, 224, "graphic/heroSprite/avatar2.png"));
                //400 Orc
                put(402, new Enemigo("Orc", 402, new SpriteGeneral(402, 1), 1024, 464, "graphic/heroSprite/avatar2.png"));
                //400 Orc
                put(403, new Enemigo("Orc", 403, new SpriteGeneral(403, 0), 640, 432, "graphic/heroSprite/avatar2.png"));
                //400 Orc
                put(404, new Enemigo("Orc", 404, new SpriteGeneral(404, 2), 544, 592, "graphic/heroSprite/avatar2.png"));
            }
        };
        return enemyData;
    }
}
