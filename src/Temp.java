import java.util.LinkedList;
import java.util.Queue;

class Temp {

    public static void main(String[] args) {
        Temp temp = new Temp();
        int[][] grid = {{2,1,1},{1,1,1},{0,1,2}};

        int time = temp.orangesRotting(grid);
        System.out.println("MIN TIME : " + time);
    }

    public int orangesRotting(int[][] grid) {

        int freshCount = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int minTime = Integer.MAX_VALUE;
        int rotten = 0;

        if(freshCount == 0) {
            return 0;
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // If it is rotten, then rot neighbour nodes
                if(!visited[i][j] && grid[i][j] == 2) {
                    int[] res = bfsRot(grid, visited, new Node(i, j, 0));
                    minTime = Math.min(res[0], minTime);
                    rotten += res[1];
                }
            }
        }

        return rotten == freshCount ? minTime : -1;

    }

    public int[] bfsRot(int[][] grid, boolean[][] visited, Node node) {
        int time = 0;
        int numberOfOrangeRotten = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.x][node.y] = true;

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            time = n.level;
            int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

            for(int[] direction : directions) {
                int nextX = n.x + direction[0];
                int nextY = n.y + direction[1];

                if(nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length
                        && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    grid[nextX][nextY] = 2;
                    numberOfOrangeRotten++;
                    queue.add(new Node(nextX, nextY, time + 1));
                    visited[nextX][nextY] = true;
                }

            }
        }

        return new int[] {time, numberOfOrangeRotten};
    }

}

class Node {
    int x;
    int y;
    int level;

    Node(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}