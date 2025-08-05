package kunalsProblems.arrays.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6AddToArrayFormInteger {
    /*
        Leetcode Problem No : 989. Link : https://leetcode.com/problems/add-to-array-form-of-integer/description/

        Dry run of below program :
        ==========================

        num = [2, 1, 5], k = 2806, carry = 2806(we take)

        -- 1. -> num[2] + 2806(carry)
              -> 5 + 2806 = 2811
              -> 2811 % 10 = 1.
              -> list = [1], carry = 2811 / 10 = 281.

        -- 2. -> num[1] + 281(carry)
              -> 1 + 281 = 282
              -> 282 % 10 = 2
              -> list = [1, 2], carry = 282 / 10 = 28.

        -- 3. -> num[0] + 28(carry)
              -> 2 + 28 = 30
              -> 30 % 10 = 0
              -> list = [1, 2, 0], carry = 30 / 10 = 3.

        -- 4. -> 3(carry)
              -> 3 % 10 = 3
              -> list = [1, 2, 0, 3], carry = 3 / 10 = 0.

         -- 5. reverse(list) => 3 0 2 1
     */
    public List<Integer> addToArrayForm(int[] num, int k) {

        int carry = k;
        List<Integer> res = new ArrayList<>();

        int i = num.length - 1;

        while (i >= 0 || carry > 0) {
            if (i >= 0) {
                carry = carry + num[i];
                i--;
            }

            res.add(carry % 10);
            carry /= 10;
        }

        Collections.reverse(res);
        return res;

    }

}
