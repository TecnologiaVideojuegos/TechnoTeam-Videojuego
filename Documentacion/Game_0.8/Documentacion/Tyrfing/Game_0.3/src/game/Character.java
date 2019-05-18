package game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.SlickException;

public abstract class Character {
	protected Map map;
	
	/* Position & offset of the sprite on the screen, in pixels */
	protected float x; /* horizontal axis, right-oriented */
	protected float y; /* vertical axis, up-oriented */
	protected final int offsetY = 20 + 64;
	/* Size & offset of the shadow */
	protected final int shadowWidth = 32;
	protected final int shadowHeight = 16;
	protected final int offsetShadowX = 16;
	protected final int offsetShadowY = 32;
	
	/* Next position of the character, if the tile has changed */
	protected float newX;
	protected float newY;
	
	/* Position of the character on the map, in tiles */
	protected int i; /* row */
	protected int j; /* column */ 
	
	protected int hp;
	protected int mp;
	protected int hpMax;
	protected int mpMax;
	protected boolean moving;
	protected boolean playing;
	protected int direction;
	protected float speed; 
	protected int level;
	protected String name;
	
	protected SpriteSheet spriteSheet;
	protected Animation[] animations;
	
	public Character(Map map, int i, int j, String name) {
		this.map = map;
		this.i = i;
		this.j = j;
		moving = false;
		playing = false;
		spriteSheet = null;
		animations = null;
		this.name = name;
	}
	
	public abstract void init() throws SlickException;
	
	public  void update(int delta) {
		/* distance = speed * time */
		float distance = (speed * delta);
		
		if(abs(newX - x) > 5 || abs(newY - y) > 5)
			setMoving(true);
		else {
			setMoving(false);
			x = newX;
			y = newY;
		}
		
		if(isMoving()) {
	        switch(getDirection()) {
	            case 0:
	            	y -= distance;
	            	break;
	            	
	            case 1:
	            	x -= distance;
	            	break;
	            	
	            case 2:
	            	y += distance;
	            	break;
	            	
	            case 3:
	            	x += distance;
	            	break;
	        }
	    }
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
	
	public abstract void reset();
	
	public void move(String strDirection) {
		if(mp > 0 && !isMoving()) {
			switch(strDirection) {
				case "left": j--; break;
				case "right": j++; break;
				case "up": i--; break;
				case "down": i++; break;
			}
			setMoving(true);
			mp--;
			newX = 64 * (j - 1); /* Cells start at 1 */
			newY = 64 * i;
		}
	}
	
	protected Animation loadAnimation(SpriteSheet ss, int startX, int endX, int y) {
		Animation anim = new Animation();
		for(int x = startX; x < endX; x++) {
			anim.addFrame(ss.getSprite(x, y), 100);
		}
		return anim;
	}
	
	public float abs(float x) {
		if(x >= 0)
			return x;
		else
			return (-1) * x;
	}
	
	public abstract String getType(); /* returns "monster" or "player" */
	
	public void setDirection(int dir) {
		this.direction = dir;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public boolean isMoving() {
		return this.moving;
	}
	
	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
	
	public boolean isPlaying() {
		return this.playing;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public int getMP() {
		return this.mp;
	}
	
	public int getMaxHP() {
		return this.hpMax;
	}
	
	public int getMaxMP() {
		return this.mpMax;
	}
	
	public Map getMap() {
		return this.map;
	}
}