package kunalsProblems.strings.medium;

public class Problem2CheckPalindrome {

    /*
        LeetCode No : 1616, Problem Link : https://leetcode.com/problems/split-two-strings-to-make-palindrome/description/
     */

    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private boolean check(String a, String b) {
        int st = 0, end = a.length() - 1;

        while (st < end && a.charAt(st) == b.charAt(end)) {
            st++;
            end--;
        }

        return isPalindrome(a, st, end) || isPalindrome(b, st, end);
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

}
