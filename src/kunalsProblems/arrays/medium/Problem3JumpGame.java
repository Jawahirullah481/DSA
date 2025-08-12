package kunalsProblems.arrays.medium;

public class Problem3JumpGame {
    /*
        LeetCode No : 55, Problem Link : https://leetcode.com/problems/jump-game/

        Intuition :
        ===========
        "Can I jump from this position i to a position that can 'already reach' the end?"

        In this solution, ptr always points to the latest element "which can reach the end".

     */

    public boolean canJump(int[] nums) {
        int ptr = nums.length - 1;

        for(int i = nums.length - 1; i >= 0; i--) {
            int dist = ptr - i;
            if(dist <= nums[i]) {
                ptr = i;
            }
        }

        return ptr == 0;
    }
}
