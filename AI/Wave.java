/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import Entities.Enemy;
import java.util.ArrayList;
import static Main.Clock.*;

/**
 *
 * @author Vovaxs
 */
public class Wave {

	private float timeSinceLastSpawn;
	private float spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;

	public Wave(float spawnTime, Enemy enemyType) {
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
		timeSinceLastSpawn = 0;
		enemyList = new ArrayList<Enemy>();
	}

	public void update() {
		timeSinceLastSpawn += Delta();
		if (timeSinceLastSpawn > spawnTime) {
			spawn();
			timeSinceLastSpawn = 0;
		}

		for (Enemy e : enemyList) {
			if (e.isAlive()) {
				e.draw();
				e.update();
			}
		}
	}

	private void spawn() {
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType
				.getStartTile(), enemyType.getLevel(), enemyType.getWidth(),
				enemyType.getHeight(), enemyType.getHealth(), enemyType
						.getSpeed()));
	}
}
