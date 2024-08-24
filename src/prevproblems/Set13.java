package prevproblems;

import jdk.jfr.Description;

import java.util.HashMap;
import java.util.Map;

public class Set13 {
    public static void main(String[] args) {
        // Problem 1
        // findNoOfCharacters();

        // Problem 2
        // reverseByKeepingPunctuation();
    }

    @Description("Problem 1")
    public static void findNoOfCharacters() {
        /*
            Problem statement :
            =================
            You’re given a number n. If write all the numbers from 1 to n in a paper,
            we have to find the number of characters written on the paper.
            For example,
            if n=13, the output should be 18.
            if n = 101, the output should be 195.


            Thought Process :
            =================
            1. I know that from 1 - 9, 9 numbers are having 1 digit.
            2. I know that from 10 - 99, 90 numbers are having 2 digit.
            3. I know that from 100 - 999, 900 numbers are having 3 digit. and so on.
            4. 18 -> 9 + 9 -> (9 * 1) + (9 * 2)
            5. 101 -> 9 + 90 + 2 -> (9 * 1 ) + (90 * 2) + (2 * 3)

            6. Iterate until the number is greater than or equal to the place.
            7. Because, for that much time, we can multiply place with digit.
            8. When remaining number is less than place, we can't take whole place.
               We can take only remaining numbers.
         */

        int n = 101;
        int place = 9;
        int digit = 1;
        int count = 0;

        while(n >= place) {
            count += place * digit;
            n -= place;
            place = place * 10;
            digit++;
        }

        if(n > 0) {
            count += n * digit;
        }

        System.out.println("Number of characters are : " + count);

    }

    @Description("Problem 2")
    public static void reverseByKeepingPunctuation() {
        /*
            Problem statement :
            =================
            You’re given a string as an input.
            You have to reverse the string by keeping the punctuation and spaces.
            You have to modify the source string itself with creating an another string.

            Thought Process :
            ==================
            1. Take 2 pointer, from st and end.
            2. If c1 is letter and c2 is also letter, then print c2 itself.
            3. If c1 is special character and c2 is letter, then don't print special character(c1).
            4. If c2 itself is special character, then don't do anything, simply move c2.

            NOTE : [Important character methods]
            ====================================
            1. Character.digit(char c, int radixOrBase) -> return equivalent digit(only for numbers)
            2. Character.getNumericValue(char c)        -> return equivalent digit(only for numbers)
            3. Character.isLetter(char c)               -> return true if it is alphabetic char.
            4. Character.isDigit(char c)                -> return true if the character is digit.
            5. Character.isLetterOrDigit(char c)        -> return true if the character is alphanumeric.
         */

        String str = "A man, in the boat says : I see 1-2-3 in the sky";
        String res = "y kse, ht ni3 21ee sIsy : a sta o-b-e ht nin amA";

        int i = 0, j = str.length() - 1;
        while(i < str.length()) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(j);

            if(Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2)) {
                res += c2;
                i++;
                j--;
            } else if((!Character.isLetterOrDigit(c1)) && Character.isLetterOrDigit(c2)) {
                res += c1;
                i++;
            } else if(!Character.isLetter(c2)) {
                j--;
            }
        }

        System.out.println("After reverse : " + res);

    }

}
