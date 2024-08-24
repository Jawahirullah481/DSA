package prevproblems;

import jdk.jfr.Description;

public class CodeIO2 {
    public static void main(String[] args) {
        // Problem 1
        gcdEuclidean();

        // Problem 2
        computeExpression();

        // Problem 3
        solveBinary();

        // Problem 4
        findRatio();
    }

    @Description("Problem 1")
    private static void gcdEuclidean() {
        /*
            Thought Process :
            =================
            1. Take n1
            2. Take n2
            3. Find rem (n1 / n2).
            4. Put n1 = n2.
            5. Put n2 = rem.
            6. check if n2 is 0.
            7. If n2 is 0, then gcd is n1.
            8. Else, continue.
         */
        int n1 = 25;
        int n2 = 15;

        int rem = 0;

        while(n2 != 0) {
            rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }

        System.out.println("GCD is : " + n1);
    }

    @Description("Problem 2")
    public static void computeExpression() {
        String str = "67542-/+-";

        int i = 0, j = -1;
        char c = ' ';
        do {
            j++;
            c = str.charAt(j);
        } while(Character.isDigit(c));

        char symbol = str.charAt(j);
        char n1 = str.charAt(i);
        char n2 = str.charAt(i + 1);
        int ans = solve(Character.digit(n1, 10), Character.digit(n2, 10), symbol);
        i = i + 2;
        j++;
        while(j < str.length()) {
           symbol = str.charAt(j);
           n2 = str.charAt(i);
           ans = solve(ans, Character.digit(n2, 10), symbol);
           j++;i++;
        }

        System.out.println("Answer is : " + ans);
    }

    public static int solve(int a, int b, char symbol) {
        int ans = 0;
        switch(symbol) {
            case '+': ans = a + b;break;
            case '-': ans = a - b;break;
            case '*': ans = a * b;break;
            case '/': ans = a / b;break;
        }

        return ans;
    }

    @Description("Problem 3")
    public static void solveBinary() {
        String str = "1C0C1C1A0B1";
        int i = 0;
        int j = 1;
        int a = Character.digit(str.charAt(i), 2);
        i += 2;
        int b = 0;

        while(i < str.length() && j < str.length()) {
            b = Character.digit(str.charAt(i), 2);
            a = solveBinary(a, b, str.charAt(j));
            j += 2;
            i += 2;
        }

        System.out.println("Output is : " + a);
    }

    public static int solveBinary(int a, int b, char c) {
        int res = 0;
        switch(c) {
            case 'C' : res = a ^ b; break;
            case 'B' : res = a | b; break;
            case 'A' : res = a & b; break;
        }
        return res;
    }

    @Description("Problem 4")
    public static void findRatio() {
        /*
            Problem statement :
            ===================
            1. Find ratio of positive elements count to negative elements count to zeros count.
            2. Print the ratio in ration with 6 decimal digit
         */
        int[] arr = {1, 2, -5, 0, 0, -2, 2, 5, 1};
        double positive = 0, negative = 0, zeros = 0;
        for(int i : arr) {
            if(i < 0) {
                negative++;
            } else if(i > 0) {
                positive++;
            } else {
                zeros++;
            }
        }

        positive = positive / arr.length;
        negative = negative / arr.length;
        zeros = zeros / arr.length;

        System.out.printf("%.6f , ", positive);
        System.out.printf("%.6f , ", negative);
        System.out.printf("%.6f", zeros);
    }

}
