package Game;

import org.lwjgl.opengl.Display;
import Game.Helper.Clock;

/**
 *
 * @author Vovaxs
 */
public class Loop implements Runnable {

    private boolean isRunning = true;

    @Override
    public void run() {
        Game game = new Game();
        while (isRunning && !Display.isCloseRequested()) { 
            Clock.update();
            game.update(Clock.Delta());
            game.render();
            
            Display.update();
            Display.sync(60);
        }
        this.destroy();
    }

    private void destroy() {
        Display.destroy();
        System.exit(0);
    }

    public void quitGame() {
        isRunning = false;
    }
}
