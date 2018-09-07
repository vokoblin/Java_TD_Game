package Game.World.Entity;

import Game.World.Level;
import static Game.Helper.Artist.quickLoadTexture;
import Game.Helper.Clock;
import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 *
 * @author Vovaxs
 */
public class Player {

    private final Level level;
    private final EnemyWave waveManager;
    private final ArrayList<Tower> towers;
    private boolean LMBisDown;

    public Player(Level level, EnemyWave waveManager) {
        this.level = level;
        this.waveManager = waveManager;
        this.towers = new ArrayList<Tower>();
        this.LMBisDown = false;
    }

    public void setTower() {
        if ((int) Math.floor(Mouse.getX() / (level.getBlockSize() * level.getSCALE())) < level.getMapWidth() && (int) Math.floor((level.getFrameHeight() - Mouse.getY() - 1) / (level.getBlockSize() * level.getSCALE())) < level.getMapWidth());
        {
            if (level.getTile((int) Math.floor(Mouse.getX() / (level.getBlockSize() * level.getSCALE())), (int) Math.floor((level.getFrameHeight() - Mouse.getY() - 1) / (level.getBlockSize() * level.getSCALE()))).isBuildable()) {
                towers.add(new Tower(level, quickLoadTexture("cannonBase"), quickLoadTexture("cannonGun"),
                        level.getTile((int) Math.floor(Mouse.getX() / (level.getBlockSize() * level.getSCALE())), (int) Math.floor((level.getFrameHeight() - Mouse.getY() - 1) / (level.getBlockSize() * level.getSCALE()))),
                        10, 200, 1, waveManager));
                level.setUnbuildable((int) Math.floor(Mouse.getX() / (level.getBlockSize() * level.getSCALE())), (int) Math.floor((level.getFrameHeight() - Mouse.getY() - 1) / (level.getBlockSize() * level.getSCALE())));
            }
        }
    }

    public void update() {
        for (Tower t : towers) {
            t.update();
        }

        //Mouse Input hendler
        if (Mouse.isButtonDown(0) && !LMBisDown) {
            setTower();
        }
        LMBisDown = Mouse.isButtonDown(0);
        //Keyboard Input hendler
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
                Clock.changeMultiplier(0.0002f);
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
                Clock.changeMultiplier(-0.0002f);
            }
        }
    }
}
