/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estados;

import java.awt.Font;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import modelos.Heroe;
import personaje.Ataque;
import principal.Estado_Juego;

/**
 *
 * @author Techno team
 */

/**
 * 
 * Clase donde se crean los combates
 *
 */
public class Estado_7_BATALLA extends BasicGameState {

	//---------------------------------------------
	//Atributos
	//---------------------------------------------
	
    private float enemigox, enemigoy;
    private Image fondo, personaje, enemigo, enemigo2, bocadillo, cajaVida, vs;
    private Rectangle perR, perE;
    private int estado;
    private Sound sonido;
    private String pos_mouse = "";
    private boolean atacar = false;
    private String comentarios;
    private String info;
    private Ataque ataque;
    private boolean turnoHumano = true;
    private boolean turnoMaquina = false;
    private boolean ganado = false;

    private Color colorTexto = Color.white;
    private final Color opcionSeleccionada = Color.orange;

    private final Color colorOpcionSelecionada[] = {colorTexto, colorTexto, colorTexto};

    private final Color atacar_huir[] = {colorTexto, colorTexto};
    
    private final Font tipo_letra_dialogo = new Font("Arial Black", Font.PLAIN, 15);
    private TrueTypeFont personaje1, frase;
    
	//---------------------------------------------
	//M�todos
	//---------------------------------------------
	
    /**
     * ID de la clase usado para cambiar entre estados
     * @return 
     */
    @Override
    public int getID() {
        return 7;
    }

    /**
     * Crea las imagenes de las peleas
     * @param container
     * @param game
     * @throws org.newdawn.slick.SlickException
     */
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

        bocadillo = new Image("graphic/enemySprite/bocadillo2.png");
        cajaVida = new Image("graphic/enemySprite/cajaVida.png");
        vs = new Image("graphic/battle/vs.png");
        container.setMouseCursor(new Image("graphic/puntero.png"), 0, 0); 
        this.enemigox = 1150;
        this.enemigoy = 230;
        comentarios = Estado_Juego.enemys.get(Estado_Juego.levelID).getEnemyName() + ": Demuestrame lo que sabes hacer!!";
        estado = 0;
        
