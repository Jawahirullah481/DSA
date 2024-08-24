package revisionProblems;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {

        // 1. Printing all subsets without storing it in list
        printSubsets("", "abc");
        System.out.println();

        // 2. Returning all subsets  without printing. It's inplace. No list is passed in argument
        List<String> subsets = getAllSubsets("", "abc");
        System.out.println(subsets);

        // 3. Subset of array
        List<List<Integer>> subsetsArr = getAllSubsetsForArray(new int[] {1, 2, 3});
        System.out.println(subsetsArr);

        // 4. Subsets in duplicates
        List<List<Integer>> subsetsDuplicates = getAllSubsetsWithoutDuplicates(new int[] {1, 2, 2});
        System.out.println(subsetsDuplicates);

        // 5. Check if a is subset of b
        boolean b = isBSubsetOfA("", "Google", "oe");
        System.out.println("oe is substring of Google : " + b);

        // 6. Get all permutations
        List<String> outerList = permutation("", "abc");
        System.out.println(outerList);
    }

    private static List<String> permutation(String p, String up) {
        if(up.equals("")) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char c = up.charAt(0);
        List<String> outer = new ArrayList<>();
        for(int i = 0; i <= p.length(); i++) {
            List<String> list = permutation(p.substring(0, i) + c + p.substring(i), up.substring(1));
            outer.addAll(list);
        }

        return outer;
    }

    private static boolean isBSubsetOfA(String p, String up, String b) {
        if(p.equals(b)) {
            return true;
        }

        if(up.equals("")) {
            System.out.print(p + " -> ");
            return false;
        }

        char c = up.charAt(0);
        return isBSubsetOfA(p + c, up.substring(1), b) ||  isBSubsetOfA(p, up.substring(1), b);
    }

    private static List<List<Integer>> getAllSubsetsWithoutDuplicates(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int i = 0; i < arr.length; i++) {
            int n = outer.size();
            int start = 0;
            if((i > 0) && (arr[i] == arr[i - 1])) {
                start = n / 2;
            }
            for(int j = start; j < n; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }

        return outer;
    }

    private static List<List<Integer>> getAllSubsetsForArray(int[] arr) {
        /*

            In this method, for every number in the array, I am creating the copy of outer list.
            In that copy, I am adding the current number.

         */
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<Integer>());
        for(int num : arr) {
            int copySize = outer.size();
            for(int i = 0; i < copySize; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }

        return outer;
    }

    private static List<String> getAllSubsets(String p, String up) {
        if(up.equals("")) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char c = up.charAt(0);
        List<String> left = getAllSubsets(p + c, up.substring(1));
        List<String> right = getAllSubsets(p, up.substring(1));
        left.addAll(right);
        return left;
    }

    private static void printSubsets(String p, String up) {
        if(up.equals("")) {
            System.out.print(p + " ");
            return;
        }
        char c = up.charAt(0);
        printSubsets(p + c, up.substring(1));
        printSubsets(p, up.substring(1));
    }
}
