package personaje;

import principal.GameStatus;
import principal.SpriteHero;
import modelos.Hero;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class MovimientoPersonaje extends SpriteHero {

    public MovimientoPersonaje() throws SlickException {
    }

    public void go(Input input, GameStatus gs, int delta, SpriteHero sprite) {

        if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
            sprite.avatar = sprite.movingUp;
            sprite.avatar.update(delta);
            GameStatus.pos_y_hero -= delta * 0.15f;
        }
        if (input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) {
            sprite.avatar = sprite.movingDown;
            sprite.avatar.update(delta);
            GameStatus.pos_y_hero += delta * 0.21f;
        }
        if (input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)) {
            sprite.avatar = sprite.movingLeft;
            sprite.avatar.update(delta);
            GameStatus.pos_x_hero -= delta * 0.15f;
        }
        if (input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)) {
            sprite.avatar = sprite.movingRight;
            sprite.avatar.update(delta);
            GameStatus.pos_x_hero += delta * 0.21f;
        }
    }
}
