package personaje;

import estados.Estado_1_PLAY;
import principal.Estado_Juego;
import principal.SpriteHeroe;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Te permite mover al personaje con wasd o con las flechas de dirección
 *
 */
public class MovimientoPersonaje extends SpriteHeroe {

	//---------------------------------------------
	//Metodos
	//---------------------------------------------
	
    public MovimientoPersonaje() throws SlickException {
    }

    public void go(Input input, Estado_Juego gs, int delta, SpriteHeroe sprite) {

        if(Estado_1_PLAY.dialogo==false){
            if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
            sprite.avatar = sprite.movingUp;
            sprite.avatar.update(delta);
            Estado_Juego.pos_y_hero -= delta * 0.15f;
        }
        if (input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) {
            sprite.avatar = sprite.movingDown;
            sprite.avatar.update(delta);
            Estado_Juego.pos_y_hero += delta * 0.21f;
        }
        if (input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)) {
            sprite.avatar = sprite.movingLeft;
            sprite.avatar.update(delta);
            Estado_Juego.pos_x_hero -= delta * 0.15f;
        }
        if (input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)) {
            sprite.avatar = sprite.movingRight;
            sprite.avatar.update(delta);
            Estado_Juego.pos_x_hero += delta * 0.21f;
        }
        }
    }
}