        sonido = new Sound("music/cancion_capitulo_5.ogg");
        info = "Tu Turno";
        personaje1 = new TrueTypeFont(tipo_letra_dialogo, true);
        frase = new TrueTypeFont(tipo_letra_dialogo, true);
    }

    /**
     * Pinta las peleas
     * @param container
     * @param game
     * @param g
     * @throws org.newdawn.slick.SlickException
     */
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        if (!sonido.playing()) {
            sonido.play();
        }
        personaje = Estado_Juego.hero.getImagen(Estado_Juego.hero.getIdHero());
        fondo = new Image("graphic/battle/"+Estado_Juego.levelID+".png"); //Imagen de fondo
        enemigo = new Image("graphic/dialogo/" + Estado_Juego.levelID + "r.png");
        fondo.draw(0, 0);
        personaje.draw(40, 340);
        enemigo.draw(enemigox, enemigoy);
        cajaVida.draw(40, 280);
        cajaVida.draw(1150, 170);
        vs.draw(522, 10);
        bocadillo.draw(0, 520);
        frase.drawString(540, 20, Estado_Juego.hero.getHeroName() + " vs " + Estado_Juego.enemys.get(Estado_Juego.levelID).getEnemyName());
        frase.drawString(80, 555, "Atacar", atacar_huir[0]);
        frase.drawString(80, 630, "Huir", atacar_huir[1]);
        frase.drawString(310, 535, "Habilidades");
        frase.drawString(310, 570, "Fuerza: " + (Estado_Juego.hero.getFuerza() * 10));
        frase.drawString(310, 600, "Resistencia: " + (Estado_Juego.hero.getResistencia() * 10));
        frase.drawString(310, 630, "Magia: " + (Estado_Juego.hero.getMagia() * 10));
        frase.drawString(365, 670, info, Color.white);
        int i = 0, pos = 625;
        for (Ataque a : Estado_Juego.hero.getAtaques()) {
            frase.drawString((pos), 550, a.getNombre(), colorOpcionSelecionada[i]);
            pos += 240;
            i++;
        }
        frase.drawString(610, 622, "Info:");
        frase.drawString(610, 647, comentarios);
        frase.drawString(60, 290, "Vida: " + Estado_Juego.hero.getTempHeroHealth());
        frase.drawString(1170, 180, "Vida: " + Estado_Juego.enemys.get(Estado_Juego.levelID).getTempHeroHealth());
        g.drawString(pos_mouse, 10, 10);

    }

    /**
     * Actualiza las batallas, decide de quien es el turno y te permite atacar
     * @param container
     * @param game
     * @param delta
     * @throws org.newdawn.slick.SlickException
     */
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();
        int pos_x = Mouse.getX();
        int pos_y = Mouse.getY();

        colorTexto = Color.white;
        pos_mouse = "x = " + pos_x + " y =" + pos_y;
        for (int k = 0; k < colorOpcionSelecionada.length; k++) {
            colorOpcionSelecionada[k] = colorTexto;
        }
        for (int k = 0; k < atacar_huir.length; k++) {
            atacar_huir[k] = colorTexto;
        }
        //Atacar
        if ((pos_x > 70 && pos_x < 290) && (pos_y > 130 && pos_y < 165) && atacar == false) {
            atacar_huir[0] = Color.orange;
            if (input.isMouseButtonDown(0) && turnoHumano) {
                atacar = true;
            }
        }
        //Huir
        if ((pos_x > 70 && pos_x < 290) && (pos_y > 65 && pos_y < 110) && atacar == false) {
            atacar_huir[1] = Color.orange;
            if (input.isMouseButtonDown(0) && atacar == false) {
                Estado_Juego.huir = true;
                game.enterState(1, new FadeOutTransition(org.newdawn.slick.Color.black), new FadeInTransition(org.newdawn.slick.Color.black));
                //Cambiar posici�n del heroe
                Estado_Juego.pos_x_hero-=50;
                Estado_Juego.pos_y_hero-=50;
                //Restaura la vida al acabar el combate
                Heroe.restaurarVida();

            }
        }
        if (atacar) {
            //Atacar y Huir desabilitados
            atacar_huir[0] = Color.gray;
            atacar_huir[1] = Color.gray;
            //Ataque 1
            if ((pos_x > 620 && pos_x < 840) && (pos_y > 130 && pos_y < 165)) {
                colorOpcionSelecionada[0] = Color.orange;
                if (input.isMouseButtonDown(0)) {
                    comentarios = Estado_Juego.hero.getHeroName() + ": " + Estado_Juego.hero.getAtaques().get(0).getDescripcion();
                    if (Estado_Juego.hero.getAtaques().get(0).isAcertado()) {
                        Estado_Juego.enemys.get(Estado_Juego.levelID).setTempHeroHealth(Estado_Juego.enemys.get(Estado_Juego.levelID).getTempHeroHealth() - Estado_Juego.hero.getAtaques().get(0).getDmg());
                        comentarios += " Bien!. De lleno";
                    } else {
                        comentarios += " Lo ha esquivado!!";
                    }
                    comentarios += " (SPACE para continuar)";
                    turnoHumano = false;
                    turnoMaquina = true;
                    atacar = false;
                }
            }
            //Ataque 2
            if ((pos_x > 855 && pos_x < 1075) && (pos_y > 130 && pos_y < 165)) {
                colorOpcionSelecionada[1] = Color.orange;
                if (input.isMouseButtonDown(0)) {
                    comentarios = Estado_Juego.hero.getHeroName() + ": " + Estado_Juego.hero.getAtaques().get(1).getDescripcion();
                    if (Estado_Juego.hero.getAtaques().get(1).isAcertado()) {
                        Estado_Juego.enemys.get(Estado_Juego.levelID).setTempHeroHealth(Estado_Juego.enemys.get(Estado_Juego.levelID).getTempHeroHealth() - Estado_Juego.hero.getAtaques().get(1).getDmg());
                        comentarios += " Bien!. De lleno";
                    } else {
                        comentarios += " Lo ha esquivado!!";
                    }
                    comentarios += " (SPACE para continuar)";
                    turnoHumano = false;
                    turnoMaquina = true;
                    atacar = false;
                }
            }
            //Ataque 3
            if ((pos_x > 1095 && pos_x < 1315) && (pos_y > 130 && pos_y < 165)) {
                colorOpcionSelecionada[2] = Color.orange;
                if (input.isMouseButtonDown(0)) {
                    comentarios = Estado_Juego.hero.getHeroName() + ": " + Estado_Juego.hero.getAtaques().get(2).getDescripcion();
                    if (Estado_Juego.hero.getAtaques().get(2).isAcertado()) {
                        Estado_Juego.enemys.get(Estado_Juego.levelID).setTempHeroHealth(Estado_Juego.enemys.get(Estado_Juego.levelID).getTempHeroHealth() - Estado_Juego.hero.getAtaques().get(2).getDmg());
                        comentarios += " Bien!. De lleno";
                    } else {
                        comentarios += " Lo ha esquivado!!";
                    }
                    comentarios += " (SPACE para continuar)";
                    turnoHumano = false;
                    turnoMaquina = true;
                    atacar = false;
                }
            }
        } else if (!atacar || !turnoHumano) {
            for (int k = 0; k < colorOpcionSelecionada.length; k++) {
                colorOpcionSelecionada[k] = Color.gray;
            }
        }

        if (input.isKeyPressed(Input.KEY_SPACE)) {
            if (turnoMaquina && !turnoHumano) {
                int dmg = Estado_Juego.enemys.get(Estado_Juego.levelID).ataque();
                Estado_Juego.hero.setTempHeroHealth(Estado_Juego.hero.getTempHeroHealth() - dmg);
                info = "Daño: " + dmg;
                comentarios = Estado_Juego.enemys.get(Estado_Juego.levelID).getEnemyName() + ": ATAQUE (SPACE para continuar)";
                
                turnoMaquina = false;
                turnoHumano = true;
            } else if (turnoHumano && !turnoMaquina) {
                info = "Tu Turno";
                comentarios="";
            }
            if(comprobacion()==true){
                comentarios="";
                Estado_Juego.ganar=true;
                game.enterState(21, new FadeOutTransition(org.newdawn.slick.Color.black), new FadeInTransition(org.newdawn.slick.Color.black));
            }else if(comprobacion()==false && partida_perdida()==true){
                comentarios="";
                game.enterState(0, new FadeOutTransition(org.newdawn.slick.Color.black), new FadeInTransition(org.newdawn.slick.Color.black));
            }
        }

    }

    /**
     * Huye del combate
     * @param container
     * @param game
     * @throws org.newdawn.slick.SlickException
     */
    @Override
    public void leave(GameContainer container, StateBasedGame game) throws SlickException {
        sonido.stop();
    }
    
    /**
     * Ganas el combate
     * @return 
     */
    public boolean partida_ganada(){
        return Estado_Juego.enemys.get(Estado_Juego.levelID).getTempHeroHealth()<=0;
        
    }
    
    /**
     * Pierdes el combate
     * @return 
     */
    public boolean partida_perdida(){
        return Estado_Juego.hero.getTempHeroHealth()<=0;
    }
    
    /**
     * Comentarios que salen al acabar el combate
     * @return 
     */
    public boolean comprobacion(){
        if(partida_ganada()||partida_perdida()){
            if(partida_ganada()){
                comentarios="Has ganado!!!!";
                ganado = true;
                //Restaura la vida al acabar el combate
                Heroe.restaurarVida();
                Estado_Juego.enemys.get(Estado_Juego.levelID).setMuerto(true);
                return true;
            }else if(partida_perdida()){
                comentarios="Has perdido :(";
                //Restaura la vida al acabar el combate
                Heroe.restaurarVida();
                Estado_Juego.enemys.get(Estado_Juego.levelID).reset();
                return false;
            }
        }
        return false;
    }

}
