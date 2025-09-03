import java.util.*;

class Temp {

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        int st = 0, end = 0;

        // 1.
        for (end = st; end <= 3; end++) {
            sum += nums[end];
        }
        end--;

        if (sum == target) {
            ans.add(addList(nums, st, end));
        }

        while (end + 1 < nums.length) {

            sum -= nums[st];
            st++;
            end++;
            sum += nums[end];

            if (sum == target && nums[st - 1] != nums[end]) {
                ans.add(addList(nums, st, end));
            }
        }

        return ans;
    }

    private static List<Integer> addList(int[] arr, int st, int end) {
        List<Integer> list = new ArrayList<>();

        for (int i = st; i <= end; i++) {
            list.add(arr[i]);
        }

        return list;
    }
}