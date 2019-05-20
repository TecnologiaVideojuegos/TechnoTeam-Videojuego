package estados;
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
import combat_interface.Sprite;
import personaje.Portales;

public class batalla1 extends BasicGameState {
	
	 private float enemigox, enemigoy;
	    private Image fondo, personaje, enemigo, enemigo2, bocadillo;
	    private Rectangle perR, perE;
	    private Sprite puntero;
	    private int estado;
	    private Sound sonido;
	    private UnicodeFont font,font1;
	    
	    public UnicodeFont getFont() {
			return font;
		}

		public void setFont(UnicodeFont font) {
			this.font = font;
		}

		@Override
	    public int getID() {
	        return 7;
	    }

	    @Override
	   
	    public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    	personaje = new Image ("graphic/heroSprite/chico2.png");
	    	bocadillo = new Image ("graphic/enemySprite/bocadillo2.png");
	    	enemigo = new Image ("graphic/enemySprite/enemigo.png");
	    	puntero = new Sprite("graphic/puntero.png");
	    	java.awt.Font fuenteAWT = new java.awt.Font("Arial", 1, 24);
	        font = new UnicodeFont(fuenteAWT);
	        font.addAsciiGlyphs();
	        ColorEffect colorFuente = new ColorEffect(java.awt.Color.WHITE);
	        font.getEffects().add(colorFuente);
	        font.loadGlyphs();
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
	        font.drawString(35,568, "Comandos");
	        font.drawString(100, 650, "Atacar");
	        font.drawString(1175, 650, "Huir");
	        font.drawString(620, 665, "Bola de fuego");
	        font.drawString(620, 590, "Estocada");
	        font.drawString(335, 640, "Habilidades");
	        if (estado == 0) {
	        	puntero.draw(185, 637);
	        }
	        else if (estado == 1) {
	        	puntero.draw(900, 575);
	        } else if (estado == 2) {
	        	puntero.draw(900, 650);
	         } else if (estado == 3) {
	        	puntero.draw(1220, 630);
	        }
	        
	            
	    }
	    
	    
	    @Override
	    
	    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	    	
            if (container.getInput().isKeyPressed(Input.KEY_D)) {
                    estado ++ ;
                
            }else if (container.getInput().isKeyPressed(Input.KEY_A)) {
                    estado --;
                }else if (estado>= 4){
                	
                	estado = 3;
                }else if (estado < 0) {
                	estado = 0;
                }
            if (container.getInput().isKeyPressed(Input.KEY_ENTER)&& estado == 0) {
            	enemigo= new Image ("graphic/enemySprite/avatars400.png");
            	enemigo.draw(enemigox, enemigoy);
            }else if (container.getInput().isKeyPressed(Input.KEY_ENTER)&& estado == 1) {
            	
            }else if (container.getInput().isKeyPressed(Input.KEY_ENTER)&& estado == 2) {
            	
            }else if (container.getInput().isKeyPressed(Input.KEY_ENTER)&& estado == 3) {
            	
            }
	    
	    }
	    @Override
	    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
	    
	    }
	    
	     @Override
	     
	    public void leave(GameContainer container, StateBasedGame game) throws SlickException {
	        sonido.stop();
	    }
	    

	
	}

