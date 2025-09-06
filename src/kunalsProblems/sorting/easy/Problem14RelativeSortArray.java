package kunalsProblems.sorting.easy;

public class Problem14RelativeSortArray {

    /*
        LeetCode No : 1122, Problem Link : https://leetcode.com/problems/relative-sort-array/description/

        NOTE : Whenever you want to solve the problem like check for the availability and filling up with that, try to do count sort.
     */

    public int[] relativeSortArrayOptimal(int[] arr1, int[] arr2) {

        int[] count = new int[1001];
        for(int num : arr1) {
            count[num]++;
        }

        int k = 0;

        // Place numbers in the order of arr2
        for(int i = 0; i < arr2.length; i++) {
            int presence = count[arr2[i]];
            for(int j = 0; j < presence; j++) {
                arr1[k++] = arr2[i];
                count[arr2[i]]--;
            }
        }

        // Place remaining numbers sorted naturally
        for(int j = 0; j < count.length; j++) {
            for(int x = 0; x < count[j]; x++) {
                arr1[k++] = j;
            }
        }

        return arr1;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int k = 0;

        for (int j = 0; j < arr2.length; j++) {

            int i = k;

            while (i < arr1.length) {
                int num = arr2[j];

                while (i < arr1.length && arr1[i] != num) {
                    i++;
                }

                if (i < arr1.length) {
                    int temp = arr1[i];
                    arr1[i] = arr1[k];
                    arr1[k] = temp;
                    k++;
                    i++;
                }
            }
        }

        if (k < arr1.length) {
            sort(arr1, k);
        }

        return arr1;
    }

    private void sort(int[] arr, int st) {
        for (int i = st; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
