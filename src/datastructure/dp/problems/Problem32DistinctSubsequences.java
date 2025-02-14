package datastructure.dp.problems;

import java.util.Arrays;

public class Problem32DistinctSubsequences {

    public static void main(String[] args) {
        String str = "rabbbit";
        String sub = "rabbit";

        int solution = 0;

        // Recursion solution
        solution = distinctSubSeqRecursion(str, sub, 0, 0);

        // Memoization solution
        int[][] dp = new int[str.length()][sub.length()];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        solution = distinctSubSeqMemoization(str, sub, 0, 0, dp);
    }

    public static int distinctSubSeqRecursion(String str, String sub, int ind1, int ind2) {

        if(ind2 == sub.length()) return 1;
        if(ind1 == str.length()) return 0;

        int common = 0;
        if(str.charAt(ind1) == sub.charAt(ind2)) {
            common = distinctSubSeqRecursion(str, sub, ind1 + 1, ind2 + 1);
        }

        int notCommon = distinctSubSeqRecursion(str, sub, ind1 + 1, ind2);
        return common + notCommon;

    }

    public static int distinctSubSeqMemoization(String str, String sub, int ind1, int ind2, int[][] dp) {

        if(ind2 == sub.length()) return 1;
        if(ind1 == str.length()) return 0;

        if(dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        int common = 0;
        if(str.charAt(ind1) == sub.charAt(ind2)) {
            common = distinctSubSeqMemoization(str, sub, ind1 + 1, ind2 + 1, dp);
        }

        int notCommon = distinctSubSeqMemoization(str, sub, ind1 + 1, ind2, dp);
        return dp[ind1][ind2] = common + notCommon;

    }
}
