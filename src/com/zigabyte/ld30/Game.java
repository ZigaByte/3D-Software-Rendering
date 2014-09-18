
package com.zigabyte.ld30;

import java.util.ArrayList;
import java.util.Random;

import com.zigabyte.ld30.gfx.Bitmap3D;
import com.zigabyte.ld30.gfx.Camera;
import com.zigabyte.ld30.gfx.Triangle;
import com.zigabyte.ld30.math.Vector3f;


public class Game {

	private final Random random = new Random();
	private ArrayList<Vector3f> stars = new ArrayList<Vector3f>();

	// Temporary testing triangles that are drawn in the render method
	private Triangle triange1;
	private Triangle triange2;
	private Triangle triange3;
	private Triangle triange4;
	private Triangle triange5;
	private Triangle triange6;

	public static Camera mainCamera;

	/** Initialize the game and the camera */
	public Game() {
		mainCamera = new Camera();

		for (int i = 0; i < 4096; i++) {
			stars.add(new Vector3f(random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1, random.nextFloat() * 5));
		}
		triange1 = new Triangle(new Vector3f(-1, 1, 7), new Vector3f(1, 1, 7), new Vector3f(-1, 1, 5), 0xffffff00);
		triange2 = new Triangle(new Vector3f(1, 1, 5), new Vector3f(1, 1, 7), new Vector3f(-1, 1, 5), 0xffffff00);
		triange3 = new Triangle(new Vector3f(-1, -1, 5), new Vector3f(1, -1, 5), new Vector3f(-1, 1, 5), 0xffff0000);
		triange4 = new Triangle(new Vector3f(1, 1, 5), new Vector3f(1, -1, 5), new Vector3f(-1, 1, 5), 0xffff0000);
		triange5 = new Triangle(new Vector3f(1, 1, 7), new Vector3f(1, -1, 7), new Vector3f(1, 1, 5), 0xff0000ff);
		triange6 = new Triangle(new Vector3f(1, -1, 7), new Vector3f(1, -1, 5), new Vector3f(1, 1, 5), 0xff0000ff);
	}

	/** Update the game */
	public void update() {
		mainCamera.update();

		// Ignore if you are looking at triangles
		for (int i = 0; i < stars.size(); i++) {
			stars.get(i).z += -0.01;
			if (stars.get(i).z < 0) {
				stars.remove(i);
				stars.add(new Vector3f(random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1, random.nextFloat() * 5));
			}

		}

	}

	/** Render the game */
	public void render(Bitmap3D g) {
		// Uncomment the code below for a cool effect
		for (int i = 0; i < stars.size(); i++) {
			g.setPixel3D(stars.get(i), 0xffffffff);
		}

		triange1.render(g);
		triange2.render(g);
		triange3.render(g);
		triange4.render(g);
		triange5.render(g);
		triange6.render(g);
	}
}
