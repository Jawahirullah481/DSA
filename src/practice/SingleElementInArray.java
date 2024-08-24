package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleElementInArray {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 1, 4, 4, 15));
        int ans = singleNonDuplicate(arr);
        System.out.println("Answe is : " + ans);
    }

    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        int start = 0;
        int end = arr.size();

        while(start < end) {
            int mid = start + (end - start) / 2;

            if((mid == 0 && arr.get(mid) != arr.get(mid + 1)) || (mid == arr.size() - 1 && arr.get(mid) != arr.get(mid - 1))) {
                return arr.get(mid);
            }

            if((start < mid && arr.get(mid) != arr.get(mid - 1)) && (mid < end && arr.get(mid) != arr.get(mid + 1))) {
                return arr.get(mid);
            }

            int firstElement = arr.get(mid) == arr.get(mid - 1) ? mid - 1 : mid;
            if(firstElement % 2 == 0) {
                start = firstElement + 2;
            } else {
                end = firstElement - 1;
            }

        }

        return arr.get(start);

        //  [1,1,2,2,4,5,5] -> 2 -> 5 -> 4
        //  [1,2,2,4,4,5,5] -> 4 -> 2 -> 1
        //  [1,1,3,5,5]       ->
        //  [1,1,4,4,15]     -> 4 ->
        //
    }
}
