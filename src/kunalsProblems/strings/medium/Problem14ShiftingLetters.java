package kunalsProblems.strings.medium;

public class Problem14ShiftingLetters {
    /*
        LeetCode No : 848, Problem Link : https://leetcode.com/problems/shifting-letters/
     */

    public String shiftingLetters(String s, int[] shifts) {

        for(int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }

        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            int diff = (int)(arr[i] - 'a');
            int shift = (diff + shifts[i]) % 26;
            arr[i] = (char)('a' + shift);
        }

        return new String(arr);
    }
}
