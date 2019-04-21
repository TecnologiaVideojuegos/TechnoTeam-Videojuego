package model;

import org.newdawn.slick.SlickException;

public class Hero {

    public String heroName;

    public int heroLevel;
    public int tempHeroExperience;
    public int maxHeroExperience;

    public int tempHeroHealth;
    public int maxHeroHealth;

    public int tempHeroMana;
    public int maxHeroMana;

    public double heroAttack;
    public double heroDeffence;

    public static double movementSpeed;
    public static double attackSpeed;

    public int fuerza;
    public int resistencia;
    public int magia;

    public int levelPoints;

    public Hero() throws SlickException {

        heroName = "Hero";
        System.out.println("model.Hero.<init>()");
        heroLevel = 1;
        tempHeroExperience = 0;
        maxHeroExperience = 100;

        tempHeroHealth = 10;
        maxHeroHealth = 10;

        tempHeroMana = 10;
        maxHeroMana = 10;

        heroAttack = 1.0;
        heroDeffence = 1.0;

        fuerza = 1;
        resistencia = 1;
        magia = 1;

        // sugested speed 1.3 
        movementSpeed = 1.0;
        attackSpeed = 1.0;

        levelPoints = 10;
    }

    /**
     *
     * @param heroName
     * @param heroLevel
     * @param tempHeroExperience
     * @param maxHeroExperience
     * @param tempHeroHealth
     * @param maxHeroHealth
     * @param tempHeroMana
     * @param maxHeroMana
     * @param heroAttack
     * @param heroDeffence
     * @param strenght
     * @param agility
     * @param inteligence
     * @param levelPoints
     */

    public Hero(String heroName, int heroLevel, int tempHeroExperience, int maxHeroExperience, int tempHeroHealth, int maxHeroHealth, int tempHeroMana, int maxHeroMana,double heroAttack, double heroDeffence, int strenght, int agility, int inteligence, int levelPoints) {
        this.heroName = heroName;
        this.heroLevel = heroLevel;
        this.tempHeroExperience = tempHeroExperience;
        this.maxHeroExperience = maxHeroExperience;
        this.tempHeroHealth = tempHeroHealth;
        this.maxHeroHealth = maxHeroHealth;
        this.tempHeroMana = tempHeroMana;
        this.maxHeroMana = maxHeroMana;
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
}
