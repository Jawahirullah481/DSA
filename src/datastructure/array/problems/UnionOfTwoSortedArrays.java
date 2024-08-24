package datastructure.array.problems;

import java.util.Arrays;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 3, 4};
        int[] arr2 = {1, 2, 3, 5, 6, 6};

        // Union of 2 sorted arrays(No duplicates)
        union(arr1, arr2);
    }

    public static void union(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = -1;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                if(k == -1 || arr1[i] != res[k]) {
                    k++;
                    res[k] = arr1[i];
                }
                i++;
            } else {
                if(k == -1 || arr2[j] != res[k]) {
                    k++;
                    res[k] = arr2[j];
                }
                j++;
            }
        }

        while(i < arr1.length) {
            if(k == -1 || arr1[i] != res[k]) {
                k++;
                res[k] = arr1[i];
            }
            i++;
        }

        while(j < arr2.length) {
            if(k == -1 || arr2[j] != res[k]) {
                k++;
                res[k] = arr2[j];
            }
            j++;
        }

        System.out.println("After Union : " + Arrays.toString(res));
    }
}
