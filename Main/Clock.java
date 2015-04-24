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
    private static int fps = 0;
    private static int fpsmodifier = 0;
    
    /** last fps time */
    private static long lastFPS;
    
    /** first update boolean */
    private static boolean  isFirstFPSUpdate = true;

    
    
    public static long getTime()
    {
        return Sys.getTime() * 1000 / Sys.getTimerResolution();
    }
    
    public static float getDelta()
    {
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        if (delta * 0.01f > 0.5f)
        {
        	return 0.5f;
        }
        else
        {
        	return delta + 0.01f;
        }
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
        updateFPS();
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
    
    
    public static void updateFPS() 
    {
        if(isFirstFPSUpdate)
        {
            defineFPS();
            isFirstFPSUpdate = false;
        }
        else if (getTime() - lastFPS > 1000) 
        {
            fps = fpsmodifier;
            fpsmodifier = 0;
            lastFPS += 1000;
        }
        fpsmodifier++;
    }
    
    public static int FPS()
    {
    	//
    	 if(paused)
             return fps;
         else
             return fps;
    }
    

    private static void defineFPS() {
        getDelta(); // call once before loop to initialise lastFrame
        lastFPS = getTime(); // call before loop to initialise fps timer
    }
}   
