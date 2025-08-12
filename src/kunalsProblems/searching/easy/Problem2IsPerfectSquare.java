package kunalsProblems.searching.easy;

public class Problem2IsPerfectSquare {

    /*
        LeetCode No : 367, Problem Link : https://leetcode.com/problems/valid-perfect-square/description/
     */

    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;

        long st = 2, end = num / 2;

        while(st <= end) {
            long mid = st + (end - st) / 2;
            long sqr = mid * mid;

            if(sqr == num) return true;

            if(sqr < num) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

}
