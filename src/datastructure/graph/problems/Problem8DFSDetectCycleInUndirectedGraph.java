package datastructure.graph.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem8DFSDetectCycleInUndirectedGraph {
    public static void main(String[] args) {

        int[][] edges1 = {
                {0, 1},
                {1, 2},
                {2, 0},
                {2, 3}
        };

        int N = 4;

        // Create adjacency list out of the matrix representation of graph
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < edges1.length; i++) {
            for(int j = 0; j < edges1[0].length; j++) {
                adjList.get(i).add(j);
                adjList.get(j).add(i);
            }
        }

        boolean[] visited = new boolean[N];
        boolean isCycle = false;

        for(int i = 0; i < N; i++) {
            isCycle = checkCycleDFS(i, -1, visited, adjList);
            if(isCycle) break;
        }

        System.out.println("The Given Graph is Cycle : " + isCycle);
    }

    public static boolean checkCycleDFS(int node, int parent, boolean[] visited, List<List<Integer>> adjList) {
        visited[node] = true;
        boolean hasCycle = false;

        for(int neighbour : adjList.get(node)) {

            if(!visited[neighbour]) {
                hasCycle = checkCycleDFS(neighbour, node, visited, adjList);
                if(hasCycle) { break ; }
            } else if(neighbour != parent) {
                return true;
            }
        }

        return hasCycle;
    }
}
