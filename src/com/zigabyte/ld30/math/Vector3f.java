
package com.zigabyte.ld30.math;


public class Vector3f {

	public float x;
	public float y;
	public float z;


	public Vector3f() {
		this(0, 0, 0);
	}

	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float length() {
		return (float) Math.sqrt(x * x + y * y + z * z);
	}

	public Vector3f add(Vector3f other) {
		return new Vector3f(x + other.x, y + other.y, z + other.z);
	}

	public Vector3f sub(Vector3f other) {
		return new Vector3f(x - other.x, y - other.y, z - other.z);
	}

	public void print() {
		System.out.println("Vector3f: " + x + ", " + y + ", " + z);
	}

}
