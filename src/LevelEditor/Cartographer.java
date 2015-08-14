/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelEditor;

import Entities.Level;
import Entities.Tile;
import Entities.TileType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
                mapData += TileType.extractTileID(map.getTile(i, j));
                mapData += map.getTile(i, j).getAngleID();
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
    
    public static Level loadMap(String mapName){
        Level map = new Level();
        try{
            BufferedReader br = new BufferedReader(new FileReader(mapName));
            String data = br.readLine();
            for(int i = 0, x = 0; x < map.getMapWidth(); i+=2, x++){
                for(int j = 0, y = 0; y < map.getMapHeight(); j+=2, y++){
                	map.setTile(x, y, TileType.extractTileType(data.substring((x * 2) * map.getMapHeight() + (y * 2), (x * 2) * map.getMapHeight() + (y * 2) + 1 )), data.substring((x * 2) * map.getMapHeight() + (y * 2) + 1, (x * 2 ) * map.getMapHeight() + (y * 2) + 2 ));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
