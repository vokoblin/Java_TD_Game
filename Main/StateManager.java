/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Vovaxs
 */
public class StateManager {
    
    public static enum GameState {
        MAINMENU, GAME, LEVELEDITOR
    }
    
    public static GameState gameState;
    public static MainMenu mainMenu;
    public static Game game;
    public static LevelEditor editor;
    
    public static void update(){
        switch(gameState){
            case MAINMENU:
                if(mainMenu == null){
                    mainMenu = new MainMenu();
                }
                mainMenu.update();
                break;
            case GAME:
                
                break;
            case LEVELEDITOR:
                
                break;
                
        }
    }
}
