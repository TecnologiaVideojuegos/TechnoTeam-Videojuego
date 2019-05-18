package estados;

import utils.Fonts;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * Menu de opciones al que puedes acceder desde el menu principal
 * No hace nada
 *
 */

public class Opciones extends BasicGameState {

    Color colorTexto = Color.white;
    Color opcionSeleccionada = Color.orange;
    Color ctab[] = {colorTexto, colorTexto, colorTexto, colorTexto, colorTexto};

    Fonts font2;

    public Opciones() {
    }

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        font2 = new Fonts();
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {

        Image menuF = new Image("graphic/menu/backgroundMainMenu.jpg");
        g.drawImage(menuF, 0, 0);
        Image buttonBB = new Image("graphic/menu/buttonMenuPrincipal.png");

        int bx = 500;
        int by = 150;
        for (int i = 0; i < 5; i++) {
            g.drawImage(buttonBB, bx, by += 85);
        }

        Fonts.print78().drawString(440, 100, "Opciones", colorTexto);
        Fonts.print25().drawString(565, 260, "Opción 1", ctab[0]);
        Fonts.print25().drawString(565, 345, "Opción 2", ctab[1]);
        Fonts.print25().drawString(565, 430, "Opción 3", ctab[2]);
        Fonts.print25().drawString(565, 515, "Opción 4", ctab[3]);
        Fonts.print25().drawString(565, 600, "Volver", ctab[4]);
    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int i) throws SlickException {
        Input input = container.getInput();
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            sbg.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }

        int xpos = Mouse.getX();
        int ypos = Mouse.getY();

        for (int j = 0; j < ctab.length; j++) {
            ctab[j] = colorTexto;
        }
        if ((xpos > 520 && xpos < 777) && (ypos > 410 && ypos < 484)) {
            ctab[0] = opcionSeleccionada;
            if (input.isMouseButtonDown(0)) {
            }
        }
        if ((xpos > 520 && xpos < 777) && (ypos > 326 && ypos < 399)) {
            ctab[1] = opcionSeleccionada;
            if (input.isMouseButtonDown(0)) {
            }
        }
        if ((xpos > 520 && xpos < 777) && (ypos > 241 && ypos < 314)) {
            ctab[2] = opcionSeleccionada;
            if (input.isMouseButtonDown(0)) {
            }
        }
        if ((xpos > 520 && xpos < 777) && (ypos > 156 && ypos < 229)) {
            ctab[3] = opcionSeleccionada;
            if (input.isMouseButtonDown(0)) {
            }
        }
        if ((xpos > 520 && xpos < 777) && (ypos > 69 && ypos < 144)) {
            ctab[4] = opcionSeleccionada;
            if (input.isMouseButtonDown(0)) {
                sbg.enterState(0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            }
        }
    }
}
