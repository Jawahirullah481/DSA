package datastructure.backtracking.mazeRunner;

import java.util.ArrayList;
import java.util.List;

public class MazeWithObstacle extends MazeRunner {

    protected int[] obstacle;

    public MazeWithObstacle(int row, int col, int[] obstacle) {
        super(row, col);
        this.obstacle = obstacle;
    }

    @Override
    protected int countAllWays(int row, int col) {
        if(row == maze.length - 1 || col == maze[0].length - 1) {
            return 1;
        }

        if(row == obstacle[0] && col == obstacle[1]) {
            return 0;
        }

        int rightWays = countAllWays(row, col + 1);
        int downWays = countAllWays(row + 1, col);

        return rightWays + downWays;
    }

    @Override
    protected List<String> getAllWays(String p, int row, int col) {
        if(row == maze.length - 1 && col == maze[0].length - 1) {
            List<String> ways = new ArrayList<>();
            ways.add(p);
            return ways;
        }

        if(row == obstacle[0] && col == obstacle[1]) {
            return new ArrayList<>();
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
        MazeRunner maze = new MazeWithObstacle(5, 4, new int[]{2, 1});
        System.out.println("All Ways count : " + maze.countAllWays());
        System.out.println("All ways : " + maze.getAllWays());
    }
}
