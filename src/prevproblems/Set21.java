package prevproblems;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Set21 {
    public static void main(String[] args) {
        // Problem 1
        sumOfPrimeOrNot();

        // Problem 2
        reverseAndPalindrome();

        // Problem 3
        reverseOnlyVowels();

        // Problem 4
        solveEquation();
    }

    @Description("Problem 1")
    public static void sumOfPrimeOrNot() {
        /*
            Problem statement :
            ===================
            Write a program to determine whether a given number can be expressed as sum of two prime numbers or not.
         */

        List<Integer> primes = new ArrayList<>();
        int n = 34;
        for(int i = 2; i < n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        int st = 0, end = primes.size() - 1;
        while(st < end) {
            int sum = primes.get(st) + primes.get(end);

            if(sum == n) {
                System.out.println(n + " is taken by sum of " + primes.get(st) + " and " + primes.get(end));
                break;
            }
            if(sum > n) {
                end--;
            } else {
                st++;
            }
        }

        if(st == end) {
            System.out.println("There is no pair available");
        }
    }

    public static boolean isPrime(int n) {
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }


    @Description("Problem 2")
    public static void reverseAndPalindrome() {
        /*
            Problem statement :
            ==================
            Take a 2 or 3 digit input number,
            reverse it and add it to the original number until the obtained number is a palindrome
            (or)
            5 iterations are completed.

            Example :
            =========

            Input : n = 32
            Output : 55
            23 + 32 = 55 which is a palindrome.
         */
        int n =  39;
        boolean isFound = false;

        for(int i = 1; i <= 5; i++) {
            int rev = reverse(n);
            int sum = n + rev;
            int revSum = reverse(sum);
            if(sum == revSum) {
                System.out.println("We get palindrome at : " + sum);
                isFound = true;
                break;
            }
            n = sum;
        }

        if(!isFound) {
            System.out.println("We don't get any palindrome");
        }

    }

    public static int reverse(int n) {
        int rev = 0;
        while(n > 0) {
            rev = (rev * 10) + n % 10;
            n = n / 10;
        }
        return rev;
    }

    @Description("Problem 3")
    public static void reverseOnlyVowels() {
        String str = "practice";

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int st = 0, end = str.length() - 1;

        while(st < end) {
            char c1 = str.charAt(st);
            char c2 = str.charAt(end);

            if(vowels.contains(c1) && vowels.contains(c2)) {
                String s1 = str.substring(0, st);
                String s2 = str.substring(st + 1, end);
                String s3 = str.substring(end + 1);

                str = s1 + c2 + s2 + c1 + s3;
                st++; end--;
                continue;
            }

            if(!vowels.contains(c1)) {
                st++;
            }
            if(!vowels.contains(c2)) {
                end--;
            }
        }

        System.out.println("After reverse : " + str);
    }

    @Description("Problem 4")
    public static void solveEquation() {
        /*
            Problem statement :
            ====================
            v = number of vehicles, w = number of wheels.
            v -> cars + bikes, w = count of car wheels and bike wheels.
            Find number of cars and bikes.

            x + y = v   -----------> 1
            2x + 4y = w -----------> 2

            1 -> y = v - x
            2 -> 2x + 4(v - x) = w
              -> 2x + 4v - 4x  = w
              -> 4v - 2x = w
              -> -2x = w + 4v
              -> x = (w + 4v) / -2
              => x = (4v - w) / 2;
         */
        int v = 200, w = 540;

        if(w == 0 || w % 2 == 1) {
            System.out.println("Invalid tires count");
            return;
        }

        int x = (4 * v - w) / 2;
        int y = v - x;

        System.out.println("Bikes : " + x);
        System.out.println("Cars : " + y);

    }

}
