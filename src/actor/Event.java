package actor;

import core.Sprite;
import core.GameStatus;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Event {

    private Movement movement;
    private CollisionsFields collisionFields;
    private Portals portals;

    public Event(Sprite sprite) throws SlickException {
        this.movement = new Movement();
        this.collisionFields = new CollisionsFields();
        this.portals = new Portals();
    }

    public void update(GameContainer container, StateBasedGame sbg, int delta, GameStatus gs, Input input, int xPos, int yPos) throws SlickException {

        int oldX = GameStatus.pos_x_hero;
        int oldY = GameStatus.pos_y_hero;
        
        Keys.functionalKeyHandler(container, sbg, input, GameStatus.sprite.heroWidth, GameStatus.sprite.heroHeight);

        movement.go(input, gs, delta, GameStatus.sprite);

        core.LoadEntity.recPlayer = new Rectangle(GameStatus.pos_x_hero, GameStatus.pos_y_hero, GameStatus.sprite.heroWidth, GameStatus.sprite.heroHeight - 5);

        int playerCenterX = GameStatus.pos_x_hero + (GameStatus.sprite.heroWidth / 2) - 7;
        int playerCenterY = GameStatus.pos_y_hero + (GameStatus.sprite.heroHeight / 2);
        
        portals.isEnter(gs, playerCenterX, playerCenterY);

        collisionFields.isCollision(gs, oldX, oldY);

    }
}
