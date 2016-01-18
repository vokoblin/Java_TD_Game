/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import org.lwjgl.opengl.Display;

/**
 *
 * @author Vovaxs
 */
public class Game implements Runnable {

    private boolean isRunning = true;

    @Override
    public void run() {
        GameEngine engine = new GameEngine();
        while (isRunning && !Display.isCloseRequested()) {
            engine.update(2);
            engine.render();
            
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
