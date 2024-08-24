package prevproblems;

import jdk.jfr.Description;

public class Set22 {
    public static void main(String[] args) {
        // Problem 1
        minimumSquares();
    }

    @Description("Problem 1")
    public static void minimumSquares() {
        int n = 12;

        int i = 1;
        for(i = 1; i * i <= n; i++) {}

        if(i * i == n) {
            System.out.println("Minimum squares : " + 1);
            return;
        }

        i = i - 1;

        int sum = 0;
        int count = 0;
        int currSum = 0;

        while(sum != n) {
            currSum = sum + (i * i);
            if(currSum > n) {
                i--;
            } else {
                sum = currSum;
                count++;
            }
        }

        System.out.println("Minimum Squares : " + count);
    }
}
