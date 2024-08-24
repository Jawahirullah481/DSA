package ConsoleApps.mazeRunner;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    char[][] maze;
    Node treasure;
    Node adventure;

    public Maze(int row, int col) {
        maze = new char[row][col];
        initializeMaze();
        treasure = new Node(-1, -1);
        adventure = new Node(-1, -1);
    }

    public void initializeMaze() {
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[i].length; j++) {
                maze[i][j] = '\0';
            }
        }
    }

    public void putTreasure(int row, int col) {
        if(!isValidCell(row, col)) {
            System.out.println("Cannot put treasure");
            return;
        }
        maze[row][col] = 'T';
        treasure = new Node(row, col);
    }

    public void putAdventure(int row, int col) {
        if(!isValidCell(row, col)) {
            System.out.println("Cannot put Adventure");
            return;
        }
        maze[row][col] = 'A';
        adventure = new Node(row, col);
    }

    public void printMaze() {
        for(char[] row : maze) {
            for(char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public int shortestPath() {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        //visited[adventure.row][adventure.col] = true;
        return findShortestPath(adventure.row, adventure.col, visited, 0);
    }

    public int findShortestPath(int row, int col, boolean[][] visited, int steps) {
        if(treasure.row == row && treasure.col == col) { return steps; }
        if(visited[row][col]) {
            return Integer.MAX_VALUE;
        }

        visited[row][col] = true;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int minimumStep = Integer.MAX_VALUE;
        for(int[] cell : directions) {
            int nextrow = row + cell[0];
            int nextcol = col + cell[1];

            if(isValidCell(nextrow, nextcol) && !visited[nextrow][nextcol]) {
                int currentStep = findShortestPath(nextrow, nextcol, visited, steps + 1);
                minimumStep = Math.min(minimumStep, currentStep);
            }
        }

        visited[row][col] = false;
        return minimumStep;
    }
//
//    public Queue<Node> getShortestPath(Queue<Node> path, boolean[][] visited) {
//        int row = path.peek().row;
//        int col = path.peek().col;
//
//        if(treasure.row == row && treasure.col == col) { return path; }
//
//        visited[row][col] = true;
//
//        Queue<Node> shortestPath = null;
//
//
//        Queue<Node> bottomPath = new LinkedList<>(path);
//        bottomPath.add(new Node(1, 0));
//        Queue<Node> leftPath = new LinkedList<>(path);
//        leftPath.add(new Node(0, -1));
//        Queue<Node> rightPath = new LinkedList<>(path);
//        rightPath.add(new Node(0, 1));
//
//        topPath = getShortestPath(topPath, visited);
//        bottomPath = getShortestPath(bottomPath, visited);
//        leftPath = getShortestPath(bottomPath, visited);
//        rightPath = getShortestPath(bottomPath, visited);
//
//        if(topPath.size() > bottomPath.size()) {
//            topPath = bottomPath;
//        }
//        if(leftPath.size() > rightPath.size()) {
//            leftPath = rightPath;
//        }
//
//        if(topPath.size() > leftPath.size()) {
//            shortestPath = leftPath;
//        } else {
//            shortestPath = rightPath;
//        }
//
//        visited[row][col] = false;
//        return minimumStep;
//    }

    public boolean isValidCell(int row, int col) {
        if(row < 0 || row > maze.length - 1 || col < 0 || col > maze[0].length - 1) {
            return false;
        }
        return true;
    }


}
// MY code