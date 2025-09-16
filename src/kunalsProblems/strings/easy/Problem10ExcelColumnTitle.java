package kunalsProblems.strings.easy;

public class Problem10ExcelColumnTitle {
    /*
        LeetCode No : 168, Problem Link : https://leetcode.com/problems/excel-sheet-column-title/description/

        Intuition :
        ==========
        🔹 Problem Recap

        We need to convert a positive integer (columnNumber) into its corresponding Excel column title.

        Mapping:

        * 1 -> A
        * 2 -> B
        * ...
        * 26 -> Z
        * 27 -> AA
        * 28 -> AB
        ...

        🔹 Intuition

        Think of this as a base-26 number system, but with a twist:

        * Instead of digits 0–25, Excel columns use letters A–Z representing 1–26.
        * That means there’s no zero digit — which is why we subtract 1 before modulus and division.
        * Every time we extract the last letter, we reduce the column number until nothing is left.

        🔹 Step-by-Step Process

        * Loop until columnNumber is 0.
        * Find remainder (rem):

          int rem = (columnNumber - 1) % 26;

        * Subtract 1 so the mapping shifts from:
          * 0 → A, 1 → B, ... 25 → Z

          Example: columnNumber = 28
          (28 - 1) % 26 = 1 → 'B'

        * Convert remainder to character:

          (char)('A' + rem)

          * If rem = 0, → 'A'
          * If rem = 25, → 'Z'

        * Append the letter to StringBuilder.
        * Update columnNumber:

          columnNumber = (columnNumber - 1) / 26;

        * This moves to the next “digit” in base-26.
        * Repeat until columnNumber = 0.
        * Reverse the string because we build letters from least significant (rightmost) to most significant (leftmost).

        🔹 Example Walkthrough

        columnNumber = 28

        * Iteration 1:
          rem = (28 - 1) % 26 = 1 → 'B'
          columnNumber = (28 - 1) / 26 = 1
          title = "B"

        * Iteration 2:
          rem = (1 - 1) % 26 = 0 → 'A'
          columnNumber = (1 - 1) / 26 = 0
          title = "BA"

        * Reverse: "AB"
        * ✅ Answer: "AB"

        🔹 Complexity

        * Time: O(log₍26₎(n)) → number of letters in result (very small).
        * Space: O(1) (ignoring output string).

        👉 In short:
        This is base-26 conversion with a shift because Excel indexing starts at 1 not 0.

        -------------------------------------------------------------------------------------

        🔹 Why not modulo/divide by 27?

        * In Excel, there are exactly 26 symbols (A … Z).
        * Base systems work on the number of symbols available:
          * Binary → 2 symbols (0,1)
          * Decimal → 10 symbols (0–9)
          * Excel → 26 symbols (A–Z)
        * If we use modulo/divide by 27:
          * That would imply 27 unique symbols are needed (A … Z plus one extra).
          * But Excel doesn’t have a 27th character.

        🔹 What actually happens in Excel

        * Excel columns are like 1-indexed base-26.
        * The tricky part is that there’s no zero digit:
          * Normal base-26: 0 → A, 1 → B, ..., 25 → Z
          * Excel base-26 (1-indexed): 1 → A, 2 → B, ..., 26 → Z, 27 → AA
        * That’s why we do (n - 1) — it shifts the number into 0–25 range to map to letters.

        🔹 Example if we wrongly used 27

        * Say columnNumber = 27.
        * If we did 27 % 27 = 0 → what symbol should “0” map to?
        * Excel has no "0th" letter.
        * We’d need a 27th symbol to handle this — but Excel only defines 26.

        ✅ That’s the core reason: Excel is 1-indexed base-26, not base-27.

     */

    public String convertToTitle(int columnNumber) {

        StringBuilder title = new StringBuilder();
        while(columnNumber > 0) {
            int rem = (columnNumber - 1) % 26;
            title.append((char)('A' + rem));

            columnNumber = (columnNumber - 1) / 26;
        }

        return title.reverse().toString();

    }
}
