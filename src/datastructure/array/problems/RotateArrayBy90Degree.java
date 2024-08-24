package datastructure.array.problems;

public class RotateArrayBy90Degree {

    public static void main(String[] args) {

        /*
            NOTE : It's n x n array.
            In case of m x n array, you have to use separate array and analyze how the elements are moved.
            And then rotate it.
         */
        int[][] arr = { {8,6,2},
                        {3,4,5},
                        {1,3,1,} };

        System.out.println("Before rotate : ");
        ArrayUtil.print2DArray(arr);
        transpose(arr);
        reverseRows(arr);
        System.out.println("After rotate : ");
        ArrayUtil.print2DArray(arr);
    }

    public static void transpose(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public static void reverseRows(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            int left = 0, right = arr[0].length - 1;
            while(left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;right--;
            }
        }
    }
}
