package datastructure.dp.problems;

import java.util.Arrays;

public class Problem25LongestCommonSubsequence {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "abcd";

        int solution = 0;

        // Recursion solution
        solution =lcsRecursion(s, t, 0, 0);

        // Memoization solution
        int[][] dp = new int[s.length()][t.length()];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        solution = lcsMemoization(s, t, 0, 0, dp);
    }

    public static int lcsRecursion(String s, String t, int ind1, int ind2) {

        // If any of the index traversed the whole array, then no more elements left
        // Which means, no more common subsequence found in the array
        if (ind1 == s.length() || ind2 == t.length()) {
            return 0;
        }

        if (s.charAt(ind1) == t.charAt(ind2)) {
            return 1 + lcsRecursion(s, t, ind1 + 1, ind2 + 1);
        }

        return Math.max(lcsRecursion(s, t, ind1 + 1, ind2),
                lcsRecursion(s, t, ind1, ind2 + 1));
    }

    public static int lcsMemoization(String s, String t, int ind1, int ind2, int[][] dp) {
        if (ind1 == s.length() || ind2 == t.length()) {
            return 0;
        }

        if(dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        if (s.charAt(ind1) == t.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + lcsMemoization(s, t, ind1 + 1, ind2 + 1, dp);
        }

        return dp[ind1][ind2] = Math.max(lcsMemoization(s, t, ind1 + 1, ind2, dp),
                lcsMemoization(s, t, ind1, ind2 + 1, dp));
    }
}
