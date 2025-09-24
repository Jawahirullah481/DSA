package kunalsProblems.strings.medium;

public class Problem12CountHomogenousSubstring {
    /*
        LeetCode No : https://leetcode.com/problems/get-equal-substrings-within-budget/description/
     */

    public int countHomogenous(String s) {

        long MOD = 1_000_000_007;
        long ans = 0;
        char prev = ' ';
        long count = 0;

        for(char c : s.toCharArray()) {
            if(c == prev) {
                count++;
            } else {
                ans += (count * (count + 1) / 2) % MOD;
                count = 1;
                prev = c;
            }
        }

        if(count > 0) {
            ans += (count * (count + 1) / 2) % MOD;
        }

        return (int)ans;
    }
}
