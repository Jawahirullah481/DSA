package practice;

import java.util.*;

public class Temp1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = arr.length;
        int s = 19;

        ArrayList<Integer> list = subarraySum(arr, n, s);
        System.out.println(list);
    }
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int st = 0, end = 0;
        int i = 0;
        int count = arr[i];
        // {1, 5}, s = 5
        while(i < n && st < n) {

            if(count == s) {
                list.add(st + 1);list.add(i + 1);
                return list;
            }

            if(count > s) {
                count -= arr[st];
                st++;
            } else {
                i++;
                count += arr[i];
            }
        }

        list.add(-1);
        return list;
    }
}
