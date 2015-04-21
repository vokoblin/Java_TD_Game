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


import Controllers.KeyHandler;
import Main.Game;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class Frame extends JFrame 
{
    private boolean isInFullscreen = false;
    
    public static Game game;
    public static Screen screen;
    
    //initialising default variables.
    public static String title = "TD Alpha 0.1";
    public static Dimension size = new Dimension(800, 600);
    
    public Frame(Game game)
    {
        this.game = game;
        //setting frame properties.
        setTitle(title);
        setSize(size);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        init();
    }
    
    void init()
    {
        //setting Grid layout
        setLayout(new GridLayout(1, 1, 0, 0));
        
        //Creating object of screen (JPanel)
        screen = new Screen();
        
        //Adding the panel to the frame and seting visible
        add(screen);
        addKeyListener(new KeyHandler(this));
        setVisible(true);   
    }
    
    public void setIsInFullscreen(){
        if(!isInFullscreen){
            isInFullscreen = true;
            //this.setUndecorated(true);
            this.setExtendedState(MAXIMIZED_BOTH);
            
        }else{
            this.setSize(size);
            //this.setUndecorated(false);
            isInFullscreen = false;
        }
    }
    
}
