package states;

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

public class Creditos extends BasicGameState {

    Image fondo;
    Image back;
    String pos_mouse = "";

    Color colorTexto = Color.white;
    Color colorOpcionSelecionada[] = {colorTexto};

    public Creditos() {
    }

    @Override
    public int getID() {
        return 8;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        fondo = new Image("graphic/menu/backgroundMainMenu.jpg");
        back = new Image("graphic/menu/buttonMenuPrincipal.png");
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            sbg.enterState(1);
        }

        int pos_x = Mouse.getX();
        int pos_y = Mouse.getY();

        pos_mouse = "x = " + pos_x + " y =" + pos_y;
        colorTexto = Color.white;
        for (int j = 0; j < colorOpcionSelecionada.length; j++) {
            colorOpcionSelecionada[j] = colorTexto;
        }

        //BACK BUTTON
        if ((pos_x > 520 && pos_x < 770) && (pos_y > 70 && pos_y < 100)) {
            if (input.isMouseButtonDown(0)) {
                sbg.enterState(0);
            }
            colorOpcionSelecionada[0] = Color.orange;
            if (input.isMouseButtonDown(0)) {
                colorOpcionSelecionada[0] = Color.gray;
            }
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {

        //fondo
        g.drawImage(fondo, 0, 0);

        //boton back
        g.drawImage(back, 493, 600);

        Fonts.print46().drawString(450, 100, "A U T O R E S", Color.white);

        Fonts.print25().drawString(250, 200, "Ricardo zambrana Zúñiga", Color.white);
        Fonts.print25().drawString(750, 200, "Técnico Sonido", Color.white);
        Fonts.print25().drawString(250, 250, "Miguel Herraez Sachez", Color.white);
        Fonts.print25().drawString(750, 250, "Diseño grafico", Color.white);
        Fonts.print25().drawString(250, 300, "Guzmán Bernaldo de Quirós", Color.white);
        Fonts.print25().drawString(750, 300, "Desarrollo Web", Color.white);
        Fonts.print25().drawString(250, 350, "Álvaro Alcaide Muñoz de Rivera", Color.white);
        Fonts.print25().drawString(750, 350, "Programador", Color.white);
        Fonts.print25().drawString(250, 400, "José Andrés Gómez Suárez", Color.white);
        Fonts.print25().drawString(750, 400, "Jefe Proyecto", Color.white);

        Fonts.print18().drawString(350, 545, "'Nunca hay que subestimar el poder de la imaginación'", Color.white);

        Fonts.print25().drawString(580, 625, "VOLVER", colorOpcionSelecionada[0]);

        g.drawString(pos_mouse, 10, 10);
    }
}
