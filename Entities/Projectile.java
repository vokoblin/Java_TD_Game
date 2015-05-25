package Entities;

import org.newdawn.slick.opengl.Texture;
import static Main.Clock.*;
import static Gfx.Artist.*;
import static Logic.Collision.*;

public class Projectile {

	private Level level;
	private Enemy target;
	private Texture texture;
	private float x;
	private float y;
	private float width;
	private float height;
	private float speed;
	private float damage;
	private float xVelocity;
	private float yVelocity;
	private boolean isAlive;

	public Projectile(Level level, Enemy target, Texture texture, float x,
			float y, float width, float height, float speed, float damage) {
		this.level = level;
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.damage = damage;
		this.target = target;
		this.xVelocity = 0;
		this.yVelocity = 0;
		this.isAlive = true;
		calculateTrajectory();
	}

	private void calculateTrajectory() {
		// MAX 100% of the movement
		float totalAllowedMovement = 1.0f;
		// Absolute value of of the targets x - tower x = distance between them
		// on the x axis.
		float xDistanceFromTarget = Math.abs(target.getX() * level.getSCALE()
				- x * level.getSCALE()
				- (level.getBlockSize() * level.getSCALE() / 4)
				+ (level.getBlockSize() * level.getSCALE() / 2));
		// Absolute value of of the targets y - tower y = distance between them
		// on the y axis.
		float yDistanceFromTarget = Math.abs(target.getY() * level.getSCALE()
				- y * level.getSCALE()
				- (level.getBlockSize() * level.getSCALE() / 4)
				+ (level.getBlockSize() * level.getSCALE() / 2));
		// total distance between target and projectile.
		float totalDistanceFromTarget = xDistanceFromTarget
				+ yDistanceFromTarget;
		// splitting the percentage of the movement on x and y depending on
		// target possition.
		float xPercentOfMovement = xDistanceFromTarget
				/ totalDistanceFromTarget;
		xVelocity = xPercentOfMovement;
		yVelocity = totalAllowedMovement - xPercentOfMovement;
		// if targets x pos is less the projectile x pos = reverse the xVelocity
		if (target.getX() * level.getSCALE() < x * level.getSCALE()) {
			xVelocity *= -1;
		}
		// if targets y pos is less the projectile y pos = reverse the yVelocity
		if (target.getY() * level.getSCALE() < y * level.getSCALE()) {
			yVelocity *= -1;
		}
	}

	public void update() {
		if (isAlive) {
			x += xVelocity * speed * Delta();
			y += yVelocity * speed * Delta();
			if (x * level.getSCALE() > (level.getMapWidth())
					* level.getBlockSize() * level.getSCALE()
					&& x * level.getSCALE() < 0
					&& y * level.getSCALE() > (level.getMapHeight())
							* level.getBlockSize() * level.getSCALE()
					&& y * level.getSCALE() < 0) {
				isAlive = false;
			}
			if (collisionTest(x, y, width, height, target.getX(),
					target.getY(), target.getWidth(), target.getHeight())) {
				// if enemy hit destroy projectile
				target.getShot(damage);
				isAlive = false;
			}
			draw();
		}
	}

	private void draw() {
		drawRectTexture(texture, x * level.getSCALE(), y * level.getSCALE(),
				32 * level.getSCALE(), 32 * level.getSCALE());
	}
}
