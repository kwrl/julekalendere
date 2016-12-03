package adventofcode.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Vec2Test {

	@Test 
	public void testNorth() {
		assertEquals(Vec2.getNorth().left(), Vec2.getWest());
		assertEquals(Vec2.getNorth().right(), Vec2.getEast());
	}

	@Test
	public void testSouth() {
		assertEquals(Vec2.getSouth().left(), Vec2.getEast());
		assertEquals(Vec2.getSouth().right(), Vec2.getWest());
	}

	@Test
	public void testEast() {
		assertEquals(Vec2.getEast().left(), Vec2.getNorth());
		assertEquals(Vec2.getEast().right(), Vec2.getSouth());
	}
	
	@Test
	public void testWest() {
		assertEquals(Vec2.getWest().left(), Vec2.getSouth());
		assertEquals(Vec2.getWest().right(), Vec2.getNorth());
	}
	
	
}
