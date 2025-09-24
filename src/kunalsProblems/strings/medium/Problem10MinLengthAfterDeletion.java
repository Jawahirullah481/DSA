package kunalsProblems.strings.medium;

public class Problem10MinLengthAfterDeletion {
    /*
        LeetCode No : 1750, Problem Link : https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
     */

    public int minimumLength(String s) {
        int prefPtr = 0, suffPtr = s.length() - 1;

        while(prefPtr < suffPtr) {
            while(prefPtr < suffPtr && s.charAt(prefPtr) == s.charAt(suffPtr) && s.charAt(prefPtr) == s.charAt(prefPtr + 1)) {
                prefPtr++;
            }

            while(prefPtr < suffPtr && s.charAt(prefPtr) == s.charAt(suffPtr) && s.charAt(suffPtr) == s.charAt(suffPtr - 1)) {
                suffPtr--;
            }

            if(s.charAt(prefPtr) == s.charAt(suffPtr)) {
                prefPtr++;
                suffPtr--;
            } else {
                break;
            }
        }

        int ans = suffPtr - prefPtr + 1;

        return Math.max(ans, 0);
    }
}
