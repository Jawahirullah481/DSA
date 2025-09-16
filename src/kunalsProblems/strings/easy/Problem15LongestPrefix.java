package kunalsProblems.strings.easy;

public class Problem15LongestPrefix {

    /*
        LeetCode No : 14, Problem Link : https://leetcode.com/problems/longest-common-prefix/

        NOTE :
        ======

        Solution 1 is accepted in leetcode. But,
        Solution 2 is expected by the interviewers.
     */

    public String longestCommonPrefixSolution1(String[] strs) {
        String smaller = strs[0];
        for(String str : strs) {
            if(str.length() < smaller.length()) {
                smaller = str;
            }
        }

        while(smaller.length() > 0) {
            boolean isCommon = checkCommon(strs, smaller);
            if(isCommon) {
                break;
            } else {
                smaller = smaller.substring(0, smaller.length() - 1);
            }
        }

        return smaller;
    }

    private boolean checkCommon(String[] strs, String prefix) {
        for(String str : strs) {
            if(!str.startsWith(prefix)) {
                return false;
            }
        }

        return true;
    }

    public String longestCommonPrefixSolution2(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                // Out of bounds OR mismatch → stop here
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];  // all characters matched
    }
}
