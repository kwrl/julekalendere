package adventofcode.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import adventofcode.util.Vec2;

public class Task2 {
	private static final Keypad keypad = new RetardedKeypad();
	//private static final Keypad keypad = new SimpleKeypad();
	private static final KeypadWalker walker = new KeypadWalker(keypad, new Vec2(0, 2));
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(Task2.class.getResource("input.txt").getFile()));
		String line;
		
		while((line = reader.readLine())!=null) {
			for(char instruction : line.toCharArray()) {
				switch(instruction) {
				case 'U':
					walker.up();
					break;
				case 'D':
					walker.down();
					break;
				case 'L':
					walker.left();
					break;
				case 'R':
					walker.right();
					break;
				}
			}
			System.out.print(keypad.getKeyLabel(walker.getPosition()));
		}
		
		reader.close();
	}
}
