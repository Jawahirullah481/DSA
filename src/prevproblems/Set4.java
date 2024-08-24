package prevproblems;

import jdk.jfr.Description;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Set4 {
    public static void main(String[] args) {

        // Problem 1
        findOddNumbersInRange();

        // Problem 2
        sortNumbersBasedOnNumberOfFactors();

        // Problem 3
        printNumbersInWords();

        // Problem 4
        remainingPetrol();
    }

    @Description("Problem 1")
    public static void findOddNumbersInRange() {
        int st = 2;
        int end = 15;

        st = ((st & 1) == 1) ? st : st + 1;
        end = ((end & 1) == 1) ? end : end - 1;

        for(int i = st; i <= end; i = i + 1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    @Description("Problem 2")
    public static void sortNumbersBasedOnNumberOfFactors() {
        int[] arr = {8, 2, 3, 12, 16};
        int[] factors = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            int factor = 0;

            for(int j = 1; j <= arr[i] / 2; j++) {
                if(arr[i] % j == 0) {
                    factor++;
                }
            }

            factors[i] = factor + 1;
        }

        System.out.println("Factors of " + Arrays.toString(arr) + " are : " + Arrays.toString(factors));

        // Sort based on factors

        for(int i = 0; i < factors.length - 1; i++) {
            for(int j = i + 1; j < factors.length; j++) {
                if(factors[i] < factors[j]) {
                    int temp = factors[j];
                    factors[j] = factors[i];
                    factors[i] = temp;

                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.println("After sorting : " + Arrays.toString(arr));
    }


    @Description("Problem 3")
    public static void printNumbersInWords() {
        /*
            To output the number in words (0-999)
            Input: 234
            Output: Two hundred and Thirty Four

            Thought Process :
            ================
            1. get the unit digit.
            2. if it is not zero, then check its place
            3. if it is 1s place, then add its string.
            4. if it is 10s place, then add equivalent string to words with previous word.
            5. if it is 100s place, then add word + hundred + and + previous word.
            6. If 10s place contains 1, then add equivalent string by skipping previous word.

            NOTE : Put equivalent words in map.
         */

        Map<Integer, String> unitPlace = new HashMap<>();
        unitPlace.put(0, "");
        unitPlace.put(1, "One ");
        unitPlace.put(2, "Two ");
        unitPlace.put(3, "Three ");
        unitPlace.put(4, "Four ");
        unitPlace.put(5, "Five ");
        unitPlace.put(6, "Six ");
        unitPlace.put(7, "Seven ");
        unitPlace.put(8, "Eight ");
        unitPlace.put(9, "Nine ");

        Map<Integer, String> tensPlace1 = new HashMap<>();
        tensPlace1.put(0, "Ten");
        tensPlace1.put(1, "Eleven");
        tensPlace1.put(2, "Twelve");
        tensPlace1.put(3, "Thirteen");
        tensPlace1.put(4, "Forteen");
        tensPlace1.put(5, "Fifteen");
        tensPlace1.put(6, "Sixteen");
        tensPlace1.put(7, "Seventeen");
        tensPlace1.put(8, "Eighteen");
        tensPlace1.put(9, "Ninteen");

        Map<Integer, String> tensPlace2 = new HashMap<>();
        tensPlace2.put(0, "");
        tensPlace2.put(1, "Eleven");
        tensPlace2.put(2, "Twenty ");
        tensPlace2.put(3, "Thirty ");
        tensPlace2.put(4, "Forty ");
        tensPlace2.put(5, "Fifty ");
        tensPlace2.put(6, "Sixty ");
        tensPlace2.put(7, "Seventy ");
        tensPlace2.put(8, "Eighty ");
        tensPlace2.put(9, "Ninty ");


        int num = 311;
        int firstDigit = num % 10;
        boolean isZero = num == 0;
        String word = "";
        int place = 1;

        while(num > 0) {
            int x = num % 10;

            if(place == 1) {
                word = unitPlace.get(x);
            } else if(place == 10) {
                if(x == 1) {
                    word = tensPlace1.get(firstDigit);
                } else {
                    word = tensPlace2.get(x) + word;
                }
            } else {
                if(word.trim().isEmpty()) {
                    word = unitPlace.get(x) + "hundred";
                } else {
                    word = unitPlace.get(x) + "hundred "+ "and " + word;
                }
            }

            num /= 10;
            place *= 10;
        }

        if(isZero) {
            word = "Zero";
        }
        System.out.println(num + " in words is : " + word);
    }


    @Description("Problem 4")
    public static void remainingPetrol() {
        /*
            If current petrol is less than distance to be covered, then it is impossible.
            else, after reaching the bunk, petrol will be reduced as the rate of 1 liter per distance
            And after you reached the station, you will be filled with capactity

         */
        int currPetrol = 3;
        int[] distance = {4, 2, 1, 5};
        int[] capacity = {6, 2, 4, 3};

        for(int i = 0; i < distance.length; i++) {
            // If available petrol is less than to reach distance, then we can't travel
            if(currPetrol < distance[i]) {
                currPetrol = -1;
                break;
            }

            currPetrol -= distance[i];
            currPetrol += capacity[i];

        }

        System.out.println("Remaining Petrol : " + currPetrol);
    }
}
