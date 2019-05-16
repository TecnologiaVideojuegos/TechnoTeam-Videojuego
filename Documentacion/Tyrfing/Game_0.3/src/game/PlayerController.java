package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class PlayerController implements KeyListener {
	private Player player;
	private GameContainer container;
	
	public PlayerController(Player p, GameContainer gc) {
		this.player = p;
		this.container = gc;
	}
	
	@Override
	public void setInput(Input input) { }

	@Override
	public boolean isAcceptingInput() { return true; }
 
	@Override
	public void inputEnded() { }

	@Override
	public void inputStarted() { }
	
	@Override
	public void keyPressed(int key, char c) { 
		switch(key) {		
			case Input.KEY_UP:
				if(!player.isMoving() && player.isPlaying()) {
					player.setDirection(0);
					player.move("up");
				}
				break;
				
			case Input.KEY_LEFT:
				if(!player.isMoving() && player.isPlaying()) {
					player.setDirection(1);
					player.move("left");
				}
				break;
				
			case Input.KEY_DOWN:
				if(!player.isMoving() && player.isPlaying()) {
					player.setDirection(2);
					player.move("down");
				}
				break;
				
			case Input.KEY_RIGHT:
				if(!player.isMoving() && player.isPlaying()) {
					player.setDirection(3);
					player.move("right");
				}
				break;
				
			case Input.KEY_ESCAPE:
					container.exit();
	
		}
	}

	@Override
	public void keyReleased(int key, char c) {
		//player.setMoving(false);
	}
}
