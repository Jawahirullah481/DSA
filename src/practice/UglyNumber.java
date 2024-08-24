package practice;

public class UglyNumber {
    public int nthUglyNumber(int n) {
        int counter = 1;
        int num = 0;

        for(num = 1; counter < n; num++) {
            if(isUgly(num)) {
                System.out.print(num + " : ");
                counter++;
            }
        }
        return num - 1;
    }

    private boolean isUgly(int num) {
        int lastFactor = 1;

        for(int i = 1; i <= num; i++) {
            if((num % i == 0 && isPrime(i)) && (i != 1 && i != 2 && i != 3 && i != 5)) {
                return false;
            }
            if(num % i == 0) {
                lastFactor = i;
            }
        }

        return lastFactor == 1 && (num > 1) ? false : true;
    }

    private boolean isPrime(int num) {
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        UglyNumber ugNumber = new UglyNumber();
        System.out.println(ugNumber.nthUglyNumber(10));
    }
}
