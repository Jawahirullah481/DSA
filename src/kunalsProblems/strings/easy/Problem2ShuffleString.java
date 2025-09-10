package kunalsProblems.strings.easy;

public class Problem2ShuffleString {
    /*
        LeetCode No : 1528, Problem Link : https://leetcode.com/problems/shuffle-string/description/

        The Additional Solution is just to know the alternate as well.
     */

    public String restoreStringAdditional(String s, int[] indices) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < indices.length; i++) {
            sb.setCharAt(indices[i], s.charAt(i));
        }
        return sb.toString();
    }

    public String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];
        for(int i = 0; i < indices.length; i++) {
            arr[indices[i]] = s.charAt(i);
        }

        return new String(arr);
    }
}
