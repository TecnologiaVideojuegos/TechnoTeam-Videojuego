package core;

import java.util.ArrayList;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

public class LoadEntity {

    int collisionID;
    public int collisionTileID;
    public int testField, testPortal;
    boolean[][] exist;
    public static ArrayList<Rectangle> collisions;
    public static ArrayList<Rectangle> npc;
    public static ArrayList<Rectangle> mobs;
    public static Rectangle recPlayer, recField;

    public void updateEntityFieldList(TiledMap map) {
        System.out.println(map.getWidth() + " " + map.getHeight());
        for (int i = 3; i < 4; i++) {
            exist = new boolean[map.getWidth()][map.getHeight()];
            testField = map.getTileId(0, 0, i);
            System.out.println(testField);
            for (int j = 0; j < map.getWidth(); j++) {
                for (int k = 0; k < map.getHeight(); k++) {
                    collisionTileID = map.getTileId(j, k, i);
                    if (collisionTileID == testField) {
                        exist[j][k] = true;
                    }
                }
            }
            if (i == 3) {
                updateCollisionFields(map);
            }
        }

    }

    public void updateCollisionFields(TiledMap map) {
        collisions = new ArrayList<>();
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                if (exist[i][j] == true) {
                    recField = new Rectangle(i * 32, j * 32, 32, 32);
                    collisions.add(recField);
                }
            }
        }
        collisions.trimToSize();
    }

    public void updateNpcFields(TiledMap map) {
        npc = new ArrayList<>();
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                if (exist[i][j] == true) {
                    recField = new Rectangle(i * 32, j * 32, 32, 32);
                    npc.add(recField);
                }
            }
        }
    }

    public void updateMobsFields(TiledMap map) {
        mobs = new ArrayList<>();
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                if (exist[i][j] == true) {
                    recField = new Rectangle(i * 32, j * 32, 32, 32);
                    mobs.add(recField);
                }
            }
        }
    }
}
