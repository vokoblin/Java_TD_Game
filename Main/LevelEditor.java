/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entities.Level;
import Entities.TileType;
import Gfx.Frame;
import static LevelEditor.Cartographer.saveMap;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 *
 * @author Vovaxs
 */
class LevelEditor {
    
    private Level map;
    private Frame frame;
    private TileType[] types;
    private int index;
    
    LevelEditor(Frame frame) {
        this.frame = frame;
        this.map = new Level(frame.SCALE);
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Dirt;
        this.types[2] = TileType.Water;
        this.index = 0;
    }

    void update() {
        map.draw();
        
        //Mouse Input hendler
        if (Mouse.isButtonDown(0))
        {
            setTile();
        }
        //Keyboard Input hendler
        while (Keyboard.next())
        {
            if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState())
            {
                changeIndex(true);
            }
            if(Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState())
            {
                changeIndex(false);
            }
            if(Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState())
            {
                saveMap("mapTest", map);
            }
        }
    }
    
    private void setTile(){
        if((int) Math.floor(Mouse.getX() / (map.blockSize * map.SCALE)) <  map.mapWidth && (int) Math.floor((map.frameHeight - Mouse.getY() - 1) / (map.blockSize * map.SCALE)) <  map.mapHeight)
        {
                 map.setTile((int) Math.floor(Mouse.getX() / (map.blockSize * map.SCALE)), (int) Math.floor((map.frameHeight - Mouse.getY() - 1) / (map.blockSize * map.SCALE)), types[index]);  
        }
    }
    
    private void changeIndex(boolean i){
        if(i){
            index++; 
        }else{
            index--;
        }
        if (index > types.length -1)
        {
            index = 0;
        }else if (index < 0){
            index = types.length -1;
        }
        System.out.println("Tile changed to: " + types[index].name());
    }
    
}
