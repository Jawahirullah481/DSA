package kunalsProblems.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem2NumberOfGoodPairs {
    /*
        LeetCode : 1512. Link : https://leetcode.com/problems/number-of-good-pairs/description/

     */

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,3};

        // 1.
        solutionBrute(arr);

        // 2.
        solutionOptimal(arr);

        // 3.
        solutionOptimal1(arr);
    }

    public static int solutionBrute(int[] nums) {
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static int solutionOptimal(int[] nums) {

        /*
            Suppose, we have following array.
            [1, 1, 1, 1]

            1. When you first see the first 1, you look into the map. But, nothing exists. Means, you cannot make any pair out of this. Just update 1's count to 1.
            2. When you see the 1 again, you look into the map. Now, you already have one 1. So, you can make a pair now. So, increment the count to 1.
            3. When you see the 1 again, you look into the map. Now, you have 2 1s in the map. Means, with the current 1, you can make 2 pairs. 1 with first one in the map and 1 with second one in the map. so the count += 2.
            4. When you see the 1 again, you look into the map. Now, you have 3 1s in the map. Means, with the current 1, you can make pair with each of the ones in the map, which is 3. So, count += 3.

         */
        Map<Integer, Integer> numberCount = new HashMap<>();
        int ans = 0;

        for(int num : nums) {
            if(numberCount.containsKey(num)) {
                int count = numberCount.get(num);
                ans += count;
                numberCount.replace(num, count + 1);
            } else {
                numberCount.put(num, 1);
            }
        }

        return ans;
    }

    public static int solutionOptimal1(int []nums) {
        /*
            In this leetcode problem, there is a constraint that the 1 <= nums[i] <= 100.   ````````
            So, I can declare a frequency array to store count of each number.
            After that, we use formula [(n * (n - 1)) / 2], which is used to find the number of ways to choose 2 elements from n distinct items (unordered pairs): which is commonly used in maths.
            How, this formula used in solving this problem.

            Solution :
            ==========

            I have 4 2's. How many pairs I can make out of these 4 2's. So, thereby this formula is used.

            Even i map also,

            1. When you 1st see the number, count = 0 (I can pair with no one).
            2. When you 2nd see the same number, count = 0 + 1 (I can pair with first).
            3. When you 3rd see the same number, count = 0 + 1 + 2 (I can pair with first and second).
            4. When you 4th see the same number, count = 0 + 1 + 2 + 3(I can pair with first, second and third).

            which can be derived using the formula,
            n * (n - 1 ) / 2
         */

        int[] freq = new int[101];  // since 1 <= nums[i] <= 100
        for (int num : nums) {
            freq[num]++;
        }

        int count = 0;
        for (int f : freq) {
            if (f > 1) {
                count += f * (f - 1) / 2;
            }
        }
        return count;
    }
}
