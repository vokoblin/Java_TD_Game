/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Vovaxs
 */
public enum TileType {

    Void("water", false, "0"), Grass("grass", true, "1"), GrassDirt("grassdirt", true, "2"), GrassDirtCorn("grassdirtcorn", true, "3"), Dirt("dirt", false, "4"), Water(
            "water", false, "5"), GrassDirtCornTiny("grassdirtcorntiny", true, "6");

    private String textureName;
    private boolean buildable;
    private String id;

    TileType(String textureName, boolean buildable, String id) {
        this.textureName = textureName;
        this.buildable = buildable;
        this.id = id;
    }

    public static String extractTileID(Tile t) {
        String id = t.getType().Void.name();

        for (TileType t1 : TileType.values()) {
            if (t1.name().equals(t.getType().name())) {
                return id = t1.getId();
            }
        }

        return id;
    }

    public static TileType extractTileType(String id) {
        TileType type = TileType.Void;

        for (TileType t1 : TileType.values()) {
            if (t1.getId().equals(id)) {
                return type = t1;
            }
        }

        return type;
    }

    public String getTextureName() {
        return textureName;
    }

    public void setTextureName(String textureName) {
        this.textureName = textureName;
    }

    public boolean isBuildable() {
        return buildable;
    }

    public void setBuildable(boolean buildable) {
        this.buildable = buildable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
