package datastructure.graph.problems;

import java.util.*;

public class Problem24WordLadder1 {

    /*
        NOTE :
        ======

        In this problem, we are creating new Set and then remove and also check the availability of string in that set.
        Because,

        List.contains() and List.remove() -> O(n)
        Set.contains() and Set.remove()   -> O(1)
     */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 1.
        int level = 1;

        // 2.
        Set<String> set = new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }

        // 3.
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!queue.isEmpty()) {

            Pair pair = queue.poll();
            String word = pair.str;

            if(word.equals(endWord)) {
                return pair.level;
            }

            for(int i = 0; i < word.length(); i++) {
                for(char c = 'a'; c <= 'z'; c++) {
                    String nextWord = word.substring(0, i) + c + word.substring(i + 1);
                    if(set.contains(nextWord)) {
                        queue.add(new Pair(nextWord, pair.level + 1));
                        set.remove(nextWord);
                    }
                }
            }
        }

        return 0;

    }

    class Pair {
        String str;
        int level;

        public Pair(String str, int level) {
            this.str = str;
            this.level = level;
        }
    }
}
