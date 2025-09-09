package kunalsProblems.sorting.medium;

import java.util.Arrays;

public class Problem2ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int ans = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) continue;

            int st = i + 1, end = nums.length - 1;
            while(st < end) {
                int sum = nums[i] + nums[st] + nums[end];
                int diff = Math.abs(target - sum);
                if(diff < minDiff) {
                    ans = sum;
                    minDiff = diff;
                }

                if(sum == target) break;

                if(sum > target) {
                    end--;
                } else {
                    st++;
                }
            }
        }

        return ans;
    }
}
