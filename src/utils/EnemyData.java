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
                put(400, new Enemy("Orc", 400, new SpriteGeneral(400, 1), 1296, 560, "graphic/heroSprite/avatar2.png"));
            }
        };
        return enemyData;
    }
}
