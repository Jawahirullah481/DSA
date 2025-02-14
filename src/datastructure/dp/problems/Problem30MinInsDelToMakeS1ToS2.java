package datastructure.dp.problems;

import java.util.Arrays;

public class Problem30MinInsDelToMakeS1ToS2 {
    public static void main(String[] args) {

        String s1 = "";
        String s2 = "";

        int solution = 0;

        // Recursion solution
        int n = s1.length(), m = s2.length();
        int lcs = lcs(s1, s2, 0, 0);

        // Memoization solution
        int[][] dp = new int[n][m];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        lcs = lcsMemoization(s1, s2, 0, 0, dp);

        solution = (n - lcs) + (m - lcs);

    }

    public static int lcs(String s1, String s2, int ind1, int ind2) {
        if(ind1 == s1.length() || ind2 == s2.length()) {
            return 0;
        }

        if(s1.charAt(ind1) == s2.charAt(ind2)) {
            return 1 + lcs(s1, s2, ind1 + 1, ind2 + 1);
        }

        int skip1 = lcs(s1, s2, ind1 + 1, ind2);
        int skip2 = lcs(s1, s2, ind1, ind2 + 1);

        return Math.max(skip1, skip2);
    }

    public static int lcsMemoization(String s1, String s2, int ind1, int ind2, int[][] dp) {
        if(ind1 == s1.length() || ind2 == s2.length()) {
            return 0;
        }

        if(dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        if(s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + lcsMemoization(s1, s2, ind1 + 1, ind2 + 1, dp);
        }

        int skip1 = lcsMemoization(s1, s2, ind1 + 1, ind2, dp);
        int skip2 = lcsMemoization(s1, s2, ind1, ind2 + 1, dp);

        return dp[ind1][ind2] = Math.max(skip1, skip2);
    }
}
