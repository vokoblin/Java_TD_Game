package Main;

import Gfx.Frame;
import Gfx.Screen;
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
        
        while(isRunning && !Display.isCloseRequested()){
            if(!Screen.isFirst)
            {
               // Frame.screen.level.physics();
            }
            Clock.update();
            
            frame.screen.drawScene();
            //frame.screen.level.draw();
            
            Display.setTitle("FPS: " + Clock.FPS());
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
     
    ///////////////////FPS///////////////////
     

}
