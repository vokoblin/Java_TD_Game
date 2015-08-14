/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import org.newdawn.slick.opengl.Texture;

import static Gfx.Artist.*;
import Gfx.Frame;
import Gfx.HUD.HUD;
import Main.StateManager.GameState;

import org.lwjgl.input.Mouse;
/**
 *
 * @author Vovaxs
 */
public class MainMenu {
    
    private Frame frame;
    private Texture background;
    public static HUD menuHUD;
    
    private boolean LMBisDown;
    
    public MainMenu(Frame frame){
        this.frame = frame;
        background = quickLoadTexture("bk");
        this.menuHUD = new HUD(frame);
        menuHUD.addButton("play", "play", frame.WIDTH / 2 - 130, (int)(frame.HEIGHT * 0.45f));
        menuHUD.addButton("level editor", "level editor", frame.WIDTH / 2 - 130, (int)(frame.HEIGHT * 0.45f) + 100);
        menuHUD.addButton("exit", "exit", frame.WIDTH / 2 - 130, (int)(frame.HEIGHT * 0.45f) + 200);
    }
    
    private void updateButtons() {
        if(Mouse.isButtonDown(0) && !LMBisDown){
            if(menuHUD.isButtonClicked("play")){
                StateManager.setState(GameState.GAME);
            }
            if(menuHUD.isButtonClicked("level editor")){
                StateManager.setState(GameState.LEVELEDITOR);
            }
            if(menuHUD.isButtonClicked("exit")){
                System.exit(0);
            }
        }
        LMBisDown = Mouse.isButtonDown(0);
    }
    
    public void update(){
        drawRectTexture(background, 0, 0, 1280, 640);
        menuHUD.draw();
        updateButtons();
    }
}
