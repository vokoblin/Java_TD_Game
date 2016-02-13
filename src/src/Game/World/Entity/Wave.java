package src.Game.World.Entity;

import java.util.ArrayList;
import static src.Game.Helper.Clock.*;

/**
 *
 * @author Vovaxs
 */
public class Wave {

    private float timeSinceLastSpawn;
    private final float spawnTime;
    private final int enemiesPerWave;
    private final Enemy enemyType;
    private final ArrayList<Enemy> enemyList;
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

        if (enemyList.size() < enemiesPerWave) {
            timeSinceLastSpawn += Delta();
            if (timeSinceLastSpawn > spawnTime) {
                spawn();
                timeSinceLastSpawn = 0;
            }
        } else {
            allEnemiesDead = true;
        }
        for (Enemy e : enemyList) {
            if (e.isAlive()) {
                allEnemiesDead = false;
                e.draw();
                e.update();
            } else {
                e = null;
            }
        }
    }

    private void spawn() {
        enemyList.add(new Enemy(enemyType.getTexture(), enemyType
                .getStartTile(), enemyType.getLevel(), enemyType.getWidth(),
                enemyType.getHeight(), enemyType.getHealth(), enemyType
                .getSpeed()));
    }

    public boolean getAllEnemiesDead() {
        return allEnemiesDead;
    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }
}
