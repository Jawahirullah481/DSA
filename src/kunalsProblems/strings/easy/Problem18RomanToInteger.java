package kunalsProblems.strings.easy;

import java.util.Map;

public class Problem18RomanToInteger {
    /*
        LeetCode No : 13, Problem Link : https://leetcode.com/problems/roman-to-integer/

        NOTE :
        ======
        If we traverse from left to right, we will end up getting wrong answer. That's not the correct process.
     */

    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

        int num = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            int prev = i < s.length() - 1 ? map.get(s.charAt(i + 1)) : Integer.MIN_VALUE;
            int curr = map.get(s.charAt(i));

            if(curr < prev) {
                num -= curr;
            } else {
                num += curr;
            }
        }

        return num;
    }
}
