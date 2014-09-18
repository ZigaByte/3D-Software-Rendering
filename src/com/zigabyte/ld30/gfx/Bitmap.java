
package com.zigabyte.ld30.gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.security.Policy;

import com.zigabyte.ld30.math.Vector2f;


public class Bitmap {

	private BufferedImage image;
	private final Vector2f halfDisplaySize;

	public Bitmap(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		halfDisplaySize = new Vector2f(1, 1);
	}

	public void clear(int color) {
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				image.setRGB(x, y, color);
			}
		}
	}

	public void setPixel(Vector2f pos, int color) {
		pos = pos.add(halfDisplaySize);
		Vector2f screenPos = getScreenPos(pos);
		if (screenPos.x < 0 || screenPos.y < 0 || screenPos.x >= image.getWidth() || screenPos.y >= image.getHeight())
			return;
		image.setRGB((int) screenPos.x, (int) screenPos.y, color);
	}

	private Vector2f getScreenPos(Vector2f pos) {
		return new Vector2f(pos.x * 400, pos.y * 400);
	}

	public BufferedImage getImage() {
		return image;
	}

	public void drawTriangle2D(Vector2f v0, Vector2f v1, Vector2f v2, int color) {
		v0 = getScreenPos(v0.add(halfDisplaySize));
		v1 = getScreenPos(v1.add(halfDisplaySize));
		v2 = getScreenPos(v2.add(halfDisplaySize));
		int x[] = { (int) v0.x, (int) v1.x, (int) v2.x };
		int y[] = { (int) v0.y, (int) v1.y, (int) v2.y };
		Polygon p = new Polygon(x, y, 3);
		Graphics g = image.getGraphics();
		g.setColor(new Color(color));
		g.fillPolygon(p);
	}
}
