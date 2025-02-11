package datastructure.dp.problems;

import java.util.Arrays;

public class Problem18PartitionWithGivenDifference {
    public static void main(String[] args) {
        int n = 4;
        int d = 1;
        int[] arr = {1, 1, 2, 3};

        int solution = 0;

        int total = 0;
        for(int i : arr) {
            total += i;
        }

        // Recursion solution
        solution = countRecursion(n, d, arr, n - 1, 0, total);

        // Memoization solution
        int[][] dp = new int[n][total + 1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        if ((total - d) % 2 != 0) solution = 0;

        solution = countMemoization(n, d, arr, n - 1, 0, total, dp);
    }

    public static int countRecursion(int n, int d, int[] arr, int index, int sum, int total) {

        if(index < 0) {
            int num1 = sum;
            int num2 = total - sum;
            if(num1 >= num2 && num1 - num2 == d) {
                return 1;
            } else {
                return 0;
            }
        }

        int notTake = countRecursion(n, d, arr, index - 1, sum, total);
        int take = 0;
        if(index >= 0) {
            take = countRecursion(n, d, arr, index - 1, sum + arr[index], total);
        }

        return notTake + take;
    }

    public static int countMemoization(int n, int d, int[] arr, int index, int sum, int total, int[][] dp) {

        if(index < 0) {
            int num1 = sum;
            int num2 = total - sum;
            if(num1 >= num2 && num1 - num2 == d) {
                return 1;
            } else {
                return 0;
            }
        }

        if(dp[index][sum] != -1) {
            return dp[index][sum];
        }

        int notTake = countMemoization(n, d, arr, index - 1, sum, total, dp);
        int take = 0;
        if(index >= 0) {
            take = countMemoization(n, d, arr, index - 1, sum + arr[index], total, dp);
        }

        dp[index][sum] = (notTake + take);
        return dp[index][sum];
    }
}
