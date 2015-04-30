/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gfx;

/**
 *
 * @author Vovaxs
 */

import AI.WaveManager;
import Entities.Enemy;
import Entities.Level;
import Entities.Player;
import Entities.Tower;
import static Gfx.Artist.quickLoadTexture;

import java.awt.Font;

import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;

public class Screen {
	Font font = new Font("Times New Roman", Font.BOLD, 24);

	public static boolean isFirst = true;

	public static Level level;

	public static int mWidth;
	public static int mHeight;

	public int levelWidth = 30;
	public int levelHeight = 30;
	public int blockSize = 32;

	// /tests:
	public Enemy enemy;
	private WaveManager waveManager;
	private Player player;
	private Tower tower;

	int[][] map = { { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 1, 1, 1, 0, 1, 1, 1 }, { 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 },
			{ 0, 1, 1, 1, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public Screen() {
		level = new Level(map);
		// setBackground(Color.BLACK);
		// drawScene();
		enemy = new Enemy(quickLoadTexture("enemy"), level.getTile(0, 0),
				level, 32, 32, 2, 50);
		waveManager = new WaveManager(enemy, 2, 2);
		player = new Player(level);
		tower = new Tower(this, quickLoadTexture("cannonBase"),
				quickLoadTexture("cannonGun"), level.getTile(4, 4), 10, 5, 0.5f);
		tower.addAttSpeed(0.2f);
	}

	public void drawScene() {        
		if (isFirst) {
			mWidth = Display.getWidth();
			mHeight = Display.getHeight();

			// if running for the first time than define everything
			define();

			// ser isFirst to false;
			isFirst = false;
		}
		// g.clearRect(0, 0, getWidth(), getHeight());
		// drawQuad(150, 150, blockSize, blockSize);
		// drawLine(10, 10, 100, 100);
		// enemy.update();
		// clean();

		level.draw();
		waveManager.update();
		player.update();
		tower.update();

		// enemy.draw();
		// wave.update();

	}

	public void clean() {
		// Clear The Screen And The Depth Buffer
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		// R,G,B,A Set The Color To Blue One Time Only
		glColor3f(0.5f, 0.5f, 1.0f);
	}

	public void Rander() {

	}

	private void define() {
		// level = new Level();
	}

}
