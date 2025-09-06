package kunalsProblems.sorting.easy;

import java.util.Arrays;

public class Problem17SortBy1Bits {

    /*
        LeetCode No : 1356, Problem Link : https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/
     */

    public int[] sortByBitsBetter(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> {
            int bitsA = Integer.bitCount(a);
            int bitsB = Integer.bitCount(b);
            if (bitsA == bitsB) return a - b;
            return bitsA - bitsB;
        });
        return Arrays.stream(boxed).mapToInt(i -> i).toArray();
    }

    public int[] sortByBits(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(isNum1GreaterThanNum2(arr[i], arr[j])) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    private boolean isNum1GreaterThanNum2(int num1, int num2) {

        int originalNum1 = num1, originalNum2 = num2;
        int num1Bits = 0;

        while(num1 > 0) {
            if((num1 & 1) == 1) {
                num1Bits++;
            }
            num1 = num1 >> 1;
        }

        int num2Bits = 0;

        while(num2 > 0) {
            if((num2 & 1) == 1) {
                num2Bits++;
            }
            num2 = num2 >> 1;
        }

        if(num1Bits == num2Bits) {
            return originalNum1 > originalNum2;
        }

        return num1Bits > num2Bits;
    }
}
