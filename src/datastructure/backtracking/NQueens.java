package datastructure.backtracking;

public class NQueens {
    private boolean[][] board;

    public NQueens(int row, int col) {
        board = new boolean[row][col];
    }

    public int getAllPossibles(int row) {
        // If row(index) reaches last row, which means all rows are filled.
        // If any one of the row is not filled with Queen, then we can't reach the board.length.
        if(row == board.length) {
            printBoard();
            return 1;
        }

        int count = 0;
        for(int col = 0; col < board[0].length; col++) {
            // Before putting a queen at particular position, we have to check whether it is safe or not.
            if(isSafe(row, col)) {
                board[row][col] = true;
                count += getAllPossibles(row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private boolean isSafe(int row, int col) {
        // Check upward whether any row in same column has queens
        for(int i = 0; i < row; i++) {
            if(board[i][col]) {
                return false;
            }
        }

        // Check left top diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
           if(board[i][j]) {
               return false;
           }
        }

       // Check right top diagonal
       for(int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
           if(board[i][j]) {
               return false;
           }
       }

       return true;
    }

    private void printBoard() {
        for(int i = 0; i < board.length; i++) {
            System.out.print("[");
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j]) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println("]");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens(8, 8);
        System.out.println("Count : " + nQueens.getAllPossibles(0));
    }
}
