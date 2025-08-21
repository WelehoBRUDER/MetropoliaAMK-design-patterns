package rpg_map_generator;

import rpg_map_generator.maps.CityMap;
import rpg_map_generator.maps.WildernessMap;

public class Game {
    public static void main (String[] args) {
        createMap("city");
    }

    public static void createMap(String type) {
        int minSize = 5;
        int maxSize = 10;
        int size = (int) (Math.random() * (maxSize - minSize + 1)) + minSize;
        Map map;
        if (type.equals("wilderness")) {
            map = new WildernessMap(size);
        } else if (type.equals("city")) {
            map = new CityMap(size);
        } else {
            throw new IllegalArgumentException("Unknown map type: " + type);
        }
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Tile tile = map.createTile();
                map.addTile(x, y, tile);
            }
        }
        map.display();
    }
}
