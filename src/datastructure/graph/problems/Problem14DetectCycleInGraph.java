package datastructure.graph.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem14DetectCycleInGraph {
    /*
        Leetcode : 207
     */
    public static void main(String[] args) {
        int[][] prerequisites = {
                {1, 0},
                {0, 1}
        };

        int numCourses = 2;
        System.out.println("Solution : " + canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list: b → a (to take a, you need b first)
        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        // DFS for each node
        for (int course = 0; course < numCourses; course++) {
            if (!visited[course]) {
                if (isCyclic(course, adj, visited, pathVisited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isCyclic(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (isCyclic(neighbor, adj, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[neighbor]) {
                // Cycle detected
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }
}
