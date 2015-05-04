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


import Main.Game;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;


public class Frame
{
    private boolean isInFullscreen = false;
    
    public static Game game;
    public static Screen screen;
    
    //initialising default variables.
    public static String title = "TD Alpha 0.1";
    public static int WIDTH = 1280;
    public static int HEIGHT = 960;
    public float SCALE = 1;
    
    public Frame(Game game)
    {
        this.game = game;
        //setting frame properties.
        
        try {
            Display.setTitle(title);
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();
        } catch (LWJGLException ex) {
            ex.printStackTrace();
        }
        
        //Display.setResizable(true);
        
        init();
    }
    
    void init()
    {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        //setting Grid layout
        //Display.setLayout(new GridLayout(1, 1, 0, 0));
        
        //Creating object of screen (JPanel)
        screen = new Screen(SCALE);
        
        //Adding the panel to the frame and seting visible
        //Display.add(screen);
        //Display.addKeyListener(new KeyHandler(this));
        //Display.setVisible(true);   
    }
    
    public void setIsInFullscreen()
    {
        if(!isInFullscreen){
            isInFullscreen = true;
            //this.setUndecorated(true);
            
        }else{
            //this.setUndecorated(false);
            isInFullscreen = false;
        }
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }
}
