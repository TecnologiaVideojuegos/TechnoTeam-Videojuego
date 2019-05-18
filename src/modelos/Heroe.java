package modelos;

import java.util.ArrayList;
import org.newdawn.slick.SlickException;
import personaje.Ataque;

public class Heroe {
    private int idHero;
    private String heroName;
    private ArrayList<Ataque> ataques;

    public int heroLevel;

    public int tempHeroHealth;
    public int maxHeroHealth;

    public double heroAttack;
    public double heroDeffence;

    public int fuerza;
    public int resistencia;
    public int magia;

    public int levelPoints;

    public Heroe() throws SlickException {
        heroName = "Hero";
        ataques = new ArrayList<>();
        heroLevel = 1;

        tempHeroHealth = 10;
        maxHeroHealth = 10;

        heroAttack = 1.0;
        heroDeffence = 1.0;

        fuerza = 1;
        resistencia = 1;
        magia = 1;

        levelPoints = 10;
    }

    public Heroe(int idHero, String heroName, int heroLevel, int tempHeroExperience, int maxHeroExperience, int tempHeroHealth, int maxHeroHealth, int tempHeroMana, int maxHeroMana,double heroAttack, double heroDeffence, int strenght, int agility, int inteligence, int levelPoints) {
        this.heroName = heroName;
        ataques = new ArrayList<>();
        this.heroLevel = heroLevel;
        this.tempHeroHealth = tempHeroHealth;
        this.maxHeroHealth = maxHeroHealth;
        this.heroDeffence = heroDeffence;
        this.heroAttack = heroAttack;
        this.fuerza = strenght;
        this.resistencia = agility;
        this.magia = inteligence;
        this.levelPoints = levelPoints;
        this.idHero = idHero;
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
}
