package kunalsProblems.sorting.easy;

public class Problem2MajorityElement {

    /*
        Intution :
        =========

        Problem Restated
        ----------------

        We’re given an array nums and need to find the element that appears more than ⌊ n/2 ⌋ times.

        * By definition, there is always exactly one majority element in the input.

        Naive Ideas (before optimal)
        ----------------------------

        * HashMap / Counting: Count frequency of each element → O(n) time, O(n) space.
        * Sorting: Sort the array → the majority element must be at the middle index → O(n log n) time.
          ✅ Works, but not optimal.

        Key Insight 💡
        --------------

        * If an element is the majority element (> n/2 occurrences), it will outnumber all other elements combined.
        * So if you start "cancelling out" different elements, the majority element will still remain at the end.

        Step-by-Step Intuition of Boyer–Moore
        -------------------------------------

        * Think of it like a vote system.
        * num = candidate, count = balance of votes.
        * Start with the first element as the candidate.
        * Traverse the array:
          * If the current element is the same as num, increase count (more support).
          * If it’s different, decrease count (opposition cancels one vote).
          * If count drops to 0, we "reset" → pick the current element as a new candidate.
            (Because so far, equal number of candidate and non-candidate votes have cancelled out.)
        * By the end, the candidate num will be the majority element, because it couldn’t be completely cancelled out.

     */

    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == num) {
                count++;
            } else {
                count--;
            }

            if(count == 0) {
                num = nums[i];
                count = 1;
            }
        }

        return num;
    }
}
