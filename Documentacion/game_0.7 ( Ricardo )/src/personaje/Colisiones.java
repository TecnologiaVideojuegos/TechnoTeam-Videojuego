package personaje;

import principal.GameStatus;
import principal.LoadEntity;

public class Colisiones {

    public Colisiones() {
    }

    public void isCollision(GameStatus gs, int oldX, int oldY) {
        int iter = 0;

        while (LoadEntity.collisions.size() > iter) {
            if (LoadEntity.recPlayer.intersects(LoadEntity.collisions.get(iter))) {
                System.out.println("Colisiones1: "+GameStatus.pos_x_hero+" "+ GameStatus.pos_y_hero);
                GameStatus.pos_x_hero = oldX;
                GameStatus.pos_y_hero = oldY;
                System.out.println("Colisiones2: "+GameStatus.pos_x_hero+" "+ GameStatus.pos_y_hero);
            }
            iter++;
        }
    }
}
