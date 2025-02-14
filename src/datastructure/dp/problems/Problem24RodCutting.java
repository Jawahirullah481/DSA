package datastructure.dp.problems;

import java.util.Arrays;

public class Problem24RodCutting {
    public static void main(String[] args) {
        int rodLength = 5;
        int[] price = {2, 5, 7, 8, 10};  // P

        int solution = 0;

        // Recursion solution
        solution = curRecursion(price, rodLength, rodLength);

        // Memoization solution
        int[][] dp = new int[rodLength + 1][rodLength + 1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        solution = curMemoization(price, rodLength, rodLength, dp);

    }

    // NOTE : The task is to cut all the length
    public static int curRecursion(int price[], int rodLength, int pieceLength) {
        // Suppose, you cut all the length(which means n is 0 or -ve), then at current piece you can't cut any more length(nothing left) and don't earn any profit
        if(rodLength <= 0) {
            return 0;
        }

        // Suppose, still there are remaining length available, and you run out of pieces, then you failed to cut all the length and the profit you have doesn't taken into account
        if(pieceLength == 0) {
            return Integer.MIN_VALUE;
        }

        int notTake = curRecursion(price, rodLength, pieceLength - 1);
        int take = 0;
        if(rodLength >= pieceLength) {
            take = price[pieceLength - 1] + curRecursion(price, rodLength - pieceLength, pieceLength);
        }

        return Math.max(take, notTake);
    }

    public static int curMemoization(int price[], int rodLength, int pieceLength, int[][] dp) {
        if(rodLength <= 0) {
            return 0;
        }

        if(pieceLength == 0) {
            return Integer.MIN_VALUE;
        }

        if(dp[rodLength][pieceLength] != -1) {
            return dp[rodLength][pieceLength];
        }

        int notTake = curMemoization(price, rodLength, pieceLength - 1, dp);
        int take = 0;
        if(rodLength >= pieceLength) {
            take = price[pieceLength - 1] + curMemoization(price, rodLength - pieceLength, pieceLength, dp);
        }

        return dp[rodLength][pieceLength] = Math.max(take, notTake);
    }
}
