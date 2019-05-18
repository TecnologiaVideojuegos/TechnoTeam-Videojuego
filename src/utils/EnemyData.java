package utils;

import java.util.HashMap;
import modelos.Enemy;
import org.newdawn.slick.SlickException;
import principal.SpriteGeneral;

public class EnemyData {

    public static HashMap<Integer, Enemy> enemyData() throws SlickException {
        HashMap<Integer, Enemy> enemyData = new HashMap<Integer, Enemy>() {
            {
                //400 Orc
                put(400, new Enemy("Orc",true, 400, new SpriteGeneral(400, 1), 1296, 560, "graphic/enemySprite/avatar400.png"));
                //400 Orc
                put(401, new Enemy("Orc",true, 401, new SpriteGeneral(401, 0), 1184, 224, "graphic/enemySprite/avatar401.png"));
                //400 Orc
                put(402, new Enemy("Orc",true, 402, new SpriteGeneral(402, 1), 528, 576, "graphic/enemySprite/avatar404.png"));
                //400 Orc
                put(404, new Enemy("Orc",true, 404, new SpriteGeneral(404, 2), 528, 576, "graphic/enemySprite/avatar404.png"));
                //400 Orc
                put(403, new Enemy("Orc",true, 403, new SpriteGeneral(403, 0), 640, 384, "graphic/enemySprite/avatar403.png"));
            }
        };
        return enemyData;
    }
}
