package src.Game.State;

import src.Game.World.Entity.EnemyWave;
import src.Game.World.Entity.Enemy;
import src.Game.World.Entity.Player;
import src.Game.Frame;
import static src.Game.Helper.Artist.quickLoadTexture;
import static src.Game.Manager.MapManager.loadMap;
import src.Game.World.Level;

/**
 *
 * @author Vovaxs
 */
public class InGameState implements State {

    private Level level;
    private EnemyWave waveManager;
    private Player player;
    
    private boolean initialized = false;
    
    @Override
    public void init(Frame frame) {
        this.level = this.levelInit();
        this.initialized = true;
    }

    @Override
    public void update() {
        this.level.draw();
        this.waveManager.update();
        this.player.update();
    }

    @Override
    public boolean isInitialized() {
        return this.initialized;
    }
    
    private Level levelInit(){
        Level currentlevel = loadMap("Map01");
        Enemy currentEnemy = new Enemy(quickLoadTexture("enemy"), currentlevel.getTile(0, 1),
                currentlevel, 32, 32, 100, 50);
        this.waveManager = new EnemyWave(currentEnemy, 2, 2);
        this.player = new Player(currentlevel, waveManager);
        return currentlevel;
    }
    
}
