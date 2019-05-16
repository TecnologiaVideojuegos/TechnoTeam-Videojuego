package game;

import org.newdawn.slick.TrueTypeFont;

import java.awt.Font;
import java.io.InputStream;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.Color;

public class Hud {
	private Characters characters;
	private GameRound round;
	private Font font;
	private TrueTypeFont ttf;
	
	public Hud(Characters cha, GameRound gr) {
		this.characters = cha;
		this.round = gr;
	}
	
	public void init() {
		/*font = new Font("resources/fonts/morningtype.ttf", Font.PLAIN, 20);
		ttf = new TrueTypeFont(font, true);*/
		
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("resources/fonts/morningtype.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			font = font.deriveFont(20f); // set font size
			ttf = new TrueTypeFont(font, true);
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void render() {
		ttf.drawString(10.0f, 30.0f, "Remaining time : " + String.valueOf(round.getRemainingTime()), Color.white);
		ttf.drawString(10.0f, 50.0f, "Current player : " + round.getCurrentCharacter().getName(), Color.white);
		
		int i = 0; 
		for(Character cha: characters.getList()) {
			i++;
			ttf.drawString(10.0f, 70.0f + 20 * i, cha.getName(), Color.white);
			ttf.drawString(100.0f, 70.0f + 20 * i, "Level: " + cha.getLevel(), Color.yellow);
			ttf.drawString(175.0f, 70.0f + 20 * i, "HP: " + cha.getHP() + "/" + cha.getMaxHP(), Color.red);
			ttf.drawString(250.0f, 70.0f + 20 * i, "MP: " + cha.getMP() + "/" + cha.getMaxMP(), Color.green);
		}
		
		displayProperty();
	}
	
	public void setRound(GameRound gr) {
		round = gr;
	}
	
	public void displayProperty() {
		int id = this.characters.getList().get(0).getMap().getTileId(1, 1, 0);
		ttf.drawString(500.0f, 70.0f, this.characters.getList().get(0).getMap().getTileProperty(id, "crossable", "default"), Color.green);
	}
}
