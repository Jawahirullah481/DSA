package kunalsProblems.strings.easy;

public class Problem14ValidPalindrome2 {
    /*
        LeetCode No : 680, Problem Link : https://leetcode.com/problems/valid-palindrome-ii/
     */

    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1, false);
    }

    private boolean isPalindrome(String s, int st, int end, boolean isReplaced) {

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

                if(letter1 != letter2) {
                    if(isReplaced) {
                        return false;
                    } else {
                        isReplaced = true;
                        return isPalindrome(s, st + 1, end, isReplaced) || isPalindrome(s, st, end - 1, isReplaced);
                    }
                } else {
                    st++; end--;
                }
            }
        }

        return true;
    }
}
