package kunalsProblems.strings.medium;

public class Problem8MaxNumberOfRemovableCharacters {
    /*

        LeetCode No : 1898, Problem Link : https://leetcode.com/problems/maximum-number-of-removable-characters/description/

        Here, Solution 1 is Optimal. Because, in the Question it is stated that "find the maximum number of removable characters". Hence, this can solved by shrinking the range.
     */

    // Solution 1
    public int maximumRemovalsOptimal(String s, String p, int[] removable) {

        int st = 0, end = removable.length - 1;
        int ans = -1;
        while(st <= end) {
            int mid = (st + end) / 2;

            if(isSubsequenceAfterRemoval(s, p, removable, mid)) {
                ans = mid;
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans + 1;

    }

    private boolean isSubsequenceAfterRemoval(String s, String p, int[] removable, int k) {
        boolean[] removed = new boolean[s.length()];
        for(int i = 0; i <= k; i++) {
            removed[removable[i]] = true;
        }

        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < s.length() && ptr2 < p.length()) {
            if(removed[ptr1]) {
                ptr1++;
                continue;
            }

            if(s.charAt(ptr1) == p.charAt(ptr2)) {
                ptr2++;
            }

            ptr1++;
        }

        return ptr2 == p.length();
    }

    // Solution 2
    public int maximumRemovals(String s, String p, int[] removable) {

        StringBuilder sb = new StringBuilder(s);
        int i = 0;

        for(i = 0; i < removable.length; i++) {

            sb.setCharAt(removable[i], '.');
            if(!isSubsequence(sb.toString(), p)) {
                break;
            }
        }

        return i;

    }

    private boolean isSubsequence(String a, String b) {
        int ptr1 = 0, ptr2 = 0;

        while(ptr1 < a.length() && ptr2 < b.length()) {
            while(ptr1 < a.length() && a.charAt(ptr1) != b.charAt(ptr2)) {
                ptr1++;
            }

            ptr1++; ptr2++;
        }

        return ptr2 == b.length();
    }

}
