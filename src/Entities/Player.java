/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import AI.WaveManager;
import static Gfx.Artist.quickLoadTexture;
import Gfx.Screen;
import Main.Clock;
import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 *
 * @author Vovaxs
 */
public class Player {

    private Screen screen;
    private Level level;
    private WaveManager waveManager;
    private ArrayList<Tower> towers;
    private boolean LMBisDown;

    public Player(Screen screen, WaveManager waveManager) {
        this.screen = screen;
        this.level = Screen.getLevel();
        this.waveManager = waveManager;
        this.towers = new ArrayList<Tower>();
        this.LMBisDown = false;
    }

    public void setTower() {
        if ((int) Math.floor(Mouse.getX() / (level.getBlockSize() * level.getSCALE())) < level.getMapWidth() && (int) Math.floor((level.getFrameHeight() - Mouse.getY() - 1) / (level.getBlockSize() * level.getSCALE())) < level.getMapWidth());
        {
            if (level.getTile((int) Math.floor(Mouse.getX() / (level.getBlockSize() * level.getSCALE())), (int) Math.floor((level.getFrameHeight() - Mouse.getY() - 1) / (level.getBlockSize() * level.getSCALE()))).isBuildable()) {
                towers.add(new Tower(screen, quickLoadTexture("cannonBase"), quickLoadTexture("cannonGun"),
                        level.getTile((int) Math.floor(Mouse.getX() / (level.getBlockSize() * level.getSCALE())), (int) Math.floor((level.getFrameHeight() - Mouse.getY() - 1) / (level.getBlockSize() * level.getSCALE()))),
                        10, 200, 1, waveManager));
                level.setUnbuildable((int) Math.floor(Mouse.getX() / (level.getBlockSize() * level.getSCALE())), (int) Math.floor((level.getFrameHeight() - Mouse.getY() - 1) / (level.getBlockSize() * level.getSCALE())));
            }
        }
    }

    public void update() {
        for (Tower t : towers) {
            t.update();
        }

        //Mouse Input hendler
        if (Mouse.isButtonDown(0) && !LMBisDown) {
            setTower();
        }
        LMBisDown = Mouse.isButtonDown(0);
        //Keyboard Input hendler
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
                Clock.changeMultiplier(0.0002f);
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
                Clock.changeMultiplier(-0.0002f);
            }
        }
    }
}
