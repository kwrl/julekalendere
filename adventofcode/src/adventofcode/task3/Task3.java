package adventofcode.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Task3 {
	List<Triangle> triangles = new ArrayList<>();

	public Task3() throws IOException {
		String content = new String(
				Files.readAllBytes(
						Paths.get(
								getClass().getResource("input3.txt").getFile())
						)
				);	
		StringTokenizer tk = new StringTokenizer(content);
		List<Integer> numbers = new ArrayList<>();
		while(tk.hasMoreTokens()) {
			numbers.add(Integer.parseInt(tk.nextToken()));
		}
		
		restructureList(numbers);
		createTriangles(numbers);
		
		System.out.println(triangles
			.stream()
			.filter(Triangle::isValid)
			.count());
	}
	
	public void createTriangles(List<Integer> numbers) {
		for(int i = 0; i < numbers.size(); i+=3) {
			triangles.add(new Triangle(numbers.get(i), numbers.get(i+1), numbers.get(i+2)));
		}
	}
	
	public void restructureList(List<Integer> numbers) {
		for(int i = 0; i < numbers.size(); i+=9) {
			swap(numbers, i+1, i+3);
			swap(numbers, i+2, i+6);
			swap(numbers, i+5, i+7);
		}
	}
	
	public void swap(List<Integer> numbers, int pos0, int pos1) {
		int temp = numbers.get(pos0);
		numbers.set(pos0, numbers.get(pos1));
		numbers.set(pos1, temp);
	}

	class Triangle {
		private final List<Integer> sides;

		public Triangle(int side0, int side1, int side2) {
			sides = new ArrayList<>();
			sides.add(side0);
			sides.add(side1);
			sides.add(side2);
			Collections.sort(sides);
		}

		public boolean isValid() {
			return sides.get(0) + sides.get(1) > sides.get(2);
		}
	};

	public static void main(String[] args) throws IOException {
		new Task3();
	}
}
