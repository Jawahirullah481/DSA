package kunalsProblems.searching.medium;

public class Problem10FindDuplicateNumber {
    /*
        LeetCode No : 287, Problem Link : https://leetcode.com/problems/find-the-duplicate-number/

        🔹 Step 1: Pigeonhole principle guarantees duplication

         There are n + 1 values but only n distinct numbers (1..n) available.
        👉 At least one number repeats. Call it D.

        So two different indices i and j (with i ≠ j) satisfy:
        nums[i] = nums[j] = D


        🔹 Step 2: Graph structure

        Think of this as a functional graph:
        * Each index has exactly one outgoing edge (because nums[i] is a single number).
        * Multiple indices can point to the same next index.

        Because of the duplicate:
        * Two arrows go into the same node (D).
        * From that node forward, the path must eventually repeat (since the graph is finite and deterministic).

        Thus → a cycle exists.

        🔹 Step 3: Why the cycle is unavoidable

        Let’s follow from index 0:
        * Since nums[i] ∈ [1, n], you can never "fall off" the array.
        * With n + 1 steps, by the pigeonhole principle again, you must revisit some index.
        * The moment you revisit, you’ve entered a cycle.

        So the traversal is guaranteed to end up looping.

        🔹 Step 4: Why the duplicate = cycle entry

        * The duplicate value D is exactly the first index where two different arrows merge.
        * From then onward, you’re trapped in a loop.
        So: Duplicate value = entry point of the cycle.

     */

    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

}
