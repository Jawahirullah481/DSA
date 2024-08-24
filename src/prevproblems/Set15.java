package prevproblems;

import datastructure.array.problems.ArrayUtil;
import jdk.jfr.Description;

import java.util.HashMap;
import java.util.Map;

public class Set15 {
    public static void main(String[] args) {
        // Problem 1
        findWordInMatrix();

        // Problem 2
        findNextGreaterNumber();

        // Problem 3
        reverseUsingRecursion();
    }

    @Description("Problem 1")
    public static void findWordInMatrix() {
        char[][] array = {
                {'a', 'z', 'o', 'l'},
                {'n', 'x', 'h', 'o'},
                {'v', 'y', 'i', 'v'},
                {'o', 'r', 's', 'e'}
        };
        String str = "love";
        int[][] res = searchInRow(array, str);
        if(res[0][0] == -1) {
            res = searchInCol(array, str);
        }

        System.out.println("Search item found in : ");
        ArrayUtil.print2DArray(res);
    }

    public static int[][] searchInRow(char[][] arr, String str) {
        boolean isMatched = true;

        for(int row = 0; row < arr.length; row++) {
            int st = 0;
            int end = st + str.length() - 1;
            while(end < arr[0].length) {
                isMatched = true;
                for (int col = st, i = 0; col <= end; col++, i++) {
                    if (arr[row][col] != str.charAt(i)) {
                        isMatched = false;
                    }
                }
                if(isMatched) {
                    return new int[][] {{row, st}, {row, end}};
                }
                st++;end++;
            }
        }
        return new int[][]{{-1, -1}, {-1, -1}};
    }

    public static int[][] searchInCol(char[][] arr, String str) {
        boolean isMatched = true;

        for(int col = 0; col < arr.length; col++) {
            int st = 0;
            int end = st + str.length() - 1;
            while(end < arr.length) {
                isMatched = true;
                for (int row = st, i = 0; row <= end; row++, i++) {
                    if (arr[row][col] != str.charAt(i)) {
                        isMatched = false;
                    }
                }
                if(isMatched) {
                    return new int[][] {{st, col}, {end, col}};
                }
                st++;end++;
            }
        }
        return new int[][]{{-1, -1}, {-1, -1}};
    }

    @Description("Problem 2")
    public static void findNextGreaterNumber() {

        int[] arr = {2, 3, 7, 1, 8, 5, 11};
        Map<Integer, Integer> map = new HashMap<>();
        int nextMax = 0;

        for(int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            nextMax = Integer.MAX_VALUE;
            for(int j = 0; j < arr.length; j++) {
                if(j != i && (arr[j] > curr && arr[j] < nextMax)) {
                    nextMax = arr[j];
                }
            }
            if(nextMax != Integer.MAX_VALUE) {
                map.put(curr, nextMax);
            } else {
                map.put(curr, -1);
            }
        }

        System.out.println("After searching : " + map);
    }

    @Description("Problem 3")
    public static void reverseUsingRecursion() {
        String str = "one two three";
        System.out.println("After reverse : " + reverse(str));
    }

    public static String reverse(String str) {
        int spaceIndex = str.lastIndexOf(" ");
        if(spaceIndex == -1) {
            return str;
        }
        return str.substring(spaceIndex + 1) + " " + reverse(str.substring(0, spaceIndex));
    }
}
