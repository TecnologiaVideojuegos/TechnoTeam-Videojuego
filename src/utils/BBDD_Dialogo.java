package utils;

import java.util.HashMap;
import modelos.Enemigo;
import modelos.Frase;
import org.newdawn.slick.SlickException;
import principal.Estado_Juego;
import principal.SpriteGeneral;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sengo
 */
public class BBDD_Dialogo {
    public static HashMap<Integer, Frase> dialogoData() throws SlickException {
        HashMap<Integer, Frase> enemyData = new HashMap<Integer, Frase>() {
            {
                //400 
                put(4001, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "El mundo de nuestros protagonistas se llama Reynos."));
                put(4002, new Frase(400, "Medusa", "Hace muchos años había un demonio, Belial, que engaño"));
                put(4003, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "a la mitad de la población con otorgarles lo que"));
            }
        };
        return enemyData;
    }
}
