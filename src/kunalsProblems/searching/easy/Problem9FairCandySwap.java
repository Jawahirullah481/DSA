package kunalsProblems.searching.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem9FairCandySwap {

    /*
        LeetCode No : 888, Problem Link : https://leetcode.com/problems/fair-candy-swap/description/

        NOTE :
        # If Alice has more candies, then diff will be in negative.
        # So, when you do x - diff, it gives positive number and check for that number in the set.

        # If Alice has less candies, then diff will be in positive.
        # So, when you do x - diff, it also check for the positive difference available in the set or not.
     */

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceTotal = 0;
        int bobTotal = 0;

        for (int candy : aliceSizes) aliceTotal += candy;
        for (int candy : bobSizes) bobTotal += candy;

        int diff = (aliceTotal - bobTotal) / 2;

        Set<Integer> bobCandies = new HashSet<>();
        for (int candy : bobSizes) bobCandies.add(candy);

        for (int x : aliceSizes) {
            int y = x - diff; // what Bob should give
            if (bobCandies.contains(y)) {
                return new int[] {x, y};
            }
        }

        return new int[] {-1, -1}; // should never reach here
    }

}
