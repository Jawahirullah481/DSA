package datastructure.dp.problems;

import java.util.Arrays;

public class Problem22CoinChange {
    public static void main(String[] args) {

        int[] denominations = {1, 2, 3};
        int value = 4;

        int solution = 0;
        // Recursion solution
        solution = countCoinsRecursion(denominations, value, denominations.length - 1);

        // Memoization solution
        int[][] dp = new int[denominations.length][value + 1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        solution =  minElementsMemoization(denominations, value, denominations.length - 1, dp);

        // Tabulation solution
        dp = new int[denominations.length][value + 1];
        solution = minElementsTabulation(denominations, value, dp);
    }

    public static int countCoinsRecursion(int[] num, int x, int index) {

        if(x < 0) {
            return 0;
        }

        if(index < 0) {
            return x == 0 ? 1 : 0;
        }

        int notTake = countCoinsRecursion(num, x, index - 1);
        int take1 = countCoinsRecursion(num, x - num[index], index);

        return notTake + take1;
    }

    public static int minElementsMemoization(int[] num, int x, int index, int[][] dp) {

        if(x < 0) {
            return 0;
        }

        if(index < 0) {
            return x == 0 ? 1 : 0;
        }

        if(dp[index][x] != -1) {
            return dp[index][x];
        }

        int notTake = minElementsMemoization(num, x, index - 1, dp);
        int take1 = minElementsMemoization(num, x - num[index], index, dp);

        return dp[index][x] = notTake + take1;
    }

    public static int minElementsTabulation(int[] num, int x, int[][] dp) {
        for(int amount = 0; amount <= x; amount++) {
            if(amount % num[0] == 0) dp[0][amount] = 1;
        }

        for(int i = 1; i < num.length; i++) {
            for(int j = 0; j <= x; j++) {

                int notTake = dp[i - 1][j];
                int take = 0;
                if(j - num[i] >= 0)
                    take = dp[i][j - num[i]];

                dp[i][j] = notTake + take;
            }
        }

        return dp[num.length - 1][x];
    }
}
