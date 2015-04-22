package Main;

import Gfx.Frame;
import Gfx.Screen;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vovaxs
 */

public final class Game implements Runnable
{
    /** main game status flag */
    boolean isRunning = false;
    
    /** time at last frame */
    long lastFrame;
     
    /** frames per second */
    int fps;
    
    /** last fps time */
    long lastFPS;

    /** position of quad */
    float x = 400, y = 300;
    
    public Game()
    {
        run();
    }
    
    @Override
    public void run()
    {
        Frame frame = new Frame(this);
        
        /** Game start */
        isRunning = true;
        
        getDelta(); // call once before loop to initialise lastFrame
        lastFPS = getTime(); // call before loop to initialise fps timer
        while(isRunning && !Display.isCloseRequested()){
            int delta = getDelta();
            if(!Screen.isFirst)
            {
               // Frame.screen.level.physics();
            }
            
            
            frame.screen.drawScene();
            //frame.screen.level.draw();
            
            updateFPS(); // update FPS Counter
            Display.update();
            Display.sync(60);
        }
        
        Display.destroy();
        System.exit(0);
        
    }
    
    public static void main(String args[]) 
    {
        
        Game game = new Game();
        
    }
    
    /** Stopping that main game loop */
    public void stopGame()
    {
        if(isRunning){
            isRunning = false;
        }
    }
    
    ///////////////////Timer///////////////////
    public long getTime() 
    {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }
    
     public int getDelta() 
     {
        long time = getTime();
        int delta = (int) (time - lastFrame);
        lastFrame = time;
      
        return delta;
    }
     
    ///////////////////FPS///////////////////
     
    public void updateFPS() 
    {
        if (getTime() - lastFPS > 1000) {
            Display.setTitle("FPS: " + fps);
            fps = 0;
            lastFPS += 1000;
        }
        fps++;
    }
}
