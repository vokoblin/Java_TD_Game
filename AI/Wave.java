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
        private int enemiesPerWave;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
        private boolean allEnemiesDead;

	public Wave(Enemy enemyType, float spawnTime, int enemiesPerWave) {
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
                this.enemiesPerWave = enemiesPerWave;
		this.timeSinceLastSpawn = 0;
		this.enemyList = new ArrayList<Enemy>();
                this.allEnemiesDead = false;
                
                spawn();
	}

	public void update() {
            allEnemiesDead = true;
            if(enemyList.size() < enemiesPerWave){
                timeSinceLastSpawn += Delta();
                if (timeSinceLastSpawn > spawnTime) {
                        spawn();
                        timeSinceLastSpawn = 0;
                }
            }
            for (Enemy e : enemyList) {
		if (e.isAlive()) {
                    allEnemiesDead = false;
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
        
        public boolean getAllEnemiesDead(){
            return allEnemiesDead;
        }
}
