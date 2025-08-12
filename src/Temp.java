import java.util.*;

class Temp {

    public static void main(String[] args) {

        int[][] arr = spiralMatrixIII(5, 6, 1, 4);

        for(int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // 1.
        int[][] matrix = new int[rows][cols];

        // 2.
        int left = cStart, right = cStart, top = rStart, bottom = rStart;

        // 3.
        boolean leftReached = false, rightReached = false, topReached = false, bottomReached = false;

        // 4.
        int count = 0;
        int num = 1;
        while(!leftReached || !rightReached || !topReached || !bottomReached) {

            for(int i = left; i <= right && top >= 0 && i <= matrix[0].length - 1 && i >= 0; i++) {
                matrix[top][i] = num++;
                print(matrix);
            }
            right++;
            if(right == matrix[0].length) {
                rightReached = true;
            }

            for(int i = top; i <= bottom && right <= matrix[0].length - 1 && i <= matrix.length - 1 && i >= 0; i++) {
                matrix[i][right] = num++;
                print(matrix);
            }
            bottom++;
            if(bottom == matrix.length) {
                bottomReached = true;
            }

            for(int i = right; i >= left && bottom <= matrix.length - 1 && i >= 0 && i <= matrix[0].length - 1; i--) {
                matrix[bottom][i] = num++;
                print(matrix);
            }
            left--;
            if(left == 0) {
                leftReached = true;
            }

            for(int i = bottom; i >= top && left >= 0 && i >= 0 && i <= matrix.length - 1; i--) {
                matrix[i][left] = num++;
                print(matrix);
            }
            top--;
            if(top == 0) {
                topReached = true;
            }

        }

        return matrix;
    }

    public static void print(int[][] arr) {
        for(int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }

        System.out.println("\n");
    }
}