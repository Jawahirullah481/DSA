package datastructure.dp.problems;

import java.util.Arrays;

public class Problem6HouseRobber {

    public static void main(String[] args) {

        int[] valueInHouse = {0, 9, 1, 8, 2, 3, 6, 4, 5, 7};
        int solution = 0;

        // Recursion solution
        if(valueInHouse.length == 1) {
            solution = valueInHouse[0];
        } else {
            int[] excludeFirst = Arrays.copyOfRange(valueInHouse, 0, valueInHouse.length - 1);
            int[] excludeLast = Arrays.copyOfRange(valueInHouse, 1, valueInHouse.length);
            solution = Math.max(robCircularHousesRecursion(excludeFirst, excludeFirst.length - 1), robCircularHousesRecursion(excludeLast, excludeLast.length - 1));
        }

        System.out.println(solution);

        // Memoization Solution
        int[] dp1 = new int[valueInHouse.length];
        int[] dp2 = new int[valueInHouse.length];

        if(valueInHouse.length == 1) {
            solution = valueInHouse[0];
        } else {
            int[] excludeFirst = Arrays.copyOfRange(valueInHouse, 0, valueInHouse.length - 1);
            int[] excludeLast = Arrays.copyOfRange(valueInHouse, 1, valueInHouse.length);
            solution = Math.max(robCircularHousesMemoization(excludeFirst, excludeFirst.length - 1, dp1), robCircularHousesMemoization(excludeLast, excludeLast.length - 1, dp2));
        }


        System.out.println(solution);

    }

    public static int robCircularHousesRecursion(int[] valueInHouse, int index) {

        if(index == 0) {
            return valueInHouse[index];
        }

        if(index < 0) {
            return 0;
        }

        int theft = valueInHouse[index] + robCircularHousesRecursion(valueInHouse, index - 2);
        int notTheft = 0 + robCircularHousesRecursion(valueInHouse, index - 1);

        return Math.max(theft, notTheft);
    }

    public static int robCircularHousesMemoization(int[] valueInHouse, int index, int[] dp) {

        if(index == 0) {
            dp[index] = valueInHouse[index];
            return dp[index];
        }

        if(index < 0) {
            return 0;
        }

        int theft = valueInHouse[index] + robCircularHousesMemoization(valueInHouse, index - 2, dp);
        int notTheft = 0 + robCircularHousesMemoization(valueInHouse, index - 1, dp);

        dp[index] = Math.max(theft, notTheft);
        return dp[index];
    }

    public int robCircularHouseTabulation(int[] nums) {
        int n = nums.length;

        // Edge cases
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[] dp = new int[n];

        // Base cases
        dp[n - 1] = nums[n - 1]; // Only one house to rob
        dp[n - 2] = Math.max(nums[n - 2], nums[n - 1]); // Max of last two houses

        // Fill dp table from n-3 to 0
        for(int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}
