package modelos;

import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import personaje.Ataque;

public class Heroe {
    private int idHero;
    private String heroName;
    private ArrayList<Ataque> ataques;

    private int tempHeroHealth;
    private int maxHeroHealth;

    private int fuerza;
    private int resistencia;
    private int magia;
    
    private Image imagen;

    private int levelPoints;

    public Heroe() throws SlickException {
        heroName = "Hero";
        ataques = new ArrayList<>();
        tempHeroHealth = 10;
        maxHeroHealth = 10;

        fuerza = 1;
        resistencia = 1;
        magia = 1;

        levelPoints = 10;
    }

    public Heroe(int idHero, String heroName, int heroLevel, int tempHeroExperience, int maxHeroExperience, int tempHeroHealth, int maxHeroHealth, int tempHeroMana, int maxHeroMana,double heroAttack, double heroDeffence, int strenght, int agility, int inteligence, int levelPoints) {
        this.heroName = heroName;
        ataques = new ArrayList<>();
        this.tempHeroHealth = tempHeroHealth;
        this.maxHeroHealth = maxHeroHealth;
        this.fuerza = strenght;
        this.resistencia = agility;
        this.magia = inteligence;
        this.levelPoints = levelPoints;
        this.idHero = idHero;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public Image getImagen(int id) throws SlickException {
        return new Image("graphic/dialogo/" + id + ".png");
    }

    public static int getMaxHeroExp(int lvl) {
        int maxHeroExperience = 100;
        for (int i = 0; i < lvl; i++) {
            maxHeroExperience += Math.log(maxHeroExperience);
        }
        return maxHeroExperience;
    }
    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(ArrayList<Ataque> ataques) {
        this.ataques = ataques;
    }

    public int getIdHero() {
        return idHero;
    }

    public void setIdHero(int idHero) {
        this.idHero = idHero;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
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

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public int getLevelPoints() {
        return levelPoints;
    }

    public void setLevelPoints(int levelPoints) {
        this.levelPoints = levelPoints;
    }

    public int getTempHeroHealth() {
        return tempHeroHealth;
    }

    public void setTempHeroHealth(int tempHeroHealth) {
        this.tempHeroHealth = tempHeroHealth;
    }

    public int getMaxHeroHealth() {
        return maxHeroHealth;
    }

    public void setMaxHeroHealth(int maxHeroHealth) {
        this.maxHeroHealth = maxHeroHealth;
    }
    
    
}
