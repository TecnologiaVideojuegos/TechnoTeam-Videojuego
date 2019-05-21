package estados;

import principal.Estado_Juego;
import utils.Fuente;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Techno team
 */

/** 
 * Menu de pausa, puedes acceder a el pulsando ESC desde el Juego
 *
 */
public class Estado_9_PAUSE extends BasicGameState {
	
	//---------------------------------------------
	//Atributos
	//---------------------------------------------
	
    private String actualScr;

    private static int actualSubWindow = 0;

    private final Color colorTexto = Color.white;
    private final Color colortextoSeleccionado = Color.orange;
    private final Color colorSubOpciones[] = {Color.orange, Color.white};

    private final Color colorTextos[] = {colorTexto, colorTexto, colorTexto, colorTexto};

	//---------------------------------------------
	//M�todos
	//---------------------------------------------
	
    /**
     * Constructor vacio
     */
    public Estado_9_PAUSE() {
    }

    /**
     * ID de la clase usado para cambiar entre estados
     */
    @Override
    public int getID() {
        return 9;
    }

    /**
     * Crea las imagenes del Menu de pausa
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    /**
     * Actualiza el Menu de pausa y te permite escoger las diferentes opciones
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();

        for (int j = 0; j < colorTextos.length; j++) {
            colorTextos[j] = colorTexto;
        }

        if ((xpos > 799 && xpos < 826) && (ypos > 564 && ypos < 592)) {
            if (input.isMouseButtonDown(0)) {
                sbg.enterState(1);
            }
        }
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            sbg.enterState(1);
        }

        if ((xpos > 455 && xpos < 641) && (ypos > 509 && ypos < 542)) {
            if (input.isMouseButtonDown(0)) {
                actualSubWindow = 0;
                colorSubOpciones[0] = colortextoSeleccionado;
                colorSubOpciones[1] = colorTexto;
            }
        }
        if ((xpos > 642 && xpos < 828) && (ypos > 509 && ypos < 542)) {
            if (input.isMouseButtonDown(0)) {
                actualSubWindow = 1;
                colorSubOpciones[0] = colorTexto;
                colorSubOpciones[1] = colortextoSeleccionado;
            }
        }
        if ((xpos > 570 && xpos < 720) && (ypos > 434 && ypos < 477)) {
            colorTextos[0] = colortextoSeleccionado;
            if (input.isMouseButtonDown(0)) {
                if (actualSubWindow == 0) {
                    sbg.enterState(1);
                } else {
                    //Opción 1
                }
            }
        }
        if ((xpos > 570 && xpos < 720) && (ypos > 369 && ypos < 412)) {
            colorTextos[1] = colortextoSeleccionado;
            if (input.isMouseButtonDown(0)) {
                if (actualSubWindow == 0) {
                    sbg.enterState(0);
                } else {
                    //OPCIÓN 2
                }
            }
        }
        if ((xpos > 570 && xpos < 720) && (ypos > 306 && ypos < 347)) {
            colorTextos[2] = colortextoSeleccionado;
            if (input.isMouseButtonDown(0)) {
                if (actualSubWindow == 0) {
                    System.exit(0);
                } else {
                    principal.Estado_Juego.musicOn = !principal.Estado_Juego.musicOn;
                    if (Estado_Juego.musicOn) {
                        Estado_Juego.music.play();
                    } else {
                        Estado_Juego.music.stop();
                    }
                }
            }
        }
        if ((xpos > 570 && xpos < 720) && (ypos > 239 && ypos < 283)) {
            colorTextos[3] = colortextoSeleccionado;
            if (input.isMouseButtonDown(0)) {
                if (actualSubWindow == 1) {
                    sbg.enterState(1);
                }
            }
        }
    }

    /**
     * Pinta el Menu de pausa
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        actualScr = utils.ScreenClass.screenNumber();
        Image skrinGB = new Image(actualScr);
        g.drawImage(skrinGB, 0, 0);
        Image menuW = new Image("graphic/menu/PauseState.png");
        g.drawImage(menuW, 0, 0);

        Fuente.print18().drawString(607, 142, "Pausa");

        Fuente.print18().drawString(515, 187, "JUEGO", colorSubOpciones[0]);
        Fuente.print18().drawString(684, 187, "OPCIONES", colorSubOpciones[1]);

        Image buttonMS = new Image("graphic/menu/buttonMSPause.png");

        int bx = 560;
        int by = 177;

        if (actualSubWindow == 0) {
            for (int i = 0; i < 3; i++) {
                g.drawImage(buttonMS, bx, by += 65);
            }
            Fuente.print18().drawString(590, 256, "REANUDAR", colorTextos[0]);
            Fuente.print18().drawString(590, 321, "MENÚ", colorTextos[1]);
            Fuente.print18().drawString(590, 384, "SALIR", colorTextos[2]);
        }
        if (actualSubWindow == 1) {
            for (int i = 0; i < 4; i++) {
                g.drawImage(buttonMS, bx, by += 65);
            }
            Fuente.print18().drawString(590, 257, "Opción 1", colorTextos[0]);
            Fuente.print18().drawString(590, 319, "Opción 2", colorTextos[1]);
            if (Estado_Juego.musicOn) {
                Fuente.print18().drawString(590, 384, "MUSIC OFF", colorTextos[2]);
            } else {
                Fuente.print18().drawString(590, 389, "MUSIC ON", colorTextos[2]);
            }
            Fuente.print18().drawString(590, 449, "RENUDAR", colorTextos[3]);
        }
    }
}
