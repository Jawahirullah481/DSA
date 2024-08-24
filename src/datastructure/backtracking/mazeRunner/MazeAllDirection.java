package datastructure.backtracking.mazeRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeAllDirection extends MazeWithObstacle {
    /*
        The one extra problem of MazeAllDirection over normal maze is
        In this, we can move in all directions.
        So, there is the possibility of going in same path again and again.
        So, We need to use backtracking here to avoid stack overflow.
     */

    private boolean[][] travelled;

    public MazeAllDirection(int row, int col, int[] obstacle) {
        super(row, col, obstacle);
        travelled = new boolean[row][col];
    }

    @Override
    protected int countAllWays(int row, int col) {
        if(row == maze.length - 1 && col == maze[0].length - 1) {
            return 1;
        }

        if(travelled[row][col] || (row == obstacle[0] && col == obstacle[1])) {
            return 0;
        }

        travelled[row][col] = true;
        int allWays = 0;

        if(row > 0) {
            // Upward
            allWays += countAllWays(row - 1, col);
        }
        if(row < maze.length - 1) {
            // Downward
            allWays += countAllWays(row + 1, col);
        }
        if(col > 0) {
            // Backward
            allWays += countAllWays(row, col - 1);
        }
        if(col < maze[0].length - 1) {
            // Forward
            allWays += countAllWays(row, col + 1);
        }
        travelled[row][col] = false;

        return allWays;
    }

    @Override
    protected List<String> getAllWays(String p, int row, int col) {
        if(row == maze.length - 1 && col == maze[0].length -1) {
            // Whenever you find the destiny simply print it
            travelled[row][col] = true;
            printTravelledPath(p);
            travelled[row][col] = true;

            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        if(travelled[row][col] || (row == obstacle[0] && col == obstacle[1])) {
            return new ArrayList<>();
        }

        travelled[row][col] = true;

        List<String> allways = new ArrayList<>();
        // Forward
        if(col < maze[0].length - 1) {
            allways.addAll(getAllWays(p + "R", row, col + 1));
        }
        // Backward
        if(col > 0) {
            allways.addAll(getAllWays(p + "L", row, col - 1));
        }
        // Downward
        if(row < maze.length -1) {
            allways.addAll(getAllWays(p + "D", row + 1, col));
        }
        // Upward
        if(row > 0) {
            allways.addAll(getAllWays(p + "U", row - 1, col));
        }

        // When the recursion comes back, i want to revert the changes i have done.
        // This is called backtracking.
        // Otherwise, it will lead to inaccurate answers.
        travelled[row][col] = false;

        return allways;
    }

    private void printTravelledPath(String path) {
        for(boolean[] row : travelled) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(path);
        System.out.println();
    }

    public static void main(String[] args) {
        MazeRunner mazeRunner = new MazeAllDirection(4, 4, new int[]{1, 1});
       // System.out.println(mazeRunner.countAllWays());
        mazeRunner.getAllWays();
    }
}
