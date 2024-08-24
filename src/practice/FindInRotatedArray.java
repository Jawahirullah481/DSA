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

        int start = 0;
        int end = nums.length - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[start] == nums[mid]) {
                if(nums[start] < nums[start + 1]) {
                    start = start + 1;
                } else {
                    end = mid;
                }
            }
            if(nums[start] < nums[mid]) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        return start;
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
