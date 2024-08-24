package prevproblems;

import jdk.jfr.Description;

import java.util.*;

public class Set26 {
    public static void main(String[] args) {
        // Problem 1
        secondMostFrequencyElement();

        // Problem 2
        printNumberInFibonacci();

        // Problem 3
        insertAfterConsecutive1();
    }

    @Description("Problem 1")
    public static void secondMostFrequencyElement() {
        int[] arr = {1, 1, 2, 3, 1, 2, 4};
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr) {
            if(map.containsKey(i)) {
                int count = map.get(i);
                map.replace(i, count + 1);
            } else {
                map.put(i, 1);
            }
        }

        int first = 0, second = 0, firstCount = 0, secondCount = 0;

        for(Integer number : map.keySet()) {
            int freq = map.get(number);
            if(freq > firstCount) {
                secondCount = firstCount;
                second = first;
                firstCount = freq;
                first = number;
            } else if(freq > secondCount) {
                secondCount = freq;
                second = number;
            }
        }

        System.out.println("2nd most frequency number : " + second);
    }


    @Description("Problem 2")
    public static void printNumberInFibonacci() {
        int[] arr = {1, 10, 6, 8, 13, 21};
        int max = 0;
        for(int i : arr) {
            max = Math.max(i, max);
        }

        List<Integer> fibonacci = new ArrayList<>();
        int a = 0, b = 1;
        while(b <= max) {
            int sum = a + b;
            fibonacci.add(sum);
            a = b;
            b = sum;
        }

        System.out.print("Fibonacci are : ");
        for(int i : arr) {
            if(fibonacci.contains(i)) {
                System.out.print(i + ", ");
            }
        }
    }

    @Description("Problem 3")
    public static void insertAfterConsecutive1() {
        int[] arr = {1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1};
        List<Integer> list = new ArrayList<>();
        int k = 2;

        int onesCount = 0;
        for(int i : arr) {
            list.add(i);

            if(i == 1) {
                onesCount++;
            } else {
                onesCount = 0;
            }

            if(onesCount == k) {
                list.add(0);
                onesCount = 0;
            }
        }

        System.out.println(list);
    }

}
