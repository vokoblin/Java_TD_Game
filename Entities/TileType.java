/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Vovaxs
 */
public enum TileType {
    
    Void("water", false), Grass("grass", true), Dirt("dirt", false), Water("water", false);
    
    String textureName;
    boolean buildable;
    
    TileType(String textureName, boolean buildable)
    {
        this.textureName = textureName;
        this.buildable = buildable;
    }
}
