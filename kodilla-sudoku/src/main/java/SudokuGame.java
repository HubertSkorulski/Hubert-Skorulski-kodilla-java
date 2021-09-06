public class SudokuGame {
    public static void main(String[] args){
        System.out.println("Hello");
        Board board = new Board();
        board.setDigit(6,3,3);
        System.out.println(board.getDigit(2,3));
        System.out.println(board.getDigit(3,3));
        System.out.println(board.toString());

    }

}
