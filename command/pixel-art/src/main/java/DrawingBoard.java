public class DrawingBoard {
    private int[][] board;
    private int x;
    private int y;
    private int[] size;

    public DrawingBoard(int width, int height) {
        size = new int[]{width, height};
        board = new int[height][width];
        x = 1;
        y = 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void toggle() {
        board[y][x] = board[y][x] == 1 ? 0 : 1;
    }

    public void clear() {
        board = new int[size[1]][size[0]];
    }

    public void moveCursorUp() {
        y -= 1;
        if (y < 0) y = 0;
    }

    public void moveCursorDown() {
        y += 1;
        if (y >= board.length) y = board.length - 1;
    }

    public void moveCursorLeft() {
        x -= 1;
        if (x < 0) x = 0;
    }

    public void moveCursorRight() {
        x += 1;
        if (x >= board[0].length) x = board[0].length - 1;
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean isSelected(int x, int y) {
        return this.x == x && this.y == y;
    }

    public boolean isFilled(int x, int y) {
        return this.getBoard()[y][x] == 1;
    }

    public void generateCode() {
        System.out.println("int[][] pixelArt = {");
        for (int y = 0; y < board.length; y++) {
            System.out.print("\t{");
            for (int x = 0; x < board.length; x++) {
                if (x == board[y].length - 1) {
                    System.out.print(board[y][x]);
                } else {
                    System.out.print(board[y][x] + ", ");
                }
            }
            System.out.print("},\n");
        }
        System.out.println("};");
    }
}
