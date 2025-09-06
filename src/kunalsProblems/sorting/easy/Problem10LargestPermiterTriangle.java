package kunalsProblems.sorting.easy;

import java.util.Arrays;

public class Problem10LargestPermiterTriangle {

    /*
        LeetCode No : 976, Problem Link : https://leetcode.com/problems/largest-perimeter-triangle/description/

        Intution :
        =========

        Rule for Sides to form a triangle :
        Let a, b and c are the sides of the triangle, then they have to be
            # a + b > c and a + c > b and b + c > a.
            # Sum of any 2 sides has to be greater than 3rd side.

        * In this problem, we need the largest perimeter.
        * So, We sort the array. And it ensures, i <= j and j <= k and i <= k
        * If, i + j > k, then i can surely say, j + k > i and i + k > j.
        * So, if i + j > k satisfies, then i can sure that j + k always greater than i and i + k always greater than j.
        * If it fails, then it cannot form a triangle.
     */

    class Solution {
        public int largestPerimeter(int[] nums) {
            Arrays.sort(nums);

            int n = nums.length;
            int i = n - 3, j = n - 2, k = n - 1;

            while(i >= 0) {
                if(nums[i] + nums[j] > nums[k]) {
                    return nums[i] + nums[j] + nums[k];
                }
                i--; j--; k--;
            }

            return 0;
        }
    }

}
