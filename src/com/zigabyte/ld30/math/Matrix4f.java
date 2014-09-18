
package com.zigabyte.ld30.math;


public class Matrix4f {

	private float[] matrix = new float[4 * 4];

	public static Matrix4f identity() {
		Matrix4f m = new Matrix4f();
		m.matrix[0 + 0 * 4] = 1;
		m.matrix[1 + 1 * 4] = 1;
		m.matrix[2 + 2 * 4] = 1;
		m.matrix[3 + 3 * 4] = 1;

		return m;
	}

	public Matrix4f translate(Vector3f v) {
		matrix[0 + 3 * 4] += v.x;
		matrix[1 + 3 * 4] += v.y;
		matrix[2 + 3 * 4] += v.z;
		return this;
	}

	public Matrix4f rotate(float angle, float x, float y, float z) {
		float r = (float) Math.toRadians(angle);
		float cos = (float) Math.cos(r);
		float sin = (float) Math.sin(r);
		float omc = 1.0f - cos;

		matrix[0 + 0 * 4] = x * x * omc + cos;
		matrix[1 + 0 * 4] = x * y * omc - z * sin;
		matrix[2 + 0 * 4] = x * z * omc + y * sin;

		matrix[0 + 1 * 4] = x * y * omc + z * sin;
		matrix[1 + 1 * 4] = y * y * omc + cos;
		matrix[2 + 1 * 4] = y * z * omc - x * sin;

		matrix[0 + 2 * 4] = x * z * omc - y * sin;
		matrix[1 + 2 * 4] = y * z * omc + x * sin;
		matrix[2 + 2 * 4] = z * z * omc + cos;

		/*
		matrix[0 + 0 * 4] = x * omc + cos;
		matrix[1 + 0 * 4] = x * y * omc + z * sin;
		matrix[2 + 0 * 4] = x * z * omc - y * sin;

		matrix[0 + 1 * 4] = x * y * omc - z * sin;
		matrix[1 + 1 * 4] = y * omc + cos;
		matrix[2 + 1 * 4] = y * z * omc + x * sin;

		matrix[0 + 2 * 4] = x * z * omc + y * sin;
		matrix[1 + 2 * 4] = y * z * omc - x * sin;
		matrix[2 + 2 * 4] = z * omc + cos;
		*/


		return this;
	}

	public Vector3f apply(Vector3f v) {
		Vector3f result = new Vector3f();

		//result.x = matrix[0 + 0 * 4] * v.x + matrix[0 + 1 * 4] * v.y + matrix[0 + 2 * 4] * v.z;
		//result.y = matrix[1 + 0 * 4] * v.x + matrix[1 + 1 * 4] * v.y + matrix[1 + 2 * 4] * v.z;
		//result.z = matrix[2 + 0 * 4] * v.x + matrix[2 + 1 * 4] * v.y + matrix[2 + 2 * 4] * v.z;
		Vector3f sub = new Vector3f(-matrix[0 + 3 * 4], -matrix[1 + 3 * 4], -matrix[2 + 3 * 4]);
		result = v.add(sub);
		
		//result.x -= matrix[0 + 3 * 4];
		//result.y -= matrix[1 + 3 * 4];
		//result.z -= matrix[2 + 3 * 4];
		
		//result.x = matrix[0 + 0 * 4] * v.x + matrix[1 + 0 * 4] * v.y + matrix[2 + 0 * 4] * v.z;
		//result.y = matrix[0 + 1 * 4] * v.x + matrix[1 + 1 * 4] * v.y + matrix[2 + 1 * 4] * v.z;
		//result.z = matrix[0 + 2 * 4] * v.x + matrix[1 + 2 * 4] * v.y + matrix[2 + 2 * 4] * v.z;
		
		result.x = matrix[0 + 0 * 4] * result.x + matrix[1 + 0 * 4] * result.y + matrix[2 + 0 * 4] * result.z;
		result.y = matrix[0 + 1 * 4] * result.x + matrix[1 + 1 * 4] * result.y + matrix[2 + 1 * 4] * result.z;
		result.z = matrix[0 + 2 * 4] * result.x + matrix[1 + 2 * 4] * result.y + matrix[2 + 2 * 4] * result.z;


		return result;
	}

	public void print() {
		System.out.println("-----------------------");

		for (int j = 0; j < 4; j++) {
			System.out.println(matrix[0 + j * 4] + ", " + matrix[1 + j * 4] + ", " + matrix[2 + j * 4] + ", " + matrix[3 + j * 4]);
		}
	}
}
