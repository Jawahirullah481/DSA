package datastructure.backtracking;

public class Sudoku {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {

        if(col == board[0].length) {
            return solve(board, row + 1, 0);
        }

        // Whenever I have reached the end, which means that there are no restrictions.
        // Which means I have solved the Sudoku
        if(row == board.length) {
            return true;
        }

        if(get(board, row, col) != 0) {
            return solve(board, row, col + 1);
        }

        for(int num = 1; num <= 9; num++) {
            if(isSafe(board, row, col, num)) {
                board[row][col] = (char)(num + '0');
                if(solve(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, int num) {
        // Check row
        for(int i = 0; i < board[0].length; i++) {
            if(i != col && get(board, row, i) == num) {
                return false;
            }
        }

        // Check column
        for(int i = 0; i < board.length; i++) {
            if(i != row && get(board, i, col) == num) {
                return false;
            }
        }

        // Check sub grid (3 X 3)
        int r = row - (row % 3);
        int c = col - (col % 3);

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(((r + i) != row) && ((c + j) != col) && get(board, r + i, c + j) == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private int get(char[][] board, int row, int col) {
        if(board[row][col] == '.') {
            return 0;
        }

        return Character.getNumericValue(board[row][col]);
    }

    public void printSudokuBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        sudoku.solveSudoku(board);
        sudoku.printSudokuBoard(board);
    }
}
