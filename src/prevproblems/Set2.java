package prevproblems;

import jdk.jfr.Description;

import java.util.Arrays;

public class Set2 {

    public static void main(String[] args) {
        // Problem 1
        //rearrangeArray();

        // Problem 2
        //removeUnbalancedParenthesis();

        // Problem 3
        nthNumberFrom3And4();


        // Problem 4


        // Problem 5
    }

    @Description("Problem 1")
    public static void rearrangeArray() {
        /*
            Question :
            =========
            Alternate sorting: Given an array of integers, rearrange the array in such a way that
            the first element is first maximum and second element is first minimum.

            Thought Process :
            =================
            1. Sort the array.
            // 1, 2, 3, 4, 5, 6, 7
            // 1. 2, 3, 4, 5, 6
         */

        int[] arr = {2, 3, 5, 1, 6, 7, 4};
        int[] res = new int[arr.length];

        Arrays.sort(arr);
        int left = 0, right = arr.length - 1, i = 0;

        while(left <= right) {
            res[i++] = arr[right--];
            if(left <= right) {
                res[i++] = arr[left++];
            }
        }

        System.out.println("After reorder : " + Arrays.toString(res));
        System.out.println("========================================\n");
    }

    @Description("Problem 2")
    public static void removeUnbalancedParenthesis() {
        /*
            Thought Process :
            =================
            1. Take counter to keep track of whether closing bracket contains equivalent open bracket.
            2. When you see open bracket, then count++.
            3. When you see close bracket, then count--.
            4. if count < 0, that means there is extra close bracket available or there is no
                equivalent open bracket for that close bracket. In that time, remove that close bracket
                and decrement count by 1 and again traverse next letter.
            5. Again we have to do for reverse order to know extra opening parenthesis.

            NOTE :
            ======
            1. During forward traversal, we won't update i when we delete char. Because,
               when we delete character, automatically i points to the next character of the deleted char.
            2. During reverse traversal, we update i whether we delete or not. Because,
               if we won't update i, then after deletion i will point already traversed character.


            # Iterate forward and remove extra close brackets.
            # Iterate backward and remove extra open brackets.
         */
        String str = "(((ab)";
        StringBuffer st = new StringBuffer(str);
        int count = 0;
        int i = 0;
        while(i < st.length()) {
            if(st.charAt(i) == '(') {
                count++;
            } else if(st.charAt(i) == ')') {
                count--;
            }

            if(count < 0) {
                st.deleteCharAt(i);
                count++;
            } else {
                i++;
            }
        }

        System.out.println("After removal first : " + st);

        i = st.length() - 1;
        count = 0;

        while(i >= 0) {
            if(st.charAt(i) == ')') {
                count++;
            } else if(st.charAt(i) == '(') {
                count--;
            }

            if(count < 0) {
                st.deleteCharAt(i);
                count++;
            }
            i--;
        }

        System.out.println("After removal : " + st);
    }


    @Description("Problem 3")
    public static void nthNumberFrom3And4() {
        /*
            Thought Process :
            ================

            0   -> 3,   1   -> 4
            00  -> 33,  01  -> 34,  10  -> 43,  11  -> 44
            000 -> 333, 001 -> 334, 010 -> 343, 011 -> 344, 100 -> 433, 101 -> 434, 111 -> 444

            We can see the pattern.
            1. At first iteration, we have 2 numbers.
            2. At second iteration, we have 4 numbers.
            3. At third iteration, we have 8 numbers.

            It is in the form of 2^x numbers. When x is iteration.

            And also, 1st iteration -> 1 digit
                    , 2nd iteration -> 2 digit
                    , 3rd iteration -> 3 digit

            How to solve :
            ===============
            To solve the problem, let's print 0, 1, 0, 1, 2, 3, 0, 1, 2, 3, 4, 5, 6, 7, ...
         */



        int nthNumber = 15;
        int digits = 1;
        int count = 0;
        int currNumber = 0;
        while(count < nthNumber) {
            int n = (int)Math.pow(2, digits);
            for(int i = 0; i < n; i++) {
                currNumber = getNumberFrom(i, digits);
                count++;
                if(count >= nthNumber) {
                    break;
                }
            }
            digits++;
        }

        System.out.println("Nth number is " + currNumber);
    }

    public static int getNumberFrom(int n, int digits) {
        String num = "";
        for(int i = 0; i < digits; i++) {
            if(((n >> i) & 1) == 1) {
                num = 4 + num;
            } else {
                num = 3 + num;
            }
        }

        return Integer.parseInt(num);
    }

}
