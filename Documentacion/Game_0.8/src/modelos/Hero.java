package modelos;

import java.util.ArrayList;
import org.newdawn.slick.SlickException;
import personaje.Ataque;

/**
 * Clase del protagonista
 * Incluye un constructor y las estadísticas que escoges al principio del juego
 */

public class Hero {

    public String heroName;
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

    public Hero() throws SlickException {

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

    public Hero(String heroName, int heroLevel, int tempHeroExperience, int maxHeroExperience, int tempHeroHealth, int maxHeroHealth, int tempHeroMana, int maxHeroMana,double heroAttack, double heroDeffence, int strenght, int agility, int inteligence, int levelPoints) {
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
}
