package ConsoleApps.snackGame;

import java.util.LinkedList;
import java.util.Queue;

public class SnackGame {
    private Snake snake;
    private Queue<Node> food;
    private char[][] board;
    private int foodCount;

    public SnackGame() {
        createBoardAndFood(5, 6);
        snake = new Snake(0, 0);
        board[0][0] = '.';
    }

    public boolean move(int row, int col) {
        Node snakeHead = snake.getHead();
        int movedRow = snakeHead.getRow() + row;
        int movedCol = snakeHead.getCol() + col;

        if(movedRow < 0 || movedCol < 0 || movedRow > board.length - 1 || movedCol > board[0].length - 1) {
            return false;
        }

        if(board[movedRow][movedCol] == '.') {
            return false;
        }

        boolean isFoodNode = snake.move(board, movedRow, movedCol);
        if(isFoodNode) {
            foodCount--;
        }

        return true;
    }

    private void createBoardAndFood(int rowCount, int colCount) {
        board = new char[rowCount][colCount];
        for(char[] row : board) {
            for(char col : row) {
                col = '\0';
            }
        }

        food = new LinkedList<>();
        food.add(new Node(2, 3));
        food.add(new Node(3, 1));
        food.add(new Node(4, 2));

        board[2][3] = 'X';
        board[3][1] = 'X';
        board[4][2] = 'X';

        foodCount = food.size();
    }

    public void printBoard() {
        for(char[] row : board) {
            for(char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public boolean isFoodAvailable() {
        return foodCount > 0;
    }
}
