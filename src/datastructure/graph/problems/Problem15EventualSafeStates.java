package datastructure.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15EventualSafeStates {
    /*
        Leetcode : 802
     */
    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},   // 0 → 1, 2
                {2, 3},   // 1 → 2, 3
                {5},      // 2 → 5
                {0},      // 3 → 0
                {5},      // 4 → 5
                {},       // 5 → (terminal node)
                {}        // 6 → (terminal node)
        };
        List<Integer> safeNodes = eventualSafeNodes(graph);
        System.out.println(safeNodes.toString());
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(i).add(graph[i][j]);
            }
        }

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        boolean[] safe = new boolean[n];
        List<Integer> terminalNodes = new ArrayList<>();

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                hasCycle(node, visited, pathVisited, safe, adjList);
            }
        }

        for (int i = 0; i < n; i++) {
            if (safe[i]) terminalNodes.add(i);
        }

        return terminalNodes;
    }

    public static boolean hasCycle(int node, boolean[] visited, boolean[] pathVisited, boolean[] safe, List<List<Integer>> adjList) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, visited, pathVisited, safe, adjList)) {
                    return true;
                }
            } else if (pathVisited[neighbor]) {
                return true;
            }
        }

        pathVisited[node] = false;
        safe[node] = true;  // mark as safe if no cycles in any path
        return false;
    }
}
