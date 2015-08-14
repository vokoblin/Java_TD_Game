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
import static Gfx.Artist.quickLoadTexture;
import static LevelEditor.Cartographer.loadMap;

import java.awt.Font;

import org.lwjgl.opengl.Display;

public class Screen {
	Font font = new Font("Times New Roman", Font.BOLD, 24);

	public static boolean isFirst = true;

	private static Level level;

	public static int mWidth;
	public static int mHeight;

	public int levelWidth = 26;
	public int levelHeight = 19;
	public int blockSize = 32;
	
	// /tests:
	public Enemy enemy;
	public WaveManager waveManager;
	private Player player;

	public Screen() {
		setLevel(new Level());
		setLevel(loadMap("Map01"));
		// setBackground(Color.BLACK);
		// drawScene();
		enemy = new Enemy(quickLoadTexture("enemy"), getLevel().getTile(0, 1),
				getLevel(), 32, 32, 100, 50);
		waveManager = new WaveManager(enemy, 2, 2);
		player = new Player(this, waveManager);
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

		getLevel().draw();
		waveManager.update();
		player.update();

		// enemy.draw();
		// wave.update();
	}

	public void Rander() {

	}

	private void define() {
		// level = new Level();
	}

	public static Level getLevel() {
		return level;
	}

	public static void setLevel(Level level) {
		Screen.level = level;
	}

}