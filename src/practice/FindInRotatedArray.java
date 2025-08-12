package practice;

public class FindInRotatedArray {

    public static void main(String[] args) {
        FindInRotatedArray obj = new FindInRotatedArray();
        int[] nums = {4,5,6,7,8,1,2,3};
        nums = new int[]{3, 1};
        System.out.println(obj.search(nums, 8));
    }

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        System.out.println("Pivot is : " + pivot);
        int targetPosition = binarySearch(nums, 0, pivot, target);
        if(targetPosition == -1) {
            targetPosition = binarySearch(nums, pivot + 1, nums.length - 1, target);
        }
        return targetPosition;
    }

    int findPivot(int[] nums) {
        // Check contition : next element of pivot is lesser
        // We don't work after find pivot. So, while(start < end)
        // In rotated, array all the elements before pivot are greater than elements after pivot.
        // So, if nums[mid] > nums[start], we have to shrink start
        // Else, we have to shrink end

        int left = 0, right = nums.length - 1;

        // If the array is not rotated
        if (nums[left] <= nums[right]) {
            return left;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is pivot
            if (mid < right && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            // Check if mid-1 is pivot
            if (mid > left && nums[mid] < nums[mid - 1]) {
                return mid;
            }

            // Decide which half to search
            if (nums[mid] >= nums[left]) {
                left = mid + 1; // Pivot is in right half
            } else {
                right = mid - 1; // Pivot is in left half
            }
        }

        return -1; // Should not happen if array is rotated
    }

    int binarySearch(int[] nums, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

}
