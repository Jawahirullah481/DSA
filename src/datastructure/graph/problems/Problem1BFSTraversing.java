package datastructure.graph.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1BFSTraversing {
    public static void main(String[] args) {

        System.out.println("Solution 1 : ");
        // 1. Traverse Connected Nodes
        traverseConnectedNodes();

        System.out.println("Solution 2 : ");
        // 2. Traverse Graph with Disconnected Nodes
        traverseDisconnectedNodes();
    }

    static void traverseConnectedNodes() {
        int vertices = 5;

        // Adjacency list representation
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Adding edges (undirected graph)
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 2, 4);

        int startNode = 0;

        // Call your BFS function here
        bfsConnected(adjList, startNode, vertices);
    }

    static void traverseDisconnectedNodes() {
        int vertices = 7;

        // Adjacency list representation
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Adding edges (undirected graph)
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 5, 6);

        // Call your BFS traversal function
        bfsDisconnected(adjList, vertices);
    }

    // Method to add an undirected edge
    static void addEdge(List<List<Integer>> adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }


    // -- 1. Traverse Graph with connected Nodes
    static void bfsConnected(List<List<Integer>> adjList, int startNode, int vertices) {

        int[] visited = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visited[startNode] = 1;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for(int neighbour : adjList.get(node)) {
                if(visited[neighbour] == 0) {
                    queue.add(neighbour);
                    visited[neighbour] = 1;
                }
            }
        }
    }

    // -- 2. Traverse Graph with Disconnected Nodes
    static void bfsDisconnected(List<List<Integer>> adjList, int vertices) {

        int[] visited = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < vertices; i++) {

            if(visited[i] == 1) {
                continue;
            }

            queue.add(i);
            visited[i] = 1;

            while(!queue.isEmpty()) {

                int node = queue.poll();
                System.out.print(node + " ");

                for(int neighbour : adjList.get(node)) {

                    if(visited[neighbour] == 0) {
                        queue.add(neighbour);
                        visited[neighbour] = 1;
                    }

                }

            }

            System.out.println();

        }

    }
}
