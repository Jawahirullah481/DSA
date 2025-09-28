package kunalsProblems.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem16PrintVertically {
    /*
        LeetCode No : 1324, Problem Link : https://leetcode.com/problems/print-words-vertically/description/
     */

    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLen = 0;
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (i < word.length()) {
                    sb.append(word.charAt(i));
                } else {
                    sb.append(' ');
                }
            }
            // remove trailing spaces
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            ans.add(sb.toString());
        }
        return ans;
    }

}
