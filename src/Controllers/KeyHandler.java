/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Gfx.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Vovaxs
 */
public class KeyHandler implements KeyListener {

    private Frame frame;

    public KeyHandler(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        System.out.println(keyCode);
        if (keyCode == e.VK_ESCAPE) {
            this.frame.game.stopGame();
        }

        if (keyCode == e.VK_F1) {
            this.frame.setIsInFullscreen();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
