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
            	put(4001, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "¿Tú eres Ylska ? ¿La famosa maga del imperio ?"));
                put(4002, new Frase(400, "Ylska", "¿Quién lo pregunta?"));
                put(4003, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "Bueno da igual quien seas, perteneces al imperio y debes morir, asi salvaré mi pueblo "));
                put(4004, new Frase(400, "Ylska", "Así que eres una rata de Caeda preparate para tu funeral"));
                put(4011, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "¿Usted quien es ?"));
                put(4012, new Frase(401,"Ray","No poder pasar, lugar prohibido a cualquiera "));
                put(4013, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "Necesito entrar ahí dentro"));
                put(4014, new Frase(401,"Ray","Si es así, yo tener que darte una lección"));
                put(4021, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "Solo me queda superar este obstáculo y la espada será mia"));
                put(4022, new Frase(402,"Dragón"," ¡¡¡¡¡arrrggggg!!!!"));
                put(4041, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "¡Suelta a mi padre, Fergalisius!"));
                put(4042, new Frase(404,"Fergalisius","Me niego, tu irás después de él"));
                put(4043, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "Si puedo impedirlo, así lo haré"));
                put(4044, new Frase(404,"Fergalisius","Crees que puedes hacerme frente, pequeño cachorrito"));
                put(4031, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "¿Eres tú el dueño de este libro ?"));
                put(4032, new Frase(403,"Klein","Así es, lo escribí hace unos años, cuando viajaba junto a tu padre"));
                put(4033, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "¡¡¿¿Con mi padre ??!!, podrías contarme más"));
                put(4034, new Frase(403,"Klein","Está bien sientate y escucha"));
                put(4035, new Frase(403,"Klein","Tu padre y yo pertenecíamos a la gran guardia de la capital Naescar, y a él se le dió bien tanto la espada como meterse en lios y a mi curarle"));
                put(4036, new Frase(403,"Klein","Tu padre impotente buscó una alternativa para retomar la capital y buscó una famosa espada llamada Tyrfing"));
                put(4037, new Frase(403,"Klein","Él consiguió encontrarla en una cueva no muy lejos de aquí hacia el sureste, y con ella, retomó la capital pero se deshizo de la espada"));
                put(4038, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "¡¡¡se deshizo de ella !!!.... "));
                put(4039, new Frase(403,"Klein","no sé los motivos pero yo no iría en su....... ¿OYE DÓNDE VAS ?"));
            }
        };
        return enemyData;
    }
}
