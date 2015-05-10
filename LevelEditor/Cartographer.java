/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelEditor;

import Entities.Level;
import Entities.Tile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author Vovaxs
 */
public class Cartographer {
    
    public static void saveMap(String mapName, Level map){
        String mapData = "";
        for(int i = 0; i < map.getMapWidth(); i++){
            for(int j = 0; j < map.getMapHeight(); j++){
                mapData += getTileID(map.getTile(i, j));
            }
        }
        
        try {
            File file = new File(mapName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(mapData);
            bw.close();
            System.out.println("File created in:" + file.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(Cartographer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public static String getTileID(Tile t){
        String id = t.getType().Void.name();
        
        switch (t.getType()){
            case Grass:
                id = "0";
                break;
            case Dirt:
                id = "1";
                break;
            case Water:
                id = "2";
                break;
            case Void:
                id = "4";
                break;
        }
        
        return id;
    }
}
