package game;

import java.util.List;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import java.util.ArrayList;

public class Characters {
	private List<Character> list;
	
	public Characters() {
		list = new ArrayList<Character>();
	}
	
	public void add(Character c) {
		list.add(c);
	}
	
	public List<Character> getList() {
		return this.list;
	}
	
	public void update(int delta) {
		for(Character cha: getList()) {
			cha.update(delta);
		}
	}
	
	public void render(Graphics graph) throws SlickException {
		for(Character cha: getList()) {
			cha.render(graph);
		}
	}
	
	
}