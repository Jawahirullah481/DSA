package kunalsProblems.searching.easy;

public class Problem3KthMissingNumber {
    /*
        LeetCode No : 1539, Problem Link : https://leetcode.com/problems/kth-missing-positive-number/description/

        Intuition :
        ==========

        Why left + k ?

        1. When the array is empty, then kth missing number is k.
        2. When the array with no missing numbers, then kth missing number is arr.length(where the missing number would be) + k
        3. When the array is [1, 2, 3, 5] and the k is 1, then, kth missing number is 3 + 1 = 4. Because, 5's index is 3. 5 is the one where number of missing elements are >= k.
     */
    public int findKthPositive(int[] arr, int k) {
        int st = 0, end = arr.length - 1;

        while(st <= end) {
            int mid = st + (end - st) / 2;
            int missing = arr[mid] - (mid + 1);

            if(missing < k) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return st + k;
    }
}
