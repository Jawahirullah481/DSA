package datastructure.dp.problems;

import java.util.Arrays;

public class Problem34WildCardMatching {

    public static void main(String[] args) {

        String pattern = "ab*cd";
        String text = "abdefcd";

        boolean solution = false;

        // Recursion solution
        solution = matchRecursion(pattern, text, 0, 0);

        // Memoization solution
        int[][] dp = new int[pattern.length()][text.length() + 1];
        for(int[] row : dp) {
            Arrays.fill(row, - 1);
        }
        solution = matchMemoization(pattern, text, 0, 0, dp);
    }

    public static boolean matchRecursion(String pattern, String text, int pind, int tind) {
		/*
			1, if the char in pattern is '?', then just move fwd.
			2. if the char in pattern is any other letter, then check if both are same. if so return accordingly.
			3. if the char in pattern is '*', then either move fwd or stick to the same place.
		*/

        if(tind == text.length() && pind == pattern.length()) {
            return true;
        }

        if(tind == text.length()) {
            return pattern.charAt(pind) == '*' ? matchRecursion(pattern, text, pind + 1, tind) : false;
        }

        if(pind == pattern.length()) {
            return false;
        }

        if(pattern.charAt(pind) == '?') {
            return matchRecursion(pattern, text, pind + 1, tind + 1);
        }

        if(pattern.charAt(pind) == '*') {
            return matchRecursion(pattern, text, pind, tind + 1) || matchRecursion(pattern, text, pind + 1, tind);
        }

        return pattern.charAt(pind) == text.charAt(tind) && matchRecursion(pattern, text, pind + 1, tind + 1);
    }

    public static boolean matchMemoization(String pattern, String text, int pind, int tind, int[][] dp) {
		/*
			1, if the char in pattern is '?', then just move fwd.
			2. if the char in pattern is any other letter, then check if both are same. if so return accordingly.
			3. if the char in pattern is '*', then either move fwd or stick to the same place.
		*/

        if(tind == text.length() && pind == pattern.length()) {
            return true;
        }

        if(pind == pattern.length()) {
            return false;
        }

        if(dp[pind][tind] != -1) {
            return dp[pind][tind] == 1;
        }

        if(tind == text.length()) {
            boolean match = pattern.charAt(pind) == '*' ? matchMemoization(pattern, text, pind + 1, tind, dp) : false;
            dp[pind][tind] = match ? 1 : 0;
            return match;
        }

        if(pattern.charAt(pind) == '?') {
            boolean match = matchMemoization(pattern, text, pind + 1, tind + 1, dp);
            dp[pind][tind] = match ? 1 : 0;
            return match;
        }

        if(pattern.charAt(pind) == '*') {
            boolean match =  matchMemoization(pattern, text, pind, tind + 1, dp) || matchMemoization(pattern, text, pind + 1, tind, dp);
            dp[pind][tind] = match ? 1 : 0;
            return match;
        }

        boolean match =  pattern.charAt(pind) == text.charAt(tind) && matchMemoization(pattern, text, pind + 1, tind + 1, dp);
        dp[pind][tind] = match ? 1 : 0;
        return match;
    }

}
