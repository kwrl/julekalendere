package com.kaurel.wheelcalendar.task4;

public class Task4 {
	public static void main(String[] args) {
		new Task4();
	}

	public Task4() {
		AwesomeGenerator gen = new AwesomeGenerator();
		for (int i = 0; i < 1336000; i++) {
			gen.next();
		}
		System.out.println(gen.next());
	}

	public class AwesomeGenerator {
		private int value = 0;
		private AwesomeGenerator child;

		public Integer next() {
			value++;
			if (value % 7 == 0 || Integer.toString(value).contains("7")) {
				if (child == null) {
					child = new AwesomeGenerator();
				}
				return child.next();
			}
			return value;
		}
	}

}
