package kunalsProblems.strings.medium;

public class Problem6RepeatedStrings {

    /*
        LeetCode No : 686, Problem Link : https://leetcode.com/problems/repeated-string-match/description/
     */

    public int repeatedStringMatchBetter(String a, String b) {
        int n = a.length();
        int m = b.length();

        int k = (m + n - 1) / n; // ceil(m / n)

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) sb.append(a);
        if (sb.indexOf(b) != -1) return k;

        sb.append(a);
        if (sb.indexOf(b) != -1) return k + 1;

        return -1;
    }

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (sb.indexOf(b) != -1) return count;

        sb.append(a);
        if (sb.indexOf(b) != -1) return count + 1;

        return -1;
    }
}
