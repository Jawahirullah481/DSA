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

        In the above example, [1, 2, 3, 5] and k = 1,
        # At the end of the loop, end is pointing 3 (arr[2]) and st is pointing 5 (arr[3]).
        # So, the missing number is ,
            -> no.of.elements missing at index 2 is      => arr[2] - (2 + 1)
            -> no.of.elements are remaining to be missed => k - (arr[2] - (2 + 1))
            -> kth missing element                       => arr[2] + (k - (arr[2] + (2 + 1))
                                                         => arr[2] + k - arr[2] + (2 + 1)
                                                         => k + 2(end pointing to at last) + 1
                                                         => end + k + 1
                                                            (or)
                                                         => st = end + 1 => st + k
     */
    public int findKthPositiveOptimal(int[] arr, int k) {
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

    /*
        Intuition : Youtube link : https://youtu.be/uZ0N_hZpyps?si=ELh2l3Ouuw3kwZU5
     */
    public int findKthPositiveBetter(int[] arr, int k) {
        int num = k;
        int i = 0;

        while(i < arr.length && arr[i] <= num) {
            num++;
            i++;
        }

        return num;
    }
}
