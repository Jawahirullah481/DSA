package practice;

public class FindInInfiniteArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8, 9, 10};
        int target = 4;
        System.out.println(find(arr, 5));
    }

    static int find(int[] arr, int target) {
        int start = 0, end = 1;
        while(arr[end] < target) {
            int oldStart = start;
            start = end + 1;
            // As we are incrementing end 2 times for every iteration, it will take logn to react target
            end = end + ((end - oldStart + 1) * 2);
        }

        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
