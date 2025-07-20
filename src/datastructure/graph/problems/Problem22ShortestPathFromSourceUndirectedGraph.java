package datastructure.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem22ShortestPathFromSourceUndirectedGraph {

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {

        int[] distance = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        int dist = 0;

        distance[src] = dist;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(src, -1));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int neighbor : adj.get(node.x)) {
                if(neighbor != node.parent && distance[neighbor] > distance[node.x] + 1) {
                    distance[neighbor] = distance[node.x] + 1;
                    queue.add(new Node(neighbor, node.x));
                }
            }
        }

        for(int i = 0; i < distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;

    }

    class Node {
        int x;
        int parent;

        public Node(int x, int parent) {
            this.x = x;
            this.parent = parent;
        }
    }

}
