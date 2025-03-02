package datastructure.dp.problems;

import java.util.Arrays;

public class Problem31ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String a = "brute";
        String b = "groot";

        String solution = shortSsRecursion(a, b, 0, 0);

        String[][] dp = new String[a.length()][b.length()];
        for(String[] row: dp) {
            Arrays.fill(row, null);
        }

        solution = shortSsMemoization(a, b, 0, 0, dp);

        // Tabulation solution
        int[][] dp1 = new int[a.length()][b.length()];
        solution = shortSsTabulation(a, b, dp1);
    }

    public static String shortSsRecursion(String a, String b, int ind1, int ind2) {
        if(ind1 == a.length() || ind2 == b.length()) {
            if(ind1 < a.length()) {
                return a.substring(ind1);
            } else if(ind2 < b.length()) {
                return b.substring(ind2);
            } else {
                return "";
            }
        }

        if(a.charAt(ind1) == b.charAt(ind2)) {
            return a.charAt(ind1) + shortSsRecursion(a, b, ind1 + 1, ind2 + 1);
        }

        String take1 = a.charAt(ind1) + shortSsRecursion(a, b, ind1 + 1, ind2);
        String take2 = b.charAt(ind2) + shortSsRecursion(a, b, ind1, ind2 + 1);

        return take1.length() < take2.length() ? take2 : take1;
    }

    public static String shortSsMemoization(String a, String b, int ind1, int ind2, String[][] dp) {
        if(ind1 == a.length() || ind2 == b.length()) {
            if(ind1 < a.length()) {
                return a.substring(ind1);
            } else if(ind2 < b.length()) {
                return b.substring(ind2);
            } else {
                return "";
            }
        }

        if(dp[ind1][ind2] != null) {
            return dp[ind1][ind2];
        }

        if(a.charAt(ind1) == b.charAt(ind2)) {
            return a.charAt(ind1) + shortSsMemoization(a, b, ind1 + 1, ind2 + 1, dp);
        }

        String take1 = a.charAt(ind1) + shortSsMemoization(a, b, ind1 + 1, ind2, dp);
        String take2 = b.charAt(ind2) + shortSsMemoization(a, b, ind1, ind2 + 1, dp);

        return dp[ind1][ind2] = take1.length() < take2.length() ? take1 : take2;
    }

    public static String shortSsTabulation(String a, String b, int[][] dp) {
        for(int i = 0; i < a.length(); i++) {
            for(int j = 0; j < b.length(); j++) {
                int top = 0, left = 0, diagonal = 0;
                if(i - 1 >= 0) top = dp[i - 1][j];
                if(j - 1 >= 0) left = dp[i][j - 1];
                if(i - 1 >= 0 && j - 1 >= 0) diagonal = dp[i - 1][j - 1];

                if(a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = 1 + diagonal;
                } else if(top > left) {
                    dp[i][j] = top;
                } else {
                    dp[i][j] = left;
                }
            }
        }

        // Getting the string out of dp
        int i = dp.length - 1, j = dp[0].length - 1;
        String str = "";

        while(i >= 0 && j >= 0) {
            int top = 0, left = 0, diagonal = 0;
            if(i - 1 >= 0) top = dp[i - 1][j];
            if(j - 1 >= 0) left = dp[i][j - 1];
            if(i - 1 >= 0 && j - 1 >= 0) diagonal = dp[i - 1][j - 1];

            if(a.charAt(i) == b.charAt(j)) {
                str += a.charAt(i);
                i--; j--;
            } else if(top > left) {
                str += a.charAt(i);
                i--;
            } else {
                str += b.charAt(j);
                j--;
            }
        }

        while(i >= 0) {
            str += a.charAt(i);
            i--;
        }

        while(j >= 0) {
            str += b.charAt(j);
            j--;
        }

        return new StringBuffer(str).reverse().toString();
    }
}
