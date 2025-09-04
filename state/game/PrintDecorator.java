package game;

public class PrintDecorator {
    public void print(String message, PrintColors color) {
        String colorString = getColor(color);
        String resetColor = getColor(PrintColors.WHITE);
        System.out.println(colorString + message + resetColor);
    }

    public void printToLine(String message, PrintColors color) {
        String colorString = getColor(color);
        String resetColor = getColor(PrintColors.WHITE);
        System.out.print(colorString + message + resetColor);
    }

    public String getColor(PrintColors color) {
        switch (color) {
            case WHITE:
                return "\u001B[0m";
            case SILVER:
                return "\u001B[37m";
            case GRAY:
                return "\u001B[90m";
            case RED:
                return "\u001B[31m";
            case GREEN:
                return "\u001B[0;92m";
            case BLUE:
                return "\u001B[34m";
            case GOLD:
                return "\u001B[1;93m";
            default:
                return "\u001B[1m";
        }
    }
}
