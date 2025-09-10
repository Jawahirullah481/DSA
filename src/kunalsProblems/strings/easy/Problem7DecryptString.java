package kunalsProblems.strings.easy;

public class Problem7DecryptString {

    /*
        LeetCode No : 1309, Problem Link : https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
     */

    public String freqAlphabets(String s) {

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while(i < s.length()) {
            int num = 0;

            if(i <= s.length() - 3 && s.charAt(i + 2) == '#') {
                num = Integer.parseInt(s.charAt(i) + "" + s.charAt(i + 1));
                i += 3;
            } else {
                num = Integer.parseInt(s.charAt(i) + "");
                i++;
            }

            sb.append((char)('a' + num - 1));
        }

        return sb.toString();

    }
}
