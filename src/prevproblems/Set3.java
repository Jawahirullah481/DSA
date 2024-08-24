package prevproblems;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.List;

public class Set3 {
    public static void main(String[] args) {

        // Problem 1
        printPattern();

        // Problem 2
        ifString1SubstringOfString2();

        // Problem 3
        mergeArraysWithoutRepetition();

        // Problem 4
        reverseStringUsingRecursion();
    }

    @Description("Problem 1")
    public static void printPattern() {
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
            int num = 0;
            char digit1 = s.charAt(i++);
            char digit2 = ' ';
            if(i < s.length()) {
                digit2 = s.charAt(i++);
            }

            if(Character.isDigit(digit2)) {
                num = Integer.parseInt(digit1 + "" + digit2);
            } else {
                num = Integer.parseInt(digit1 + "");
                i--;
            }

            for(int j = 0; j < num; j++) {
                System.out.print(c);
            }
        }
    }

    @Description("Problem 2")
    public static void ifString1SubstringOfString2() {
        int index = -1;

        String s1 = "testing12";
        String s2 = "1234";

        for(int i = 0; i < s1.length() - s2.length() + 1; i++) {
            if((s1.substring(i, i + s2.length())).equals(s2))  {
                index = i;
                break;
            }
        }

        System.out.println("Index is : " + index);
    }


    @Description("Problem 3")
    public static void mergeArraysWithoutRepetition() {
        int[] arr1 = {2,4,5,6,7,9,10,13};
        int[] arr2 = {2,3,4,5,6,7,8,9,11,15};
        List<Integer> list = new ArrayList<>();

        int i = 0, j = 0, k = 0;
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                // Add ith from arr1 element after checking if it's not already avail in list
                if(k > 0) {
                    if((list.get(k - 1) != arr1[i])) {
                        list.add(arr1[i]);
                        k++;
                    }
                } else {
                    list.add(arr1[i]);
                    k++;
                }
                i++;
            } else {
                // Add jth from arr2 element after checking if it's not already avail in list
                if(k > 0) {
                    if((list.get(k - 1) != arr2[j])) {
                        list.add(arr2[j]);
                        k++;
                    }
                } else {
                    list.add(arr2[j]);
                    k++;
                }
                j++;
            }
        }

        while(i < arr1.length) {
            if(k > 0) {
                if((list.get(k - 1) != arr1[i])) {
                    list.add(arr1[i]);
                    k++;
                }
            } else {
                list.add(arr1[i]);
                k++;
            }
            i++;
        }

        while(j < arr2.length) {
            if(k > 0) {
                if((list.get(k - 1) != arr2[j])) {
                    list.add(arr2[j]);
                    k++;
                }
            } else {
                list.add(arr2[j]);
                k++;
            }
            j++;
        }

        System.out.println("After merget : " + list);
    }


    @Description("Problem 4")
    public static void reverseStringUsingRecursion() {
        String original = "one two three";
        String reversed = reverse(original);
        System.out.println("Reversed string is : " + reversed);
    }

    public static String reverse(String str) {

        /*
            Thought Process :
            =================
            1. Find the index of last space.
            2. take string after last space and reverse string before space.
            3. when there is no space available, return string itself.
         */

        int lastSpaceIndex = str.lastIndexOf(' ');

        if(lastSpaceIndex == -1) {
            return str;
        }

        String beforeSpace = str.substring(0, lastSpaceIndex);
        String afterSpace = str.substring(lastSpaceIndex + 1);

        return afterSpace + " " + reverse(beforeSpace);
    }
}
