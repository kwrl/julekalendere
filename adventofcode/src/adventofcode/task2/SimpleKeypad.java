package adventofcode.task2;

import adventofcode.util.Vec2;

public class SimpleKeypad implements Keypad {

	@Override
	public boolean isValidPosition(Vec2 position) {
		return position.getX() >= 0 
				&& position.getX() < 3
				&& position.getY() >= 0
				&& position.getY() < 3;
	}

	@Override
	public String getKeyLabel(Vec2 position) {
		return ""+(position.getX()+1 + 3*(2-position.getY()));
	}

}
