package practice;

import java.util.Scanner;

public class ZohoPrevious {

    public static void main(String[] args) {
       // problem1();
        problem2();
    }

    private static void problem2() {
        /*
            Find if a String2 is substring of String1.
            If it is, return the index of the first occurrence. else return -1.

            Eg 1:Input:
            String 1: test123string
            String 2: 123
            Output: 4

            Eg 2: Input:
            String 1: testing12
            String 2: 1234
            Output: -1
         */

        String str1 = "testing12";
        String str2 = "123";

        boolean isSubstr = false;

        int length = str2.length();
        for(int i = 0; i <= str1.length() - length; i++) {
            String substr = str1.substring(i, i + str2.length());
            if(substr.equals(str2)) {
                isSubstr = true;
                break;
            }
        }
        if(isSubstr) {
            System.out.println(str2 + " is substring of " + str1);
        } else {
            System.out.println(str2 + " is not substring of " + str1);
        }
    }

    private static void problem1() {
        /*
            Eg 1: Input: a1b10
            Output: abbbbbbbbbb
            Eg: 2: Input: b3c6d15
            Output: bbbccccccddddddddddddddd
            The number varies from 1 to 99.
         */
        String s = "b3c6d15";
        int i = 0;
        while(i < s.length()) {
            char c = s.charAt(i++);
            String number = Character.toString(s.charAt(i++));
            char number2 = 's';
            if(i < s.length()) {
                number2 = s.charAt(i);
                if(number2 >= '0' && number2 <= '9') {
                    number = number + number2;
                    i++;
                }
            }

            for(int k = 0; k < Integer.parseInt(number); k++) {
                System.out.print(c);
            }
        }
    }

}
