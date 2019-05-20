package modelos;

/**
 * Constructor de los Portales que te permiten cambiar
 * entre mapas
 *
 */
public class Portal {
    
    public int xStart;
    
    public int xEnd;
    
    public int yStart;
    
    public int yEnd;
    
    public int levelID;
    
    public int xNew;
    
    public int yNew;

    public Portal() {
    }

    public Portal(int xStart, int xEnd, int yStart, int yEnd, int levelID, int xN, int yN) {
        this.xStart = xStart;
        this.xEnd = xEnd;
        this.yStart = yStart;
        this.yEnd = yEnd;
        this.levelID = levelID;
        this.xNew = xN;
        this.yNew = yN;
    }

    @Override
    public String toString() {
        return "Portal{" + "xStart=" + xStart + ", xEnd=" + xEnd + ", yStart=" + yStart + ", yEnd=" + yEnd + ", levelID=" + levelID + ", xN=" + xNew + ", yN=" + yNew + '}';
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public void setxEnd(int xEnd) {
        this.xEnd = xEnd;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    public void setyEnd(int yEnd) {
        this.yEnd = yEnd;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    public void setxNew(int xN) {
        this.xNew = xN;
    }

    public void setyNew(int yN) {
        this.yNew = yN;
    }

    
    
}
