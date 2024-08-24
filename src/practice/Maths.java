package practice;
import java.util.List;
import java.util.ArrayList;

public class Maths {

    public static void main(String[] args) {

        // Question 1 : Find all prime numbers <= n
        findAllPrimeTillNMethod1(40);
        findAllPrimeTillNMethod2(40);

        // Question 2 : Find square root of a number
        findSquareRootMethod1(36); // O(n);
        findSquareRootMethod2(36); // O(logn)

        // Question 3 : Find square root of non perfect square number
        findSquareRootofNonPerfectSquare(33);

    }

    private static void findSquareRootofNonPerfectSquare(int n) {
        double ans = 0;

        int st = 1, end = n;
        while(st <= end) {
            int mid = st + (end - st) / 2;
            if(mid * mid == n) {
                ans = mid;
                break;
            }
            if(mid * mid > n) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        if(ans != 0) {
            System.out.println("Square root of " + n + " is : " + ans);
            return;
        }

        ans = end;
        double decimal = 0.1;
        double temp = ans;
        for(int i = 1; i <= 10; i++) {
            temp = ans + (decimal * i);
            if(temp * temp == n) {
                System.out.println("Square root of " + n + " is : " + temp);
                return;
            }

            if(temp * temp > n) {
                break;
            }
        }

        System.out.println("Square root of " + n + " is : " + (temp - decimal));

    }

    private static void findSquareRootMethod2(int n) {
        /*
            As we difinitely know that the square root of n lies between 1 and n.
            Here, we have a range. and it is sorted. Why don't we use binary search.
         */

        int st = 1; int end = n;
        int sqrt = 0;
        while(st <= end) {
            int mid = st + (end - st) / 2;
            if(mid * mid == n) {
                sqrt = mid;
                break;
            }

            if(mid * mid > n) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        System.out.println("Square root of " + n + " is : " + sqrt);
    }

    private static void findSquareRootMethod1(int n) {
        for(int i = 1; i <= n; i++) {
            if(i * i == n) {
                System.out.println("Square root of " + n + " is : " + i);
                break;
            }
        }
    }

    private static void findAllPrimeTillNMethod2(int n) {
        /*

            NOTE : If a number is prime, then all the multiples of that number are not prime.

            1. So, in the below program, what you do is,
            2. If you find any number as prime, then make all the multiples of that number as not prime
            3. In the below program, numbers are by default prime(false). When particular number is prime,
               then we make that number's multiples as not prime(true).
            4. Finally, we print only false numbers(primes)

         */
        boolean[] primeNumbers = new boolean[n + 1];
        for(int i = 2; i <= n; i++) {
            if(i <= 1) {
                primeNumbers[i] = true;
            }

            if(primeNumbers[i] == false) {
                for(int j = i * 2; j <= n; j += i) {
                    primeNumbers[j] = true;
                }
            }
        }

        System.out.print("Prime numbers are : ");
        for(int i = 2; i <= n; i++) {
            if(!primeNumbers[i])
             System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void findAllPrimeTillNMethod1(int n) {
        List<Integer> primeNumbers = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            if(isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        System.out.println("Prime Numbers from 2 to " + n + " are " + primeNumbers);
    }

    private static boolean isPrime(int n) {
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }


}
