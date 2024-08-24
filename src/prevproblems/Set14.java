package prevproblems;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Set14 {
    public static void main(String[] args) {
        // Problem 1
        convertNumToAlpha();

        // Problem 2
        romantToInteger();

        // Problem 3
        findMonoDigitOrNot();
    }

    @Description("Problem 1")
    public static void convertNumToAlpha() {
        /*
            Problem statment :
            ==================
            Input | Output
            ---------------
             1    |  A
             26   |  Z
             27   |  AA
             676  |  ZZZ
         */

        int n = 676;
        String res = "";
        do {
            int temp = n - 1;
            temp = temp % 26;
            res += ((char)('A' + temp));
            n = n / 26;
        } while (n > 1);

        System.out.println("Equivalent alpha : " + res);
    }

    @Description("Problem 3")
    public static void romantToInteger() {
        /*
            Thought Process :
            ==================
            1. if curr value is greater than or equal to next value, then add curr value to total.
            2. if curr value is less than next value, then less it from total.

            NOTE :
            ======
            1. Be careful, always compare current with next. don't compare curr with prev.
         */
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        String rom = "XIX";

        int total = 0;
        for(int i = 0; i < rom.length(); i++) {
            int curr = map.get(rom.charAt(i));
            int next = 0;
            if(i + 1 < rom.length()) {
                next = map.get(rom.charAt(i + 1));
            }

            if(curr >= next) {
                total = total + curr;
            } else {
                total = total - curr;
            }
        }

        System.out.println("The total is : " + total);
    }

    @Description("Problem 3")
    public static void findMonoDigitOrNot() {
        /*
            Problem statement :
            ===================
            Write a program to convert a number into a mono-digit number.
            Conditions:
            ===========
            a) You are allowed to add and subtract the consecutive digits (starting from left).
            b) You are allowed to do only one operation on a digit.
            c) You cannot perform any operation on a resultant digit of the previous operation.
            d) Your code should also find if a given number cannot be converted to a mono digit number.

            Input     Output
            ==================
            72581     7(2+5)81
                      77(8-1)
                      777
            3962      cannot create a mono digit number


            Thought Process :
            ==================
            1. As you can see this carefully, you can find a pattern.
            2. Either you keep a number as it is (or) you can add consecutive numbers (or)
               you can subtract consecutive numbers.

         */

        int num = 72581;
        List<Integer> list = getAllPossibles("", Integer.toString(num));
        int result = -1;
        for(Integer i : list) {
            result = isMonoDigit(i);
            if(result != -1) {
                break;
            }
        }

        System.out.println("The number's mono digits is : " + result);
    }

    public static List<Integer> getAllPossibles(String p, String up) {
        if(up.length() == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(p));
            return list;
        }

        int n1 = Character.digit(up.charAt(0), 10);
        int n2 = -1;
        if(up.length() > 1) {
            n2 = Character.digit(up.charAt(1), 10);
        }

        List<Integer> nothing = getAllPossibles(p + n1, up.substring(1));
        List<Integer> sum = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        if(n2 != -1) {
            sum = getAllPossibles(p + (n1 + n2), up.substring(2));
        }
        if(n2 != -1 && n1 >= n2) {
            sub = getAllPossibles(p + (n1 - n2), up.substring(2));
        }

        nothing.addAll(sum);
        nothing.addAll(sub);

        return nothing;
    }

    public static int isMonoDigit(int n) {
        String s = String.valueOf(n);
        char c = s.charAt(0);

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != c) {
                return -1;
            }
            c = s.charAt(i);
        }

        return n;
    }
}
