package kunalsProblems.strings.easy;

public class Problem6ToLowerCase {
    /*
        LeetCode No : 709, Problem Link : https://leetcode.com/problems/to-lower-case/
     */

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {

            if(c >= 'A' && c <= 'Z') {
                sb.append((char)('a' + (c - 'A')));
            } else {
                sb.append((char)c);
            }

        }

        return sb.toString();
    }
}
