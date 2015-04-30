/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import Entities.Enemy;

/**
 *
 * @author Vovaxs
 */
public class WaveManager {
    
    private float timeSinceLastWave;
    private float timeBetweenEnemies;
    private int waveNumber;
    private int enemiesPerWave;
    private Enemy enemyType;
    private Wave currentWave;
    
    public WaveManager(Enemy enemyType, float timeBetweenEnemies, int enemiesPerWave){
        this.enemyType = enemyType;
        this.enemiesPerWave = enemiesPerWave;
        this.timeBetweenEnemies = timeBetweenEnemies;
        this.timeSinceLastWave = 0;
        this.waveNumber = 0;
        
        this.currentWave = null;
        
        newWave();
    }
    
    public void update(){
        if(!currentWave.getAllEnemiesDead()){
            currentWave.update();
        }
        else{
            newWave();
        }
    }
    
    public void newWave(){
        waveNumber++;
        currentWave = new Wave(enemyType, timeBetweenEnemies, enemiesPerWave + waveNumber);
        System.out.println("Wave #"+waveNumber);
    }
}
