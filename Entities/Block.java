/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.awt.*;

/**
 *
 * @author Vovaxs
 */
public class Block extends Rectangle
{
    public int GroundID;
    public int AirID;
    
    public Block(int x, int y, int width, int height, int GroundID, int AirID)
    {
        setBounds(x, y, width, height);
        this.GroundID = GroundID;
        this.AirID = AirID;
    }
    
    public void draw (Graphics g)
    {
        g.drawRect(x, y, width, height);
        
        if(AirID != Entities.airAir)
        {
            
        }
    }
}
