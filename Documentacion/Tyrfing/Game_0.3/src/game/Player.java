package game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.SlickException;

public class Player extends Character {	
	private int money;
	
	public Player(Map map, int i, int j, String name) {
		super(map, i , j, name);
		
		x = 64 * (j - 1); /* Cells start at 1 */
		y = 64 * i;		
		newX = x;
		newY = y;
		direction = 2;
		hpMax = 5;
		mpMax = 3;
		hp = hpMax;
		mp = mpMax;
		speed = 0.08f;
		level = 1;
		money = 0;
	}
	
	@Override
	public void init() throws SlickException {
		spriteSheet = new SpriteSheet("resources/images/character.png", 64, 64);
		
		animations = new Animation[8];
		/* Static player sprites */
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0); /* startX, endX, y on the spriteSheet */
		this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
		this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
		
		/* Moving player sprites */
		this.animations[4] = loadAnimation(spriteSheet, 1, 9, 0);
		this.animations[5] = loadAnimation(spriteSheet, 1, 9, 1);
		this.animations[6] = loadAnimation(spriteSheet, 1, 9, 2);
		this.animations[7] = loadAnimation(spriteSheet, 1, 9, 3);
	}
		
	@Override
	public void reset() {
		mp = mpMax;
	}
	
	@Override
	public String getType() {
		return "player";
	}
}
