package practice;

public class NthNumerFrom3And4 {
    public static void main(String[] args) {
        findNthNumber();
    }

    public static void findNthNumber() {
        /*
            Thought Process :
            =================
            1. 3, 4,     33, 44, 34, 43,     333, 334, 343, 433, 344, 443, 343, 444, ....
            2. As you can see at 2, 4, 8, 16, ...

            When i use binary method,

            0 -> 3,    1 -> 4
            00 -> 33,  01  -> 34,   10  -> 43,   11 -> 44
            000 -> 333, 001 -> 334,  010  -> 343,  011  -> 344,....
         */

        int n = 15;
        int x = 0;
        int i = 1;

        while(x < n) {
            int possibles = (int)Math.pow(2, i);
            for(int j = 0; j < possibles; j++) {
                // System.out.print(j + " ");
                // System.out.print(getNumberFromBinary(j, i) + " ");
                getNumberFromBinary(j, i);
                x++;
                if(x >= n) {
                    break;
                }
            }
            i++;
        }
    }

    public static int getNumberFromBinary(int n, int digits) {
        System.out.print("Input : n = " + n + " digits : " + digits);
        // 3 -> 344, 011
        String num = "";
        for(int i = 0; i < digits; i++) {
            if(((n >> i) & 1) == 1) {
                num = 4 + num;
            } else {
                num = 3 + num;
            }
        }
        System.out.print(" | Output : " + Integer.parseInt(num));
        System.out.println();
        return Integer.parseInt(num);
    }


}
