package com.kaurel.wheelcalendar.task5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Task5 {
	public static int parseRomanNumeral(String numeral) {
	        if (numeral == null || numeral.equals("")) return 0;
	        if (numeral.startsWith("M")) return 1000 + parseRomanNumeral(numeral.substring(1));
	        if (numeral.startsWith("CM")) return 900 + parseRomanNumeral(numeral.substring(2));
	        if (numeral.startsWith("D")) return 500 + parseRomanNumeral(numeral.substring(1));
	        if (numeral.startsWith("CD")) return 400 + parseRomanNumeral(numeral.substring(2));
	        if (numeral.startsWith("C")) return 100 + parseRomanNumeral(numeral.substring(1));
	        if (numeral.startsWith("XC")) return 90 + parseRomanNumeral(numeral.substring(2));
	        if (numeral.startsWith("L")) return 50 + parseRomanNumeral(numeral.substring(1));
	        if (numeral.startsWith("XL")) return 40 + parseRomanNumeral(numeral.substring(2));
	        if (numeral.startsWith("X")) return 10 + parseRomanNumeral(numeral.substring(1));
	        if (numeral.startsWith("IX")) return 9 + parseRomanNumeral(numeral.substring(2));
	        if (numeral.startsWith("V")) return 5 + parseRomanNumeral(numeral.substring(1));
	        if (numeral.startsWith("IV")) return 4 + parseRomanNumeral(numeral.substring(2));
	        if (numeral.startsWith("I")) return 1 + parseRomanNumeral(numeral.substring(1));
	        return 0;
	}
	
	public static char alphabetIndexToChar(int idx) {
		return (char)((int)'a'+idx-1);
	}
	
	public static void main(String[] args) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get(Task5.class.getResource("input5.txt").getFile())));
		StringTokenizer tk = new StringTokenizer(content);
		List<Integer> numbers = new ArrayList<>();
		while(tk.hasMoreTokens()) {
			numbers.add(parseRomanNumeral(tk.nextToken(", ")));
		}
		
		String message = "";
		for(int i = 0; i < numbers.size()/2; i++) {
			message += alphabetIndexToChar(numbers.get(i) + numbers.get(numbers.size()-1-i));
		}
	
		System.out.println(message);
	}
}
