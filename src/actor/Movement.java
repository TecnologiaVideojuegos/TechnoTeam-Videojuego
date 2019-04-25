package actor;

import core.GameStatus;
import core.Sprite;
import model.Hero;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Movement extends Sprite {

    public Movement() throws SlickException {
    }

    public void go(Input input, GameStatus gs, int delta, Sprite sprite) {

        if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
            sprite.avatar = sprite.movingUp;
            sprite.avatar.update(delta);
            GameStatus.pos_y_hero -= Hero.movementSpeed * delta * 0.15f;
        }
        if (input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) {
            sprite.avatar = sprite.movingDown;
            sprite.avatar.update(delta);
            GameStatus.pos_y_hero += Hero.movementSpeed * delta * 0.21f;
        }
        if (input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)) {
            sprite.avatar = sprite.movingLeft;
            sprite.avatar.update(delta);
            GameStatus.pos_x_hero -= Hero.movementSpeed * delta * 0.15f;
        }
        if (input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)) {
            sprite.avatar = sprite.movingRight;
            sprite.avatar.update(delta);
            GameStatus.pos_x_hero += Hero.movementSpeed * delta * 0.21f;
        }
    }
}
