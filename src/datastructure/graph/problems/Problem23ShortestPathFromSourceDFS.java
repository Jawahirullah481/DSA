package datastructure.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem23ShortestPathFromSourceDFS {

    /*
        NOTE :
        ======

        I here solved DFS solution only for knowledge. It is not recommended.
        Because, it performs duplicate calls.
     */

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // 1.
        int[] distance = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        // 2.
        dfs(src, distance, adj);

        // 3.
        for(int i = 0; i < distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    public void dfs(int node, int[] distance, ArrayList<ArrayList<Integer>> adj) {

        for(int neighbor : adj.get(node)) {
            if(distance[neighbor] > distance[node] + 1) {
                distance[neighbor] = distance[node] + 1;
                dfs(neighbor, distance, adj);
            }
        }

    }

}
