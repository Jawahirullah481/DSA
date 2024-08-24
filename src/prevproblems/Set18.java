package prevproblems;

import jdk.jfr.Description;

import java.util.Arrays;

public class Set18 {
    public static void main(String[] args) {
        // Problem 1
        countArray();

        // Problem 2
        twoSum();

        // Problem 3
        maximumSumOfContiguousSubArray();

    }

    @Description("Problem 1")
    public static void countArray() {
        int[] arr1 = {9, 2, 8, 1, 3, 5, 6, 7, 3, 1, 1, 6};
        int[] arr2 = {7, 8, 4, 6, 2, 1, 9, 9, 7};

        // arr1 = new int[] {9, 9, 9, 9, 9};
        // arr2 = new int[] {9, 9, 9, 9, 9};

        int maxLength = Math.max(arr1.length, arr2.length);
        int[] sum = new int[maxLength + 1];
        int i = arr1.length - 1, j = arr2.length - 1, k = sum.length - 1, carry = 0;

        while(i >= 0 && j >= 0) {
            int tot = arr1[i] + arr2[j] + carry;
            sum[k] = tot % 10;
            carry = tot / 10;
            i--;j--;k--;
        }

        while(i >= 0) {
            int tot = arr1[i] + carry;
            sum[k] = tot % 10;
            carry = tot / 10;
            i--;k--;
        }

        while(j >= 0) {
            int tot = arr2[j] + carry;
            sum[k] = tot % 10;
            carry = tot / 10;
            j--;k--;
        }

        if(carry > 0) {
            sum[k] = carry;
        }

        System.out.println("Addition of 2 Arrays : " + Arrays.toString(sum));
    }


    @Description("Problem 2")
    public static void twoSum() {
        /*
            NOTE :
            ======
            1. The below approach is optimal approach.
            2. Better solution is using hashing.
         */
        int[] arr = {1, 3, 4, 8, 10};
        int st = 0, end = arr.length - 1;
        int n = 7;

        while(st < end) {
            if(arr[st] + arr[end] == n) {
                break;
            }

            if(arr[st] + arr[end] < n) {
                st++;
            } else {
                end--;
            }
        }

        if(st == end) {
            System.out.println("There is no pairs found");
        } else {
            System.out.println(n + " is taken by sum of " + arr[st] + " and " + arr[end]);
        }
    }

    @Description("Problem 3")
    public static void maximumSumOfContiguousSubArray() {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int max = Integer.MIN_VALUE;
        int st = 0, end = 0;
        int tempst = 0;
        int count = 0;

        int i = 0;
        while(i < arr.length) {
            if(count < 0) {
                count = 0;
                tempst = i;
            }

            count += arr[i];
            if(count > max) {
                max = count;
                st = tempst;
                end = i;
            }
            i++;
        }

        System.out.println("max sub array : " + st + ", " + end);
    }
}
