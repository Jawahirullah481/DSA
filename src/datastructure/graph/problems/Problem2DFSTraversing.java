package datastructure.graph.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem2DFSTraversing {
    public static void main(String[] args) {

        System.out.println("Solution 1 : ");
        // 1. Traverse Connected Nodes
        traverseConnectedNodes();

        System.out.println("Solution 2 : ");
        // 2. Traverse Disconneted Nodes
        traverseDisconnectedNodes();
    }

    // Method to add an undirected edge
    static void addEdge(List<List<Integer>> adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
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

        // Call your DFS function here
        boolean[] visited = new boolean[vertices];
        dfsConnected(adjList, startNode, visited);
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

        // Call your DFS disconnected function
        dfsDisconnected(adjList, vertices);

    }

    // -- 1. Traverse Graph with connected Nodes
    static void dfsConnected(List<List<Integer>> adjList, int currentNode, boolean[] visited) {

        visited[currentNode] = true;
        System.out.print(currentNode + " ");

        for(int neighbourNode : adjList.get(currentNode)) {
            if(!visited[neighbourNode]) {
                dfsConnected(adjList, neighbourNode, visited);
            }
        }
    }

    // -- 2. Traverse Graph with Disconnected Nodes
    static void dfsDisconnected(List<List<Integer>> adjList, int vertices) {

        boolean[] visited = new boolean[vertices];

        for(int i = 0; i < vertices; i++) {
            if(!visited[i]) {
                dfs(adjList, i, visited);
                System.out.println();
            }
        }

    }

    static void dfs(List<List<Integer>> adjList, int currentNode, boolean[] visited) {

        if(visited[currentNode]) {
            return;
        }

        System.out.print(currentNode + " ");
        visited[currentNode] = true;

        for(int neighbour : adjList.get(currentNode)) {
            dfs(adjList, neighbour, visited);
        }
    }
}
