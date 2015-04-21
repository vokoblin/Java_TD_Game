/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gfx;

/**
 *
 * @author Vovaxs
 */

import Entities.Level;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Screen extends JPanel
{
    private int fps;
    
    public static boolean isFirst = true;
    
    public static Level level;
    
    public static int mWidth;
    public static int mHeight;
    
    public Screen()
    {
        //setBackground(Color.BLACK);
        System.out.println("hello :D");
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        if(isFirst)
            {
                mWidth = getWidth();
                mHeight = getHeight();
                
                //if running for the first time than define everything
                define();
                
                //ser isFirst to false;
                isFirst=false;
            }
        g.clearRect(0, 0, getWidth(), getHeight());
        
        g.drawString("FPS : "+fps, 10, 10);
        level.draw(g);
    }

    public void Rander() {
        
    }

    private void define() {
        level= new Level();
    }
    
    
    public void setFps(int fps) {
        this.fps = fps;
    }
    
}
