package estados;

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
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import principal.Estado_Juego;

public class Estado_2_OPCIONES extends BasicGameState {

    Color colorTexto = Color.white;
    Color opcionSeleccionada = Color.orange;
    Color ctab[] = {colorTexto, colorTexto, colorTexto, colorTexto, colorTexto};

    Fuente font2;

    public Estado_2_OPCIONES() {
    }

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        font2 = new Fuente();
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

        Fuente.print78().drawString(440, 100, "Opciones", colorTexto);
        Fuente.print25().drawString(565, 260, "Opción 1", ctab[0]);
        Fuente.print25().drawString(565, 345, "Opción 2", ctab[1]);
        Fuente.print25().drawString(565, 430, "Opción 3", ctab[2]);
        if (Estado_Juego.musicOn) {
            Fuente.print25().drawString(590, 384, "MUSIC OFF", ctab[3]);
        } else {
            Fuente.print25().drawString(590, 389, "MUSIC ON", ctab[3]);
        }
        Fuente.print25().drawString(565, 600, "Volver", ctab[4]);
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
                 Estado_Juego.musicOn = !Estado_Juego.musicOn;
                 if(Estado_Juego.musicOn){
                 Estado_Juego.music.play();
                 }else{
                 Estado_Juego.music.stop();
                 }
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
