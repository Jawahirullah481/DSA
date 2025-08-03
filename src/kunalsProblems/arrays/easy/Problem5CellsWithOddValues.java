package kunalsProblems.arrays.easy;

public class Problem5CellsWithOddValues {

    public static void main(String[] args) {
        int[][] indices = { { 0, 1 }, {1, 1} };
        oddCells(2, 3, indices);
    }

    public static int oddCells(int m, int n, int[][] indices) {
        int oddCount = 0;

        int[] row = new int[m];
        int[] col = new int[n];

        for(int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((row[i] + col[j]) % 2 == 1) {
                    oddCount++;
                }
            }
        }

        return oddCount;
    }

}
