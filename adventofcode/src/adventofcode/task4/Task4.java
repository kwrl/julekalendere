package adventofcode.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task4 {
	public Task4() throws IOException {
		Files.lines(Paths.get(getClass().getResource("input4.txt").getFile()))
			.map(e -> new EncryptedRoom(e))
			.filter(e -> e.getDecryptedName().equals("northpole object storage"))
			.forEach(e -> System.out.println(e.getSectorID()));
	}
	
	
	public static void main(String[] args) throws IOException {
		new Task4();
	}
	
	class EncryptedRoom {
		private final String content; 
		private final String name, checksum;
		private final int sectorID;
		
		public EncryptedRoom(String content) {
			this.content = content;
			this.checksum = getChecksum(content);
			this.sectorID = getSectorID(content);
			this.name = getName(content);
		}
		
		private String getName(String str) {
			int stop = str.indexOf("[") - 4;
			return str.substring(0, stop);
		}
		
		private String getChecksum(String str) {
			int start = str.indexOf("[") +1;
			int stop = str.length()-1;
			return str.substring(start, stop);
		}
		
		private int getSectorID(String str) {
			int stop = str.indexOf("[");
			int start = stop -3; 
			return Integer.parseInt(str.substring(start, stop));
		}
		
		private String createChecksum(String str) {
			String candidate = str.replace("-", "");
			Map<Character, Integer> occurrences = new HashMap<>();
			for(char c : candidate.toCharArray()) {
				if(!occurrences.containsKey(c)) {
					occurrences.put(c, 0);
				}
				occurrences.put(c, occurrences.get(c)+1);
			}
			
			List<Character> chars = occurrences.entrySet().stream()
				.sorted((e0, e1) -> {
					int lengthCompare = e1.getValue() - e0.getValue();
					if(lengthCompare!=0) {
						return lengthCompare;
					}
					return e0.getKey() - e1.getKey();
				})
				.map(e->e.getKey())
				.collect(Collectors.toList());
			String checksum = "";
			for(int i = 0; i < 5; i++) {
				checksum += chars.get(i);
			}
			
			return checksum;
		}
		
		public String getDecryptedName() {
			String encrypted = name;
			for(int i = 0; i < getSectorID(); i++) {
				encrypted = rotate(encrypted);
			}
			return encrypted;
		}
		
		private String rotate(String str) {
			String newString = "";
			for(Character c : str.toCharArray()) {
				if(c == 'z') {
					newString+='a';
					continue;
				} 
				if(c == '-') {
					newString+=' ';
					continue;
				}
				if(c == ' ') {
					newString += ' ';
					continue;
				}
				newString += (char)((int)c+1);
			}
			
			return newString;
		}
		
		public boolean isValid() {
			return createChecksum(name).equals(checksum);
		}
		
		public int getSectorID() {
			return sectorID; 
		}
	}
}
