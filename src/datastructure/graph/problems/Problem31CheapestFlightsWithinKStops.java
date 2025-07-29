package datastructure.graph.problems;

import java.util.*;

public class Problem31CheapestFlightsWithinKStops {

    /*
        Leetcode Problem No : 787

        NOTE : This solution is accepted in the leetcode. But, I think there is a flaw in this solution.
        Path 1 : If I reach a node with more distance but less number of stops.
        Path 2 : If I reach a node with lesser distance but more number of stops.

        Path 2 may not reach the end. So,

        if (totalPrice < prices[neighborNum]) condition always ignore Path 1.

        So, I think the leetcode doesn't check for such cases.
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 1.
        List<List<Node>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Node>());
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            adjList.get(from).add(new Node(to, price));
        }

        // 2.
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // 3.
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(src, 0, 0));

        // 4.
        while (!queue.isEmpty()) {
            Node city = queue.poll();
            int num = city.node;
            int price = city.price;
            int stops = city.stops;

            if (stops > k) {
                continue;
            }

            for (Node neighbor : adjList.get(num)) {
                int neighborNum = neighbor.node;
                int totalPrice = price + neighbor.price;

                if (totalPrice < prices[neighborNum]) {
                    prices[neighborNum] = totalPrice;
                    queue.add(new Node(neighborNum, totalPrice, stops + 1)); // --> line 1
                }

                // if(neighborNum != dst) // --> line 2
                //     queue.add(new Node(neighborNum, totalPrice, stops + 1)); // --> line 3

            }
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];


    }

    class Node {
        int node;
        int price;
        int stops;

        public Node(int node, int price) {
            this(node, price, 0);
        }

        public Node(int node, int price, int stops) {
            this.node = node;
            this.price = price;
            this.stops = stops;
        }

    }

}
