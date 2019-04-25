package actor;

import core.GameStatus;
import core.LoadEntity;

public class CollisionsFields {

    public CollisionsFields() {
    }

    public void isCollision(GameStatus gs, int oldX, int oldY) {
        int iter = 0;

        while (LoadEntity.collisions.size() > iter) {
            if (LoadEntity.recPlayer.intersects(LoadEntity.collisions.get(iter))) {
                GameStatus.pos_x_hero = oldX;
                GameStatus.pos_y_hero = oldY;
            }
            iter++;
        }
    }
}
