package kunalsProblems.arrays.easy;

public class Problem12MinCostToMoveChips {

    /*
        LeetCode No : 1217. Problem Link : https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/description/

        Problem Statement :
        ==================
        We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:

        position[i] + 2 or position[i] - 2 with cost = 0.
        position[i] + 1 or position[i] - 1 with cost = 1.

        Return the minimum cost needed to move all the chips to the same position.

        Intuition:
        ==========

        1. In this problem, we aim to minimize the total cost to move all chips to the same position.

        2. According to the problem:
           * Moving a chip by 2 units (i.e., from x to x+2 or x-2) costs 0.
           * Moving a chip by 1 unit (i.e., from x to x+1 or x-1) costs 1.

        3. This means:
           * All chips at even positions can be moved among each other at no cost.
           * All chips at odd positions can also be moved among each other at no cost.
           * But, moving a chip from an even position to an odd position (or vice versa) will cost 1 per chip, because a 1-step move will be required at some point.


          Examples to Understand the Behavior:
            ✅ Even to Even:
            Positions: 4 and 12

            Path: 4 → 6 → 8 → 10 → 12 (all moves are 2 units → 0 cost)

            ✅ Odd to Odd:
            Positions: 3 and 9

            Path: 3 → 5 → 7 → 9 (all moves are 2 units → 0 cost)

            ⚠️ Odd to Even:
            Positions: 3 and 8

            Path: 3 → 5 → 7 → 8

            3→5 and 5→7 cost 0

            7→8 is a 1-unit move → cost = 1

            ⚠️ Even to Odd:
            Positions: 2 and 5

            Path: 2 → 4 → 5

            2→4 is 2 units → 0 cost

            4→5 is 1 unit → cost = 1

        Final Conclusion:
        =================

        # To avoid cost, keep chips on the same parity (all even or all odd).
        # So, we only need to move chips from one parity to the other.
        # To minimize the cost:
            * We move the smaller group (odd or even) to the other side.
            * Each such move costs 1, so total cost = min(oddCount, evenCount).

     */

    public static void main(String[] args) {
        int[] position = {2,2,2,3,3};
        minCostToMoveChips(position);
    }

    public static int minCostToMoveChips(int[] position) {

        int oddCount = 0, evenCount = 0;

        for(int pos : position) {
            if(pos % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return (int)Math.min(oddCount, evenCount);
    }

}
