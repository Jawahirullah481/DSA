package practice;

public class CountWaysToClimb {
    /*
        Problem Statement :
        ===================
        Count Number of Ways to Climb Stairs

        You can climb 1 or 2 steps at a time. Find the number of ways to reach the top of a staircase with N steps.

        Example:

        Input: N = 3
        Output: 3 (ways are: 1+1+1, 1+2, 2+1)
     */

    public static void main(String[] args) {

        int pos = 0;
        int N = 10;

        int totalWays = getWays(pos, N);
        System.out.println("TOTAL WAYS : " + totalWays);

    }

    public static int getWays(int pos, int n) {
        if(pos == n) {
            return 1;
        }

        if(pos > n) {
            return 0;
        }

        int oneStep = getWays(pos + 1, n);
        int twoStep = getWays(pos + 2, n);

        return oneStep + twoStep;
    }
}
