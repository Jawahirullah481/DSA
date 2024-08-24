package prevproblems;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Set6 {
    public static void main(String[] args) {
        // Problem 1
        sortDate();

        // Problem 2
        findMagicNumberOrNot(8);

        // Problem 3
        findAllPossibleWords();
    }

    @Description("Problem 1")
    public static void sortDate() {
        String[] arr = {"01 03 2015", "11 04 1996", "22 10 2007"};

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(isBGreaterA(arr[i], arr[j])) {
                    String temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.println("After sorting : " + Arrays.toString(arr));
    }

    public static boolean isBGreaterA(String d1, String d2) {
        int year1 = Integer.parseInt(d1.split(" ")[2]);
        int year2 = Integer.parseInt(d2.split(" ")[2]);
        int month1 = Integer.parseInt(d1.split(" ")[1]);
        int month2 = Integer.parseInt(d2.split(" ")[1]);
        int day1 = Integer.parseInt(d1.split(" ")[0]);
        int day2 = Integer.parseInt(d2.split(" ")[0]);

        if(year2 < year1 || month2 < month1 || day2 < day1) {
            return true;
        }

        return false;
    }

    @Description("Problem 2")
    public static void findMagicNumberOrNot(int originalNumber) {
        /*
            Magic Number :
            =============
            1. You are given a number. Cube it and sum the digits of the cube.
            2. If the process cycles back to the original number, it is magic.
            3. If it reaches 1, then it is not magic.
         */

        int slow = originalNumber;
        int fast = originalNumber;
        boolean isMagic = false;

        do {
            slow = sumOfDigitsOfCube(slow);
            fast = sumOfDigitsOfCube(sumOfDigitsOfCube(fast));
            
            if (slow == fast) {
                if (slow == originalNumber) {
                    isMagic = true;
                }
                break;
            }

        } while (fast != 1 && slow != 1);

        System.out.println(originalNumber + " is magic : " + isMagic + " | meeting number : " + slow);
    }

    private static int sumOfDigitsOfCube(int num) {
        long cube = (long) Math.pow(num, 3);
        int sum = 0;
        while (cube > 0) {
            sum += cube % 10;
            cube /= 10;
        }
        return sum;
    }


    @Description("Problem 3")
    public static void findAllPossibleWords() {
        List<String> list = findAllPossibleWordsRec("", "11112");
        System.out.println("All possible words of 11112 are : " + list);
    }

    public static List<String> findAllPossibleWordsRec(String p, String up) {
        /*
            Thought Process :
            ================
            1. The thought process is very simple.
            2. Either take single letter or 2 continuous letter.
            3. Take 2 continuous letter only if it doesn't exceed 26.
         */
        if(up.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int num1= Integer.parseInt(Character.toString(up.charAt(0)));
        int num2 = -1;
        if(up.length() > 1) {
            num2 = Integer.parseInt(Character.toString(up.charAt(0)) + Character.toString(up.charAt(1)));
        }

        char c = (char)(('A' - 1) + num1);
        List<String> list1 = findAllPossibleWordsRec(p + c, up.substring(1));
        List<String> list2 = new ArrayList<>();
        if(num2 > 0 && num2 <= 26) {
            c = (char)(('A' - 1) + num2);
            list2 = findAllPossibleWordsRec(p + c, up.substring(2));
        }

        for(String str : list2) {
            if(!list1.contains(str)) {
                list1.add(str);
            }
        }

        return list1;
    }
}
