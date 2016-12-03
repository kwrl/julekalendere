package adventofcode.task2;

import adventofcode.util.Vec2;

public class RetardedKeypad implements Keypad {
	private String[][] labels = { 	
									new String[] { null, null, "D", null, null }, 
									new String[] { null, "A", "B", "C", null }, 
									new String[] { "5", "6", "7", "8", "9" },
									new String[] { null, "2", "3", "4", null }, 
									new String[] { null, null, "1", null, null },
								};

	@Override
	public boolean isValidPosition(Vec2 position) {
		if (position.getY() < 0 || position.getY() > 4 || position.getX() < 0 || position.getX() > 4) {
			return false;
		}

		return labels[position.getY()][position.getX()] != null;
	}

	@Override
	public String getKeyLabel(Vec2 position) {
		return labels[position.getY()][position.getX()];
	}

}
