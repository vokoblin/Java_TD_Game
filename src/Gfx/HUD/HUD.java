/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gfx.HUD;

import static Gfx.Artist.*;
import Gfx.Frame;
import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Vovaxs
 */
public class HUD {
    private ArrayList<Button> buttonList;
    public static Frame frame;
    
    public HUD(Frame frame){
        this.frame = frame;
        buttonList = new ArrayList<Button>();
    }
    
    public void addButton(String name, String textureName, int x, int y){
        buttonList.add(new Button(name, quickLoadTexture(textureName), x, y));
    }
    
    public boolean isButtonClicked(String buttonName){
        Button b = getButton(buttonName);
        float mouseY = frame.HEIGHT - Mouse.getY() - 1;
        if(Mouse.getX() > b.getX() && Mouse.getX() < b.getX() + b.getWidth() /2 
                && mouseY > b.getY() && mouseY < b.getY() + b.getHeight() /2){
            return true;
        }
        return false;
    }
    
    public Button getButton(String buttonName){
        for (Button b: buttonList){
            if (b.getName().equals(buttonName)){
                return b;
            }
        }
        return null;
    }
    
    public void draw(){
        for (Button b: buttonList){
            drawRectTexture(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
        }
    }
}
