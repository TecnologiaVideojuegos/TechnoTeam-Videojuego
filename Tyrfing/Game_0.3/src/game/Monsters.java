package game;

import java.util.List;
import java.util.ArrayList;
import org.newdawn.slick.SlickException;

public class Monsters {
	private List<Monster> list;
	private Characters characters;
	private Map map; 
	
	public Monsters(Map map, Characters chars) {
		list = new ArrayList<Monster>();
		this.map = map;
		this.characters = chars;
	}
	
	public void spawn(int i, int j, String name) throws SlickException {
		Monster monster = new Monster(map, i, j, name);
		monster.init();
		list.add(monster);
		characters.add(monster);
	}
	
	public List<Monster> getList() {
		return this.list;
	}
}
