package adventofcode.task2;

import adventofcode.util.Vec2;

public interface Keypad {
	public boolean isValidPosition(Vec2 position);
	public String getKeyLabel(Vec2 position);
}
