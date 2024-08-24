package practice;

public class NumbersLength {

    // Program to find the count of letters of numbers from 1 to n

    public static void main(String[] args) {
        int number = 1000;
        System.out.println("FindCount1 : " + findCount1(number));
        System.out.println("FindCount1 : " + findCount2(number));
    }

    static int findCount1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            count += str.length();
        }

        return count;
    }

    static int findCount2(int n) {
        int dividor = 9;
        int lettersCount = 1;
        int count = 0;
        while (n > 0) {
            int diff = n / dividor;
            if(diff >= 1) {
                count += dividor * lettersCount;
                n -= dividor;
                dividor *= 10;
                lettersCount++;
            } else {
                count += n * lettersCount;
                n = 0;
            }
        }
        return count;
    }

}
