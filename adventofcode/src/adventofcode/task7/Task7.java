package adventofcode.task7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Task7 {
	public static boolean hasABBA(String str) {
		for(int i = 0; i < str.length()-3; i++) {
			if(isABBA(str.substring(i, i+4))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isABBA(String str) {
		if(str.length() != 4) {
			return false;
		}
		return str.charAt(3) == str.charAt(0) &&
								str.charAt(2) == str.charAt(1) &&
								str.charAt(3) != str.charAt(2);
	}
	
	public static boolean supportsTLS(String str) {
		StringTokenizer tk = new StringTokenizer(str,"[]");
		boolean hypernet = false;
		boolean hasABBA = false;
		while(tk.hasMoreTokens()) {
			boolean abba = hasABBA(tk.nextToken());
			if(abba) { 
				if(hypernet) {
					return false;
				}
				hasABBA = true;
			}
			hypernet = !hypernet;
		}
		return hasABBA;
	}
	
	public static List<String> getABAs(String str) {
		List<String> abas = new ArrayList<>();
		for(int i = 0; i < str.length()-2; i++) {
			if(str.charAt(i) != str.charAt(i+1) && str.charAt(i) == str.charAt(i+2)) {
				abas.add(str.substring(i, i+3));
			}
		}
		return abas;
	}
	
	public static boolean supportsSSL(String str) {
		List<String> hypernetSequences = new ArrayList<String>();
		List<String> supernetSequences = new ArrayList<String>();
		StringTokenizer tk = new StringTokenizer(str, "[]");
		boolean supernet = true;
		while(tk.hasMoreTokens()) {
			if(supernet) {
				supernetSequences.add(tk.nextToken());
			} else {
				hypernetSequences.add(tk.nextToken());
			}
			supernet = ! supernet;
		}
		List<String> abas = supernetSequences
								.stream()
								.flatMap(s -> getABAs(s).stream())
								.collect(Collectors.toList());
		for(String aba : abas) {
			for(String hypernet : hypernetSequences) {
				String bab = "";
				bab += aba.charAt(1);
				bab += aba.charAt(0);
				bab += aba.charAt(1);
				if(hypernet.contains(bab)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		long count = Files.lines(Paths.get(Task7.class.getResource("input7.txt").getFile()))
			.filter(Task7::supportsSSL)
			.count();
		System.out.println(count);
	}
}
 