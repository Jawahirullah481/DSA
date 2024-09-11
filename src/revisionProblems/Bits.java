package revisionProblems;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Bits {

    public static void main(String[] args) {

        // Question 1 : Find odd or even
        findOddOrEven(4);

        // Question 2 : Find single number (All other numbers appear twice)
        findSingleNumber1(new int[] {1, 5, 3, 2, 3, 1, 6, 5, 2});

        // Question 3 : Find ith bit of a number
        findithBitOfNumber(23, 2);

        // Question 4 : Set the ith bit
        setTheithBit(23, 4);

        // Question 5 : Reset the ith bit
        resetTheithBit(23, 3);
        
        // Question 6 : Position of right most set bit
        findPositionOfRightMostSetBit(12);

        // Question 7: Single number II
        findSingleNumber2(new int[] {1, 5, 1, 3, 2, 5, 3, 1, 2, 3, 6, 5, 2});

        // Question 8 : Find Magic number
        findNthMagicNumber(5);

        // Question 9 : Find no.of.digits in base b
        findNoOfDigits(6, 10);

        // Question 10 : Find if power of 2
        findIfPowerOfTwo(31);

        // Question 11 : Find number of set bits.
        findNoOfSetBits(23);
        findNOOfSetBitsMethod2(23);

        // Question 12 : Find xor of number from 0 to a
        findXorOfN(23);

        // Queston 13 : Find xor of numbers between a to b
        findXorInRange(3, 10);

        // Question 14 : Print All the subsets of array
        printAllSubsets(new int[] {1, 2, 3, 4, 5});

        // Question 15 : Find no of flips to reach goal
        noOfFlips(10, 7);

    }

    private static void noOfFlips(int start, int goal) {
        /*
            When i xor start with goal, then i will get the number which has 1 wherever different bits are available
            in start and goal.

            Example : start = 10, goal = 7;
            10 ^ 7 = 1010 ^ 0111 = 1101 => 13

            if I count no.of.set bits in 13, then i can find no of flips needed.
         */
        int xor = start ^ goal;
        int flips = 0;

        while(xor > 0) {
            if((xor & 1) == 1) {
                flips++;
            }
            xor = xor >> 1;
        }

        System.out.println("No of flips taken : " + flips);
    }

    private static void printAllSubsets(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        int n = (int)(Math.pow(2, arr.length));
        for(int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>();
            int x = i;
            int j = 0;
            while(x > 0) {
                if((x & 1) == 1) {
                    l.add(arr[j]);
                }
                j++;
                x = x >> 1;
            }

            list.add(l);
        }

        System.out.print("{ ");
        for (List<Integer> integers : list) {
            System.out.print(integers);
            System.out.print(", ");
        }
        System.out.print(" }");

    }

    private static void findXorInRange(int a, int b) {
        /*
            Let's say if a is 3 and b is 5.
            XOR from 1 till 5 is 1 ^ 2 ^ 3 ^ 4 ^ 5
            XOR from 1 till 2 is 1 ^ 2

            If I XOR 1 ^ 2 ^ 3 ^ 4 ^ 5 and 1 ^ 2, the term "1 ^ 2" get repeated 2 times.
            And all the repeated numbers will become cancelled out.
            Then we get the answer of remaining 3 ^ 4 ^ 5.
         */

        int x = findXorOfN(a - 1);
        int y = findXorOfN(b);
        System.out.println("xor of numbers between " + a + " and " + b + " is : " + (x ^ y));
    }

    private static int findXorOfN(int i) {
        // NOTE : XOR OF RANGE OF NUMBERS WILL GET REPEATED FOR EVERY 4 NUMBERS
        /*
            0 -> 0
            1 -> 1
            2 -> 3
            3 -> 11 ^ 11 -> 0
            4 -> 4
            5 -> 100 ^ 101 -> 1
            6 -> 001 ^ 110 -> 7
            7 -> 111 ^ 111 -> 0
         */
            if(i % 4 == 3) {
                System.out.print("XOR of " + i + " is : " + 0 + " -> ");
                return 0;
            }
            else if(i % 4 == 1) {
                System.out.print("XOR of " + i + " is : " + 1 + " -> ");
                return 1;
            }
            else if(i % 4 == 2) {
                System.out.print("XOR of " + i + " is : " + (i + 1) + " -> ");
                return i + 1;
            }

            System.out.print("XOR of " + i + " is : " + i + " -> ");
            return i;
    }

    private static void findNOOfSetBitsMethod2(int n) {
        int count = 0;
        while(n > 0) {
            n = n & (n - 1);
            count++;
        }
        System.out.println("No of set bits in " + n + " is : " + count);
    }

    private static void findNoOfSetBits(int n) {
        int count = 0;
        while(n > 0) {
            if((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        System.out.println("No of set bits in " + n + " is : " + count);
    }

    private static void findIfPowerOfTwo(int num) {
        int input = num;
        int mask = num - 1;
        if((num & mask) == 0) {
            System.out.println("The given number " + input + " is power of 2");
        } else {
            System.out.println("The given number " + input + " is not power of 2");
        }
    }

    private static void findNoOfDigits(int num, int base) {
        int noOfDigits = (int)Math.floor(Math.log(num) / Math.log(base)) + 1;
        System.out.println("No of digits of " + num + " in " + base + " is : " + noOfDigits);
    }

    private static void findNthMagicNumber(int i) {
        int multiple = 5;
        int n = i;
        int ans = 0;
        int bitPosition = 1;
        while(n > 0) {
            if((n & 1) != 0) {
                ans += Math.pow(multiple, bitPosition);
            }
            bitPosition++;
            n = n >> 1;
        }

        System.out.println(i + "nth magic number is " + ans);
    }

    private static void findSingleNumber2(int[] nums) {
        /*
           Refer : Stiver's single number II video in bit playlist
         */
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int ones = 0;
            for(int j = 0; j < nums.length; j++) {
                if((nums[j] & (1 << i)) != 0) {
                    ones++;
                }
            }
            if(ones % 3 == 1)
                ans = ans | (1 << i);
        }

        System.out.println("Single number among 3s is : " + ans);
    }

    private static void findPositionOfRightMostSetBit(int num) {
        int pos = 1;
        while(num > 0) {
            if((num & 1) != 0) {
                System.out.println("Right most set bit of " + num + " is : " + pos);
                break;
            }
            num = num >> 1;
            pos++;
        }

        // 12 -> 1100
        // 11 -> 1011
        //~11 0> 0100
    }

    private static void resetTheithBit(int num, int i) {
        /*
            Let's say the number is 23 and its binary is "10111". And I want to reset 3rd bit
            If I put 1 and left shit (3 - 1) times, the number becomes  00100.
            If I complement this, it'll become 11011.
            If I 10111 & 11011, except 3rd bit, all bits remains same. And only 3rd bit will unset becuase it is in & with 0.
         */
        int mask = ~(1 << (i - 1));
        int result = num & mask;
        System.out.println("After resetting " + i + "th bit of " + num + ", it becomes " + result);
    }

    private static void setTheithBit(int num, int i) {
        int mask = 1 << (i - 1);
        int n = num | mask;
        System.out.println("After setting " + i + "th bit of " + num + ", it becomes " + n);
    }

    private static void findithBitOfNumber(int num, int i) {
        /*
            Let's say we have a number 23 which is "10111".
            If I want to find 3rd bit is 0 or 1.
            I will use 10111 & (1 << 2), which is 10111 & 00100
            The result will 0 only if the ith bit is zero. The result is non zero value(2 power value) if the ith bit is 1.
         */
        int n = num & (1 << (i - 1));
        if(n == 0) {
            System.out.println(i + "th bit of " + num + " is " + 0);
        } else {
            System.out.println(i + "th bit of " + num + " is " + 1);
        }
    }

    private static void findSingleNumber1(int[] arr) {
        /*
            As we know, ^ operator gives 0 if both bits are same.
            In our array, 2 same numbers become 0(cancelled out) when we use ^ operator on them.
            So, remaining number is the single number.
         */

        int singleNumber = 0;
        for(int i = 0; i < arr.length; i++) {
            singleNumber ^= arr[i];
        }

        System.out.println("Single Number is : " + singleNumber);
    }

    private static void findOddOrEven(int n) {
        /*

            Let's say we have number 21 which is having binary value of "1011"
            If I use "& 1" with 21, It will return me 1 if and only if the last bit is 1

         */
        boolean isOdd = (n & 1) == 1;
        System.out.println("Number " + n + " is " + (isOdd ? "Odd" : "Even"));
    }


}
