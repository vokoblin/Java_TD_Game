/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Gfx.Screen;
import java.awt.Graphics;

/**
 *
 * @author Vovaxs
 */
public class Level 
{
    public int levelWidth = 80;
    public int levelHeight = 60;
    public int blockSize = 8;
    
    public Block[][] block;
    
    public Level()
    {
        define();
    }
    
    public void define()
    {
        block = new Block[levelHeight][levelWidth];
        
        for(int y=0; y<block.length; y++)
        {
            for(int x=0; x<block[0].length; x++)
            {
                block[y][x] = new Block((Screen.mWidth / 2)-(levelWidth * blockSize / 2)+(x * blockSize), (Screen.mHeight / 2)-(levelHeight * blockSize / 2)+(y * blockSize), blockSize, blockSize, Entities.groundGrass, Entities.airAir);
            }
        }
    }
    
    public void draw(Graphics g)
    {
        for(int y = 0; y < block.length; y++)
        {
            for(int x = 0; x < block[0].length; x++)
            {
                block[y][x].draw(g);
            }
        }
    }

    public void physics() {
        
    }
}
