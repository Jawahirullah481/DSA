package prevproblems;

import datastructure.array.problems.ArrayUtil;
import jdk.jfr.Description;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Set12 {
    public static void main(String[] args) {
        // Problem 1
        // squaresBetweenAandB();

        // Problem 2
        // findThreshold();

        // Problem 3
        // addBinaryNumbers();

        // Problem 4
        // matrixSearch();

        // Problem 5
        rotateMatrix();
    }

    @Description("Problem 1")
    public static void squaresBetweenAandB() {
        int a = 20;
        int b = 100;
        List<Integer> list = new ArrayList<>();

        int i = 0;
        for(i = 1; i * i < a; i++) {}

        for(int j = i; j * j <= b; j++) {
            list.add(j * j);
        }

        System.out.println("Roots are : " + list);
    }

    @Description("Problem 2")
    public static void findThreshold() {
        int[] arr = {5, 8, 10, 13, 6, 2};
        int threshold = 3;

        int count = 0;

        for(int i : arr) {
            count += (i / threshold);
            if(i % threshold != 0) {
                count += 1;
            }
        }

        System.out.println("Threshold count is : " + count);
    }

    @Description("Problem 3")
    public static void addBinaryNumbers() {
        /*
            Thought Process :
            =================
            1. Make 2 pointers point end of s1 and s2.
            2. Add the numbers of pointer1 and pointer2 and rem.
            3. Take the sum, and make the result and put appropriate carry.
         */
        String s1 = "1101";
        String s2 = "10111";
        String res = "";

        int i = s1.length() - 1;
        int j = s2.length() - 1;

        int carry = 0;

        while(i >= 0 && j >= 0) {
            int n1 = Integer.parseInt(Character.toString(s1.charAt(i)));
            int n2 = Integer.parseInt(Character.toString(s2.charAt(j)));

            int sum = n1 + n2 + carry;

            switch(sum) {
                case 0 : res = "0" + res;carry = 0; break;
                case 1 : res = "1" + res;;carry = 0; break;
                case 2 : res = "0" + res;;carry = 1; break;
                case 3 : res = "1" + res;;carry = 1; break;
            }
            i--;j--;
        }

        while(i >= 0) {
            int n1 = Integer.parseInt(Character.toString(s1.charAt(i)));

            int sum = n1 + carry;

            switch(sum) {
                case 0 : res = "0" + res;carry = 0; break;
                case 1 : res = "1" + res;;carry = 0; break;
                case 2 : res = "0" + res;;carry = 1; break;
                case 3 : res = "1" + res;;carry = 1; break;
            }
            i--;
        }

        while(j >= 0) {
            int n2 = Integer.parseInt(Character.toString(s2.charAt(j)));

            int sum = n2 + carry;

            switch(sum) {
                case 0 : res = "0" + res;carry = 0; break;
                case 1 : res = "1" + res;;carry = 0; break;
                case 2 : res = "0" + res;;carry = 1; break;
                case 3 : res = "1" + res;;carry = 1; break;
            }
            j--;
        }

        if(carry != 0) {
            res = "1" + res;
        }

        System.out.println("After addition : " + res);
    }

    @Description("Problem 4")
    public static void matrixSearch() {
        /*
            Problems statement :
            =====================
            Given bigger NxN matrix and a smaller MxM matrix print TRUE.
            if the smaller matrix can be found in the bigger matrix else print FALSE

            Thought Process :
            ================
            1. iterate every submatrix of bigger matrix of length smaller matrix.
            2. Then check if element are same. if so, return true, else false.
         */
        int[][] arr1 = {{1,  2,  3,  4,  5},
                        {6,  7,  8,  9,  10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}};

        int[][] arr2 = {{7,  8,  9},
                        {12, 13, 14},
                        {17, 18, 19}};

        int stx = 0, endx = 0, sty = 0, endy = 0;
        //int[][] arr3 = new int[arr2.length][arr2[0].length];


        while(endx < arr1.length) {
            endx = stx + arr2[0].length - 1;
            endy = sty + arr2.length - 1;

            System.out.println("stx = " + stx + " -> sty = " + sty + " endx -> " + endx + " endy -> " + endy);

            if (endy == arr1[0].length) {
                sty = 0;
                stx++;
                continue;
            }

            if (endx == arr1.length) {
                break;
            }

            boolean isFound = true;

            for (int i = stx, k = 0; i <= endx; i++, k++) {
                for (int j = sty, l = 0; j <= endy; j++, l++) {
                    // arr3[k][l] = arr1[i][j];
                    if(arr2[k][l] != arr1[i][j]) {
                        isFound = false;
                        break;
                    }
                }
            }

            if(isFound) {
                System.out.println("Array found at " + stx + " " + endx + " " + sty + " " + endy);
                break;
            }
           // ArrayUtil.print2DArray(arr3);
            sty++;
        }

    }

    @Description("Problem 5")
    public static void rotateMatrix() {
        /*
            Problem statement :
            ===================
            Given two matrices a and b both of size NxN.
            find if matrix a can be transformed to matrix b by rotating it 90deg , 180deg , 270deg.
            if so print TRUE else print FALSE


            Thought Process :
            =================
            1. Transpose matrix. (Check the logic for transpose the array).
            2. Reverse Matrix.
            3. Either you can reverse it and check it (or) you can check during reverse

            NOTE :
            ======
            1. When you rotate by 90 deg, row becomes column and column becomes row.
            Note this point while writing sample array for rotation.
         */

        int[][] a = {{1,  2,  3,  4},
                     {5,  6,  7,  8},
                     {9,  10, 11, 12},
                     {13, 14, 15, 16}};

        int[][] b = {{13,  9,  5,  1},
                     {14, 10,  6,  2},
                     {15, 11,  7,  3},
                     {16, 12,  8,  4}};

        int[][] res = rotate90Deg(a);
        if(checkIfSame(b, res)) {
            System.out.println("Array is same");
            ArrayUtil.print2DArray(res);
            return;
        }
        res = rotate90Deg(res);
        if(checkIfSame(b, res)) {
            System.out.println("Array is same");
            ArrayUtil.print2DArray(res);
            return;
        }
        res = rotate90Deg(res);
        if(checkIfSame(b, res)) {
            System.out.println("Array is same");
            ArrayUtil.print2DArray(res);
            return;
        }

        System.out.println("Array is not same");


    }

    public static int[][] rotate90Deg(int[][] arr) {
        int[][] res = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                res[i][j] = arr[i][j];
            }
        }

        // Transpose matrix
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr[0].length; j++) {
                int temp = res[i][j];
                res[i][j] = res[j][i];
                res[j][i] = temp;
            }
        }

        // Reverse matrix
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length / 2; j++) {
                int temp = res[i][j];
                res[i][j] = res[i][res.length - 1 - j];
                res[i][res.length - 1 - j] = temp;
            }
        }

        return res;
    }

    public static boolean checkIfSame(int[][] arr1, int[][] arr2) {
        boolean isSame = true;
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr1[0].length; j++) {
                if(arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
