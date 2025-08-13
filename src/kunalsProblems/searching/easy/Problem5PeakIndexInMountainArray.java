package kunalsProblems.searching.easy;

public class Problem5PeakIndexInMountainArray {

    /*
        LeetCode No : 852, Problem Link : https://leetcode.com/problems/peak-index-in-a-mountain-array/
     */

    public int peakIndexInMountainArray1(int[] arr) {
        int st = 0, end = arr.length - 1;

        while (st < end) { // note: no <=
            int mid = st + (end - st) / 2;

            if (arr[mid] < arr[mid + 1]) {
                st = mid + 1; // go right
            } else {
                end = mid; // go left (mid could be peak)
            }
        }

        return st; // or end, both point to peak
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int st = 0, end = arr.length - 1;

        while(st <= end) {
            int mid = st + (end - st) / 2;

            if(mid - 1 >= 0 && mid + 1 < arr.length && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if(mid - 1 < 0 || arr[mid] > arr[mid - 1]) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

}
