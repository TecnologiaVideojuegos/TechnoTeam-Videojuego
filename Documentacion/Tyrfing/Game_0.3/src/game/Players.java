package game;

import java.util.List;
import java.util.ArrayList;
import org.newdawn.slick.SlickException;

public class Players {
	private List<Player> list;
	private Characters characters;
	private Map map; 
	
	public Players(Map map, Characters chars) throws SlickException {
		list = new ArrayList<Player>();
		this.characters = chars;
		this.map = map;
	}
	
	public void spawn(int i, int j, String name) throws SlickException {
		Player player = new Player(map,i, j, name);
		player.init();
		list.add(player);
		characters.add(player);
	}
	
	public List<Player> getList() {
		return this.list;
	}
}