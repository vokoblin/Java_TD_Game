package Game.World.Entity;

/**
 *
 * @author Vovaxs
 */
public class Checkpoint {

    private final Tile tile;
    private final int xDirection;
    private final int yDirection;

    public Checkpoint(Tile tile, int xDirection, int yDirection) {
        this.tile = tile;
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    public Tile getTile() {
        return tile;
    }

    public int getxDirection() {
        return xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

}
