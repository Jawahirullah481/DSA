package kunalsProblems.strings.medium;

import java.util.Stack;

public class Problem5BasicCalculator2 {
    /*
        LeetCode No : 227, Problem Link : https://leetcode.com/problems/basic-calculator-ii/description/
     */

    public int calculate(String s) {

        int num = 0;
        char lastSign = '+';

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                num = (num * 10) + (c - '0');
            }

            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if(lastSign == '+') {
                    stack.push(num);
                } else if (lastSign == '-') {
                    stack.push(-num);
                } else if (lastSign == '*') {
                    stack.push(stack.pop() * num);
                } else if (lastSign == '/') {
                    stack.push(stack.pop() / num);
                }

                num = 0;
                lastSign = c;
            }

        }

        int result = 0;
        for(int n : stack) {
            result += n;
        }

        return result;

    }
}
