package datastructure.dp.problems;

import java.util.Arrays;

public class Problem20MinimumElements {
    // Problem Link : https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbmx5V2dIS2RfWWxNQjhpdEhkTzNTa2p2N3J6QXxBQ3Jtc0tsVk9pSDR3aXJWWml5OVI5X1V5RDlUTFBFN3k4SElDNGNXd1ZVQW1CUlp6QXRzVXpiWDZFV3NYY290VnY2WHd6dDRwanRqb01iNnVTZjhLbEYwc19jSTR2YjJVWTFYLXJsazRYdnVYdFlpZFZTdnE3UQ&q=https%3A%2F%2Fbit.ly%2F3HJTeIl&v=myPeWb3Y68A

    public static void main(String[] args) {

        int[] num = {1, 2, 3};
        int x = 5;

        int solution = 0;

        // Recursion solution
        solution = minElementsRecursion(num, x, num.length - 1);
        solution = solution == Integer.MAX_VALUE ? -1 : solution;

        // Memoization Solution
        int[][] dp = new int[num.length][x + 1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        solution = minElementsMemoization(num, x, num.length - 1, dp);
        solution = solution == Integer.MAX_VALUE ? -1 : solution;
    }



    public static int minElementsRecursion(int[] num, int x, int index) {

        if(x == 0) {
            return 0;
        }

        if(index < 0 || x < 0) {
            return Integer.MAX_VALUE;
        }

        int notTake = minElementsRecursion(num, x, index - 1);
        int take1 = 1 + minElementsRecursion(num, x - num[index], index - 1);
        int take2 = 1 + minElementsRecursion(num, x - num[index], index);

        return Math.min(notTake, Math.min(take1, take2));
    }

    public static int minElementsMemoization(int[] num, int x, int index, int[][] dp) {

        if(x == 0) {
            return 0;
        }

        if(index < 0 || x < 0) {
            return (int)Math.pow(10, 9);
        }

        if(dp[index][x] != -1) {
            return dp[index][x];
        }

        int notTake = minElementsMemoization(num, x, index - 1, dp);
        int take1 = 1 + minElementsMemoization(num, x - num[index], index - 1, dp);
        int take2 = 1 + minElementsMemoization(num, x - num[index], index, dp);

        return dp[index][x] = Math.min(notTake, Math.min(take1, take2));
    }
}
