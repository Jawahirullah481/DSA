package prevproblems;

import jdk.jfr.Description;

import java.util.HashMap;
import java.util.Map;

public class Set24 {
    public static void main(String[] args) {
        // Problem 1
        convertNumToBase7();

        // Problem 2
        printNOccurenceElements();
    }

    @Description("Problem 1")
    public static void convertNumToBase7() {
        int num = 100;
        String res = "";

        boolean isNegative = num < 0;
        if(isNegative) {
            num = -num;
        }

        int rem = 0;
        while(num >= 7) {
            rem = num % 7;
            res = rem + "" + res;
            num = num / 7;
        }
        rem = num % 7;
        res = rem + res;

        if(isNegative) {
            res = "-" + res;
        }

        System.out.println("Base 7 is : " + res);
    }

    @Description("Problem 2")
    public static void printNOccurenceElements() {
        /*
            Problem statement :
            ==================
            Given an array of characters print the characters that have ‘n’ number of occurrences.
            If a character appears consecutively it is counted as 1 occurrence
         */
        char[] arr = {'a', 'b', 'a', 'a', 'b', 'c', 'c', 'd', 'e', 'd'};
        int occurence = 2;

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                map.put(arr[i], 1);
                continue;
            }
            if(arr[i] != arr[i - 1]) {
                if (map.containsKey(arr[i])) {
                    map.replace(arr[i], map.get(arr[i]) + 1);
                } else {
                    map.put(arr[i], 1);
                }
            }
        }

        System.out.println(map);

        map.forEach((key, value) -> {
            if(value == occurence) {
                System.out.print(key + " ");
            }
        });
    }
}
