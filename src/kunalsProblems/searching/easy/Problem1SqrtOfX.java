package kunalsProblems.searching.easy;

public class Problem1SqrtOfX {

    /*
        LeetCode No : 69, Problem Link : https://leetcode.com/problems/sqrtx/

        NOTE :
        ======

        In Binary Search, If you want to find
        # ceil -> pick st/min
        # floor -> pick end/max

       Important : Suppose, if you have a confusion of "whether should we floor it or ceil it."
                   Think like "both the st and end are pointing to the answer element. In the next call, which one still point the answer."
     */

    public int mySqrt(int x) {

        if(x <= 1) return x;

        long min = 2, max = x / 2;

        while(min <= max) {
            long mid = min + (max - min) / 2;
            long sqr = mid * mid;

            if(sqr == x) {
                return (int)mid;
            } else if (sqr > x){
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return (int)max;
    }

}
