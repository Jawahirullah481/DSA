package kunalsProblems.arrays.easy;

public class MatrixRotation {

    /*
        Leetcode No : 1886, Problem Link : https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/
     */

    public static void main(String[] args) {
        int[][] src = {
                {0, 1},
                {1, 0}
        };

        int[][] target = {
                {1, 0},
                {0, 1}
        };

        findRotation(src, target);
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        for(int i = 1; i <= 4; i++) {
            rotate90Degree(mat);
            if(checkIsSame(mat, target)) {
                return true;
            }
        }

        return false;
    }

    public static void rotate90Degree(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            int st = 0, end = arr[0].length - 1;
            while(st < end) {
                int temp = arr[i][st];
                arr[i][st] = arr[i][end];
                arr[i][end] = temp;
                st++; end--;
            }
        }
    }

    public static boolean checkIsSame(int[][] src, int[][] target) {
        for(int i = 0; i < src.length; i++) {
            for(int j = 0; j < src[0].length; j++) {
                if(src[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }

}
