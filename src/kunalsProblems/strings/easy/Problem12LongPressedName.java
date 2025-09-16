package kunalsProblems.strings.easy;

public class Problem12LongPressedName {

    /*
        LeetCode No : 925, Problem Link : https://leetcode.com/problems/long-pressed-name/
     */

    public boolean isLongPressedName(String name, String typed) {

        int i = 0, j = 0;

        while(i < name.length() && j < typed.length()) {
            if(name.charAt(i) == typed.charAt(j)) {
                i++; j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }

        while(j < typed.length()) {
            if(typed.charAt(j) == name.charAt(i - 1)) {
                j++;
            } else {
                return false;
            }
        }

        return i == name.length() && j == typed.length();

    }
}
