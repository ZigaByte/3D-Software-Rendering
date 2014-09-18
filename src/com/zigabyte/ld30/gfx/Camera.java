
package com.zigabyte.ld30.gfx;

import com.zigabyte.ld30.Input;
import com.zigabyte.ld30.math.Matrix4f;
import com.zigabyte.ld30.math.Vector3f;


public class Camera {

	public Matrix4f matrix = Matrix4f.identity();

	private Vector3f position;
	private Vector3f rotation;

	public Camera() {
		//matrix.translate(new Vector3f(-5, -5, 0));
		position = new Vector3f();
		rotation = new Vector3f();
	}

	public void update() {
		//matrix.print();

		float rotationSpeed = 1f;
		float moveSpeed = 0.1f;

		if (Input.left) {
			rotation.y += rotationSpeed;
		}
		if (Input.right) {
			rotation.y -= rotationSpeed;
		}

		if (Input.space) {
			//position.y += moveSpeed;
			position = position.add(new Vector3f(1, 0, 0));
		}
		if (Input.shift) {
			//position.y -= moveSpeed;
			position = position.add(new Vector3f(-1, 0, 0));
		}

		if (Input.up) {
			position = position.add(new Vector3f(0, 0, 1));
		}
		if (Input.down) {
			position = position.add(new Vector3f(0, 0, -1));
		}

		matrix = Matrix4f.identity();
		//matrix = matrix.rotate(rotation.x, 1, 0, 0);
		matrix = matrix.rotate(rotation.y, 0, 1, 0);
		//matrix = matrix.rotate(rotation.z, 0, 0, 1);
		matrix = matrix.translate(position);

		System.out.println(rotation.y);
		//System.out.println(position.toString());

		//matrix.print();

		//matrix.translate(new Vector3f(dx, 0, dz));
		//matrix.translate(new Vector3f(dx, 0, dz));
		//matrix.rotate(rotationY, 0, 1, 0);
		//System.out.println(rotationY);
	}

	public Vector3f apply(Vector3f vector) {
		Vector3f v = vector.sub(position);
		float cos = (float) Math.cos(Math.toRadians(rotation.y));
		float sin = (float) Math.sin(Math.toRadians(rotation.y));
		v.x = cos * v.x + sin * v.z;
		v.y = v.y;
		v.z = -sin * v.x + cos * v.z;


		return v;
	}
}
