package kunalsProblems.sorting.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem19MakeTwoArraysEqual {

    /*
        LeetCode No : 1460, Problem Link : https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/

        Intuition behind solving this problem :
        =======================================

        1. What is a Multiset?
        ----------------------

        * A set only cares about whether an element exists (e.g. {1,2,3} = {3,2,1}).
        * A multiset also cares about how many times each element occurs.

        Example:
        * {1,2,2,3} ≠ {1,2,3,3} because the counts differ.
        * Both contain 1,2,3, but the frequency is different.

        2. Why Does the Problem Reduce to Multisets?
        --------------------------------------------

        * We’re allowed to reverse any subarray in arr.
        * Reversing doesn’t remove or add elements.
        * It only changes the order.
        * By repeatedly reversing, we can reorder arr however we want (so order doesn’t matter at all).
        * So the only thing that matters is whether the bag of elements in arr is identical to the bag of elements in target.
        * That’s exactly the definition of checking if two multisets are equal.

        3. Multiset Equality = Frequency Matching
        -----------------------------------------

        * To check if two arrays are the same multiset:
          * Each element in target must appear in arr.
          * The number of times it appears must match.
        * So we just need to compare frequency counts of all numbers in both arrays.

        4. Example
        ----------

        * target = [1,2,3,2]
          arr = [2,3,2,1]
          Frequency of target: {1:1, 2:2, 3:1}
          Frequency of arr: {1:1, 2:2, 3:1}
          👉 Multisets match → return true.

        * But if arr = [2,3,3,1]:
          Frequency of arr: {1:1, 2:1, 3:2}
          👉 Counts don’t match → return false.

        ✅ Final Intuition
        -----------------

        * The problem is not really about reversing arrays. It’s disguised.
        * The reversal operation guarantees that order doesn’t matter.
        * So the problem reduces to a multiset equality check → “Do both arrays contain the same elements, with the same frequencies?”

     */

    public boolean canBeEqualOptimalForVariableSize(int[] target, int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : target) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (!freq.containsKey(num)) return false;
            freq.put(num, freq.get(num) - 1);
            if (freq.get(num) == 0) {
                freq.remove(num);
            }
        }

        return freq.isEmpty();
    }

    public boolean canBeEqualOptimalForFixedSize(int[] target, int[] arr) {
        int[] freq = new int[1001];

        for (int num : target) {
            freq[num]++;
        }

        for (int num : arr) {
            if (freq[num] != 0) {
                freq[num]--;
            }
        }

        int sum = 0;
        for (int i : freq) {
            sum += i;
        }

        return sum == 0;
    }

    public boolean canBeEqualBrute(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) {
                return false;
            }
        }

        return true;
    }
}
