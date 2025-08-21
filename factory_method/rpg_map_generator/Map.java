package rpg_map_generator;

public abstract class Map {
    private I_Tile[][] tiles;
    public abstract I_Tile createTile();
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
        tiles = new I_Tile[size][size];
    }

    public void addTile(int x, int y, I_Tile tile) {
        if (x < 0 || y < 0 || x >= tiles.length || y >= tiles[0].length) {
            throw new IndexOutOfBoundsException("Tile coordinates out of bounds");
        }
        tiles[y][x] = tile;
    }
}
