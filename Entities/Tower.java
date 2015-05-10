package Entities;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

import static Gfx.Artist.*;
import Gfx.Screen;
import static Main.Clock.*;

public class Tower {

	private Screen screen;
        private Level level;
	private float x;
	private float y;
	private float width;
	private float height;
        private float angle;
	private float damage;
	private float range;
	private float timeSinceLastShot;
	private float attSpeed;
	private float initAttSpeed;
	private Texture textureBase;
	private Texture textureTop;
	private Tile startTile;
	private ArrayList<Projectile> projectiles;
        private ArrayList<Enemy> enemies;
        private Enemy target;

	public Tower(Screen screen, Texture textureBase, Texture textureTop, Tile startTile, float damage, float range, float attSpeed, ArrayList<Enemy> enemies) {
		this.screen = screen;
                this.level = screen.level;
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
                this.enemies = enemies;
                this.target = takeAim();
                this.angle = calculateTrajectory();
	}
        
        private Enemy takeAim(){
            return enemies.get(0);
        }
        
        private float calculateTrajectory(){
            double tempAngle = Math.atan2(target.getY() * level.getSCALE() - y * level.getSCALE(), target.getX() * level.getSCALE() - x * level.getSCALE());
            return (float)Math.toDegrees(tempAngle) - 90;
        }
        
	public void update() {
		timeSinceLastShot += Delta();
		if (timeSinceLastShot > initAttSpeed){
                    shoot();
		}
		
		for (Projectile p: projectiles){
                    p.update();
		}
		
                angle = calculateTrajectory();
		draw();
	}

	private void shoot() {
		timeSinceLastShot = 0;
		projectiles.add(new Projectile(level, target, quickLoadTexture("bullet"), x + (level.getBlockSize() / 4), y + (level.getBlockSize() / 4), 1000, damage));
	}

	public void draw() {
		drawRectTexture(textureBase, x * level.getSCALE(), y * level.getSCALE(), width * level.getSCALE(), height * level.getSCALE());
		drawRotatableRectTexture(textureTop, x * level.getSCALE(), y * level.getSCALE(), width * level.getSCALE(), height * level.getSCALE(), angle);
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
        
        public void addAttSpeed(float attSpeed) {
		this.attSpeed += attSpeed;
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
