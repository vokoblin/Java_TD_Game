package Main;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import Gfx.Frame;
import Gfx.Screen;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vovaxs
 */

public final class Game implements Runnable {
	/** main game status flag */
	boolean isRunning = false;

	public Game() {
		run();
	}

	@Override
	public void run() {
		Frame frame = new Frame(this);

		/** Game start */
		isRunning = true;
		while (isRunning && !Display.isCloseRequested()) {
			
			
			Clock.update();

			// System.out.println("mouse y :" + Mouse.getY());
			// System.out.println("mouse x :" + Mouse.getX());
			StateManager.update(frame);

			Display.setTitle("FPS: " + Clock.FPS());
			Display.update();
			Display.sync(60);
			
			clean();
		}

		Display.destroy();
		System.exit(0);

	}
	
	public void clean() {
		// R,G,B,A Set The Color To Blue One Time Only
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		// Clear The Screen And The Depth Buffer
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}

	public static void main(String args[]) {

		Game game = new Game();

	}

	/** Stopping that main game loop */
	public void stopGame() {
		if (isRunning) {
			isRunning = false;
		}
	}

	// /////////////////FPS///////////////////

}
