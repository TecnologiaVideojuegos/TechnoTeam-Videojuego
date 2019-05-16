package game;

import java.util.Random;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;

public class Monster extends Character {		
	public Monster(Map map, int i, int j, String name) {
		super(map, i, j, name);

		x = 64 * (j - 1); /* Cells start at 1 */
		y = 64 * i;
		newX = x;
		newY = y;
		direction = 2;
		speed = 0.06f;
		mpMax = 2;
		level = 1;
		hpMax = 3;
		mp = mpMax;
		hp = hpMax;
	}
	
	@Override
	public void init() throws SlickException {
		spriteSheet = new SpriteSheet("resources/images/skeleton.png", 64, 64);
		
		animations = new Animation[8];
		/* Static monster sprites */
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0); /* startX, endX, y on the spriteSheet */
		this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
		this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
		
		/* Moving monster sprites */
		this.animations[4] = loadAnimation(spriteSheet, 1, 9, 0);
		this.animations[5] = loadAnimation(spriteSheet, 1, 9, 1);
		this.animations[6] = loadAnimation(spriteSheet, 1, 9, 2);
		this.animations[7] = loadAnimation(spriteSheet, 1, 9, 3);
	}
	
	public void render(Graphics graph) throws SlickException {
		/* Display of the shadow */
		graph.setColor(new Color(0, 0, 0, 0.3f));
		graph.fillOval(this.x + offsetShadowX, this.y - offsetShadowY, shadowWidth, shadowHeight);
		
		if(!isMoving())
			graph.drawAnimation(animations[direction], (int)getX(), (int)getY() - offsetY);
		else
			graph.drawAnimation(animations[direction + 4], (int)getX(), (int)getY() - offsetY);
	}
	
	public void reset() {
		mp = mpMax;
		setDirection(1);
		move("left");
	}
	
	@Override
	public String getType() {
		return "monster";
	}
}
