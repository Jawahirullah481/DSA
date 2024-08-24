package prevproblems;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CodeIO3 {
    public static void main(String[] args) {
        // Problem 1
        reciprocalString();

        // Problem 2
        isDivisibleBy3();

        // Problem 3
        bracketNumber();
    }

    @Description("Problem 1")
    public static void reciprocalString() {
        String str = "xyZ";
        System.out.println((int)'A');
        System.out.println((int)'a');

        String res = "";

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                int n = (int)(c - 'A');
                res += (char)('Z' - n);
            } else {
                int n = (int)(c - 'a');
                res += (char)('z' - n);
            }
        }

        System.out.println("Reciprocal string is : " + res);
    }

    @Description("Problem 2")
    public static void isDivisibleBy3() {
        /*
            Approach 1 (Number system approach):
            =====================================
            Add all the digits of every number of array.
            Check if it is divisible by 3.

            Approach 2 :
            =============
            Sum every remainder after dividing every number with 3.
            Finally, if sum is divisible by 3, then it is divisible by 3.x`
         */
        int[] arr = {40, 50, 90};
        int sum = 0;
        for(int i : arr) {
            sum += i % 3;
        }

        if(sum % 3 == 0) {
            System.out.println("The given array is divisible by 3");
        } else {
            System.out.println("The given array is not divisible by 3");
        }
    }

    @Description("Problem 3")
    public static void bracketNumber() {
        /*
            Problem statement :
            ===================
            1. Whenever you find a bracket, print it's bracket count.

            Thought Process :
            =================
            1. Take a counter variable to count bracket count.
            2. Whenever you see a open bracket, increment the count and put it stack.
            3. Whenever you see a close bracket, pop the top most element of stack and print it.

         */

        String str = "(aa(bdc))p(dee)ade";
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                count++;
                stack.push(count);
                res.add(count);
            } else if(c == ')') {
                res.add(stack.pop());
            }
        }

        System.out.println(res);
    }
}
