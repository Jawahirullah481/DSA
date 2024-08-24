package prevproblems;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Set8  {
    public static void main(String[] args) {
         // Problem 1 :
         spiralPrinting();

         // Problem 2 :
        sortAlternateElements();

        // Problem 3 :
        printMismatchedLetters();

        // Problem 4
        findPermutation();
    }

    @Description("Problem 1")
    public static void spiralPrinting() {
        /*
            4444444
            4333334
            4322234
            4321234
            4322234
            4333334
            4444444
         */

        int n = 4;
        int top = 0, left = 0, right = 2 * n - 1, bottom = 2 * n - 1;

        for(int i = top; i <= bottom; i++) {
            for(int j = left; j <= right; j++) {
                int fromLeft = j - left;
                int fromRight = right - j;
                int fromTop = i - top;
                int fromBottom = bottom - i;

                int min = (int)Math.min(Math.min(fromLeft, fromRight), Math.min(fromTop, fromBottom));
                System.out.print(n - min);
            }
            System.out.println();
        }
    }

    @Description("Problem 2")
    public static void sortAlternateElements() {
        /*
            NOTE : Time Complexity : O(N), Space Complexity: O(1)
         */
    }

    @Description("Problem 3")
    public static void printMismatchedLetters() {
        char[] arr1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        char[] arr2 = {'a', 'b', 'd', 'e', 'e', 'g', 'g', 'i', 'i'};

        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                System.out.print(arr1[i] + "" +  arr2[i] + " ");
            }
        }

        System.out.println();
    }

    @Description("Problem 4")
    public static void findPermutation() {
        List<String> list = getAllUniquePermutation("", "Java");
        Collections.sort(list);
        System.out.println("All permutation are : " + list);
    }

    public static List<String> getAllUniquePermutation(String p, String up) {
        if(up.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char c = up.charAt(0);
        List<String> outer = new ArrayList<>();
        for(int i = 0; i <= p.length(); i++) {
            List<String> inner = getAllUniquePermutation(p.substring(0, i) + c + p.substring(i), up.substring(1));
            for(String s : inner) {
                if(!outer.contains(s)) {
                    outer.add(s);
                }
            }
        }

        return outer;
    }
}
