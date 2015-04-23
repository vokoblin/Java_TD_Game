/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 *
 * @author Vovaxs
 */
public class Player {
    
    private Level level;
    private TileType[] types;
    private int index;
    
    public Player(Level level)
    {
        this.level = level;
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Dirt;
        this.types[2] = TileType.Water;
        this.index = 0;
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
    
    public void update() 
    {
        if (Mouse.isButtonDown(0))
        {
            setTile();
        }
        while (Keyboard.next())
        {
            if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState())
            {
                changeIndex();
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
