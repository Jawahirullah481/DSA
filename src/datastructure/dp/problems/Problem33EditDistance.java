package datastructure.dp.problems;

import java.util.Arrays;

public class Problem33EditDistance {

    public static void main(String[] args) {

        String str1 = "abcdef";
        String str2 = "aceg";

        int solution = 0;

        // Recursion solution
        solution = lcsRecursion(str1, str2, 0, 0);

        // Memoization solution
        int[][] dp = new int[str1.length()][str2.length()];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        solution = lcsMemoization(str1, str2, 0, 0, dp);

        // Tabulation solution
        // NOTE : Here, we used length + 1 to handle exhausted base case in tabulation
        int[][] dp1 = new int[str1.length() + 1][str2.length() + 1];
        solution = lcsTabulation(str1, str2, dp1);
    }

    public static int lcsRecursion(String s1, String s2, int ind1, int ind2) {
        /*
            1. if insert, then move ind2 to one
            2. if delete, then move ind1 to one
            3. if replace, then move both to one
            4. if any of them reached the end, then count number of remaining letters to insert/delete
        */

        if(ind1 == s1.length() || ind2 == s2.length()) {
            return (s1.length() - ind1) + (s2.length() - ind2);
        }

        if(s1.charAt(ind1) == s2.charAt(ind2)) {
            return lcsRecursion(s1, s2, ind1 + 1, ind2 + 1);
        }

        int insert = 1 + lcsRecursion(s1, s2, ind1, ind2 + 1);
        int delete = 1 + lcsRecursion(s1, s2, ind1 + 1, ind2);
        int replace = 1 + lcsRecursion(s1, s2, ind1 + 1, ind2 + 1);

        return Math.min(insert, Math.min(delete, replace));
    }

    public static int lcsMemoization(String s1, String s2, int ind1, int ind2, int[][] dp) {
        /*
            If both characters are same, then there is no need to feel. You don't have to any operation on that element. You can just move forward.
            Otherwise, do any of following 4 operations :

            1. if insert, then move ind2 to one
            2. if delete, then move ind1 to one
            3. if replace, then move both to one
            4. if any of them reached the end, then count number of remaining letters to insert/delete
        */

        if(ind1 == s1.length() || ind2 == s2.length()) {
            return (s1.length() - ind1) + (s2.length() - ind2);
        }

        if(dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        if(s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = lcsMemoization(s1, s2, ind1 + 1, ind2 + 1, dp);
        }

        int insert = 1 + lcsMemoization(s1, s2, ind1, ind2 + 1, dp);
        int delete = 1 + lcsMemoization(s1, s2, ind1 + 1, ind2, dp);
        int replace = 1 + lcsMemoization(s1, s2, ind1 + 1, ind2 + 1, dp);

        return dp[ind1][ind2] = Math.min(insert, Math.min(delete, replace));
    }

    public static int lcsTabulation(String s1, String s2, int[][] dp) {
        for(int i = 0; i <= s2.length(); i++) {
            dp[0][i] = i;
        }

        for(int j = 0; j <= s1.length(); j++) {
            dp[j][0] = j;
        }

        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {

                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }

            }
        }

        return dp[s1.length()][s2.length()];
    }
}
