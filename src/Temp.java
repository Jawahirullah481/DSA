import java.util.*;

class Temp {

    public static void main(String[] args) {
        String[] words = { "baa", "abcd", "abca", "cab", "cad" };
        System.out.println(findOrder(words));
    }

    public static String findOrder(String[] words) {

        // 1.
        Set<Character> set = new HashSet<>();

        for(String word : words) {
            for(Character letter : word.toCharArray()) {
                set.add(letter);
            }
        }

        // 2.
        Map<Integer, Character> indexMap = new HashMap<>();
        Map<Character, Integer> charMap = new HashMap<>();

        int indx = 0;
        for(Character c : set) {
            indexMap.put(indx, c);
            charMap.put(c, indx);
            indx++;
        }

        // 3.
        int n = set.size();

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // 4.
        for(int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            boolean hasFoundDiff = false;
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if(c1 != c2) {
                    hasFoundDiff = true;
                    adjList.get(charMap.get(c1)).add(charMap.get(c2));
                    break;
                }
            }

            if(!hasFoundDiff && word1.length() > word2.length()) {
                return "";
            }
        }

        // 5.
        boolean[] visited = new boolean[adjList.size()];
        boolean[] pathVisited = new boolean[adjList.size()];
        String ans = "";

        for(int node = 0; node < adjList.size(); node++) {
            if(!visited[node]) {
                ans += dfs(node, visited, pathVisited, adjList, indexMap, charMap);
            }
        }

        if(ans.length() != set.size()) {
            return "";
        }

        return new StringBuilder(ans).reverse().toString();

    }

    public static String dfs(int node, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adjList, Map<Integer, Character> indexMap, Map<Character, Integer> charMap) {

        visited[node] = true;
        pathVisited[node] = true;

        String ans = "";
        for(int neighbor : adjList.get(node)) {
            if(!visited[neighbor]) {
                ans += dfs(neighbor, visited, pathVisited, adjList, indexMap, charMap);
            } else if (pathVisited[neighbor]) {
                return "";
            }
        }

        pathVisited[node] = false;
        return indexMap.get(node) + ans;

    }
}