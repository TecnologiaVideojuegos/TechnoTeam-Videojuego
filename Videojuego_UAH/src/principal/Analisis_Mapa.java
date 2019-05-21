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

/**
 * @author Techno team
 */

/** 
 * Se encarga de las colisiones que ocurren en el Mapa
 *
 */
public class Analisis_Mapa {

	//---------------------------------------------
	//Atributos
	//---------------------------------------------
	
    private int collisionID;
    private int collisionTileID;
    private int testField;
    private boolean[][] exist;
    public static ArrayList<Rectangle> collisions;
    public static Rectangle recPlayer, recField;
    
	//---------------------------------------------
	//Metodos
	//---------------------------------------------
	
    /**
     * Actualiza el mapa
     */
    public void updateEntityFieldList(TiledMap map) {
        exist = new boolean[map.getWidth()][map.getHeight()];
        testField = map.getTileId(0, 0, 1);
        for (int i = 0; i < exist.length; i++) {
            for (int j = 0; j < exist[i].length; j++) {
                collisionTileID = map.getTileId(i, j, 1);
                if (collisionTileID == testField) {
                    exist[i][j] = true;
                }
            }
        }
        updateCollisionFields(map);
    }

    /**
     * Actualiza las colisiones
     */
    public void updateCollisionFields(TiledMap map) {
        collisions = new ArrayList<>();
        collisions.clear();
        for (int i = 0; i < exist.length; i++) {
            for (int j = 0; j < exist[i].length; j++) {
                if (exist[i][j] == true) {
                    recField = new Rectangle(i * 16, j * 16, 16, 16);
                    collisions.add(recField);
                }
            }
        }
        collisions.trimToSize();
    }

    /**
     * Actualiza los portales
     * @param portalMapList
     */
    public void updatePortalMapList(ArrayList<Portal> portalMapList) {
        Portal newPortal;
        String path = "res/portal/" + Estado_Juego.levelID + ".xml";
        File filePath = new File(path);
        portalMapList.clear();
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
