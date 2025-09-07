package kunalsProblems.sorting.easy;

public class Problem18MaxProductOfTwoNums {

    /*
        LeetCode No : 1464, Problem Link :  https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/
     */

    public int maxProduct(int[] nums) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for(int num : nums) {
            if(num >= first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }

        return (first - 1) * (second - 1);
    }
}
