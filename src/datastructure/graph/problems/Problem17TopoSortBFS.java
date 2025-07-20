package datastructure.graph.problems;

import java.util.*;

public class Problem17TopoSortBFS {

    /*
        Thought Process :
        ------------------
        If a ---> b (a is directing b), then a is an ancestor of b, and a should come before b.

        Hence,
        Putting b when its indegree reaches 0 is something similar to the logic
        "I have sent all my ancestors before. So, now I have no ancestor. Hence, I need to go into the queue".
        
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] pair : prerequisites){
            adjList.get(pair[0]).add(pair[1]);
            indegree[pair[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> ansList = new ArrayList<>();

        while(!queue.isEmpty()) {
            int node = queue.poll();
            ansList.add(node);

            for(int neighbor : adjList.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if(ansList.size() != numCourses) return new int[] {};

        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
}
