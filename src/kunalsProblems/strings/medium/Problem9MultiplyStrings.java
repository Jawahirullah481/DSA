package kunalsProblems.strings.medium;

import java.util.Arrays;

public class Problem9MultiplyStrings {
    /*
        LeetCode No : 43, Problem Link : https://leetcode.com/problems/multiply-strings/description/
     */

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        char[] ans = new char[m + n];
        Arrays.fill(ans, '0');

        int currPos = ans.length - 1;

        for (int i = m - 1; i >= 0; i--) {
            int carry = 0;
            int pos = currPos;

            for (int j = n - 1; j >= 0; j--, pos--) {
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';
                int sum = x * y + (ans[pos] - '0') + carry;
                ans[pos] = (char) ('0' + (sum % 10));
                carry = sum / 10;
            }

            if (carry > 0) {
                ans[pos] = (char) ('0' + carry);
            }

            currPos--;
        }

        // Convert char array to String without leading zeros
        StringBuilder sb = new StringBuilder();
        boolean nonZeroFound = false;
        for (char c : ans) {
            if (!nonZeroFound && c != '0') nonZeroFound = true;
            if (nonZeroFound) sb.append(c);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

}
