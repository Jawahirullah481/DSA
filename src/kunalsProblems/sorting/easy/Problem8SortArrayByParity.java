package kunalsProblems.sorting.easy;

public class Problem8SortArrayByParity {

    /*
        LeetCode No : 905, Problem Link : https://leetcode.com/problems/sort-array-by-parity/

        The "Ok" solution is Ok. But Better solution is more clean.
     */

    public int[] sortArrayByParityBetter(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            if (nums[left] % 2 == 0) left++;
            if (nums[right] % 2 == 1) right--;
        }

        return nums;
    }

    public int[] sortArrayByParityOk(int[] nums) {
        int oddPtr = 0, evenPtr = 0;

        while(oddPtr < nums.length && evenPtr < nums.length) {

            if(nums[oddPtr] % 2 == 1 && nums[evenPtr] % 2 == 0) {
                if(oddPtr < evenPtr) {
                    int temp = nums[evenPtr];
                    nums[evenPtr] = nums[oddPtr];
                    nums[oddPtr] = temp;
                    oddPtr++;
                    evenPtr++;
                } else {
                    evenPtr++;
                }

            } else {
                if(nums[oddPtr] % 2 != 1) {
                    oddPtr++;
                }
                if(nums[evenPtr] % 2 != 0) {
                    evenPtr++;
                }
            }
        }

        return nums;
    }
}
