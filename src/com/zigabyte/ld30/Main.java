
package com.zigabyte.ld30;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.zigabyte.ld30.gfx.Bitmap3D;


@SuppressWarnings("serial")
public class Main extends Canvas implements Runnable {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;

	private boolean running = false;
	private Thread thread;
	private JFrame frame;

	private Game game;
	private Bitmap3D bitmap;

	public Main() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		game = new Game();

		bitmap = new Bitmap3D(WIDTH, HEIGHT, 70);

		addKeyListener(new Input());
	}


	public void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}


	public void stop() {
		if (!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				updates++;
				delta--;
				update();
			}
			frames++;
			render();
			if (System.currentTimeMillis() - timer > 1000) {
				frame.setTitle("LD30" + "   " + frames + " fps,   " + updates + " ups");
				timer += 1000;
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	private void update() {
		game.update();
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();

		g.fillRect(0, 0, getWidth(), getHeight());
		bitmap.clear(0xff000000);

		game.render(bitmap);

		g.drawImage(bitmap.getImage(), 0, 0, getWidth(), getHeight(), null);

		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.frame = new JFrame();
		main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.frame.setResizable(false);
		main.frame.add(main);
		main.frame.pack();
		main.frame.setTitle("LD30");
		main.frame.setLocationRelativeTo(null);
		main.frame.setVisible(true);

		main.start();
	}

}
