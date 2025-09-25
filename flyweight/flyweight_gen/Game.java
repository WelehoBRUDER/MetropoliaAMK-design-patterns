package flyweight_gen;

import flyweight_gen.maps.CityMap;
import flyweight_gen.maps.WildernessMap;

import java.util.List;
import java.util.Scanner;

public class Game {
    private static Map map;
    private static String[] types = new String[]{"wilderness", "city"};
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Wilderness");
        System.out.println("2. City");
        System.out.print("Specify type of map: ");
        int mapType = scanner.nextInt();
        System.out.print("Specify size of map (2-50): ");
        int size = scanner.nextInt();
        if (size < 2 || size > 50) {
            System.out.println("Size must be between 2 and 50.");
            return;
        }
        createMap(types[mapType - 1], size);
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
