package prevproblems;

import datastructure.array.problems.ArrayUtil;
import jdk.jfr.Description;

import java.util.Arrays;

public class Set9 {
    public static void main(String[] args) {
        // Problem 1
        // makeAdjacentToZero();

        // Problem 2
        // replaceElementWithLargestToItsRight();

        // Problem 3
        // findEquilibriumIndex();

        // Problem 4
        floodFilledAlgorithm();
    }

    @Description("Problem 1")
    public static void makeAdjacentToZero() {
        int[][] arr = {
                {1, 0, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0}
        };

        int[][] res = new int[arr.length][arr[0].length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                res[i][j] = arr[i][j];
            }
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) {
                    convertAdjacentToZero(res, i, j);
                }
            }
        }

        System.out.println("After changes : \n");
        ArrayUtil.print2DArray(res);
    }

    public static void convertAdjacentToZero(int[][] arr, int i, int j) {
        // If there is an element at its left
        if(j - 1 >= 0) {
            arr[i][j - 1] = 0;
        }

        // If there is an element at its right
        if(j + 1 < arr[0].length) {
            arr[i][j + 1] = 0;
        }

        // If there is an element at its top
        if(i - 1 >= 0){
            arr[i - 1][j] = 0;
        }

        // If there is an element at its bottom
        if(i + 1 < arr.length) {
            arr[i + 1][j] = 0;
        }
    }


    @Description("Problem 2")
    public static void replaceElementWithLargestToItsRight() {
        int[] arr = {16, 17, 4, 3, 5, 2};
        int max = Integer.MIN_VALUE;

        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] < max) {
                arr[i] = max;
            }
            max = Math.max(arr[i], max);
        }

        System.out.println("After changing : " + Arrays.toString(arr));
    }

    @Description("Problem 3")
    public static void findEquilibriumIndex() {
        /*
            NOTE :
            ======
            1. As the array contains -ve value, and it's not sorted, we can't point to middle and
               move left and right.
            2. So, the approach should be moving from start.
         */
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        int left = arr[0];
        int right = 0;

        for(int i = 2; i < arr.length; i++) {
            right += arr[i];
        }

        int i = 1;
        while(i < arr.length - 1) {
            if(left == right) {
                break;
            }
            left += arr[i];
            right -= arr[i + 1];
            i++;
        }

        if(i == arr.length - 1) {
            System.out.println("Equilibrium index is : " + -1);
        } else {
            System.out.println("Equilibrium index is : " + i);
        }
    }

    public static void floodFilledAlgorithm() {
        int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 2, 2, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 2, 2, 0},
            {1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 1, 1, 2, 2, 1},
        };

        int x = 4, y = 4, newColor = 3;

        System.out.println("Before change : ");
        ArrayUtil.print2DArray(screen);
        changeColor(screen, 4, 4, 3);
        System.out.println("After change : ");
        ArrayUtil.print2DArray(screen);
    }

    public static void changeColor(int[][] arr, int x, int y, int color) {
        int currColor = arr[x][y];
        arr[x][y] = color;

        if(isAvailable(arr, y, "left") && arr[x][y - 1] == currColor) {
            changeColor(arr, x, y - 1, color);
        }
        if(isAvailable(arr, y, "right") && arr[x][y + 1] == currColor) {
            changeColor(arr, x, y + 1, color);
        }
        if(isAvailable(arr, x, "top") && arr[x - 1][y] == currColor) {
            changeColor(arr, x - 1, y, color);
        }
        if(isAvailable(arr, x, "bottom") && arr[x + 1][y] == currColor) {
            changeColor(arr, x + 1, y, color);
        }

    }

    public static boolean isAvailable(int[][] arr, int i, String pos) {
        if(pos.equals("left") && i - 1 >= 0) {
            return true;
        } else if(pos.equals("right") && i + 1 < arr[0].length){
            return true;
        } else if(pos.equals("top") && i - 1 >= 0) {
            return true;
        } else if(pos.equals("bottom") && i + 1 < arr.length) {
            return true;
        }
        return false;
    }
}
