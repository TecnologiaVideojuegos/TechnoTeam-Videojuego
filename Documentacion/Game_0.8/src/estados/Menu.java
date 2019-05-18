package estados;

import utils.Fonts;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * Menu principal que sale al iniciar el juego
 * 
 *
 */
public class Menu extends BasicGameState {

    Image fondo;
    Image buttonBB;
    private Color colorTexto = Color.white;
    private final Color colorOpcionSelecionada[] = {colorTexto, colorTexto, colorTexto, colorTexto};

    public static Music music;

    private String pos_mouse = "";

    public Menu() {
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        fondo = new Image("graphic/menu/backgroundMainMenu.jpg");
        buttonBB = new Image("graphic/menu/buttonMenuPrincipal.png");
        music = new Music("music/cancion_intro_al_juego.ogg");
        music.setVolume(1);
        music.loop(1.0F, 0.1F);
    }

    //Al pulsar una de las opciones cambias de estado(interfaz)
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

        Input input = gc.getInput();
        int pos_x = Mouse.getX();
        int pos_y = Mouse.getY();

        colorTexto = Color.white;
        pos_mouse = "x = " + pos_x + " y =" + pos_y;
        for (int k = 0; k < colorOpcionSelecionada.length; k++) {
            colorOpcionSelecionada[k] = colorTexto;
        }
        //Jugar
        if ((pos_x > 520 && pos_x < 770) && (pos_y > 410 && pos_y < 480)) {
            colorOpcionSelecionada[0] = Color.orange;
            if (input.isMouseButtonDown(0)) {
                sbg.enterState(14, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            }
        }
        //Opciones
        if ((pos_x > 520 && pos_x < 770) && (pos_y > 320 && pos_y < 390)) {
            colorOpcionSelecionada[1] = Color.orange;
            if (input.isMouseButtonDown(0)) {
                sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            }
        }
        //Créditos
        if ((pos_x > 520 && pos_x < 770) && (pos_y > 240 && pos_y < 310)) {
            colorOpcionSelecionada[2] = Color.orange;
            if (input.isMouseButtonDown(0)) {
                sbg.enterState(8, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            }
        }

        //Exit
        if ((pos_x > 520 && pos_x < 770) && (pos_y > 160 && pos_y < 220)) {
            colorOpcionSelecionada[3] = Color.orange;
            if (input.isMouseButtonDown(0)) {
                System.exit(0);
            }
        }
    }

    //Pintas las opciones del menu
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        g.drawImage(fondo, 0, 0);

        int bx = 500, by = 150;
        for (Color selectorColor : colorOpcionSelecionada) {
            g.drawImage(buttonBB, bx, by += 85);
        }

        Fonts.print78().drawString(450, 100, "TYRFING", Color.white);
        Fonts.print25().drawString(570, 260, "JUGAR", colorOpcionSelecionada[0]);
        Fonts.print25().drawString(570, 345, "OPCIONES", colorOpcionSelecionada[1]);
        Fonts.print25().drawString(570, 430, "CREDITOS", colorOpcionSelecionada[2]);
        Fonts.print25().drawString(570, 515, "EXIT", colorOpcionSelecionada[3]);

        g.drawString(pos_mouse, 10, 10);
    }
}
