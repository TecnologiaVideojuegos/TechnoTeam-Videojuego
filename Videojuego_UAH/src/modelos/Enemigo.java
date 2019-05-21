package modelos;

import principal.SpriteGeneral;

public class Enemigo {
    private String enemyName;
    private int IdLevel;
    private int x_pos;
    private int y_pos;
    private SpriteGeneral sprite;
    
    private int tempHeroHealth;
    private int maxHeroHealth;

    private int fuerza;
    private int resistencia;
    private int magia;
    private boolean muerto = false;
 
    public Enemigo() {}

    public Enemigo(String enemyName, int tempHeroHealth, int fuerza, int resistencia, int magia, int IdLevel, SpriteGeneral sprite, int x_pos, int y_pos) {
        this.enemyName = enemyName;
        this.tempHeroHealth = tempHeroHealth;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        this.magia = magia;
        this.IdLevel=IdLevel;
        this.sprite = sprite;
        this.x_pos=x_pos;
        this.y_pos=y_pos;
    }

    public boolean isMuerto() {
        return muerto;
    }
    
    public void reset(){
        this.tempHeroHealth = this.maxHeroHealth;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
    }
    
    
    
    public int ataque(){
        return ((fuerza+magia)/(20));
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getMagia() {
        return magia;
    }

    public int getResistencia() {
        return resistencia;
    }

    public int getTempHeroHealth() {
        return tempHeroHealth;
    }

    public void setTempHeroHealth(int tempHeroHealth) {
        this.tempHeroHealth = tempHeroHealth;
        this.maxHeroHealth = tempHeroHealth;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public void setIdLevel(int IdLevel) {
        this.IdLevel = IdLevel;
    }


    public void setSprite(SpriteGeneral sprite) {
        this.sprite = sprite;
    }

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getIdLevel() {
        return IdLevel;
    }


    public SpriteGeneral getSprite() {
        return sprite;
    }

    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }
   
}
