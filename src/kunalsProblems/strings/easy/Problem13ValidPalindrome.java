package kunalsProblems.strings.easy;

public class Problem13ValidPalindrome {

    /*
        LeetCode No : 125, Problem Link : https://leetcode.com/problems/valid-palindrome/
     */

    public boolean isPalindrome(String s) {
        int st = 0, end = s.length() - 1;

        while(st <= end) {
            while(st < s.length() && !Character.isDigit(s.charAt(st)) && !Character.isAlphabetic(s.charAt(st))) {
                st++;
            }

            while(end >= 0 && !Character.isDigit(s.charAt(end)) && !Character.isAlphabetic(s.charAt(end))) {
                end--;
            }

            if(st <= end) {
                char letter1 = Character.toLowerCase(s.charAt(st));
                char letter2 = Character.toLowerCase(s.charAt(end));

                if(letter1 != letter2) { return false; }
                else { st++; end--; }
            }
        }

        return true;
    }
}
