import java.util.*;

class Temp {

    public static void main(String[] args) {

        int[] nums = {0,1,2,3,4}, index = {0,1,2,2,1};

        int[] target = new int[nums.length];
        Arrays.fill(target, -1);

        for(int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int ind = index[i];

            insert(target, number, ind);
            System.out.println(Arrays.toString(target));

        }

        System.out.println(Arrays.toString(target));


    }

    // [0, 1, 2, -1, -1]

    public static void insert(int[] target, int number, int index) {
        if(target[index] == -1) {
            target[index] = number;
            return;
        }

        // right shift the array elements
        int tempInd = index;
        int tempNum = number;

        while(tempNum != -1) {
            int currentNumber = target[tempInd];
            target[tempInd] = tempNum;
            tempNum = currentNumber;
            tempInd++;
        }
    }

    public boolean[] findAnswer(int n, int[][] edges) {
        // 1.
        List<List<Node>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int source = edge[0];
            int target = edge[1];
            int weight = edge[2];

            adjList.get(source).add(new Node(target, weight));
            adjList.get(target).add(new Node(source, weight));
        }

        // 2.
        Queue<List<Integer>> queue = new LinkedList<>(); // Each set inside the queue is a path
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;
        List<Integer> firstSet = new ArrayList<>();
        firstSet.add(0);
        queue.add(firstSet);

        Set<String> resultSet = new HashSet<>();

        // 3.
        while(!queue.isEmpty()) {
            List<Integer> set = queue.poll();
            int latestNode = set.get(set.size() - 1);

            if(latestNode == n - 1) {
                continue; // Whenever i found a target, i don't want to move forward
            }

            for(Node neighbor : adjList.get(latestNode)) {
                int oldDistance = distance[neighbor.value];
                int newDistance = distance[latestNode] + neighbor.weight;

                if(newDistance <= oldDistance) {
                    distance[neighbor.value] = newDistance;
                    List<Integer> newSet = new ArrayList<>(set);
                    newSet.add(neighbor.value);
                    queue.add(newSet);


                    if(neighbor.value == n - 1)  {
                        if(newDistance < oldDistance) {
                            resultSet.clear();
                            addSet(resultSet, newSet);
                        } else if (newDistance == oldDistance) {
                            addSet(resultSet, newSet);
                        }
                    }

                }
            }
        }

        System.out.println(resultSet);

        boolean[] result = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++) {
            String edge = edges[i][0] + "-" + edges[i][1];
            String edgeRev = edges[i][1] + "-" + edges[i][0];
            if(resultSet.contains(edge) || resultSet.contains(edgeRev)) {
                result[i] = true;
            }
        }

        return result;

    }

    public void addSet(Set<String> resultSet, List<Integer> sourceSet) {
        int n = sourceSet.size();

        for(int i = 0; i <= n - 2; i++) {
            String edge = sourceSet.get(i) + "-" + sourceSet.get(i + 1);
            resultSet.add(edge);
        }
    }

    class Node {
        int value;
        int weight;

        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}