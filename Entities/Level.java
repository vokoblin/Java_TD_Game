/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import static Gfx.Artist.*;

/**
 *
 * @author Vovaxs
 */
public class Level 
{
    public int mapWidth = 10;
    public int mapHeight = 7;
    public int blockSize = 64;
    
    public Tile[][] map;
    
    public Level()
    {
       map = new Tile[mapWidth][mapHeight];
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
                map[i][j] = new Tile(i * blockSize, j * blockSize, blockSize, blockSize, TileType.Grass);
            }
        }
    }
    
    public Level(int[][] newMap)
    {
        map = new Tile[mapWidth][mapHeight];
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
                if(newMap[j][i] == 0)
                {
                    map[i][j] = new Tile(i * blockSize, j * blockSize, blockSize, blockSize, TileType.Grass);
                }
                else
                {
                    map[i][j] = new Tile(i * blockSize, j * blockSize, blockSize, blockSize, TileType.Dirt);
                }
            }
        }
    }
    
    public void draw()
    {
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
                Tile t = map[i][j];
                map[i][j].draw();
            }
        }
    }
    

    public void physics() {
        
    }
}
