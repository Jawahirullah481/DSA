package datastructure.array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};

        intersection(arr1, arr2);
    }

    private static void intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        List<Integer> inter = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                // Check for duplicates before adding
                if (inter.isEmpty() || inter.get(inter.size() - 1) != arr1[i]) {
                    inter.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        System.out.println("Intersection is: " + inter);
    }

}
