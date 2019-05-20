package personaje;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import utils.ScreenClass;

public class Teclas {
    public static void functionalKeyHandler(GameContainer gc, StateBasedGame sbg, Input input, int xpos, int ypos) {
        
        xpos = input.getMouseX();
        ypos = input.getMouseY();

        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            switch (sbg.getCurrentStateID()) {
                case 0: {
                    System.exit(0);
                    break;
                }
                case 1: {
                    ScreenClass.makeScreen(xpos, ypos);
                    sbg.enterState(9);
                    break;
                }
                default: {
                    sbg.enterState(1);
                    break;
                }
            }
        }
        
        //Pause
        if (input.isKeyPressed(Input.KEY_P)) {
            if (sbg.getCurrentStateID() == 9) {
                sbg.enterState(1);
            } else {
                utils.ScreenClass.makeScreen(xpos, ypos);
                sbg.enterState(9);
            }
        }
    }
}
