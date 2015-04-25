package Entities;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

import static Gfx.Artist.*;
import static Main.Clock.*;

public class Tower {

	private float x;
	private float y;
	private float width;
	private float height;
	private float damage;
	private float range;
	private float timeSinceLastShot;
	private float attSpeed;
	private float initAttSpeed;
	private Texture textureBase;
	private Texture textureTop;
	private Tile startTile;
	private ArrayList<Projectile> projectiles;

	public Tower(Texture textureBase, Texture textureTop, Tile startTile, float damage, float range, float attSpeed) {
		this.textureBase = textureBase;
		this.textureTop = textureTop;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = startTile.getWidth();
		this.height = startTile.getHeight();
		this.damage = damage;
		this.range = range;
		this.attSpeed = attSpeed;
		this.initAttSpeed = attSpeed;
		this.timeSinceLastShot = 0;
		this.projectiles = new ArrayList<Projectile>();

	}

	public void update() {
		timeSinceLastShot += Delta();
		if (timeSinceLastShot > initAttSpeed - (attSpeed - initAttSpeed)){
			shoot();
		}
		
		for (Projectile p: projectiles){
			p.update();
		}
		
		draw();
	}

	private void shoot() {
		timeSinceLastShot = 0;
		projectiles.add(new Projectile(quickLoadTexture("bullet"), x + startTile.getWidth(), y + startTile.getHeight(), attSpeed, damage));
	}

	public void draw() {
		drawRectTexture(textureBase, x, y, width, height);
		drawRectTexture(textureTop, x, y, width, height);
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

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	public float getRange() {
		return range;
	}

	public void setRange(float range) {
		this.range = range;
	}

	public float getAttSpeed() {
		return attSpeed;
	}

	public void setAttSpeed(float attSpeed) {
		this.attSpeed = attSpeed;
	}

	public Texture getTextureBase() {
		return textureBase;
	}

	public void setTextureBase(Texture textureBase) {
		this.textureBase = textureBase;
	}

	public Texture getTextureTop() {
		return textureTop;
	}

	public void setTextureTop(Texture textureTop) {
		this.textureTop = textureTop;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}
}
