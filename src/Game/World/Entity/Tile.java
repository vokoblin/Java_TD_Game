package Game.World.Entity;

import static Game.Helper.Artist.*;
import org.newdawn.slick.opengl.Texture;
import Game.Frame;

/**
 *
 * @author Vovaxs
 */
public class Tile {

    private float x;
    private float y;
    private float width;
    private float height;
    private Texture texture;
    private TileType type;
    private final float SCALE;
    private String angleID;
    private final int[] angleTypes;
    private boolean isBuildable;

    public Tile(int x, int y, int width, int height, TileType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.texture = quickLoadTexture(type.getTextureName());
        this.SCALE = Frame.getSCALE();
        this.angleTypes = new int[4];
        this.angleTypes[0] = 0;
        this.angleTypes[1] = 90;
        this.angleTypes[2] = 180;
        this.angleTypes[3] = 270;
        this.angleID = "0";
        this.isBuildable = type.isBuildable();
    }

    public Tile(int x, int y, int width, int height, TileType type, String angleID) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.texture = quickLoadTexture(type.getTextureName());
        this.SCALE = Frame.getSCALE();
        this.angleTypes = new int[4];
        this.angleTypes[0] = 0;
        this.angleTypes[1] = 90;
        this.angleTypes[2] = 180;
        this.angleTypes[3] = 270;
        this.angleID = angleID;
        this.isBuildable = type.isBuildable();

    }

    public boolean isBuildable() {
        return isBuildable;
    }

    public void setBuildable(boolean isBuildable) {
        this.isBuildable = isBuildable;
    }

    public void draw() {
        drawRotatableRectTexture(texture, x * SCALE, y * SCALE, width * SCALE, height * SCALE, angleTypes[Integer.parseInt(angleID)]);
    }

    public float getX() {
        return x;
    }

    public int getXPos() {
        return (int) x / 32;
    }

    public void setX(float x) {
        this.x = x;
    }

    public int getYPos() {
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
