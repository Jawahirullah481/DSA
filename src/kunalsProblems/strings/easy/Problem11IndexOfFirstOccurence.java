package kunalsProblems.strings.easy;

public class Problem11IndexOfFirstOccurence {

    /*
        LeetCode No : 28, Problem Link : https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
     */

    public int strStr(String haystack, String needle) {
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            String str = haystack.substring(i, i + needle.length());
            if(str.equals(needle)) {
                return i;
            }
        }

        return -1;
    }

}
