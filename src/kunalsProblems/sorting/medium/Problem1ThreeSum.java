package kunalsProblems.sorting.medium;

import java.util.*;

public class Problem1ThreeSum {

    /*
        LeetCode No : 15, Problem Link : https://leetcode.com/problems/3sum/description/

        Youtube Link : https://youtu.be/DhFh8Kw7ymk?si=YlOi56-7DKc9AHMe
     */

    public List<List<Integer>> threeSumOptimal(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int st = i + 1, end = nums.length - 1;
            while (st < end) {
                int sum = nums[i] + nums[st] + nums[end];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[st], nums[end]));

                    // Skip duplicates for st and end
                    while (st < end && nums[st] == nums[st + 1]) st++;
                    while (st < end && nums[end] == nums[end - 1]) end--;

                    st++;
                    end--;
                } else if (sum > 0) {
                    end--;
                } else {
                    st++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSumBetter(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                int sum = nums[i] + nums[j];
                int rem = -sum;

                if(map.containsKey(rem)) {
                    int idx = map.get(rem);
                    if(idx > i && idx > j) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[idx]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }

        for(List<Integer> list : set) {
            ans.add(list);
        }

        return ans;
    }
}
