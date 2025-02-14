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
}
