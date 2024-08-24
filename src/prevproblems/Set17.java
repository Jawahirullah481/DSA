package prevproblems;

import java.util.HashMap;
import java.util.Map;

public class Set17 {
    public static void main(String[] args) {
        // Problem 1
        printPattern();

        // Problem 2
        countOccurences();
    }

    public static void printPattern() {
        /*
              123456789012G
              1234567890GR
              12345678GRA
              123456GRAM
              1234GRAMP
              12GRAMPR
              GRAMPRO

              Thought Process :
              =================
              1. At first there 13(2n - 1) letters.
              2. After every line, numbers of letters gets decremented by 1.
              3. Number of spaced gets decremented by 2.
              4. Numbers of characters gets incremented by 1.
         */
        String str = "PROGRAM";
        int n = 2 * str.length() - 1;
        int sp = n - 1;
        int c = n - sp;
        int st = str.length() / 2;

        for(int i = 1; i <= str.length(); i++) {
            for(int j = 1; j <= sp; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= c; j++) {
                System.out.print(str.charAt((st + j - 1 ) % str.length()));
            }
            System.out.println();
            n--;
            sp -= 2;
            c++;
        }
    }

    public static void countOccurences() {
        int[] arr = {2, 3, 2, 6, 1, 6, 2};
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr) {
            if(map.containsKey(i)) {
                int count = map.get(i);
                map.replace(i, ++count);
            } else {
                map.put(i, 1);
            }
        }

        System.out.println("After count : " + map);
    }
}
