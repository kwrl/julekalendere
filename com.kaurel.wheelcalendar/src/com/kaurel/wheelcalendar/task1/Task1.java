package com.kaurel.wheelcalendar.task1;

public class Task1 {
	public static int shuffled(int num) {
		String orig = ""+num;
		return Integer.parseInt(orig.charAt(orig.length()-1) + orig.substring(0, orig.length()-1));
	}
	
	public static boolean endWithSix(int num) {
		String snum = ""+num;
		return snum.charAt(snum.length()-1)=='6';
	}
	public static void main(String[] args) {
		
		for(int i = 1; i < 1000000000; i++) {
			if(endWithSix(i) && ((double)shuffled(i))/i==4.0) {
				System.out.println(i);
			}
		}
	}
}
