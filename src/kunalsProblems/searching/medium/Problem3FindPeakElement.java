package kunalsProblems.searching.medium;

public class Problem3FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        // If start == end, then we can definitely say st = end = peak.
        while(start < end) {
            int mid = start + (end - start) / 2;
            // You can't say that "when start reaches the mid, then start is always equal to peak or start is the answer."
            // If start reaches the mid, then there will be 2 elements in the array or only 1 element in the array.
            // If end reaches the mid, then there will be only 1 element in the array.

            if(nums[mid] > nums[mid + 1]) {
                end = mid;
            }else {
                start = mid + 1;
            }

        }

        return start;
    }
}
