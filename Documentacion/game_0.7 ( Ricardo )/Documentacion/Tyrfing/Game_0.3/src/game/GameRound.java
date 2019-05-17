package game;

public class GameRound {
	
	private int duration;
	private final int durationMax = 10000; /* 5 seconds */
	private Character currentCharacter;
	private Characters characters;
	
	public GameRound(Character ch, Characters chars) {
		duration = 0;
		currentCharacter = ch;
		characters = chars;
		ch.setPlaying(true);
		ch.reset();
	}

	public boolean isOver() {
		return (duration > durationMax);
	}
	
	public void end() {
		currentCharacter.setPlaying(false);
	}
	
	public void update(int delta) {
		duration += delta;
	}
	
	public int getRemainingTime() {
		return (int)((durationMax - duration) / 1000);
	}
	
	public Character getCurrentCharacter() {
		return currentCharacter;
	}
}
