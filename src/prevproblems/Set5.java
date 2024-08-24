package prevproblems;

import jdk.jfr.Description;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Set5 {
    public static void main(String[] args) {
        // Problem 1 :
        findMinimumWorkersNeeded();

        // Problem 2 :
        findUnionIntersection();

        // Problem 3 :
        findLargestPrimeNumberWithGivenNo();
    }

    @Description("Problem 1")
    public static void findMinimumWorkersNeeded() {
        /*
            Youtube : https://www.youtube.com/watch?v=AsGzwR_FWok

            Thought Process :
            =================
            1. Here you simply watching time and keep track of count of workers.
            2. You sort both st and end time of work.
            3. if starting time of next work is less than ending time of current work,
                then need 1 more worker.
            4. if ending time of next work is less than starting time,
                then work will be finished before next work starts.
            5. So, release 1 worker.
         */
        int[] st = {1230, 1200, 1600};
        int[] end = {1330, 1300, 1700};

        Arrays.sort(st);
        Arrays.sort(end);

        int i = 0, j = 0, count = 0, maxCount = 0;

        while(i < st.length) {
            if(st[i] <= end[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }

            maxCount = Math.max(count, maxCount);
        }

        System.out.println("Minimum workers needed is : " + maxCount);
    }


    @Description("Problem 2")
    public static void findUnionIntersection() {
        int[] arr1 = {1,3,4,5,6,8,9};
        int[] arr2 = {1,5,8,9,2};

        findUnion(arr1, arr2);
        findIntersection(arr1, arr2);
    }

    public static void findUnion(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = -1;
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        List<Integer> list = new ArrayList<>();

        while(i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                if (k == -1) {
                    list.add(arr1[i]);
                    k++;
                } else {
                    if (list.get(k) != arr1[i]) {
                        list.add(arr1[i]);
                        k++;
                    }
                }
                i++;
            } else {
                if (k == -1) {
                    list.add(arr2[j]);
                    k++;
                } else {
                    if (list.get(k) != arr2[j]) {
                        list.add(arr2[j]);
                        k++;
                    }
                }
                j++;
            }
        }

            while(i < arr1.length) {
                if(k == -1) {
                    list.add(arr1[i]);
                    k++;
                } else {
                    if(list.get(k) != arr1[i]) {
                        list.add(arr1[i]);
                        k++;
                    }
                }
                i++;
            }

            while(j < arr2.length) {
                if(k == -1) {
                    list.add(arr2[j]);
                    k++;
                } else {
                    if(list.get(k) != arr2[j]) {
                        list.add(arr2[j]);
                        k++;
                    }
                }
                j++;
            }

            System.out.println("union : " + list);
    }

    public static void findIntersection(int[] arr1, int[] arr2) {

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0, k = 0;
        List<Integer> list = new ArrayList<>();

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] == arr2[j]) {
                list.add(arr1[i]);
                i++;
                j++;
            } else if(arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println("Intersection : " + list);
    }

    public static void findLargestPrimeNumberWithGivenNo() {
        int n = 4691;
        List<Integer> list = findAllPossibleNumbers("", Integer.toString(n));
        Collections.sort(list);
        Collections.reverse(list);

        System.out.println(list);

        int maxNo = 0;

        for(int x : list) {
            boolean isPrime = true;
            for(int i = 2; i * i <= x; i++) {
                if(x % i == 0) {
                    isPrime = false;
                }
            }
            if(isPrime) {
                maxNo = x;
                break;
            }
        }

        System.out.println("Maximum Prime number is : " + maxNo);
    }

    public static List<Integer> findAllPossibleNumbers(String p, String up) {
        if(up.length() == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(p));
            return list;
        }

        char top = up.charAt(0);
        List<Integer> outer = new ArrayList<>();
        for(int i = 0; i <= p.length(); i++) {
            List<Integer> inner = findAllPossibleNumbers(p.substring(0, i) + top + p.substring(i), up.substring(1));
            outer.addAll(inner);
        }

        return outer;
    }
}
