package personaje;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import utils.ScreenClass;

public class Keys {
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
        if (input.isKeyPressed(Input.KEY_C)) {
            if (sbg.getCurrentStateID() == 3) {
                sbg.enterState(1);
            } else {
                utils.ScreenClass.makeScreen(xpos, ypos);
                sbg.enterState(3);
            }
        }
        if ((input.isKeyPressed(Input.KEY_B)) || (input.isKeyPressed(Input.KEY_TAB)) || (input.isKeyPressed(Input.KEY_I))) {
            if (sbg.getCurrentStateID() == 4) {
                sbg.enterState(1);
            } else {
                utils.ScreenClass.makeScreen(xpos, ypos);
                sbg.enterState(4);
            }
        }
        if ((input.isKeyPressed(Input.KEY_Q)) || (input.isKeyPressed(Input.KEY_L))) {
            if (sbg.getCurrentStateID() == 5) {
                sbg.enterState(1);
            } else {
                utils.ScreenClass.makeScreen(xpos, ypos);
                sbg.enterState(5);
            }
        }

        if (input.isKeyPressed(Input.KEY_K)) {
            if (sbg.getCurrentStateID() == 6) {
                sbg.enterState(1);
            } else {
                utils.ScreenClass.makeScreen(xpos, ypos);
                sbg.enterState(6);
            }
        }
        if (input.isKeyPressed(Input.KEY_M)) {
            if (sbg.getCurrentStateID() == 7) {
                sbg.enterState(1);
            } else {
                sbg.enterState(7);
            }
        }
        if (input.isKeyPressed(Input.KEY_Z)) {
            if (sbg.getCurrentStateID() == 12) {
                sbg.enterState(1);
            } else {
                utils.ScreenClass.makeScreen(xpos, ypos);
                sbg.enterState(12);
            }
        }
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
