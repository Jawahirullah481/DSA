package datastructure.graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Problem29MinimumMutiplicationToReachEnd {

    /*
        Problem Link : https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
     */

    int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) return 0;

        boolean[] visited = new boolean[100000];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int num = curr[0], steps = curr[1];

            for (int factor : arr) {
                int next = (num * factor) % 100000;
                if (next == end) return steps + 1;

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, steps + 1});
                }
            }
        }

        return -1;
    }


}
