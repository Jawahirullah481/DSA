package datastructure.linkedlist.problems.singly;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 19;
        System.out.println("The number " + n + " is : " + (isHappy(n) ? "Happy NUmber" : "Not happy Number"));
    }
    public static boolean isHappy(int n) {
        /*
        A happy number is a number defined by the following process:

        # Starting with any positive integer, replace the number by the sum of the squares of its digits.
        # Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
        # Those numbers for which this process ends in 1 are happy.

        Return true if n is a happy number, and false if not.
         */
        int pointer1 = n;
        int pointer2 = n;

        do {
            pointer1 = squareSum(pointer1);
            pointer2 = squareSum(squareSum(pointer2));

            if(pointer1 == 1 || pointer2 == 1) {
                return true;
            }

        } while(pointer1 != pointer2);

        return false;
    }

    public static int squareSum(int num) {
        int ans = 0;
        while(num > 0) {
            int rem = num % 10;
            ans += rem * rem;
            num = num / 10;
        }

        return ans;
    }
}
