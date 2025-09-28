package kunalsProblems.strings.medium;

import java.util.Arrays;
import java.util.List;

public class Problem3MinTimeDifference {
    /*
        LeetCode No : 539, Problem Link : https://leetcode.com/problems/minimum-time-difference/description/

        Youtube Ref : AlgoTamizha
     */
    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];

        int idx = 0;
        for(String time : timePoints) {
            int hh = Integer.parseInt(time.split(":")[0]);
            int mm = Integer.parseInt(time.split(":")[1]);
            times[idx++] = (hh * 60) + mm;
        }

        Arrays.sort(times);
        int minDiff = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(times));

        for(int i = 1; i < times.length; i++) {
            minDiff = Math.min(minDiff, times[i] - times[i - 1]);
        }

        return Math.min(minDiff, (times[0] + (24 * 60)) - times[times.length - 1]);
    }
}
