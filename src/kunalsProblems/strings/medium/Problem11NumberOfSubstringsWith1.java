package kunalsProblems.strings.medium;

public class Problem11NumberOfSubstringsWith1 {
    /*
        LeetCode No : 1513, Problem Link : https://leetcode.com/problems/number-of-substrings-with-only-1s/description/
     */
    
    public int numSub(String s) {
        long MOD = 1_000_000_007;
        long count = 0, ans = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++; // extend streak
                ans = (ans + count) % MOD; // add substrings ending here
            } else {
                count = 0; // reset streak
            }
        }
        return (int) ans;
    }
}
