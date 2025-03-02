package datastructure.dp.problems;

import java.util.Arrays;

public class Problem28LCSPalindrome {
    public static void main(String[] args) {
        String s = "abcde";

        int solution = 0;
        String t = new StringBuffer(s).reverse().toString();

        // Recursion solution
        solution =lcsRecursion(s, t, 0, 0);

        // Memoization solution
        int[][] dp = new int[s.length()][t.length()];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        solution = lcsMemoization(s, t, 0, 0, dp);

        // Tabulation solution
        dp = new int[s.length()][t.length()];
        solution = lcsTabulation(s, t, dp);
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

    public static int lcsTabulation(String s, String t, int[][] dp) {
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < t.length(); j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = 1 + (((i - 1 >= 0 && j - 1 >= 0)) ? dp[i - 1][j - 1] : 0);
                } else {
                    int top = 0, left = 0;
                    if(i - 1 >= 0) {
                        top = dp[i - 1][j];
                    }

                    if(j - 1 >= 0) {
                        left = dp[i][j - 1];
                    }

                    dp[i][j] = Math.max(top, left);
                }
            }
        }

        return dp[s.length() - 1][t.length() - 1];
    }
}
