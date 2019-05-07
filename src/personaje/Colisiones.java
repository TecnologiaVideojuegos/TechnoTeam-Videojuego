package personaje;

import principal.GameStatus;
import principal.LoadEntity;

public class Colisiones {

    public Colisiones() {
    }

    public void isCollision(GameStatus gs, int oldX, int oldY) {
        int iter = 0;

        while (LoadEntity.colisiones.size() > iter) {
            if (LoadEntity.celdaJugador.intersects(LoadEntity.colisiones.get(iter))) {
                GameStatus.pos_x_hero = oldX;
                GameStatus.pos_y_hero = oldY;
            }
            iter++;
        }
    }
}
