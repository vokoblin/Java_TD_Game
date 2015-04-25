package Entities;

import org.newdawn.slick.opengl.Texture;
import static Main.Clock.*;
import static Gfx.Artist.*;

public class Projectile {

	private Texture texture;
	private float x;
	private float y;
	private float speed;
	private float damage;

	public Projectile(Texture texture, float x, float y, float speed,
			float damage) {
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.damage = damage;
	}

	public void update() {
		x += Delta() * speed;
		draw();
	}

	private void draw() {
		drawRectTexture(texture, x, y, 32, 32);
	}
}
