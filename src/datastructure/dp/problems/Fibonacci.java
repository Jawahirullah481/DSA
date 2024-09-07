package datastructure.dp.problems;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int ans = fibonacciRecursion(5);
        System.out.println(ans);

        int[] dp = new int[5 + 1];
        Arrays.fill(dp, -1);
        ans = fibonacciMemoization(5, dp);
        System.out.println(ans);

        ans = fibonacciTabulation(5);
        System.out.println(ans);

        ans = spaceOptimized(5);
        System.out.println(ans);
    }


    private static int fibonacciRecursion(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    private static int fibonacciMemoization(int n, int[] dp) {
        if(dp[n] != -1) {
            return dp[n];
        }

        if(n == 0 || n == 1) {
            dp[n] = n;
            return n;
        }

        dp[n] = fibonacciMemoization(n - 1, dp) + fibonacciMemoization(n - 2, dp);;
        return dp[n];
    }

    private static int fibonacciTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    private static int spaceOptimized(int n) {
        int first = 1;
        int second = 0;

        for(int i = 2; i <= n; i++) {
            int curr = first + second;
            second = first;
            first = curr;
        }

        return first;
    }
}
