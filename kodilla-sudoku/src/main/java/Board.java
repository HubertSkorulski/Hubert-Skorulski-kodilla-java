public class Board {
    public final static int minIndex = 0;
    public final static int maxIndex = 8;
    private final int[][] board = new int[9][];


    public Board() {
        for (int n = 0; n < 8; n++) {
            board[n] = new int[8];
        }
    }

    public int getDigit(int x, int y) {
        return board[x][y];
    }

    public void setDigit(int digit, int x, int y) {
        board[x][y] = digit;
    }

    public String toString() {
        String result = "";
        for (int y = minIndex; y <= maxIndex; y++) {
            result += "|";
            for (int x = minIndex; x <= maxIndex; x++) {
                result += 4;
                result += "|";

            }
            result += "\n";
        }
        return result;
    }
}
