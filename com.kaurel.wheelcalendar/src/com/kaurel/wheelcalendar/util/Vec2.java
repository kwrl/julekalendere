package com.kaurel.wheelcalendar.util;

public class Vec2 {
	private int x, y;
	
	public Vec2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Vec2 scale(int length) {
		x *= length;
		y *= length;
		return this;
	}
	
	public Vec2 add(Vec2 other) {
		x += other.getX();
		y += other.getY();
		return this;
	}
	
	public Vec2 sub(Vec2 other) {
		x -= other.getX();
		y -= other.getY();
		return this;
	}

	public Vec2 left() {
		int temp = getX();
		x = -getY(); 
		y = temp;
		return this;
	}
	
	public Vec2 right() {
		int temp = getX();
		x = getY();
		y = -temp;
		return this;
	}
	
	public Vec2 clone() {
		return new Vec2(getX(), getY());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if(!(obj instanceof Vec2)) {
			return false;
		}
		
		Vec2 vec2 = (Vec2) obj;
		
		return getX()==vec2.getX() && getY()==vec2.getY();
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(x)*31 + Integer.hashCode(y);
	}

	@Override
	public String toString() {
		return "("+getX() + ", " + getY()+")";
	}

	public static Vec2 getNorth() {
		return new Vec2(0, 1);
	}

	public static Vec2 getSouth() {
		return new Vec2(0, -1);
	}

	public static Vec2 getEast() {
		return new Vec2(1, 0);
	}

	public static Vec2 getWest() {
		return new Vec2(-1, 0);
	}
}