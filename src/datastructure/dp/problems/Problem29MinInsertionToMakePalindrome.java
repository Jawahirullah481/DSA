package datastructure.dp.problems;

import java.util.Arrays;

public class Problem29MinInsertionToMakePalindrome {

    public static void main(String[] args) {
        String str = "abeb";
        String str2 = new StringBuffer(str).reverse().toString();

        int solution = 0;

        // Recursion solution
        int lcs = lcsRecursion(str, str2, 0, 0);
        solution = (str.length() - lcs);

        // Memoization solution
        int[][] dp = new int[str.length()][str.length()];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        lcs = lcsMemoization(str, str2, 0, 0, dp);
        solution = str.length() - lcs;

        // Tabulation solution
        lcs = lcsTabulation(str, str2, dp);
        solution = str.length() - lcs;
    }

    public static int lcsRecursion(String s, String t, int ind1, int ind2) {
        if(ind1 == s.length() || ind2 == t.length()) {
            return 0;
        }

        if(s.charAt(ind1) == t.charAt(ind2)) {
            return 1 + lcsRecursion(s, t, ind1 + 1, ind2 + 1);
        }

        int take1 = lcsRecursion(s, t, ind1 + 1, ind2);
        int take2 = lcsRecursion(s, t, ind1, ind2 + 1);

        return Math.max(take1, take2);
    }

    public static int lcsMemoization(String s, String t, int ind1, int ind2, int[][] dp) {
        if(ind1 == s.length() || ind2 == t.length()) {
            return 0;
        }

        if(dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        if(s.charAt(ind1) == t.charAt(ind2)) {
            return 1 + lcsMemoization(s, t, ind1 + 1, ind2 + 1, dp);
        }

        int take1 = lcsMemoization(s, t, ind1 + 1, ind2, dp);
        int take2 = lcsMemoization(s, t, ind1, ind2 + 1, dp);

        return dp[ind1][ind2] = Math.max(take1, take2);
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
