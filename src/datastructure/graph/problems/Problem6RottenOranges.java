package datastructure.graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Problem6RottenOranges {

    /*
        BFS only can be applied to this problem. We cannot solve it by DFS.
        Because,
        ------------------------------------------------------------------------------------
        | Problem Type                                               | Preferred Algorithm |
        | ---------------------------------------------------------- | ------------------- |
        | Simultaneous,parallel spread (Spreading/infection problems)| BFS                 |
        | pathfinding, combinations, permutations or backtracking    | DFS                 |
        ------------------------------------------------------------------------------------

        In this problem, 2 oranges are rotten. Simultaneously neighbours of both the oranges will start rotting.
        Hence, BFS is used. DFS cannot be used.
     */

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 2}
        };

        Problem6RottenOranges problem = new Problem6RottenOranges();

        System.out.println("Time to Rotting Oranges : " + problem.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {

        int freshOranges = 0;
        int rottedOranges = 0;
        Queue<Node> queue = new LinkedList<>();

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                } else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int time = 0;

        if(freshOranges == 0) return 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Node node = queue.poll();

                int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
                for(int[] dir : directions) {
                    int nextX = node.x + dir[0];
                    int nextY = node.y + dir[1];

                    if(nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length
                            && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        grid[nextX][nextY] = 2;
                        rottedOranges++;
                        queue.add(new Node(nextX, nextY));
                    }
                }
            }

            if(!queue.isEmpty()) {
                time++;
            }
        }

        return freshOranges == rottedOranges ? time : -1;

    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
