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
    private TileType[] types;
    private int index;
    private ArrayList<Tower> towers;
    private boolean LMBisDown;
    
    public Player(Screen screen, WaveManager waveManager)
    {
        this.screen = screen;
        this.level = screen.level;
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Dirt;
        this.types[2] = TileType.Water;
        this.index = 0;
        this.waveManager = waveManager;
        this.towers = new ArrayList<Tower>();
        this.LMBisDown = false;
    }
    
    public void setTile()
    {
        if((int) Math.floor(Mouse.getX() / level.blockSize) < level.mapWidth && (int) Math.floor((level.frameHeight - Mouse.getY() - 1) / level.blockSize) < level.mapHeight)
        {
                level.setTile((int) Math.floor(Mouse.getX() / level.blockSize), 
                    (int) Math.floor((level.frameHeight - Mouse.getY() - 1) / level.blockSize),
                    types[index]);  
        }
    }
    
    public void setTower()
    {
        if((int) Math.floor(Mouse.getX() / (level.blockSize * level.SCALE)) < level.mapWidth && (int) Math.floor((level.frameHeight - Mouse.getY() - 1) / (level.blockSize * level.SCALE)) < level.mapHeight)
        {
            towers.add(new Tower(screen ,quickLoadTexture("cannonBase"), quickLoadTexture("cannonGun"),
                    level.getTile((int) Math.floor(Mouse.getX() / (level.blockSize * level.SCALE)), (int) Math.floor(((level.frameHeight - (level.mapHeight * level.blockSize)) - Mouse.getY()) / level.blockSize)), 
                    1, 1, 1, waveManager.getCurrentWave().getEnemyList()));
            System.out.println("frame hight :" + level.frameHeight);
            System.out.println("mouse y :" + Mouse.getY());
            System.out.println("mouse x :" + Mouse.getX());
            System.out.println("block size :" + level.blockSize * level.SCALE);
            System.out.println("formula : (" + level.frameHeight + " - " + Mouse.getY() + " - 1) / (" + level.blockSize + " * " + level.SCALE + ")");
            System.out.println("result :" + (int) Math.floor((level.frameHeight - Mouse.getY() - 1) / (level.blockSize * level.SCALE)));
        }
    }
    
    public void update() 
    {
        for(Tower t: towers){
            t.update();
        }
        
        //Mouse Input hendler
        if (Mouse.isButtonDown(0) && !LMBisDown)
        {
            setTower();
        }
        LMBisDown = Mouse.isButtonDown(0);
        //Keyboard Input hendler
        while (Keyboard.next())
        {
            if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState())
            {
                Clock.changeMultiplier(0.0002f);
            }
            if(Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState())
            {
                Clock.changeMultiplier(-0.0002f);
            }
        }
    }
    
    private void changeIndex()
    {
        index++;
        if (index > types.length -1)
        {
            index = 0;
        }
        System.out.println("Tile changed to: " + types[index].name());
    }
    
}
