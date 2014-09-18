
package com.zigabyte.ld30.gfx;

import com.zigabyte.ld30.math.Vector3f;

/** A set of 3 vertices and a color */
public class Triangle {

	private Vector3f v0;
	private Vector3f v1;
	private Vector3f v2;

	private int color;

	public Triangle(Vector3f v0, Vector3f v1, Vector3f v2) {
		this(v0, v1, v2, 0xffffffff);
	}

	public Triangle(Vector3f v0, Vector3f v1, Vector3f v2, int color) {
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
		this.color = color;
	}

	public void render(Bitmap3D g) {
		g.drawTriangle3D(v0, v1, v2, color);
	}


	public Vector3f getV0() {
		return v0;
	}

	public void setV0(Vector3f v0) {
		this.v0 = v0;
	}

	public Vector3f getV1() {
		return v1;
	}

	public void setV1(Vector3f v1) {
		this.v1 = v1;
	}

	public Vector3f getV2() {
		return v2;
	}

	public void setV2(Vector3f v2) {
		this.v2 = v2;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}


}
