package kunalsProblems.sorting.medium;

public class Problem5SortColors {

    /*
        LeetCode No : 75, Problem Link : https://leetcode.com/problems/sort-colors/description/
     */

    public void sortColors(int[] nums) {
        int i = sort(nums, 0, 0);
        sort(nums, 1, i);
    }

    public static int sort(int[] arr, int searchNo, int st) {
        int i = st;
        int j = 0;

        while(i < arr.length && j < arr.length) {
            // Iterate i until it finds next non zero(search) number
            while(i < arr.length && arr[i] == searchNo) {
                i++;
            }
            j = i + 1;

            // Iterate j until it finds next search number
            while(j < arr.length && arr[j] != searchNo) {
                j++;
            }

            if(j < arr.length) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        return i;
    }
}
