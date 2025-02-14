package datastructure.dp.problems;

import java.util.Arrays;

public class Problem26LongestSubstring {

    // NOTE : Using 3 states (3 params in function) will increase the space complexity. So, try to reduce it AMAP.

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abfce";

        int solution = 0;

        // Recursion solution

        // Memoization solution
        int n = str1.length(), m = str2.length();

        int[][][] dp = new int[n][m][Math.max(n, m)];
        for(int[][] matrix : dp) {
            for(int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
    }

    public static int lcsRecursion(String str1, String str2, int ind1, int ind2, int count) {
        // NOTE : If any of the strings runs out, then there will no more common substring found in rest of the strings. So, max count will be what we have upto now
        if(ind1 == str1.length() || ind2 == str2.length()) {
            return count;
        }

        // Current characters may be equal or not and also next characters may be equal or not.
        // If current characters are equal, then currentcount includes the current count and update itself based on result of next characters.
        // Suppose, if the characters are not equal, then currentcount will be what is the maximum count we have upto now is.
        int currentCount = count;

        if(str1.charAt(ind1) == str2.charAt(ind2)) {
            currentCount = lcsRecursion(str1, str2, ind1 + 1, ind2 + 1, count + 1);
        }

        // When you skip any of the character at the middle, you have to reset to 0. Because, it is substring, not subsequence.
        int skip1 = lcsRecursion(str1, str2, ind1, ind2 + 1, 0);
        int skip2 = lcsRecursion(str1, str2, ind1 + 1, ind2, 0);

        return Math.max(currentCount, Math.max(skip1, skip2));
    }

    public static int lcsMemoization(String str1, String str2, int ind1, int ind2, int count, int[][][] dp) {
        if(ind1 == str1.length() || ind2 == str2.length()) {
            return count;
        }

        if(dp[ind1][ind2][count] != -1) {
            return dp[ind1][ind2][count];
        }

        int currentCount = count;

        if(str1.charAt(ind1) == str2.charAt(ind2)) {
            currentCount = lcsMemoization(str1, str2, ind1 + 1, ind2 + 1, count + 1, dp);
        }

        int skip1 = lcsMemoization(str1, str2, ind1, ind2 + 1, 0, dp);
        int skip2 = lcsMemoization(str1, str2, ind1 + 1, ind2, 0, dp);

        return dp[ind1][ind2][count] = Math.max(currentCount, Math.max(skip1, skip2));
    }
}
