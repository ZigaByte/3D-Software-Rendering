
package com.zigabyte.ld30.math;


public class Vector2f {

	public float x;
	public float y;

	public Vector2f() {
		this(0, 0);
	}

	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float length() {
		return (float) Math.sqrt(x * x + y * y);
	}

	public Vector2f add(Vector2f other) {
		return new Vector2f(x + other.x, y + other.y);
	}
}
