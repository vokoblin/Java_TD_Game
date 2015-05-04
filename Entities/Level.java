/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Gfx.Frame;

/**
 *
 * @author Vovaxs
 */
public class Level {
	public int mapWidth = 15;
	public int mapHeight = 10;
	public int blockSize = 64;
	public int frameWidth;
	public int frameHeight;
        public float SCALE;

	public Tile[][] map;

	public Level(float SCALE) {
		frameWidth = Frame.getWIDTH();
		frameHeight = Frame.getHEIGHT();
                this.SCALE  = SCALE;
		map = new Tile[mapWidth][mapHeight];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Tile(i * blockSize, j * blockSize, blockSize,
						blockSize, TileType.Grass, 2);
			}
		}
	}

	public Level(int[][] newMap, float SCALE) {
		frameWidth = Frame.getWIDTH();
		frameHeight = Frame.getHEIGHT();
                this.SCALE  = SCALE;
		map = new Tile[mapWidth][mapHeight];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (newMap[j][i] == 0) {

				} else {
					map[i][j] = new Tile(i * blockSize, j * blockSize,
							blockSize, blockSize, TileType.Dirt, SCALE);
				}
				switch (newMap[j][i]) {
				case 0:
					map[i][j] = new Tile(i * blockSize, j * blockSize,
							blockSize, blockSize, TileType.Grass, SCALE);
					break;
				case 1:
					map[i][j] = new Tile(i * blockSize, j * blockSize,
							blockSize, blockSize, TileType.Dirt, SCALE);
					break;
				case 2:
					map[i][j] = new Tile(i * blockSize, j * blockSize,
							blockSize, blockSize, TileType.Water, SCALE);
					break;
				}
			}
		}
	}

	public void setTile(int xCoord, int yCoord, TileType type) {
		map[xCoord][yCoord] = new Tile((int) (xCoord * blockSize * SCALE), (int) (yCoord * blockSize * SCALE), (int) (blockSize * SCALE), (int) (blockSize * SCALE), type, SCALE);
	}

	public Tile getTile(int xPos, int yPos) {
		if (xPos < mapWidth && yPos < mapHeight && xPos > -1 && yPos > -1) {
			return map[xPos][yPos];
		} else {
			return new Tile(0, 0, 0, 0, TileType.Void, SCALE);
		}
	}

	public void draw() {
		for (Tile[] map1 : map) {
			for (Tile t : map1) {
				t.draw();
			}
		}
	}

	public void physics() {

	}

	public int getMapWidth() {
		return mapWidth;
	}

	public void setMapWidth(int mapWidth) {
		this.mapWidth = mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public void setMapHeight(int mapHeight) {
		this.mapHeight = mapHeight;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public Tile[][] getMap() {
		return map;
	}

	public void setMap(Tile[][] map) {
		this.map = map;
	}
}
