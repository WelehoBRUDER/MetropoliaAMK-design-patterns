import maps.CityMap;
import maps.Map;
import maps.WildernessMap;
import tiles.Tile;

import java.util.Scanner;

public class Game {
    private static Map map;
    private static String[] types = new String[]{"wilderness", "city"};
    public static void main (String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("1. Wilderness");
//        System.out.println("2. City");
//        System.out.print("Specify type of map: ");
//        int mapType = scanner.nextInt();
//        System.out.print("Specify size of map (2-25): ");
//        int size = scanner.nextInt();
//        if (size < 2 || size > 25) {
//            System.out.println("Size must be between 2 and 25.");
//            return;
//        }
        int mapType = 2;
        int size = 25;
        Map _map = createMap(types[mapType - 1], size);
        RenderMap.setMap(_map);
        RenderMap.launch(RenderMap.class);
    }

    public static Map createMap(String type, int size) {
        if (type.equals("wilderness")) {
            map = new WildernessMap(size);
        } else if (type.equals("city")) {
            map = new CityMap(size);
        } else {
            throw new IllegalArgumentException("Unknown map type: " + type);
        }
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Integer tile = map.createTile();
                map.addTile(x, y, tile);
            }
        }
        map.display();
        return map;
    }
}
