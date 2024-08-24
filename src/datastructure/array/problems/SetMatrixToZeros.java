package datastructure.array.problems;

import java.util.Arrays;

public class SetMatrixToZeros {
    public static void main(String[] args) {
        int[][] arr = { {0,1,2,0},
                        {3,4,5,2},
                        {1,3,1,5} };

        // Brute
        setMatrixToZerosBrute(arr);

        int[][] arr1 = { {0,1,2,0},
                         {3,4,5,2},
                         {1,3,1,5} };

        // Optimal
        setMatrixToZerosOptimal(arr1);
    }

    public static void setMatrixToZerosBrute(int[][] arr) {
        /*
            Thought Process :
            =================
            1. Create 2 arrays as row and col.
            2. Row array holds the information of particular row contains 0 or not.
            3. Col array holds the information of particular col contains 0 or not.
            4. If array's xth row contains 0, then row's xth element will be set to 0.
            5. If array's yth col contains 0, then col's yth element will be set to 0.
            6. After iterate the row and col arrays.
            7. If any particular element have value 0, then entire row and col will be set to 0 resp.
         */

        /*
            By default, all the values of below arrays are zero.
            A row element become 1 when any of the elements in that row is 0.
            A column element become 1 when any of the elements in that column in 0.
         */
        int[] row = new int[arr.length];
        int[] col = new int[arr[0].length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }


        for(int i = 0; i < row.length; i++) {
            if(row[i] == 1) {
                for(int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < col.length; i++) {
            if(col[i] == 1) {
                for(int j = 0; j < arr.length; j++) {
                    arr[j][i] = 0;
                }
            }
        }

        System.out.println("After Brute force approach : ");
        ArrayUtil.print2DArray(arr);

    }

    private static void setMatrixToZerosOptimal(int[][] arr) {
        /*
            Thought Process :
            ================
            1. Rather than creating separate arrays to hold the info of whether that row or col contains
               0 or not, we can use that array's 1st row and 1st col.

            2. Iterate the array. If any element is 0,
                    then make it's current row's 1st col to 0.
                    And make it's current column's 1st row to 0.

            3. But, the thing we have to notice is arr[0][0].

            4. Suppose, if one of the elements of 1st row is 0, and if we make arr[0][0] to 0, and
               if none of the elements of 1st col is 0, then there is the collusion will happen.

            5. To restrict this we use separate holder for the first row.
            6. If any of the elements of 1st row is 0, then rather than updating arr[0][0], update separate variable.
            7. This will avoid the collusion.
         */
        int firstRow = arr[0][0];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0) {
                    if(i == 0) {
                        firstRow = 0;
                    } else {
                        arr[i][0] = 0;
                        arr[0][j] = 0;
                    }
                }
            }
        }

        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j < arr[0].length; j++) {
                if(arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        if(firstRow == 0) {
            for(int i = 1; i < arr[0].length; i++) {
                arr[0][i] = 0;
            }
        }

        if(arr[0][0] == 0) {
            for(int i = 1; i < arr.length; i++) {
                arr[i][0] = 0;
            }
        }

        if(firstRow == 0) {
            arr[0][0] = 0;
        }

        System.out.println("After Optimal approach : ");
        ArrayUtil.print2DArray(arr);
    }

}
