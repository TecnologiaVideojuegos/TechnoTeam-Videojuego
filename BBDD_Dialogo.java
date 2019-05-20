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
 * @author Techno team
 */

/**
 * Dialogo de los NPC y enemigos
 *
 */
public class BBDD_Dialogo {
	
	
	//---------------------------------------------
	//Metodos
	//---------------------------------------------
	
	/**
	 * Dialogos
	 * @return
	 * @throws SlickException
	 */
    public static HashMap<Integer, Frase> dialogoData() throws SlickException {
        HashMap<Integer, Frase> enemyData = new HashMap<Integer, Frase>() {
            {
                //400 
            	put(4001, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "�T� eres Ylska ? �La famosa maga del imperio ?"));
                put(4002, new Frase(400, "Ylska", "�Qui�n lo pregunta?"));
                put(4003, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "Bueno da igual quien seas, perteneces al imperio y debes morir, asi salvar� mi pueblo "));
                put(4004, new Frase(400, "Ylska", "As� que eres una rata de Caeda preparate para tu funeral"));
                put(4011, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "�Usted quien es ?"));
                put(4012, new Frase(401,"Ray","No poder pasar, lugar prohibido a cualquiera "));
                put(4013, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "Necesito entrar ah� dentro"));
                put(4014, new Frase(401,"Ray","Si es as�, yo tener que darte una lecci�n"));
                put(4021, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "Solo me queda superar este obst�culo y la espada ser� mia"));
                put(4022, new Frase(402,"Drag�n"," �����arrrggggg!!!!"));
                put(4041, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "�Suelta a mi padre, Fergalisius!"));
                put(4042, new Frase(404,"Fergalisius","Me niego, tu ir�s despu�s de �l"));
                put(4043, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "Si puedo impedirlo, as� lo har�"));
                put(4044, new Frase(404,"Fergalisius","Crees que puedes hacerme frente, peque�o cachorrito"));
                put(4031, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "�Eres t� el due�o de este libro ?"));
                put(4032, new Frase(403,"Klein","As� es, lo escrib� hace unos a�os, cuando viajaba junto a tu padre"));
                put(4033, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "����Con mi padre ??!!, podr�as contarme m�s"));
                put(4034, new Frase(403,"Klein","Est� bien sientate y escucha"));
                put(4035, new Frase(403,"Klein","Tu padre y yo pertenec�amos a la gran guardia de la capital Naescar, y a �l se le di� bien tanto la espada como meterse en lios y a mi curarle"));
                put(4036, new Frase(403,"Klein","Tu padre impotente busc� una alternativa para retomar la capital y busc� una famosa espada llamada Tyrfing"));
                put(4037, new Frase(403,"Klein","�l consigui� encontrarla en una cueva no muy lejos de aqu� hacia el sureste, y con ella, retom� la capital pero se deshizo de la espada"));
                put(4038, new Frase(Estado_Juego.hero.getIdHero(), Estado_Juego.hero.getHeroName(), "���se deshizo de ella !!!.... "));
                put(4039, new Frase(403,"Klein","no s� los motivos pero yo no ir�a en su....... �OYE D�NDE VAS ?"));
            }
        };
        return enemyData;
    }
}
