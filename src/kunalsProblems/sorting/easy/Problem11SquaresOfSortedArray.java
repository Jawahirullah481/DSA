package kunalsProblems.sorting.easy;

public class Problem11SquaresOfSortedArray {

    /*
        LeetCode No : 977, Problem Link : https://leetcode.com/problems/squares-of-a-sorted-array/

        Intuition :
        ==========

        In the question itself, it is mentioned like below :
        "Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?"

        So, we cannot use that approach.

        * I first thought, comparing st and end, and swap the positions of bigger square element.
        * But, as it is sorted array, it will spoil the sorted nature.
        * So, we cannot do that.
        * So, I thought can i use O(n) extra space.
        * Yes. I can.
        * So, I used below approach.
     */

    public int[] sortedSquares(int[] nums) {

        int[] res = new int[nums.length];
        int st = 0, end = nums.length - 1;
        int i = res.length - 1;

        while(st <= end) {
            if(Math.abs(nums[st]) >= Math.abs(nums[end])) {
                res[i--] = nums[st] * nums[st];
                st++;
            } else {
                res[i--] = nums[end] * nums[end];
                end--;
            }
        }

        return res;

    }

}
