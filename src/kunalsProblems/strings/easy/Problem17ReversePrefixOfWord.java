package kunalsProblems.strings.easy;

public class Problem17ReversePrefixOfWord {
    /*
        LeetCode No : 2000, Problem Link : https://leetcode.com/problems/reverse-prefix-of-word/
     */

    public String reversePrefixManual(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx == -1) return word;

        char[] arr = word.toCharArray();

        // two-pointer reverse
        int left = 0, right = idx;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return new String(arr);
    }

    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);

        if (idx == -1) return word;

        return new StringBuilder(word.substring(0, idx + 1)).reverse().toString() + word.substring(idx + 1);
    }
}
