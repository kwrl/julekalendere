package adventofcode.task1;

import java.util.ArrayList;
import java.util.List;

import adventofcode.util.Vec2;

public class Walker {
	private final Vec2 position = new Vec2(0, 0);
	private final Vec2 direction = Vec2.getNorth();
	
	private List<Vec2> path = new ArrayList<>();
	
	public Walker() {
		path.add(position);
	}

	public void turnLeft() {
		direction.left();
	}
	
	public void turnRight() {
		direction.right();
	}
	
	public void move(int length) {
		Vec2 move = direction.clone().scale(length);
		position.add(move);
		
		path.add(position.clone());
	}
	
	public Vec2 getPosition() {
		return position;
	}
	
	public Vec2 getDirection() {
		return direction;
	}
	
	public List<Vec2> getPath() {
		return path;
	}
}
