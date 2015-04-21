package Main;


import Gfx.Frame;
import Gfx.Screen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vovaxs
 */

public class Game implements Runnable
{
    boolean isRunning = false;
    
    public Thread gameloop = new Thread(this);
        
    public Game()
    {
        gameloop.start();
    }
    
    @Override
    public void run()
    {
        Frame frame = new Frame(this);
        long lastFrame = System.currentTimeMillis();
        int frames = 0;
        
        isRunning = true;
        
        while(isRunning){
            if(!Screen.isFirst)
            {
                Frame.screen.level.physics();
            }
            
            
            Frame.screen.repaint();
            
            frames ++;
            
            if(System.currentTimeMillis() - 1000 >= lastFrame){
                Frame.screen.setFps(frames);
                frames = 0;
                lastFrame = System.currentTimeMillis();
            }
            
            try
            {
                Thread.sleep(2);
            } catch(Exception e)
            {}
        }
        
        System.exit(0);
        
    }
    
        public static void main(String args[]) 
    {
        
        Game game = new Game();
        
    }
    
    public void stopGame(){
        if(isRunning){
            isRunning = false;
        }
    }

}
