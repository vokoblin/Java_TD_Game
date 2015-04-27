package Entities;

import org.newdawn.slick.opengl.Texture;
import static Main.Clock.*;
import static Gfx.Artist.*;

public class Projectile {

	private Level level;
	private Texture texture;
	private float x;
	private float y;
	private float speed;
	private float damage;

	public Projectile(Level level, Texture texture, float x, float y, float speed,
			float damage) {
		this.level = level;
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.damage = damage;
	}

	public void update() {
		x += Delta() * speed;
		if(x < (level.mapWidth -1) * level.blockSize && x > 0 && y < (level.mapHeight -1) * level.blockSize && y > 0){
			draw();
		}
	}

	private void draw() {
		drawRectTexture(texture, x, y, 32, 32);
	}
}
