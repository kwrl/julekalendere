package com.kaurel.wheelcalendar.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;

public class Task3 {
	private static Map<String, Person> people = new HashMap<>();
	
	public static Person getOrCreatePerson(String name) {
		if(!people.containsKey(name)) {
			people.put(name, new Person(name));
		}
		return people.get(name);
	}
	
	public static void processLine(String line) {
		StringTokenizer tk = new StringTokenizer(line);
		String t0 = tk.nextToken();
		String t1 = tk.nextToken();
		String t2 = tk.nextToken();
		
		if(t0.equals("friends")) {
			Person p1 = getOrCreatePerson(t1);
			Person p2 = getOrCreatePerson(t2);
			p1.addFriend(p2);
			p2.addFriend(p1);
		} else {
			getOrCreatePerson(t0).addHate(getOrCreatePerson(t2));
		}
	}

	public static void main(String[] args) throws IOException {
		Files
			.lines(Paths.get(Task3.class.getResource("input3.txt").getFile()))
			.forEach(Task3::processLine);
		
		Optional<Person> best = people
			.values()
			.parallelStream()
			.max((p0, p1) -> p0.getHatedFriends().size() - p1.getHatedFriends().size());
		
		System.out.println(best.get().getName());
	}

}
