package datastructure.array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};

        intesection(arr1, arr2);
    }

    private static void intesection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        List<Integer> inter = new ArrayList<>();
        int i = 0, j = 0, k = -1;

        while(i < arr1.length && j < arr2.length) {
            while(j < arr2.length && arr2[j] < arr1[i]) {
                j++;
            }

            if(j < arr2.length) {
                if((inter.isEmpty() || inter.get(k) != arr1[i]) && arr1[i] == arr2[j]) {
                    inter.add(arr1[i]);
                    i++;j++;k++;
                } else {
                    i++;
                }
            }
        }

        System.out.println("Intersection is : " + inter);
    }
}
