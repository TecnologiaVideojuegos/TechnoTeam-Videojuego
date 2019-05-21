package modelos;
public class Portal {
    
    private int xStart;
    
    private int xEnd;
    
    private int yStart;
    
    private int yEnd;
    
    private int levelID;
    
    private int xNew;
    
    private int yNew;

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

    public int getLevelID() {
        return levelID;
    }

    public int getxEnd() {
        return xEnd;
    }

    public int getxNew() {
        return xNew;
    }

    public int getxStart() {
        return xStart;
    }

    public int getyEnd() {
        return yEnd;
    }

    public int getyNew() {
        return yNew;
    }

    public int getyStart() {
        return yStart;
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
