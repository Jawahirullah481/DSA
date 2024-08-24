package practice;

public class ArrayRotation {
    public static void main(String[] args) {
        int[][] arr = {{1,  2,  3,  4},
                       {5,  6,  7,  8},
                       {9,  10, 11, 12},
                       {13, 14, 15, 16},
                       {17, 18, 19, 20}};

        rotate(arr);
    }

    public static void rotate(int[][] arr) {
        /*
            0, 0 -> 0, 3     1, 0 -> 0, 2
            0, 1 -> 1, 3     2, 0 -> 0, 1
            0, 2 -> 2, 3     3, 0 -> 0, 0
            0, 3 -> 3, 3


         */
        int row = arr.length;
        int col = arr[0].length;

        int[][] res = new int[col][row];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                res[j][row - i - 1] = arr[i][j];
            }
        }

        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                System.out.printf("%3d ", res[i][j]);
            }
            System.out.println();
        }
    }
}
