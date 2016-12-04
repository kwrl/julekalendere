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
		private final String name, checksum;
		private final int sectorID;
		
		public EncryptedRoom(String content) {
			this.checksum = parseChecksum(content);
			this.sectorID = parseSectorID(content);
			this.name = parseName(content);
		}
		
		private String parseName(String str) {
			int stop = str.indexOf("[") - 4;
			return str.substring(0, stop);
		}
		
		private String parseChecksum(String str) {
			int start = str.indexOf("[") +1;
			int stop = str.length()-1;
			return str.substring(start, stop);
		}
		
		private int parseSectorID(String str) {
			int stop = str.indexOf("[");
			int start = stop -3; 
			return Integer.parseInt(str.substring(start, stop));
		}
		
		private String generateChecksum(String str) {
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
			String decrypted = name;
			for(int i = 0; i < getSectorID(); i++) {
				decrypted = rotate(decrypted);
			}
			return decrypted;
		}
		
		private String rotate(String str) {
			String newString = "";
			for(Character c : str.toCharArray()) {
				if(c == 'z') {
					newString+='a';
					continue;
				} 
				if(c == '-') {
					newString += ' ';
					continue;
				}
				newString += (char)((int)c+1);
			}
			
			return newString;
		}
		
		public boolean isValid() {
			return generateChecksum(name).equals(checksum);
		}
		
		public int getSectorID() {
			return sectorID; 
		}
	}
}
