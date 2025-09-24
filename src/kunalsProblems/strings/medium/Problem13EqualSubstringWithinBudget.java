package kunalsProblems.strings.medium;

public class Problem13EqualSubstringWithinBudget {
    /*
        LeetCode No : 1208, Problem Link : https://leetcode.com/problems/get-equal-substrings-within-budget/description/

     */
    public int equalSubstring(String s, String t, int maxCost) {
        int maxLength = 0; // store max window length
        int cost = 0;      // current window cost
        int left = 0;      // start of the window

        // Expand the window with 'right' pointer
        for (int right = 0; right < s.length(); right++) {
            // Add cost of new character
            cost += Math.abs(s.charAt(right) - t.charAt(right));

            // Shrink window if cost exceeds maxCost
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            // Update maxLength after each expansion
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
