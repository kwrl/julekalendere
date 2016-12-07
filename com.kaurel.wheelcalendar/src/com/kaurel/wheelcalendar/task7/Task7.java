package com.kaurel.wheelcalendar.task7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

import com.kaurel.wheelcalendar.util.Vec2;
public class Task7 {
	public static Vec2 parseVec2(String line) {
		StringTokenizer tk = new StringTokenizer(line);
		tk.nextToken(); //"walk"
		int length = Integer.parseInt(tk.nextToken());
		tk.nextToken(); //"meters"
		String direction = tk.nextToken();
		if("north".equals(direction)) {
			return Vec2.getNorth().scale(length);
		} else if("south".equals(direction)) {
			return Vec2.getSouth().scale(length);
		} else if("west".equals(direction)) {
			return Vec2.getWest().scale(length);
		} else {
			return Vec2.getEast().scale(length);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Vec2 start = new Vec2(0, 0);
		Files.lines(Paths.get(Task7.class.getResource("input7.txt").getFile()))
			.map(Task7::parseVec2)
			.forEach(start::add);
		System.out.println(start.getY()+","+(-start.getX()));;
	}
}
