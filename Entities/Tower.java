package Entities;

import org.newdawn.slick.opengl.Texture;
import static Gfx.Artist.*;

public class Tower {

	private float x;
	private float y;
	private float width;
	private float height;
	private float damage;
	private float range;
	private float attspeed;
	private Texture texture;
	private Tile startTile;

	public Tower(Texture texture, Tile startTile, float damage, float range, float attspeed) {
		this.texture = texture;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = startTile.getWidth();
		this.height = startTile.getHeight();
		this.damage = damage;
		this.range = range;
		this.attspeed = attspeed;

	}

	public void update() {

	}

	public void draw() {
		drawRectTexture(texture, x, y, width, height);
	}
}
