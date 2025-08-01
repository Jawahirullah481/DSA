package datastructure.graph.problems;

import java.util.*;

public class Problem25WordLadder2 {

    /*
        Problem : Word Ladder 2

        To print all the shortest paths.

        NOTE : Why we remove from set level wise, instead of immediately after found it ?

        Answer:
        If two paths got separated, they might meet at the same word in the future in the same level
        but from different parent word.
        So to keep this merge or meet, we don't need to remove immediately.
     */

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        // 1.
        Set<String> set = new HashSet<>(wordList);

        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> firstList = new ArrayList<>();
        firstList.add(beginWord);
        queue.add(firstList);

        List<List<String>> ans = new ArrayList<>();
        boolean hasFound = false;

        while (!queue.isEmpty()) {

            int size = queue.size();
            Set<String> usedOnLevel = new HashSet<>();

            for (int i = 0; i < size; i++) {
                ArrayList<String> list = queue.poll();
                String word = list.get(list.size() - 1);

                if (word.equals(endWord)) {
                    ans.add(list);
                    hasFound = true;
                }

                if(hasFound) {
                    continue;
                }

                for (int j = 0; j < word.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {

                        if (word.charAt(j) == c) continue;

                        String nextWord = word.substring(0, j) + c + word.substring(j + 1);
                        if (set.contains(nextWord)) {
                            ArrayList<String> newList = new ArrayList<>(list);
                            newList.add(nextWord);
                            queue.add(newList);
                            usedOnLevel.add(nextWord);
                        }
                    }
                }
            }


            for(String usedWord : usedOnLevel) {
                set.remove(usedWord);
            }

            if(hasFound) {
                break;
            }

        }

        return ans;
    }
}
