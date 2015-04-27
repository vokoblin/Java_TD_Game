/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import AI.Checkpoint;
import static Gfx.Artist.*;
import static Main.Clock.*;
import java.util.ArrayList;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Vovaxs
 */
public class Enemy {
    private Level level;
    
    private float x;
    private float y;
    private int width;
    private int height;
    private float health;
    private float speed;
    private Texture texture;
    private Tile startTile;
    private boolean isFirstUpdate = true;
    private boolean isAlive = true;
    
    private ArrayList<Checkpoint> checkpoints;
    private int[] directions;
    private int currentCheckpoint;
    
    public Enemy (Texture texture, Tile startTile, Level level, int width, int height, float health, float speed)
    {
        this.texture = texture;
        this.startTile = startTile;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = width;
        this.height = height;
        this.health = health;
        this.speed = speed;
        this.level = level;
       
        this.checkpoints = new ArrayList<Checkpoint>();
        this.directions = new int[2];
        //x direction
        this.directions[0] = 0;
        //y direction
        this.directions[1] = 0;
        directions = detectPath(startTile);
        this.currentCheckpoint = 0;
        scanLevel();
    }
    public void update()
    {
        if (isFirstUpdate)
        {
            isFirstUpdate = false;
        }
        else
        {
            if(checkpointReached())
            {
            	if(currentCheckpoint >= checkpoints.size() - 1)
            	{
            		die();
            	}
            	else
            	{
            		currentCheckpoint++;	
            	}
            }
            else
            {
                x += Delta() * checkpoints.get(currentCheckpoint).getxDirection() * speed;
                y += Delta() * checkpoints.get(currentCheckpoint).getyDirection() * speed;
            }
        }
    }
    
    private boolean checkpointReached ()
    {
        boolean reached = false;
        Tile t = checkpoints.get(currentCheckpoint).getTile();
        int modifier = 3;
                
        if(x > t.getX() - modifier &&
                x < t.getX() + modifier &&
                y > t.getY() - modifier &&
                y < t.getY() + modifier)
        {
            reached = true;
            x = t.getX();
            y = t.getY();
        }
        
        return reached;
    }
    
    /** Scans the level for all the checkpoints
     and populates checkpoint array */
    private void scanLevel ()
    {
        checkpoints.add(detectCheckpoint(startTile, directions = detectPath(startTile)));
        
        int counter = 0;
        boolean end = false;
        while (!end && counter < 20)
        {
            int [] currentDirection = detectPath(checkpoints.get(counter).getTile());
            //check all map for checkpoints or until counter = 20
            if (currentDirection[0] == 2)
            {
                end = true;
            }
            else{
                checkpoints.add(detectCheckpoint(checkpoints.get(counter).getTile(),
                        directions = detectPath(checkpoints.get(counter).getTile())));
            }
            counter++;
        }
    }
    
    private Checkpoint detectCheckpoint (Tile t, int[] dir)
    {
        Tile next = null;
        Checkpoint c = null;
        
        boolean detected = false;
        int counter = 1;
        
        while (!detected)
        {
            //check the path along the direction that enemy is heading
            if (t.getXPos() + dir[0] * counter == level.getMapWidth() ||
            		t.getYPos() + dir[1] * counter == level.getMapHeight() ||
            		t.getType() != 
                    level.getTile(t.getXPos() + dir[0] * counter,
                        t.getYPos() + dir[1] * counter).getType())
            {
                //checkpoint detected
                detected = true;
                //when the end of the path is found then go one tile back
                counter -= 1;
                //set this tile as a checkpoint/future turn
                next = level.getTile(t.getXPos() + dir[0] * counter,
                        t.getYPos() + dir[1] * counter);
            }
            counter++;
        }
        //adding to check point
        c = new Checkpoint(next, dir[0], dir[1]);
        return c;
    }
    
    private int[] detectPath (Tile t)
    {
        //int array for heading direction
        int[] dir = new int[2];
        //predicted tiles (up/right/down/left)
        Tile up = level.getTile(t.getXPos(), t.getYPos() - 1);
        Tile right = level.getTile(t.getXPos() + 1, t.getYPos());
        Tile down = level.getTile(t.getXPos(), t.getYPos() + 1);
        Tile left = level.getTile(t.getXPos() - 1, t.getYPos());
        //for extra movement predicted tiles (upleft/upright/downright/downleft)
        Tile upleft = level.getTile(t.getXPos() - 1, t.getYPos() - 1);
        Tile upright = level.getTile(t.getXPos() + 1, t.getYPos() - 1);
        Tile downright = level.getTile(t.getXPos() + 1, t.getYPos() + 1);
        Tile downleft = level.getTile(t.getXPos() - 1, t.getYPos() + 1);
        
        //find path
        if (t.getType() == up.getType() && directions[1] != 1)
        {
            dir[0] = 0;
            dir[1] = -1;
        }
        else if (t.getType() == right.getType() && directions[0] != -1)
        {
            dir[0] = 1;
            dir[1] = 0;
        }
        else if (t.getType() == down.getType() && directions[1] != -1)
        {
            dir[0] = 0;
            dir[1] = 1;
        }
        else if (t.getType() == left.getType() && directions[0] != 1)
        {
            dir[0] = -1;
            dir[1] = 0;
        }
        else if (t.getType() == upleft.getType() && (directions[0] != 1  || directions[1] != 1))
        {
            dir[0] = -1;
            dir[1] = -1;
        }
        else if (t.getType() == upright.getType() && (directions[0] != -1  || directions[1] != 1))
        {
            dir[0] = 1;
            dir[1] = -1;
        }
        else if (t.getType() == downright.getType() && (directions[0] != -1  || directions[1] != -1))
        {
            dir[0] = 1;
            dir[1] = 1;
        }
        else if (t.getType() == downleft.getType() && (directions[0] != 1  || directions[1] != -1))
        {
            dir[0] = -1;
            dir[1] = 1;
        }
        else
        {
            dir[0] = 2;
            dir[1] = 2;
        }
        
        return dir;
    }
   
    public void draw(){
        drawRectTexture(texture, x, y, width, height);
    }
    
    private void die()
    {
    	isAlive = false;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Tile getStartTile() {
        return startTile;
    }

    public void setStartTile(Tile startTile) {
        this.startTile = startTile;
    }
    
    public Level getLevel()
    {
        return level;
    }
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
