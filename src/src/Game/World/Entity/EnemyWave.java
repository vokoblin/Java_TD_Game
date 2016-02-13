package src.Game.World.Entity;

/**
 *
 * @author Vovaxs
 */
public class EnemyWave {

    private final float timeSinceLastWave;
    private final float timeBetweenEnemies;
    private int waveNumber;
    private final int enemiesPerWave;
    private final Enemy enemyType;
    private Wave currentWave;

    public EnemyWave(Enemy enemyType, float timeBetweenEnemies, int enemiesPerWave) {
        this.enemyType = enemyType;
        this.enemiesPerWave = enemiesPerWave;
        this.timeBetweenEnemies = timeBetweenEnemies;
        this.timeSinceLastWave = 0;
        this.waveNumber = 0;

        this.currentWave = null;

        newWave();
    }

    public void update() {
        if (!currentWave.getAllEnemiesDead()) {
            currentWave.update();
        } else {
            newWave();
        }
    }

    public final void newWave() {
        waveNumber++;
        currentWave = new Wave(enemyType, timeBetweenEnemies, enemiesPerWave + waveNumber);
        System.out.println("Wave #" + waveNumber);
    }

    public Wave getCurrentWave() {
        return currentWave;
    }
}
