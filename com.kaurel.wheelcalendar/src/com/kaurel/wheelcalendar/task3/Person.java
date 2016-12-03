package com.kaurel.wheelcalendar.task3;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Person {
	private String name;
	private Set<Person> friends = new HashSet<>();
	private Set<Person> hates = new HashSet<>();
	
	public Person(String name) {
		this.name = name;
	}
	
	public void addFriend(Person friend) {
		friends.add(friend);
	}
	
	public void addHate(Person hate) {
		hates.add(hate);
	}

	public boolean isHating(Person other) {
		return hates.contains(other);
	}

	public Set<Person> getHatedFriends() {
		return friends.stream()
				.filter(this::isHating)
				.filter(p -> !p.isHating(this))
				.collect(Collectors.toSet());
	}
	
	public String getName() {
		return name;
	}
}
