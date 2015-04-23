/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import org.lwjgl.Sys;

/**
 *
 * @author Vovaxs
 */
public class Clock {
    
    private static boolean paused = false;
    public static long lastFrame;
    public static long totalTime;
    
    public static float d = 0;
    public static float multiplier = 0.01f;
    
    ///FPS///
    
    /** frames per second */
    private int fps;
    
    /** last fps time */
    private long lastFPS;
    
    /** first update boolean */
    private boolean  isFistFPSUpdate = true;

    
    
    public static long getTime()
    {
        return Sys.getTime() * 1000 / Sys.getTimerResolution();
    }
    
    public static float getDelta()
    {
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta + 0.01f;
    }
    
    public static float Delta()
    {
        if(paused)
            return 0;
        else
            return d * multiplier;
    }
    
    public static float totalTime()
    {
        return totalTime;
    }
    
    public static float multiplier()
    {
        return multiplier;
    }
    
    public static void update()
    {
        d = getDelta();
        totalTime += d;
    }
    
    public static void changeMultiplier(int change)
    {
        if(multiplier + change < -1 && multiplier > 7)
        {
            
        }
        else
        {
            multiplier += change;
        }
    }
    
    public static void Pause()
    {
        if(paused)
            paused = false;
        else
            paused = true;
    }
    
    /*
    public int getFPS() 
    {
        if(isFistFPSUpdate)
        {
            defineFPS();
        }
        if (getTime() - lastFPS > 1000) 
        {
            setFps(fps);
            fps = 0;
            lastFPS += 1000;
        }
        fps++;
        return getFps();
    }
    */

    private void defineFPS() {
        getDelta(); // call once before loop to initialise lastFrame
        lastFPS = getTime(); // call before loop to initialise fps timer
    }
    
}   
