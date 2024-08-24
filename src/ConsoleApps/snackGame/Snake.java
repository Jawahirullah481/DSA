package ConsoleApps.snackGame;

import java.util.LinkedList;
import java.util.Queue;

public class Snake {
    private Queue<Node> body;
    private Node head;

    public Snake(int row, int col) {
        body = new LinkedList<>();
        head = new Node(row, col);
        body.add(head);
    }

    public boolean move(char[][] board, int row, int col) {
        boolean isFoodNode = true;

        head = new Node(row, col);
        body.add(head);
        if(board[row][col] != 'X') {
            Node tail = body.poll();
            board[tail.getRow()][tail.getCol()] = '\0';
            isFoodNode = false;
        }
        board[row][col] = '.';
        return isFoodNode;
    }

    public void printSnake(char[][] board) {
        for(Node node : this.body) {
            board[node.getRow()][node.getCol()] = '.';
        }
    }

    public Node getHead() {
        return this.head;
    }
}
