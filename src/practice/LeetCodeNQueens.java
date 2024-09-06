package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCodeNQueens {
    public List<List<String>> solveNQueens(int n) {
        return solve(0, n, new ArrayList<String>());
    }

    private List<List<String>> solve(int row, int n, List<String> rows) {
        if(row == n) {
            List<List<String>> solution = new ArrayList<>();
            List<String> dest = new ArrayList<>(rows);
            solution.add(dest);
            //printBoard(rows);
            return solution;
        }

        String currentRow = createRow(n);
        rows.add(currentRow);

        List<List<String>> solutions = new ArrayList<>();

        for(int col = 0; col < n; col++) {
            if(isSafe(row, col, rows)) {
                rows.set(rows.size() - 1, currentRow.substring(0, col) + "Q" + currentRow.substring(col + 1));
                solutions.addAll(solve(row + 1, n, rows));
                rows.set(rows.size() - 1, currentRow.substring(0, col) + "." + currentRow.substring(col + 1));
            }
        }

        rows.remove(rows.size() - 1);
        return solutions;
    }

    private boolean isSafe(int row, int col, List<String> rows) {
        // Checking column
        for(int i = 0; i < row; i++) {
            if(rows.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(rows.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        for(int i = row - 1, j = col + 1; i >=0 && j < rows.get(0).length(); i--, j++) {
            if(rows.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    private String createRow(int n) {
        String row = "";

        for(int i = 0; i < n; i++) {
            row += ".";
        }

        return row;
    }

    private void printBoard(List<String> rows) {
        for(String row : rows) {
            System.out.println(Arrays.toString(row.toCharArray()));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LeetCodeNQueens nQueens = new LeetCodeNQueens();
        List<List<String>> lists = nQueens.solveNQueens(4);
        for(List<String> list : lists) {
            for(String str : list) {
                System.out.println(str);
            }
            System.out.println();
        }
    }
}
