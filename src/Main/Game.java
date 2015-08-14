package Main;

import static Gfx.Artist.drawCircle;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glColor4f;
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
	public void run() { //TODO: cange everything using MVC structure!
		Frame frame = new Frame(this);
		
		// R,G,B,A Set The Color To Black One Time Only
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

		/** Game start */
		isRunning = true;
		while (isRunning && !Display.isCloseRequested()) {
			clean();
			
			Clock.update();
			
			
			// System.out.println("mouse y :" + Mouse.getY());
			// System.out.println("mouse x :" + Mouse.getX());
			StateManager.update(frame);

			Display.setTitle("FPS: " + Clock.FPS());
			drawCircle(6 * 32 + 16, 6 * 32 + 16, 48);
			Display.update();
			Display.sync(60);
		}

		Display.destroy();
		System.exit(0);

	}
	
	public void clean() {
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
