package kunalsProblems.strings.medium;

public class Problem4SentenceSimilarity {

    /*
        LeetCode No : 1813, Problem Link : https://leetcode.com/problems/sentence-similarity-iii/
     */

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");

        int ptr = 0;
        while(ptr < arr1.length && ptr < arr2.length) {
            if(!arr1[ptr].equals(arr2[ptr])) break;

            ptr++;
        }

        int a = arr1.length - 1;
        int b = arr2.length - 1;

        while(a >= ptr && b >= ptr) {
            if(!arr1[a].equals(arr2[b])) return false;

            a--; b--;
        }

        return true;
    }
}
