
package com.zigabyte.ld30;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Input implements KeyListener {

	public static boolean up, down, left, right;
	public static boolean space, shift;

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			up = true;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			down = true;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			left = true;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			right = true;
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			space = true;
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
			shift = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			up = false;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			down = false;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			left = false;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			right = false;
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			space = false;
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
			shift = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
