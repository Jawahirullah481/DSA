package datastructure.graph.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem7BFSDetectCycleInUndirectedGraph {

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

        boolean isCycle = false;

        boolean[] visited = new boolean[N];
        for(int node = 0; node < N; node++) {
            if(!visited[node]) {
                isCycle = checkIsCycleBFS(new Node(node, -1), adjList, visited);
                if(isCycle) {
                    break;
                }
            }
        }

        System.out.println("The Given Graph is Cycle : " + isCycle);
    }

    static boolean checkIsCycleBFS(Node node, List<List<Integer>> adjList, boolean[] visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.x] = true;

        while(!queue.isEmpty()) {

            Node n = queue.poll();

            for(int neighbour : adjList.get(n.x)) {
                if(!visited[neighbour]) {
                    queue.add(new Node(neighbour, n.x));
                    visited[neighbour] = true;
                } else if (neighbour != n.parent) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Node {
        int x;
        int parent;

        Node(int x, int parent) {
            this.x = x;
            this.parent = parent;
        }
    }
}


