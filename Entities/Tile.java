/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import static Gfx.Artist.*;

import org.newdawn.slick.opengl.Texture;

import Gfx.Frame;

/**
 *
 * @author Vovaxs
 */
public class Tile
{
    private float x;
    private float y;
    private float width;
    private float height;
    private Texture texture;
    private TileType type;
    private float SCALE;
    private String angleID;
    private int[] types;
    
    public Tile(int x, int y, int width, int height, TileType type)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.texture = quickLoadTexture(type.getTextureName());
        this.SCALE = Frame.getSCALE();
        this.types = new int[4];
        this.types[0] = 0;
        this.types[1] = 90;
        this.types[2] = 180;
        this.types[3] = 270;
        this.angleID = "0";
    }
    
    public Tile(int x, int y, int width, int height, TileType type, String angleID)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.texture = quickLoadTexture(type.getTextureName());
        this.SCALE = Frame.getSCALE();
        this.types = new int[4];
        this.types[0] = 0;
        this.types[1] = 90;
        this.types[2] = 180;
        this.types[3] = 270;
        this.angleID = angleID;
        
    }
    
    public void draw()
    {
    	drawRotatableRectTexture(texture, x * SCALE, y * SCALE, width * SCALE, height * SCALE, types[Integer.parseInt(angleID)]);
    }
    
    public float getX() {
        return x;
    }
    
    public int getXPos()
    {
        return (int) x / 32;
    }
    
    public void setX(float x) {
        this.x = x;
    }
    
    public int getYPos()
    {
        return (int) y / 32;
    }
    
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

	public String getAngleID() {
		return angleID;
	}

	public void setAngleID(String angleID) {
		this.angleID = angleID;
	}
}
