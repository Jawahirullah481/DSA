package kunalsProblems.arrays.easy;

public class Problem10ReshapeMatrix {

    /*
        LeetCode No : 566, Link : https://leetcode.com/problems/reshape-the-matrix/

        Important Note :
        ================

        cell / c => Number of group of c you have traversed so far. As each row has c cell, it means number of rows you have traversed so far.
        cell % c => Whenever you go beyond 'c', you have to be wrapped inside its range.

     */

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        if(r * c != mat.length * mat[0].length) {
            return mat;
        }

        int[][] res = new int[r][c];

        int cell = 0;
        // c = 4, r = 1
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                int row = cell / c;
                int col = cell % c;

                res[row][col] = mat[i][j];
                cell++;
            }
        }

        return res;

    }

}
