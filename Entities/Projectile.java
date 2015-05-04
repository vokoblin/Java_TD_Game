package Entities;

import org.newdawn.slick.opengl.Texture;
import static Main.Clock.*;
import static Gfx.Artist.*;

public class Projectile {

	private Level level;
        private Enemy target;
	private Texture texture;
	private float x;
	private float y;
	private float speed;
	private float damage;
        private float xVelocity;
        private float yVelocity;

	public Projectile(Level level, Enemy target, Texture texture, float x, float y, float speed,
			float damage) {
		this.level = level;
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.damage = damage;
                this.target = target;
                this.xVelocity = 0;
                this.yVelocity = 0;
                calculateTrajectory();
	}
        
        private void calculateTrajectory(){
            //MAX 100% of the movement
            float totalAllowedMovement = 1.0f;
            //Absolute value of of the targets x - tower x = distance between them on the x axis.
            float xDistanceFromTarget = Math.abs(target.getX() * level.SCALE - x * level.SCALE - (level.blockSize * level.SCALE / 4) + (level.blockSize * level.SCALE / 2));
            //Absolute value of of the targets y - tower y = distance between them on the y axis.
            float yDistanceFromTarget = Math.abs(target.getY() * level.SCALE - y * level.SCALE - (level.blockSize * level.SCALE / 4) + (level.blockSize * level.SCALE / 2));
            //total distance between target and projectile.
            float totalDistanceFromTarget = xDistanceFromTarget + yDistanceFromTarget;
            //splitting the percentage of the movement on x and y depending on target possition.
            float xPercentOfMovement = xDistanceFromTarget / totalDistanceFromTarget;
            xVelocity = xPercentOfMovement;
            yVelocity = totalAllowedMovement - xPercentOfMovement;
            //if targets x pos is less the projectile x pos = reverse the xVelocity
            if(target.getX() * level.SCALE < x * level.SCALE){
                xVelocity *= -1;
            }
            //if targets y pos is less the projectile y pos = reverse the yVelocity
            if(target.getY() * level.SCALE < y * level.SCALE){
                yVelocity *= -1;
            }
        }
        
	public void update() {
		x += xVelocity * speed * Delta();
                y += yVelocity * speed * Delta();
		if(x * level.SCALE < (level.mapWidth) * level.blockSize * level.SCALE && x * level.SCALE > 0 && y * level.SCALE < (level.mapHeight) * level.blockSize * level.SCALE && y * level.SCALE > 0){
			draw();
		}
	}

	private void draw() {
		drawRectTexture(texture, x * level.SCALE, y * level.SCALE, 32  * level.SCALE, 32  * level.SCALE);
	}
}
