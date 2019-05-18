package utils;

import java.util.HashMap;

import modelos.NPC;
import modelos.NPC;
import org.newdawn.slick.SlickException;
import principal.SpriteGeneral;

public class EnemyData {

    public static HashMap<Integer, NPC> enemyData() throws SlickException {
        HashMap<Integer, NPC> enemyData = new HashMap<Integer, NPC>() {
            {
                //400 Orc
            	put(400, new NPC("Goblin", 400, new SpriteGeneral(401, 0), 1296, 360, "graphic/enemySprite/avatars400.png"));
                
//              put(400, new Enemy("Goblin", 400, new SpriteGeneral(400, 0), 1096, 560, "graphic/enemySprite/avatars400.png"));
              
              
              put(401, new NPC("Squeleton", 400, new SpriteGeneral(402, 1), 896, 460, "graphic/enemySprite/avatars401.png"));
            }
        };
        return enemyData;
    }
}
