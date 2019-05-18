package combat_interface;

import java.io.InputStream;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.util.Color;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.util.ResourceLoader;

import personaje.Portales;

public class interfaz2 extends BasicGameState {
	
	 private float personajex, personajey, enemigox, enemigoy;
	    private Image fondo, personaje, enemigo,bocadillo;
	    private Rectangle perR, perE;
	    private int estado;
	    private Sound sonido;
	    
	    @Override
	    public int getID() {
	        return 7;
	    }

	    @Override
	   
	    public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    	personaje = new Image ("graphic/heroSprite/chico2.png");
	    	bocadillo = new Image ("graphic/enemySprite/bocadillo1.png");
	    	enemigo = new Image ("graphic/enemySprite/enemigo.png");
	        this.personajex = 0; //Coordenadas donde empieza el personaje
	        this.personajey = 440;
	        this.enemigox = 900;
	        this.enemigoy = 240;
	        
	        estado = 0;
	        fondo = new Image("graphic/battle/battleground_forest2.png"); //Imagen de fondo
	        sonido = new Sound("Documentacion/Musica/cancion capitulo 5.ogg");
	    }
	    
	    
	    @Override
	    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException { 
	        if (!sonido.playing()) {
	            sonido.play();
	        }
	        fondo.draw();
	        personaje.draw(40, 396);
	        enemigo.draw(enemigox, enemigoy);
	        bocadillo.draw(0,540);
	            g.drawString("Comandos", 10, 561);
	            g.drawString("Atacar", 50, 654);
	            g.drawString("Huir", 500, 654);
	            
	         
	    }
	    
	    
	    @Override
	    
	    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	    
	    }
	    @Override
	    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
	    
	        perR = new Rectangle(personajex, personajey, 100, 50);
	        perE = new Rectangle(enemigox, enemigoy, 100, 50);
	        this.personajex = 343; //Coordenadas donde empieza el personaje
	        this.personajey = 349;
	        perR.setY(personajey);
	        perR.setX(personajex);
	    }
	    
	     @Override
	     
	    public void leave(GameContainer container, StateBasedGame game) throws SlickException {
	        sonido.stop();
	    }
	    

	
	}

