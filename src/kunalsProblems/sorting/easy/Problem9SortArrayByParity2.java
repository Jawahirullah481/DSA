package kunalsProblems.sorting.easy;

public class Problem9SortArrayByParity2 {
    /*
        LeetCode No : 922, Problem Link : https://leetcode.com/problems/sort-array-by-parity-ii/description/

        Intuition :
        ===========

        # In the Optimal Solution, i always points to the even number at the even position.
        # j always points to the odd number at the odd position.
        # When i sees the odd number at the even position it stops.
        # When j sees the even number at the odd position it stops.
        # Then both will be swapped and positioned correctly.

     */

    public int[] sortArrayByParityIIOptimal(int[] nums) {

        int i = 0, j = 1;

        while(i < nums.length && j < nums.length) {
            while(i < nums.length && nums[i] % 2 == 0) {
                i += 2;
            }

            while(j < nums.length && nums[j] % 2 == 1) {
                j += 2;
            }

            if(i < nums.length && j < nums.length) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return nums;

    }

    public int[] sortArrayByParityII(int[] nums) {
        int i = 0, j = 0, k = 0;
        int[] ans = new int[nums.length];

        while(i < nums.length && j < nums.length) {
            // Want to increment i, until it reaches even number
            if(nums[i] % 2 != 0) i++;

            // Want to increment j, until it reaches odd number
            if(nums[j] % 2 != 1) j++;

            if(nums[i] % 2 == 0 && nums[j] % 2 == 1) {
                ans[k++] = nums[i++];
                ans[k++] = nums[j++];
            }
        }

        return ans;
    }
}
