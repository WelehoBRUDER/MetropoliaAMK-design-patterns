package rpg_map_generator.maps;
import rpg_map_generator.Map;

import java.awt.geom.GeneralPath;

public class WildernessMap extends Map {
    private String[][] tiles;
    @Override
    public void createTile() {

    }

    @Override
    public void display() {
        System.out.println("Generated map:");
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {
                System.out.print(tiles[y][x]);
            }
            System.out.println();
        }
    }
}
