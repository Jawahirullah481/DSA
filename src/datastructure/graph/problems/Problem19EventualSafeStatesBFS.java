package datastructure.graph.problems;

import java.util.*;

public class Problem19EventualSafeStatesBFS {

    /*
        Thought Process :
        ----------------
        In DFS algorithm, we can find the solution by going into the deep.
        But in BFS, we can't do like that.

        So, we start from the solution itself.

        Example :
        --------
        1. In this problem, we start from the terminal nodes itself by reversing the graph.
        2. In the rotten oranges problem, we start from the rotten oranges itself.
     */

    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<List<Integer>> revList = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) {
            revList.add(new ArrayList<>());
        }

        int[] indegree = new int[graph.length];

        for(int i = 0; i < graph.length; i++) {
            for(int j : graph[i]) {
                revList.get(j).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while(!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);

            for(int neighbor : revList.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }

        }

        Collections.sort(safeNodes);
        return safeNodes;

    }
}
