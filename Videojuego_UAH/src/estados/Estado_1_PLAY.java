package estados;

import java.awt.Font;
import personaje.Evento;
import principal.Estado_Juego;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.Image;
import org.newdawn.slick.TrueTypeFont;
import modelos.Frase;

/**
 * @author Techno team
 */

 /** 
  * Estado principal del Videojuego
  */
public class Estado_1_PLAY extends BasicGameState {

	
	//---------------------------------------------
	//Atributos
	//---------------------------------------------
	
    public static boolean needToMapUpdate = false;

    public static Estado_Juego gameStatus;

    private Evento event;
    private int i = 1;

    private Image ventanaDialogo, avatarDialogo;
    private static final int POSICIONAVATARX = 30;
    private static final int POSICIONAVATARY = 600;

    public static boolean dialogo = false;
    public static boolean pelea = false;
    private TrueTypeFont personaje, frase;
    private Font tipo_letra_dialogo = new Font("Arial Black", Font.PLAIN, 15);

	//---------------------------------------------
	//Métodos
	//---------------------------------------------
	
    /**
     * Constructor vacio
     */
    public Estado_1_PLAY() {
    }

    /**
     * ID de la clase usado para cambiar entre estados
     * @return 
     */
    @Override
    public int getID() {
        return 1;
    }

    /**
     * Crea las imagenes del Juego principal
     * @param container
     * @param sbg
     * @throws org.newdawn.slick.SlickException
     */
    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        gameStatus = new Estado_Juego();
        event = new Evento(Estado_Juego.sprite);
        ventanaDialogo = new Image("graphic/dialogo/cajaTexto.png");

        personaje = new TrueTypeFont(tipo_letra_dialogo, true);
        frase = new TrueTypeFont(tipo_letra_dialogo, true);

    }

    /**
     * Actualiza el Juego
     * 
     * @param container
     * @param sbg
     * @param delta
     * @throws org.newdawn.slick.SlickException
     */
    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {

        Input input = container.getInput();
        int xPos = Mouse.getX();
        int yPos = Mouse.getY();

        event.update(container, sbg, delta, gameStatus, input, xPos, yPos);

        if (needToMapUpdate) {
            updateGameStatus(container);
        }
    }

    /**
     * Pinta el mapa del juego y a los personajes
     * @param container
     * @param sbg
     * @param g
     * @throws org.newdawn.slick.SlickException
     */
    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        if (!Estado_Juego.music.playing()) {
            Estado_Juego.music.play();
        }
        if (Estado_Juego.levelID == 402) {
            Estado_Juego.escena_final = true;
        }
        Input input = container.getInput();
        try {
            gameStatus.map = new TiledMap("graphic/map/" + Integer.toString(Estado_Juego.levelID) + ".tmx");
            gameStatus.map.render(0, 0, 0);
            gameStatus.updateEntityFieldList(gameStatus.map);
        } catch (SlickException e) {
            System.out.println("Error en updateGameStatus playState");
        }
        Estado_Juego.sprite.avatar.draw(Estado_Juego.pos_x_hero, Estado_Juego.pos_y_hero);
        if (Estado_Juego.enemys.get(Estado_Juego.levelID) != null && !Estado_Juego.enemys.get(Estado_Juego.levelID).isMuerto()) {
            Estado_Juego.enemys.get(Estado_Juego.levelID).getSprite().avatar.draw(Estado_Juego.enemys.get(Estado_Juego.levelID).getX_pos(), Estado_Juego.enemys.get(Estado_Juego.levelID).getY_pos());
        }
        if(dialogo){
            renderDialogo(input, sbg);
        }
        
        if (Estado_Juego.huir || Estado_Juego.ganar) {
            i = 1;
            Estado_Juego.huir = false;
            Estado_Juego.ganar = false;
        }

    }

    
    /**
     * Actualiza GameStatus
     * 
     * @param container
     */
    public void updateGameStatus(GameContainer container) {
        needToMapUpdate = false;
        gameStatus.updatePortalMapList(gameStatus.portalMapList);
    }
    
    /**
     * Detiene la música
     * @param container
     * @param game
     * @throws org.newdawn.slick.SlickException
     */
    @Override
    public void leave(GameContainer container, StateBasedGame game) throws SlickException {
        Estado_Juego.music.stop();
    }

    /**
     * Comprobamos que todos los enemigos están muertos para poder acceder a la escena final
     * @return true si todos están muertos, false si todavia queda alguno vivo.
     */
    public static boolean lucha_dragon() {
        return Estado_Juego.enemys.get(400).isMuerto() && Estado_Juego.enemys.get(401).isMuerto() && Estado_Juego.enemys.get(403).isMuerto() && Estado_Juego.enemys.get(404).isMuerto();
    }

    /**
     * 
     * Crea el dialogo que aparece al acercarte al un npc
     */
    private void renderDialogo(Input input, StateBasedGame sbg) throws SlickException {
        Frase f = Estado_Juego.dialogo.get((Estado_Juego.levelID * 10) + i);

        if (dialogo && Estado_Juego.dialogo.get((Estado_Juego.levelID * 10) + i) != null) {
            this.ventanaDialogo.draw(0, 620, 1);

            if (Estado_Juego.escena_final && !lucha_dragon()) {
                frase.drawString(160, 645, "DERROTA A TODOS LOS ENEMIGOS Y PODRÁS LUCHAR CON EL DRAGÓN");
                if (input.isKeyPressed(Input.KEY_SPACE)) {
                    Estado_Juego.escena_final = false;
                    dialogo=false;
                    Estado_Juego.levelID=401;
                    needToMapUpdate=true;
                }
            } else {
                if (f.getPersonaje().equalsIgnoreCase("Hero")) {
                    avatarDialogo = new Image("graphic/dialogo/" + Estado_Juego.hero.getIdHero() + ".png");
                    personaje.drawString(160, 625, Estado_Juego.hero.getHeroName());
                } else {
                    avatarDialogo = new Image("graphic/dialogo/" + f.getIdPersonaje() + ".png");
                    personaje.drawString(160, 625, f.getPersonaje());
                }
                this.avatarDialogo.draw(POSICIONAVATARX, POSICIONAVATARY, 1);
                frase.drawString(160, 645, f.getFrase());

                if (input.isKeyPressed(Input.KEY_SPACE)) {
                    i++;
                }
            }

        } else if (Estado_Juego.dialogo.get((Estado_Juego.levelID * 10) + i) == null && !Estado_Juego.enemys.get(Estado_Juego.levelID).isMuerto()) {
            dialogo = false;
            sbg.enterState(7);
        }
        
    }
}
