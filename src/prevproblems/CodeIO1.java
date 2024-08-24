package prevproblems;

import jdk.jfr.Description;

import java.util.Arrays;

public class CodeIO1 {
    public static void main(String[] args) {
        // Problem 1
        sortLexicographically();

        // Problem 2
        checkSubstring();

        // Problem 3
        removeDuplicates();

        // Problem 4
        convert0to5();

        // Problem 5
        multiplyPolynomials();
    }

    @Description("Problem 1")
    public static void sortLexicographically() {
        String str = "jawahirullah";

        int[] counts = new int[26];
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = (int)(c - 'a');
            counts[index] = counts[index] + 1;
        }

        String res = "";
        for(int i = 0; i < counts.length; i++) {
            char c = (char)('a' + i);
            for(int j = 0; j < counts[i]; j++) {
                res += c;
            }
        }

        System.out.println("After sorting : " + res);
    }

    @Description("Problem 2")
    public static void checkSubstring() {
        String str1 = "geeksforgeeks";
        String str2 = "for";

        boolean isSubstring = true;
        for(int i = 0; i < str1.length(); i++) {
            if(str2.charAt(0) == str1.charAt(i)) {
                int k = i;
                isSubstring = true;
                for(int j = 0; j < str2.length(); j++, k++) {
                    if(str2.charAt(j) != str1.charAt(k)) {
                        isSubstring = false;
                    }
                }
                if(isSubstring) {
                    System.out.println("substring starts at : " + i);
                    break;
                }
            }
        }

        if(!isSubstring) {
            System.out.println("No substring found ");
        }
    }

    @Description("Problem 3")
    public static void removeDuplicates() {
        /*
            Problem statment :
            ==================
            Remove duplicates from sorted array. put distinct element to front of array.
         */
        int[] arr = {1, 2, 3, 3, 5, 5, 5, 6, 7, 8};
        int distinct = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i == 0 || arr[i] != arr[i - 1]) {
                arr[distinct] = arr[i];
                distinct++;
            }
        }

        int[] distinctArray = Arrays.copyOfRange(arr, 0, distinct);
        System.out.println(Arrays.toString(distinctArray));
    }

    @Description("Problem 4")
    public static void convert0to5() {
        int n = 4065;
        int res = 0;
        int place = 1;

        while(n > 0) {
            int rem = n % 10;
            if(rem == 0) {
                res = (5 * place) + res;
            } else {
                res = (rem * place) + res;
            }
            n = n / 10;
            place *= 10;
        }

        System.out.println("After conversion : " + res);
    }

    @Description("Problem 5")
    public static void multiplyPolynomials() {
           /*
            (3 + 4x + 5x2) * (2 + 3x + 4x2) ->
            (3 * 2) + (4x * 2) + (5x2 * 2) +
            (3 * 3x) + (4x * 3x) + (5x2 + 3x) +
            (3 * 4x2) + (4x * 4x2) + (5x2 * 4x2)

            By the above equation, you can conclude following conditions,

            When you multiply,
            C(0) and C(0) => move to C(0) position
            C(0) and X(1) => move to X(1) postion
            C(0) and X2(2) => moved to X2(2) postion
            X(1) and X(1) => moved to X2(2) postion
            X(1) and X2(2)=> moved to X3(3) postion
        */
        int[] Arr1 = {1, 0, 3, 2};
        int[] Arr2 = {2, 0, 4};

        int M = Arr1.length;
        int N = Arr2.length;

        int[] res = new int[M + N - 1];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                res[i + j] = res[i + j] + (Arr1[i] * Arr2[j]);
            }
        }

        System.out.println(Arrays.toString(res));
    }

}
