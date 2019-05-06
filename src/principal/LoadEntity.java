package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import modelos.Portal;

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
        //exist = new boolean[map.getWidth()][map.getHeight()];
        exist = new boolean[map.getWidth()][map.getHeight()];
        testField = map.getTileId(0, 0, 1);
        for(int i=0; i< exist.length; i++){
            for(int j=0; j< exist[i].length; j++){
                collisionTileID = map.getTileId(i, j, 1);
                if(collisionTileID==testField){
                    exist[i][j] = true;
                }
            }
        }
        updateCollisionFields(map);
    }

    public void updateCollisionFields(TiledMap map) {
        collisions = new ArrayList<>();
        for (int i = 0; i < exist.length; i++) {
            for (int j = 0; j < exist[i].length; j++) {
                if (exist[i][j] == true) {
                    recField = new Rectangle(i * 48, j * 30, 48, 30);
                    collisions.add(recField);
                }
            }
        }
        collisions.trimToSize();
    }

    public void updatePortalMapList(ArrayList<Portal> portalMapList) {
        Portal newPortal;
        String path = "res/portal/" + GameStatus.levelID + ".xml";
        System.out.println(path);
        File filePath = new File(path);
        try {
            XMLInputFactory iFactory = XMLInputFactory.newInstance();
            InputStream xmlFile = new FileInputStream(filePath);
            XMLStreamReader parser = iFactory.createXMLStreamReader(xmlFile);
            newPortal = new Portal();
            while (parser.hasNext()) {
                switch (parser.next()) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (parser.getLocalName().equals("Portal")) {
                            newPortal = new Portal();
                        }
                        if (parser.getLocalName().equals("xStart")) {
                            newPortal.setxStart(Integer.parseInt(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("xEnd")) {
                            newPortal.setxEnd(Integer.parseInt(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("yStart")) {
                            newPortal.setyStart(Integer.parseInt(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("yEnd")) {
                            newPortal.setyEnd(Integer.parseInt(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("levelID")) {
                            newPortal.setLevelID(Integer.parseInt(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("xNew")) {
                            newPortal.setxNew(Integer.parseInt(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("yNew")) {
                            newPortal.setyNew(Integer.parseInt(parser.getElementText()));
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:

                        if (parser.getLocalName().equals("Portal")) {
                            portalMapList.add(newPortal);
                            System.out.println(newPortal);
                        }
                        break;
                }
            }
        } catch (FileNotFoundException e1) {
            System.out.println("Exception FileNotFoundException - class:LoadEntity   methode:updatePortalMapList ");
        } catch (XMLStreamException e2) {
            System.out.println("Exception XMLStreamException - class:LoadEntity   methode:updatePortalMapList ");
        } catch (NumberFormatException e3) {
            System.out.println("Exception NumberFormatException - class:LoadEntity   methode:updatePortalMapList ");
        }
    }
}
