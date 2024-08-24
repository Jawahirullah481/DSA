package practice;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 0, 4};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cyclicSort(int[] arr) {
        int i = 0;
        int n = arr.length;
        while(i < n) {
            if(arr[i] < n && (arr[i] != i)) {
                int temp = arr[i];
                arr[i] = arr[arr[i]];
                arr[arr[i]] = temp;
            } else {
                i++;
            }
        }
    }
}
