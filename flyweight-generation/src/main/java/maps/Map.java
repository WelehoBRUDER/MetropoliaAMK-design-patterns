package maps;

import tiles.Tile;
import tiles.TileGraphicFactory;

import java.util.Arrays;

public abstract class Map {
    private TileGraphicFactory tgf = TileGraphicFactory.getInstance();
    private Integer[][] tiles;
    public abstract Integer createTile();
    public void display() {
        System.out.println("Generated map of size " + tiles.length + "x" + tiles[0].length);
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {
                System.out.print(" " + tgf.getTile(tiles[y][x]).getCharacter() + " ");
            }
            System.out.println();
        }
    }
    public Map(int size) {
        tiles = new Integer[size][size];
    }

    public void addTile(int x, int y, int tile) {
        if (x < 0 || y < 0 || x >= tiles.length || y >= tiles[0].length) {
            throw new IndexOutOfBoundsException("Tile coordinates out of bounds");
        }
        tiles[y][x] = tile;
    }
}
