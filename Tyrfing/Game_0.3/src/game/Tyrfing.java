package game;

import java.util.Iterator;
import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class Tyrfing extends BasicGame {
	
	/* Fields */
	private GameContainer container;
	private Map map;
	private Hud hud;
	private Characters characters;
	private Players players; 
	private Monsters monsters;
	private PlayerController controller;
	private GameRound round;
	private Iterator<Character> itr;
	
	/* Constructor */
	public Tyrfing() throws SlickException {
		super("Tyrfing"); 
		container = null;
		map = new Map();
		characters = new Characters();
		players = new Players(map, characters);
		monsters = new Monsters(map, characters);
		round = null;
		hud = null;
	}
	
	@Override
	/* Initializes the game, loads graphics, music ... */
	public void init(GameContainer container) throws SlickException {
		this.container = container;
		/* Create an object map from Tiled file */
		this.map.init();
		
		/* Spawn the characters */
		players.spawn(3, 3, "Player 1");
		
		Random rand = new Random();
		for(int k = 0; k < 2; k++) {
			int i = rand.nextInt(16 - 1 + 1) + 1;
			int j = rand.nextInt(30 - 1 + 1) + 1;
			monsters.spawn(i, j, "Monster " + String.valueOf(k));
		}
		
		itr = characters.getList().iterator();
		
		round = new GameRound((Character)itr.next(), characters);
		hud = new Hud(characters, round);
		hud.init();
		controller = new PlayerController(players.getList().get(0), container);
		
		this.container.getInput().addKeyListener(controller);
		Music background = new Music("resources/sounds/showme.ogg");
		background.loop();
	}
	
	@Override
	/* Renders the game content */
	public void render(GameContainer container, Graphics graph) throws SlickException {
		this.map.render();
		this.characters.render(graph);
		this.hud.render();
	}
	
	@Override
	/* Updates the elements of the game according to the elapsed time delta (miliseconds) */
	public void update(GameContainer container, int delta) throws SlickException {
	    this.characters.update(delta);
	    this.round.update(delta);
	   
	    if(round.isOver()) {
	    	round.end();
	    	
	    	if(itr.hasNext())
	    		round = new GameRound((Character)itr.next(), characters);
	    	else {
	    		itr = characters.getList().iterator();
	    		round = new GameRound((Character)itr.next(), characters);
	    	}
	    	hud.setRound(round);
	    }
	}
	
	public static void main(String[] args) throws SlickException {
		//1920, 1080 true    error
		new AppGameContainer(new Tyrfing(), 1280, 720, false).start();
	}
}
