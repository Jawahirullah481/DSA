package datastructure.graph.problems;

import java.util.*;

public class Problem20AlienDictionary {

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad" };
        System.out.println(findOrderBFS(words));
        System.out.println(findOrderDFS(words));
    }

    // -- DFS SOLUTION
    public static String findOrderDFS(String[] words) {

        // 1.
        Set<Character> set = new HashSet<>();

        for (String word : words) {
            for (Character letter : word.toCharArray()) {
                set.add(letter);
            }
        }

        // 2.
        Map<Integer, Character> indexMap = new HashMap<>();
        Map<Character, Integer> charMap = new HashMap<>();

        int indx = 0;
        for (Character c : set) {
            indexMap.put(indx, c);
            charMap.put(c, indx);
            indx++;
        }

        // 3.
        int n = set.size();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // 4.
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            boolean hasFoundDiff = false;
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    hasFoundDiff = true;
                    adjList.get(charMap.get(c1)).add(charMap.get(c2));
                    break;
                }
            }

            if (!hasFoundDiff && word1.length() > word2.length()) {
                return "";
            }
        }

        // 5.
        boolean[] visited = new boolean[adjList.size()];
        boolean[] pathVisited = new boolean[adjList.size()];
        StringBuilder ans = new StringBuilder();

        for (int node = 0; node < adjList.size(); node++) {
            if (!visited[node]) {
                if (!dfs(node, visited, pathVisited, adjList, indexMap, charMap, ans)) {
                    return "";
                }
            }
        }

        if (ans.length() != set.size()) {
            return "";
        }

        return ans.reverse().toString();

    }

    public static boolean dfs(int node, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adjList, Map<Integer, Character> indexMap, Map<Character, Integer> charMap, StringBuilder ans) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (!dfs(neighbor, visited, pathVisited, adjList, indexMap, charMap, ans)) return false;
            } else if (pathVisited[neighbor]) {
                return false;
            }
        }

        pathVisited[node] = false;
        ans.append(indexMap.get(node));
        return true;

    }

    // BFS Solution
    public static String findOrderBFS(String[] words) {
        // Step 1: Collect all unique characters
        Set<Character> characterSet = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                characterSet.add(c);
            }
        }

        // Map characters to indices
        Map<Character, Integer> charToIndex = new HashMap<>();
        Map<Integer, Character> indexToChar = new HashMap<>();
        int idx = 0;
        for (char c : characterSet) {
            charToIndex.put(c, idx);
            indexToChar.put(idx, c);
            idx++;
        }

        int n = characterSet.size();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Step 2: Build graph with proper prefix conflict check
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int minLen = Math.min(word1.length(), word2.length());
            boolean foundDifference = false;

            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    int u = charToIndex.get(c1);
                    int v = charToIndex.get(c2);
                    adjList.get(u).add(v);
                    foundDifference = true;
                    break;
                }
            }

            // If no difference found and word1 is longer — invalid ordering
            if (!foundDifference && word1.length() > word2.length()) {
                return "";
            }
        }

        // Step 3: Topological sort (Kahn's Algorithm)
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int neighbor : adjList.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.append(indexToChar.get(node));

            for (int neighbor : adjList.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If result length != total unique characters — cycle exists
        if (result.length() != n) {
            return "";
        }

        return result.toString();
    }

}
