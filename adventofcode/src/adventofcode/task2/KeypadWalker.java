package adventofcode.task2;

import adventofcode.util.Vec2;

public class KeypadWalker {
	private final Vec2 position;
	private final Keypad keypad;

	public KeypadWalker(Keypad keypad, Vec2 position) {
		this.keypad = keypad;
		this.position = position;
	}
	
	private void move(Vec2 move) {
		if(keypad.isValidPosition(position.clone().add(move))) {
			position.add(move);
		}
	}

	public void up() {
		move(Vec2.getNorth());
	}
	
	public void down() {
		move(Vec2.getSouth());
	}
	
	public void left() {
		move(Vec2.getWest());
	}
	
	public void right() {
		move(Vec2.getEast());
	}
	
	public Vec2 getPosition() {
		return position;
	}
	
	public Keypad getKeypad() {
		return keypad;
	}
}
