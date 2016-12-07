package adventofcode.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task6 {
	private List<String> lines = new ArrayList<>();
	
	private String mostOccurringInColumn(int column) {
		Map<Character, Integer> occurrences = new HashMap<>();
		
		for(String line : lines) {
			char c = line.charAt(column);
			if(occurrences.containsKey(c)) {
				occurrences.replace(c, occurrences.get(c)+1);
			} else {
				occurrences.put(c, 1);
			}
		}
		
		return ""+occurrences
			.entrySet()
			.stream()
			.max((e0, e1) -> e0.getValue() - e1.getValue())
			.get().getKey();
	}
	
	private String leastOccurringInColumn(int column) {
		Map<Character, Integer> occurrences = new HashMap<>();
		
		for(String line : lines) {
			char c = line.charAt(column);
			if(occurrences.containsKey(c)) {
				occurrences.replace(c, occurrences.get(c)+1);
			} else {
				occurrences.put(c, 1);
			}
		}
		
		return ""+occurrences
			.entrySet()
			.stream()
			.min((e0, e1) -> e0.getValue() - e1.getValue())
			.get().getKey();

	}
	
	private String getProfileString() {
		int width = lines.get(0).length();
		String profile = "";
		for(int i = 0; i < width; i++) {
			profile += leastOccurringInColumn(i);
		}
		return profile;
	}
	

	public Task6() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(getClass().getResource("input6.txt").getFile()));
		
		String line; 
		while((line=reader.readLine())!=null) {
			lines.add(line);
		}
		System.out.println(getProfileString());
	}
	
	public static void main(String[] args) throws IOException {
		new Task6();
	}
}
