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

            Original Array :

            [ 1,  2,  3,  4]
            [ 5,  6,  7,  8]
            [ 9, 10, 11, 12]
            [13, 14, 15, 16]
            [17, 18, 19, 20]

            Rotated Array :

            [17, 13,  9,  5,  1]
            [18, 14, 10,  6,  2]
            [19, 15, 11,  7,  3]
            [20, 16, 12,  8,  4]

            [1] -> (0, 0)  -> (0, 4] -> [0, 0] -> [0, 5 - 0 + 1] -> [i, j] = [j, rows - i - 1]
            [2] -> (0, 1)  -> [1, 4]
            [3] -> (0, 2)  -> [2, 4]
            [4] -> (0, 3)  -> [3, 4]
            [5] -> (1, 0)  -> [0, 3]
            [6] -> (1, 1)  -> [1, 3]
            [7] -> (1, 2)  -> [2, 3]

            Where, i -> current row, j -> current col

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
