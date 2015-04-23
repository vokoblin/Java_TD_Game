/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Gfx.Frame;

/**
 *
 * @author Vovaxs
 */
public class Level 
{
    public int mapWidth = 10;
    public int mapHeight = 7;
    public int blockSize = 64;
    public int frameWidth;
    public int frameHeight;
    
    public Tile[][] map;
    
    public Level()
    {
       frameWidth = Frame.getWIDTH();
       frameHeight = Frame.getHEIGHT();
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
        frameWidth = Frame.getWIDTH();
        frameHeight = Frame.getHEIGHT();
        map = new Tile[mapWidth][mapHeight];
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
                if(newMap[j][i] == 0)
                {
                    
                }
                else
                {
                    map[i][j] = new Tile(i * blockSize, j * blockSize, blockSize, blockSize, TileType.Dirt);
                }
                switch (newMap[j][i])
                {
                    case 0:
                        map[i][j] = new Tile(i * blockSize, j * blockSize, blockSize, blockSize, TileType.Grass);
                        break;
                    case 1:
                        map[i][j] = new Tile(i * blockSize, j * blockSize, blockSize, blockSize, TileType.Dirt);
                        break;
                    case 2:
                        map[i][j] = new Tile(i * blockSize, j * blockSize, blockSize, blockSize, TileType.Water);
                        break;
                }
            }
        }
    }
    
    public void setTile(int xCoord, int yCoord, TileType type)
    {
        map[xCoord][yCoord] = new Tile(xCoord * blockSize, yCoord * blockSize, blockSize, blockSize, type);
    }
    
    public Tile getTile(int xPos, int yPos){
        return map[xPos][yPos];
    }
    
    public void draw()
    {
        for (Tile[] map1 : map) {
            for (Tile t : map1) {
                t.draw();
            }
        }
    }
    

    public void physics() {
        
    }
}
