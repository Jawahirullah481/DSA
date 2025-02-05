package datastructure.dp.problems;

import java.util.Arrays;

public class Problem1Fibonacci {

    public static void main(String[] args) {

        int n = 120;
        int solution = 0;

        // Recursion Solution
        //solution = findFibonacci(n);

        // Memoization Solution
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        solution = findFibonacciMemoization(n, dp);


        System.out.println(solution);
    }

    public static int findFibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        return findFibonacci(n - 1) + findFibonacci(n - 2);
    }

    public static int findFibonacciMemoization(int n, int[] dp) {
        if(n <= 1) {
            dp[n] = n;
            return dp[n];
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        dp[n] = findFibonacciMemoization(n - 1, dp) + findFibonacciMemoization(n - 2, dp);
        return dp[n];
    }

}


