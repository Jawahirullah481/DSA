package kunalsProblems.strings.easy;

import java.util.Stack;

public class Problem19ValidParenthesis {

    /*
        LeetCode No : 20, Problem Link : https://leetcode.com/problems/valid-parentheses/

        Note the array representation of stack solution.
     */

    public boolean isValidArrayDenotion(String s) {
        char[] arr = new char[s.length()];
        int top = -1; // points to top of stack

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                arr[++top] = c; // push
            } else {
                if (top == -1) return false; // stack empty
                char open = arr[top--];      // pop
                if ((c == ')' && open != '(') ||
                        (c == ']' && open != '[') ||
                        (c == '}' && open != '{')) {
                    return false;
                }
            }
        }

        return top == -1; // stack empty means valid
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        for(char c : s.toCharArray()) {
            if(c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if(stack.size() == 0) return false;

                char top = stack.peek();
                if((c == ']' && top != '[') || (c == ')' && top != '(') || (c == '}' && top != '{')) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.size() == 0;
    }
}
