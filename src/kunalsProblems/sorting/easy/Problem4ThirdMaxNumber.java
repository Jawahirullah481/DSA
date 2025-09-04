package kunalsProblems.sorting.easy;

import java.util.TreeSet;

public class Problem4ThirdMaxNumber {

    /*
        LeetCode No : 414, Problem Link : https://leetcode.com/problems/third-maximum-number/
     */

    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;

        for(int i : nums) {
            if(i > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = i;
            } else if (i > secondMax && i != firstMax) {
                thirdMax = secondMax;
                secondMax = i;
            } else if (i > thirdMax && i != secondMax && i != firstMax) {
                thirdMax = i;
            }
        }

        return (int)(thirdMax != Long.MIN_VALUE ? thirdMax : Math.max(firstMax, secondMax));
    }

    public int thirdMaxTreeSetApproach(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.pollFirst(); // remove the smallest to keep only top 3
            }
        }

        return set.size() == 3 ? set.first() : set.last();
    }

}
