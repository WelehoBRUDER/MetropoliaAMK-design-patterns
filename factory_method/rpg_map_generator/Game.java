package rpg_map_generator;

import rpg_map_generator.maps.CityMap;
import rpg_map_generator.maps.WildernessMap;

import java.util.Scanner;

public class Game {
    private static Map map;
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Specify type of map (city/wilderness): ");
        String mapType = scanner.nextLine().trim().toLowerCase();
        System.out.print("Specify size of map (2-50): ");
        int size = scanner.nextInt();
        if (size < 2 || size > 50) {
            System.out.println("Size must be between 2 and 50.");
            return;
        }
        createMap(mapType, size);
    }

    public static void createMap(String type, int size) {
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
