package maps;

import tiles.Tile;

public abstract class Map {
    private Tile[][] tiles;
    public abstract Tile createTile();
    public void display() {
        System.out.println("Generated map of size " + tiles.length + "x" + tiles[0].length);
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {
                System.out.print(" " + tiles[y][x].getCharacter() + " ");
            }
            System.out.println();
        }
    }
    public Map(int size) {
        tiles = new Tile[size][size];
    }

    public void addTile(int x, int y, Tile tile) {
        if (x < 0 || y < 0 || x >= tiles.length || y >= tiles[0].length) {
            throw new IndexOutOfBoundsException("Tile coordinates out of bounds");
        }
        tiles[y][x] = tile;
    }
}
