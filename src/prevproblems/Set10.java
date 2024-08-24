package prevproblems;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Set10 {
    public static void main(String[] args) {
        // Problem 1
        mergeWithouDuplicates();

        // Problem 2
        slidingWindow();

        // Problem 3
        printNoOfOccurence();

        // Problem 4
        checkSubstring();
    }

    @Description("Problem 1")
    public static void mergeWithouDuplicates() {
        /*
            Thought Process :
            =================
            1. Take 2 pointer.
            2. If arr1 element is smaller than arr2 element,
                then check, if last element in the list is not similar to arr1 element.
            3. If arr2 element is smaller that arr1 element,
                then check, if last element in list is not similar to arr2 element.
            4. If so add it to list.
         */
        int[] arr1 = {1, 2, 3, 6, 9};
        int[] arr2 = {2, 4, 5, 10};

        int i = 0, j = 0, k = -1;
        List<Integer> list = new ArrayList<>();

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                // Add arr1 element to list
                if(k == -1 || list.get(k) !=arr1[i]) {
                    list.add(arr1[i]);
                    k++;
                }
                i++;
            } else {
                // Add arr2 element to list
                if(k == -1 || list.get(k) != arr2[j]) {
                    list.add(arr2[j]);
                    k++;
                }
                j++;
            }
        }

        while(i < arr1.length) {
            if(k == -1 || list.get(k) != arr1[i]) {
                list.add(arr1[i]);
                k++;
            }
            i++;
        }

        while(j < arr2.length) {
            if(k == -1 || list.get(k) != arr2[j]) {
                list.add(arr2[j]);
                k++;
            }
            j++;
        }

        System.out.println("After merger : " + list);
    }

    @Description("Problem 2")
    public static void slidingWindow() {
        /*
            Thought Process :
            ================
            1. Take 2 pointers. st and end.
            2. Iterate from st till end to find the max element.
            3. After find the max element put it into list.
            4. then move st and end.
            5. if old max lies in range even after we moved st and end. And, if new end element
            is less than our old max, then add old max to list.
            6. if new end element is greater than our old max, then max new end as max and add to list.
            7. if old max not lies in range, then find max from st to end.
         */
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        int st = 0, end = k - 1;
        int max = findMax(arr, st, end);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[max]);
        st++;end++;

        while(end < arr.length) {
            if((max >= st && max < end)) {
                if(arr[max] > arr[end]) {
                    list.add(arr[max]);
                } else {
                    max = end;
                    list.add(arr[max]);
                }
            } else {
                max = findMax(arr, st, end);
                list.add(arr[max]);
            }
            st++;end++;
        }

        System.out.println("After sliding the window : " + list);
    }

    public static int findMax(int[] arr, int st, int end) {
        int max = st;
        for(int i = st + 1; i <= end; i++) {
            if(arr[i] >= arr[max]) {
                max = i;
            }
        }
        return max;
    }

    public static void printNoOfOccurence() {
        int[] arr = {2,1,3,2,2,5,8,9,8};
        // Map<No, Count>
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                int count = map.get(i);
                map.replace(i, count + 1);
            }
        }

        System.out.println("Occurence : " + map);
    }

    public static void checkSubstring() {
        String s1 = "abcd";
        String s2 = "a*cd";

        System.out.println((s1.matches(s2)) ? "Yes" : " No");
    }
}