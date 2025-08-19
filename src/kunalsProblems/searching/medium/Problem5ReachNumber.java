package kunalsProblems.searching.medium;

public class Problem5ReachNumber {

    /*
        LeetCode No : 754, Problem Link : https://leetcode.com/problems/reach-a-number/

        Intution :
        =========
        1. As per the problem statement,
            * At 1st move you can go either +1 or -1
            * At 2nd move you can go either +2 or -2
            * At nth move you can go either +n or -n.

        2. We need to find the minimum moves. So, we completely move in single direction(positive direction) in this case to reach the target quicker.

        3. If luck is on our side, we can exactly reach the target at nth step.

        4. But, what if we cross that. Oh shit. There is a problem here.
           For this, we have a trick or some logic.

        5. # If we reached 2 steps more than the target, we can flip the 1st move to move in negative direction.
           # If we reached 4 steps more than the target, we can flip the 2nd move to move in negative direction.
           # If we reached 2n steps more than the target, we can flip the nth move to move in negative direction.

        6. By doing so, still at n steps we can reach the target by only flipping.

        7. Hey wait! What if I reached 1 or 3 or 5 or any odd number of steps more than the target.
           # If I flip 1st move, from +1 to -1, there are 2 steps only not 1 steps.
           # If I flip 2nd move, from +2 to -2, there are 4 steps only not 3 steps.

           Then How can i solve odd number of steps.

        8. For this case, you need to move further and further until you difference between the target and total steps become even count.
        9. By doing so, we can easily flip the necessary move to reach the target. For example kth step.

        10. NOTE : We needn't flip only 1 move to make it reach the target.
            We can split the difference to 2 or more moves.

            Example :
            ========
            If the target is 12, and you reached the even difference after target at 28, the difference is 28 - 12 which is 16.
            But, to reach 28, you only came across 7 moves. Then how can if flip the 8th move as it doesn't exist.

            For such cases, we can reduce the difference of 16 by flipping 3rd move and 5th move.
            => +3 to -3 (6 steps)
            => +5 to -5 (10 steps)
            => total 16 steps reduces and we can reach the target.

     */

    public int reachNumber(int target) {

        target = Math.abs(target);

        int steps = 0;
        int pos = 0;

        while (pos < target || (pos - target) % 2 != 0) {
            steps++;
            pos += steps;
        }

        return steps;
    }
}
