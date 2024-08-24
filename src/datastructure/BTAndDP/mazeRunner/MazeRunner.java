package datastructure.BTAndDP.mazeRunner;

import java.util.ArrayList;
import java.util.List;

public class MazeRunner {
    /*
        This MazeRunner is the simple runner app, which moves only in the forward direction.
     */
    protected int[][] maze;

    public MazeRunner(int row, int col) {
        maze = new int[row][col];
    }

    public int countAllWays() {
        return countAllWays(0, 0);
    }

    public List<String> getAllWays() {
        return getAllWays("", 0, 0);
    }

    protected int countAllWays(int row, int col) {
        if(row == maze.length - 1 || col == maze[0].length - 1) {
            return 1;
        }

        int right = countAllWays(row, col + 1);
        int bottom = countAllWays(row + 1, col);

        return right + bottom;
    }

    protected List<String> getAllWays(String p, int row, int col) {
        if(row == maze.length - 1 && col == maze[0].length -1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> allWays = new ArrayList<>();
        if(col < maze[0].length - 1) {
            List<String> rightWays = getAllWays(p + "R", row, col + 1);
            allWays.addAll(rightWays);
        }
        if(row < maze.length - 1) {
            List<String> downWays = getAllWays(p + "D", row + 1, col);
            allWays.addAll(downWays);
        }

        return allWays;
    }

    public static void main(String[] args) {
        MazeRunner maze = new MazeRunner(3, 3);
        System.out.println("All ways Count : " + maze.countAllWays());
        System.out.println("All ways : " + maze.getAllWays());
    }

}
