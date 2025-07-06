package datastructure.graph.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem16TopoSortDFS {

    /*
        Leetcode : 210
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build adjacency list: prerequisite[i][1] → prerequisite[i][0]
        for (int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        List<Integer> topoOrder = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(i, adjList, visited, onPath, topoOrder)) {
                    return new int[] {}; // cycle detected
                }
            }
        }

        // Since nodes are added post-recursion, reverse for correct order
        Collections.reverse(topoOrder);

        // Convert list to array
        int[] result = topoOrder.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    private boolean hasCycle(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] onPath, List<Integer> topoOrder) {
        visited[node] = true;
        onPath[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, adjList, visited, onPath, topoOrder)) {
                    return true;
                }
            } else if (onPath[neighbor]) {
                return true; // cycle detected
            }
        }

        onPath[node] = false;
        topoOrder.add(node);
        return false;
    }
}
