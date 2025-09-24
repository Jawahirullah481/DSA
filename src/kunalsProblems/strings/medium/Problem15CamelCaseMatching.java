package kunalsProblems.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem15CamelCaseMatching {
    /*
        LeetCode No : 1023, Problem Link : https://leetcode.com/problems/camelcase-matching/description/
     */

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            res.add(matches(query, pattern));
        }
        return res;
    }

    private boolean matches(String query, String pattern) {
        int i = 0; // pointer for pattern
        for (int j = 0; j < query.length(); j++) {
            char qc = query.charAt(j);
            if (i < pattern.length() && qc == pattern.charAt(i)) {
                i++; // matched current pattern char
            } else if (Character.isUpperCase(qc)) {
                return false; // uppercase must match pattern
            }
        }
        return i == pattern.length(); // pattern fully matched
    }
}
