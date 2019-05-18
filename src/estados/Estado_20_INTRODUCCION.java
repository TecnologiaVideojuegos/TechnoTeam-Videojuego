package estados;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Estado_20_INTRODUCCION extends BasicGameState {

    public static final int ID = 20;
    private Image introimg;
    private float posy;
    private final float vel = (float) 0.015;
    private boolean movimiento;
    private int msFinal;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        posy = 0;

        introimg = new Image("graphic/historia/intro.png");
        movimiento = true;
        msFinal = 0;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        introimg.draw(0, -posy);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        if (movimiento) {
            if (Keyboard.isKeyDown(Input.KEY_RETURN)) {
                posy += (vel * 2.5) * delta;
            } else {
                posy += (vel) * delta;
            }
            if (posy >= 340) {
                posy = 340;
                movimiento = false;
            }
        } else {

            if (Keyboard.isKeyDown(Input.KEY_RETURN)) {
                msFinal += delta;
            } else {
                msFinal += delta * 2;
            }
            if (posy >= 365) {
                movimiento = false;
            }
        }

        if (Keyboard.isKeyDown(Input.KEY_ESCAPE) || msFinal >= 3000) {
            game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

        }

    }
}
