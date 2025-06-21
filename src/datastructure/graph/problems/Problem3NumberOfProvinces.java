package datastructure.graph.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem3NumberOfProvinces {

    public static void main(String[] args) {

        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        // Convert into adjacency List
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < isConnected.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int count = bfsSolution(isConnected, adjList);
        System.out.println("BFS Solution : " + count);

        count = dfsSolution(isConnected, adjList);
        System.out.println("DFS Solution : " + count);

    }

    public static int bfsSolution(int[][] isConnected, List<List<Integer>> adjList) {

        // Traverse the list
        int[] visited = new int[isConnected.length];
        int count = 0;

        for (int node = 0; node < isConnected.length; node++) {
            if (visited[node] == 0) {
                count++;
                bfs(node, adjList, visited);
            }
        }

        return count;
    }

    public static void bfs(int node, List<List<Integer>> adjList, int[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 1;

        while (!queue.isEmpty()) {
            int lastNode = queue.poll();
            for (int neighbour : adjList.get(lastNode)) {
                if (visited[neighbour] == 0) {
                    queue.add(neighbour);
                    visited[neighbour] = 1;
                }
            }
        }

    }

    public static int dfsSolution(int[][] isConnected, List<List<Integer>> adjList) {

        int[] visited = new int[isConnected.length];
        int count = 0;

        for(int node = 0; node < isConnected.length; node++) {
            if(visited[node] == 0) {
                count++;
                // bfs(node, adjList, visited);
                dfs(node, adjList, visited);
            }
        }

        return count;
    }

    public static void dfs(int node, List<List<Integer>> adjList, int[] visited) {

        visited[node] = 1;
        for(int neighbour : adjList.get(node)) {
            if(visited[neighbour] == 0) {
                dfs(neighbour, adjList, visited);
            }
        }

    }
}
