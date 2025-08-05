package kunalsProblems.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem9LuckyNumber {
    /*
        LeetCode No : 1380
     */

    public static void main(String[] args) {

    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        Arrays.fill(row, Integer.MAX_VALUE);
        Arrays.fill(col, Integer.MIN_VALUE);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                row[i] = Math.min(row[i], matrix[i][j]);
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (row[i] == col[j])
                    list.add(row[i]);
            }
        }

        return list;
    }
}
