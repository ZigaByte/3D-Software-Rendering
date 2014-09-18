
package com.zigabyte.ld30.gfx;

import com.zigabyte.ld30.Game;
import com.zigabyte.ld30.math.Vector2f;
import com.zigabyte.ld30.math.Vector3f;

/** Same as bitmap, just has methods to draw triangles from 3D space by projecting them into 2D */
public class Bitmap3D extends Bitmap {

	// Field of view
	private float fov;
	// Used when projecting vertices on the camera's view. Is constant is fov is constant
	private float tanHalfFov;

	public Bitmap3D(int width, int height, float fov) {
		super(width, height);
		this.fov = fov;
		tanHalfFov = (float) Math.tan(fov / 2);
	}

	/** Draw a certain pixel in 3D on the screen by projecting it's position */
	public void setPixel3D(Vector3f pos, int color) {
		pos = Game.mainCamera.matrix.apply(pos);
		Vector2f pos2D = project3D(pos);
		setPixel(pos2D, color);
	}

	/** Project a 3D point into 2D on the camera's screen */
	private Vector2f project3D(Vector3f pos) {
		float temp = (pos.z * tanHalfFov);
		return new Vector2f(pos.x / temp, pos.y / temp);
	}

	/** Draw a triangle from 3D, first project it into 2D and then draw the 2D */
	public void drawTriangle3D(Vector3f v0, Vector3f v1, Vector3f v2, int color) {
		// project the 3D vectors into 2D and send them into drawTriangle2D method

		//v0 = Game.mainCamera.matrix.apply(v0);
		//v1 = Game.mainCamera.matrix.apply(v1);
		//v2 = Game.mainCamera.matrix.apply(v2);

		v0 = Game.mainCamera.apply(v0);
		v1 = Game.mainCamera.apply(v1);
		v2 = Game.mainCamera.apply(v2);
		v0.print();
		v1.print();
		v2.print();

		if (v0.z < 0 && v1.z < 0 && v2.z < 0)
			return;

		Vector2f p0 = project3D(v0);
		Vector2f p1 = project3D(v1);
		Vector2f p2 = project3D(v2);

		drawTriangle2D(p0, p1, p2, color);
	}

}
