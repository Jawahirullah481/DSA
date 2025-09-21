package kunalsProblems.strings.medium;

public class Problem7NextGreaterNumber {

    /*
        LeetCode No : 556, Problem Link : https://leetcode.com/problems/next-greater-element-iii/
     */

    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int pos = arr.length - 2;

        // Step 1: find dip
        while (pos >= 0 && arr[pos] >= arr[pos + 1]) {
            pos--;
        }
        if (pos < 0) return -1;

        // Step 2: find the smallest digit greater than arr[pos]
        int minPos = arr.length - 1;
        while (arr[minPos] <= arr[pos]) {
            minPos--;
        }

        // Step 3: swap
        char temp = arr[pos];
        arr[pos] = arr[minPos];
        arr[minPos] = temp;

        // Step 4: reverse the suffix
        reverse(arr, pos + 1, arr.length - 1);

        // Step 5: parse and check overflow
        long val = Long.parseLong(new String(arr));
        return val > Integer.MAX_VALUE ? -1 : (int) val;
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}
