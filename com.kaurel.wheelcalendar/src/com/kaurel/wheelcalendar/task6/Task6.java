package com.kaurel.wheelcalendar.task6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kaurel.wheelcalendar.util.Vec2;

public class Task6 {
	private static List<Vec2> moves = new ArrayList<>();
	
	static {
		moves.add(new Vec2(1, 2));
		moves.add(new Vec2(1, -2));
		moves.add(new Vec2(-1, 2));
		moves.add(new Vec2(-1, -2));
		
		moves.add(new Vec2(2, 1));
		moves.add(new Vec2(2, -1));
		moves.add(new Vec2(-2, 1));
		moves.add(new Vec2(-2, -1));
	}
	
	
	private Map<Vec2, Integer> cells = new HashMap<>();
	
	public int getCellValue(Vec2 pos) {
		if(!cells.containsKey(pos)) {
			cells.put(pos, pos.getX()+pos.getY());
		}
		return cells.get(pos);
	}
	
	public void setCellValue(Vec2 pos, int value) {
		if(!cells.containsKey(pos)) {
			cells.put(pos, value);
		} else {
			cells.replace(pos, value);
		}
	}
	
	private Vec2 position = new Vec2(0, 0);
	
	public void move() {
		Vec2 newPos = moves
			.stream()
			.map(m -> position.clone().add(m))
			.sorted((p0, p1) -> {
				int p0dist = Math.abs(getCellValue(position) - getCellValue(p0));
				int p1dist = Math.abs(getCellValue(position) - getCellValue(p1));
				if(p0dist == p1dist) {
					if(p0.getX() == p1.getX()) {
						return p0.getY() - p1.getY();
					}
					return p0.getX() -p1.getX();
				}
				return p0dist - p1dist;
			})
			.findFirst()
			.get();
		
		System.out.println(newPos.clone().sub(position));
		int oldValue = getCellValue(position);
		if(oldValue == 1000) {
			setCellValue(position, 0);
		} else {
			setCellValue(position, 1000);
		}
		position = newPos;
	}
		
	public Task6() {
		for(long i = 0; i < 3L; i++ ) {
			move();
		}
		
		for(int y = 5; y >= -5; y--) {
			for(int x = -5; x < 5; x++) {
				System.out.print(getCellValue(new Vec2(x, y))+"\t");
			}
			System.out.println();
		}
		System.out.println(position);
	}

	
	public static void main(String[] args) {
		new Task6();
	}
	
	class Cell extends Vec2 {
		boolean valueIsSet = false;
		private int value;
		
		public Cell(int x, int y) {
			super(x, y);
		}
		
		private int getInitialValue() {
			return getX() + getY();
		}
		
		public int getValue() {
			if(!valueIsSet) {
				return getInitialValue();
			}
			return value;
		}
		
		public void setValue(int value) {
			this.value = value;
			valueIsSet = true;
		}
	}

}
