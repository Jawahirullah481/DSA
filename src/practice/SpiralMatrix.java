package practice;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /*
        ❓ Why do we check if (top <= bottom) before looping right-to-left?

        🔍 Background:
        When you're traversing right → left on the bottom row, you only want to do this if that bottom row hasn't already been processed in a previous step.

        🧠 Why?
        Because after processing the top row, you do top++.

        After processing the right column, you do right--.

        By now, top might have crossed bottom, or left might have crossed right, meaning no rows or columns are left to process.

        If you don’t check top <= bottom, you might end up:
        # Repeating rows
        # Accessing invalid indices (ArrayIndexOutOfBoundsException).

        ❓ Why is bottom-- inside the if (top <= bottom) block?
        🔍 Reason:
        # We only update the bottom boundary if we’ve actually traversed that bottom row.
        # If top > bottom, and we didn’t traverse the bottom row, then doing bottom-- unnecessarily would cause incorrect shrinking of boundaries and potential errors in further iterations (especially for larger matrices).
        # So the update of the boundary (bottom--) is only meaningful when that row is used.

     */
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
    }

    public static List<Integer> spiralOrder(int[]   [] matrix) {

        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> list = new ArrayList<>();

        while(left <= right && top <= bottom) {

            for(int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }

        }

        return list;

    }
}
