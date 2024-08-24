package practice;

public class TwoSum {

        public static void main(String[] args) {
            int[] arr = {3,2,4}; int target = 6;
            int[] result = twoSum(arr, target);
            System.out.println("["+result[0]+ ", " + result[1] + "]");
        }

        public static int[] twoSum(int[] arr, int target) {
            int n = -1, m = -1;
            for(int i = 0; i < arr.length - 1; i++) {
                if(arr[i] + arr[i + 1] == target) {
                    n = i; m = i + 1;
                    break;
                }
            }
            return new int[] {n, m};
        }

}
