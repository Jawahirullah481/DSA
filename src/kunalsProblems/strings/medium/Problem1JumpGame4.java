package kunalsProblems.strings.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1JumpGame4 {
    /*
        LeetCode No : 1871, Problem Link : https://leetcode.com/problems/jump-game-vii/description/
     */

    // Optimal Solution
    public int numWays(String s) {
        long MOD = 1_000_000_007;

        int onesCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') onesCount++;
        }

        if (onesCount % 3 != 0) return 0;

        if (onesCount == 0) {
            int n = s.length();
            long ways = ((long) (n - 1) * (n - 2)) / 2;
            return (int) (ways % MOD);
        }

        int k = onesCount / 3;

        int firstKOnes = 0, i = 0;
        int firstZerosCount = 0;

        // Count zeros after first k ones
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '1') firstKOnes++;
            if (firstKOnes == k) {
                i++;
                while (i < s.length() && s.charAt(i) == '0') {
                    firstZerosCount++;
                    i++;
                }
                break;
            }
        }

        int secondKOnes = 0, secondZerosCount = 0;

        // Count zeros after second k ones
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '1') secondKOnes++;
            if (secondKOnes == k) {
                i++;
                while (i < s.length() && s.charAt(i) == '0') {
                    secondZerosCount++;
                    i++;
                }
                break;
            }
        }

        long ways = ((long) (firstZerosCount + 1) * (secondZerosCount + 1)) % MOD;
        return (int) ways;
    }


    public boolean canReach(String s, int minJump, int maxJump) {

        if (s.charAt(s.length() - 1) != '0') {
            return false;
        }

        boolean[] visited = new boolean[s.length()];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            int idx = queue.poll();
            for (int i = idx + minJump; i <= idx + maxJump && i < s.length(); i++) {
                if (s.charAt(i) == '0' && !visited[i]) {
                    if (i == s.length() - 1) {
                        return true;
                    } else {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }

        }

        return false;

    }
}
