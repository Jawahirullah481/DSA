package practice;

public class binarysearch1 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        System.out.println(ceil(arr, 17));
    }

    static int ceil(int[] arr, int target) {

        if(target > arr[arr.length - 1]) {
            return -1;
        }

        int ceil = arr.length - 1;
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) {
                return mid;
            } else {
                int difference = arr[mid] - target;
                int prevDifference = arr[ceil] - target;
                if(difference > 0 && difference < prevDifference) {
                    ceil = mid;
                }
            }

            if(arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ceil;
    }

}
