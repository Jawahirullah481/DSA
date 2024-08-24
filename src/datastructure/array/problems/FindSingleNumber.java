package datastructure.array.problems;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class FindSingleNumber {
    /*
        NOTE :
        ======
        1. Whenever there are situation to find a single number, then try to use xor operator.
        2. Becuase, duplicates numbers will cancelled out.
        3. In the missing number also, all the number and it's index gets cancelled out.
     */
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 2, 3, 4, 5};

        // Brute (Space complexity : O(N / 2), Time Complexity : O(2N)
        findSingleNumberBrute(arr);

        // Optimal (Space Complexity : O(1), Time Complexity : O(N)
        findSinglenNumberOptimal(arr);
    }

    private static void findSingleNumberBrute(int[] arr) {
        int singleNumber = -1;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int num = map.get(arr[i]);
                map.replace(arr[i], num + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for(Integer i : map.keySet()) {
            if(map.get(i) == 1) {
               singleNumber = i;
               break;
            }
        }

        System.out.println("Array is : " + Arrays.toString(arr));
        System.out.println("Single Number is : " + singleNumber);
    }

    public static void findSinglenNumberOptimal(int[] arr) {
        int xor = 0;
        for(int i : arr) {
            xor ^= i;
        }

        System.out.println("Single Number using XOR is : " + xor);
    }
}
