package states;

import actor.*;
import core.*;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class PlayState extends BasicGameState {

    public static boolean needToMapUpdate = false;

    private Camera camera;

    public static GameStatus gameStatus;

    private Event event;


    public PlayState() {
    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        gameStatus = new GameStatus();
        camera = new Camera(container, gameStatus.map);
        event = new actor.Event(GameStatus.sprite);
    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {

        Input input = container.getInput();
        int xPos = Mouse.getX();
        int yPos = Mouse.getY();

        event.update(container, sbg, delta, gameStatus, input, xPos, yPos);

        if (needToMapUpdate) {
            updateGameStatus(container);
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {

        camera.centerOn(GameStatus.pos_x_hero, GameStatus.pos_y_hero);

        camera.drawMap(0);

        camera.translateGraphics();

        GameStatus.sprite.avatar.draw(GameStatus.pos_x_hero, GameStatus.pos_y_hero);

    }

    public void updateGameStatus(GameContainer container) {
        try {
            gameStatus.map = new TiledMap("graphic/map/" + Integer.toString(GameStatus.levelID) + ".tmx");
            gameStatus.map.render(0, 0);
            camera = new core.Camera(container, gameStatus.map);

            gameStatus.updateEntityFieldList(gameStatus.map);

        } catch (SlickException e) {
            System.out.println("Error en updateGameStatus playState");
        }
        needToMapUpdate = false;
    }
}
