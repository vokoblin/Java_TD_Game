/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Gfx.Frame;

/**
 *
 * @author Vovaxs
 */
public class StateManager {

    public static enum GameState {

        MAINMENU, GAME, LEVELEDITOR
    }

    public static GameState gameState = GameState.MAINMENU;
    public static MainMenu mainMenu;
    public static Game game;
    //public static Frame frame = new Frame(game);
    public static LevelEditor editor;

    public static void update(Frame frame) {
        switch (gameState) {
            case MAINMENU:
                if (mainMenu == null) {
                    mainMenu = new MainMenu(frame);
                }
                mainMenu.update();
                break;
            case GAME:
                Frame.getScreen().drawScene();
                break;
            case LEVELEDITOR:
                if (editor == null) {
                    editor = new LevelEditor();
                }
                editor.update();
                break;

        }
    }

    public static void setState(GameState newState) {
        gameState = newState;
    }
}
