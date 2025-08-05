package kunalsProblems.arrays.easy;

public class Problem8IntegersSumUptoZero {

    /*
        LeetCode No : 1304, Link : https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
     */
    public static void main(String[] args) {

    }

    public int[] sumZero1(int n) {
        /*
            Intuition :
            ==========

            1. If you want to store n elements in array, first put 1 to n - 1 elements.
            2. Then put negative of sum of all numbers upto n - 1.
            3. It'll nullify the array.

         */
        int[] ans = new int[n];
        int sum = 0;

        for (int i = 0; i < n - 1; i++) {
            ans[i] = i + 1;
            sum += i + 1;
        }

        ans[n - 1] = -sum;
        return ans;
    }

    public static int[] sumZero2(int n) {
        /*
            Intuition :
            =========

            1. For every number, put its negative number into the array. so that it will become sum to 0.
            2. For the odd n, put 0 also, so, the sum will become 0.

         */

        int[] ans = new int[n];

        int st = 0, end = 0;

        if(n == 1) {
            ans[0] = 0;
            return ans;
        }

        st = (n / 2);
        end = (n / 2);

        int sum = 0;
        int j = 0;
        for(int i = -st; i <= end; i++) {
            if(i == 0 && n % 2 != 1) {
                continue;
            }
            ans[j++] = i;
            sum += i;
        }

        return ans;
    }
}
