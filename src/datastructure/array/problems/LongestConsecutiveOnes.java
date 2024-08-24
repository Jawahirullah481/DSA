package datastructure.array.problems;

public class LongestConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1};
        findLongestConsecutiveOnes(arr);
    }

    private static void findLongestConsecutiveOnes(int[] arr) {
        int i = 0;
        int max = 0;

        while(i < arr.length) {
            int currCount = 0;
            while(i < arr.length && arr[i] == 1) {
                currCount++;
                i++;
            }

            if(currCount > max) {
                max = currCount;
            }
            i++;
        }

        System.out.println("Maximum consecutive 1s : " + max);
    }
}
