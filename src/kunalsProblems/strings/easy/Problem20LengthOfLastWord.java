package kunalsProblems.strings.easy;

public class Problem20LengthOfLastWord {

    /*
        LeetCode No : 58, Problem Link : https://leetcode.com/problems/length-of-last-word/description/
     */

    public int lengthOfLastWord(String s) {
        int ptr = s.length() - 1;

        while (ptr >= 0 && s.charAt(ptr) == ' ') ptr--;
        int st = ptr;

        while (ptr >= 0 && s.charAt(ptr) != ' ') ptr--;
        int end = ptr;

        return st - end;
    }

}
