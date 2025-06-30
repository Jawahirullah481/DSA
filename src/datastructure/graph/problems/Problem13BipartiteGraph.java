package datastructure.graph.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem13BipartiteGraph {
    /*
        Leetcode : 785

        Problem statement : There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v.

        In the problem statement, you can note the following point.

        "where graph[u] is an array of nodes that node u is adjacent to."

        The above point portrays that the array itself is the adjacency list representation. So, for the format like this, you need to construct adj list in different format as used in this program.
     */
    public static void main(String[] args) {

        int[][] graph = {
                {1, 3},  // Node 0 is connected to 1 and 3
                {0, 2},  // Node 1 is connected to 0 and 2
                {1, 3},  // Node 2 is connected to 1 and 3
                {0, 2}   // Node 3 is connected to 0 and 2
        };

        boolean isBipartite = false;
        isBipartite = isBipartiteBFS(graph);
        isBipartite = isBipartiteDFS(graph);

        System.out.println("The given graph is : " + isBipartite);

    }

    // -- 1. BFS Solution
    public static boolean isBipartiteBFS(int[][] graph) {

        // -- 1. Construct adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
            for (int neighbor : graph[i]) {
                adjList.get(i).add(neighbor);
            }
        }

        // -- 2.
        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            Queue<Integer> queue = new LinkedList<>();

            if (visited[i] == 0) {
                queue.add(i);
                visited[i] = 1;
            }

            while (!queue.isEmpty()) {
                Integer node = queue.poll();
                int group = visited[node];

                for (int nextNode : adjList.get(node)) {
                    if (visited[nextNode] == 0) {
                        queue.add(nextNode);
                        visited[nextNode] = group == 1 ? 2 : 1;
                    } else if (visited[nextNode] == group) {
                        return false;
                    }
                }

            }
        }

        return true;

    }

    // -- 2. DFS Solution
    public static boolean isBipartiteDFS(int[][] graph) {
        // -- 1. Construct adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
            for (int neighbor : graph[i]) {
                adjList.get(i).add(neighbor);
            }
        }

        int[] visited = new int[graph.length];

        for(int i = 0 ; i < graph.length; i++) {
            if(visited[i] == 0) {
                boolean isBipartite = dfs(i, adjList, visited, 1);
                if(!isBipartite) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean dfs(int node, List<List<Integer>> adjList, int[] visited, int group) {
        visited[node] = group;

        for(int neighbor : adjList.get(node)) {
            if(visited[neighbor] == 0) {
                boolean isBipartite = dfs(neighbor, adjList, visited, group == 1 ? 2 : 1);
                if(!isBipartite) return false;
            } else if (visited[neighbor] == group) {
                return false;
            }
        }

        return true;
    }
}
