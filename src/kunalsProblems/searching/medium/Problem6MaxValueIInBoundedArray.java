package kunalsProblems.searching.medium;

public class Problem6MaxValueIInBoundedArray {

    /*
        LeetCode No : 1802, Problem Link : https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

        ChatGPT Explanation Link : https://chatgpt.com/c/689a2285-ed04-8321-83c1-5fb70b982623

        ✅ Intuition (Final Polished Version)
        =====================================
        1. The minimum possible value at any index is 1 (since every element must be ≥ 1).
            * Example: when n == maxSum, all elements must be 1.

        2. The maximum possible value at any index is maxSum (when n == 1).
            * Example: only one element, it can take the entire sum.

        3. So, the answer is guaranteed to lie between [1, maxSum].
        4. We can now apply binary search to find the maximum valid number at index:
            * If a candidate number mid is valid (total sum ≤ maxSum), store it and try a bigger value (search right).
            * If a candidate number mid is invalid (total sum > maxSum), reduce the value (search left).

        ✅ How to Check if a Number x is Valid?
        ======================================
        1. Let’s say we test placing mid = x at position index.
            * On the left side, numbers must decrease step by step until they reach 1.
            * On the right side, numbers must also decrease step by step until 1.
            * If decreasing would take them below 1, they just stay at 1.

        So, we must compute:
            leftSum  = sum of elements left of index
            rightSum = sum of elements right of index
            total    = leftSum + rightSum + mid

       ✅ How to Calculate leftSum / rightSum : 
       =========================================
       
        We use the arithmetic series formula to calculate the sum of elements on either side of the target index.
        
        Arithmetic Series Formula:
        sum = (length / 2) * (first_term + last_term) * difference
        
        * In our problem, the difference between consecutive numbers is 1, so the formula simplifies to:
          sum = (length / 2) * (first_term + last_term)
        
        ---
        
        Step 1: Determine the first_term
        
        * Always: first_term = mid - 1
          (the number immediately before mid on that side)
        
        ---
        
        Step 2: Determine the last_term
        
        Case 1: Enough numbers to decrease fully
        
        * Condition: mid - 1 >= length
        * We can decrease without hitting 1.
        * Example: mid = 7, length = 3 → sequence: 6, 5, 4
        * last_term = first_term - length + 1
        * Formula explanation: subtract (length - 1) to account for inclusive terms.
        
        Case 2: Not enough numbers to decrease fully (hit 1)
        
        * Condition: mid - 1 < length
        * The sequence would hit 1 before filling all positions.
        
        Steps:
        
        1. Decreasing part ends at 1.
        2. Sum the decreasing sequence: (first_term * (first_term + 1)) / 2
        3. Remaining positions are filled with 1s: remaining = length - first_term
        4. Total sum = decreasing part + remaining ones
        
        * Example: mid = 3, length = 5 → sequence: 2, 1, 1, 1, 1
        
          * Decreasing part sum = 2 + 1 = 3
          * Remaining = 1 + 1 + 1 = 3
          * Total sum = 6


     */

    public int maxValue(int n, int index, int maxSum) {
        int low = 1, high = maxSum;
        int answer = 1;

        // Binary Search to find the maximum possible value at position `index`
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(n, index, maxSum, mid)) {
                answer = mid;   // mid is valid, try for a larger value
                low = mid + 1;
            } else {
                high = mid - 1; // mid is too large, try smaller
            }
        }
        return answer;
    }

    /**
     * Check if placing `mid` at `index` is valid without exceeding `maxSum`.
     */
    private boolean isValid(int n, int index, int maxSum, int mid) {
        long leftSum = calculateSideSum(mid - 1, index);           // Left side contribution
        long rightSum = calculateSideSum(mid - 1, n - index - 1);  // Right side contribution

        long total = leftSum + rightSum + mid; // include mid itself
        return total <= maxSum;
    }

    /**
     * Calculates the sum of one side (left or right) when starting from `start`
     * and extending `length` elements outward.
     * <p>
     * Formula used:
     * - If `start >= length`:
     * sum = (start + (start - length + 1)) * length / 2
     * -> Arithmetic progression sum from (start) down to (start - length + 1)
     * <p>
     * - If `start < length`:
     * sum = (start * (start + 1)) / 2   // complete decreasing sequence down to 1
     * + (length - start)          // remaining positions filled with 1
     */
    private long calculateSideSum(long start, long length) {
        if (start >= length) {
            // Example: start = 5, length = 3 → sum of (5 + 4 + 3)
            long end = start - length + 1;
            return (start + end) * length / 2;
        } else {
            // Example: start = 3, length = 5 → sum of (3 + 2 + 1) + remaining(2 * 1s)
            long decreasingPart = (start * (start + 1)) / 2;
            long remainingOnes = length - start;
            return decreasingPart + remainingOnes;
        }
    }

}
