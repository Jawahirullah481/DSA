package datastructure.backtracking;

public class NKnights {

    private boolean[][] board;

    public NKnights(int row, int col) {
        board = new boolean[row][col];
    }

    public int putKnight(int row, int col, int target) {
        if(target == 0) {
            printBoard();
            return 1;
        }

        if(col == board[0].length) {
            return putKnight(row + 1, 0, target);
        }

        if(row == board.length) {
            return 0;
        }

        int count = 0;
        if(isSafe(row, col)) {
            board[row][col] = true;
            count += putKnight(row, col + 1, target - 1);
            board[row][col] = false;
        }

        count += putKnight(row, col + 1, target);

        return count;
    }

    private boolean isSafe(int row, int col) {
        // We need to check in L shape, if knight is already placed or not in upward only.
        // Because, as we haven't traversed the bottom, definitely no knights will be in the bottom of current row.

        if(!(row < board.length && col < board[0].length)) {
            return false;
        }

        if(!isValid(row - 2, col - 1)) {
            return false;
        }

        if(!isValid(row - 2, col + 1)) {
            return false;
        }

        if(!isValid(row - 1, col - 2)) {
            return false;
        }

        if(!isValid(row - 1, col + 2)) {
            return false;
        }

        return true;
    }

    private boolean isValid(int row, int col) {
        return !((row >= 0 && row < board.length) && (col >= 0 && col < board[0].length) && (board[row][col]));
    }

    private void printBoard() {
        for(int i = 0; i < board.length; i++) {
            System.out.print("[");
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j]) {
                    System.out.print("K ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println("]");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        NKnights nKnights = new NKnights(4, 4);
        System.out.println("Count : " + nKnights.putKnight(0, 0, 2));
    }
}
