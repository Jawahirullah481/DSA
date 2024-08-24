package practice;

public class Bouqet {

        public static void main(String[] args) {
            int[] arr = {1, 2, 1, 2, 7, 2, 2, 3, 1};
            int r = 3, b = 2;
            System.out.println("Answer : " + roseGarden(arr, r, b));
        }

        public static int roseGarden(int[] arr, int r, int b) {

            if(arr.length < r * b) {
                return -1;
            }

            int min = findMin(arr), max = findMax(arr);
            while(min <= max) {
                int mid = (min) + (max - min) / 2;
                int totalBouqets = findTotal(arr, mid, r, b);

                if(totalBouqets < b) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }

            return min;
        }

        static int findTotal(int[] arr, int bloominDay, int r, int b) {
            int roseCount = 0;
            int total = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] <= bloominDay) {
                    roseCount++;
                } else {
                    // total bouquets made is sum of
                    total += Math.floor((double)roseCount / r);
                    roseCount = 0;
                }
            }

            return total;

            // [1, 2, 3, 5, 4, 5]
        }

        static int findMin(int[] arr) {
            int ans = Integer.MAX_VALUE;
            for(int i = 0; i < arr.length; i++) {
                ans = Integer.min(ans, arr[i]);
            }

            return ans;
        }

        static int findMax(int[] arr) {
            int ans = Integer.MIN_VALUE;
            for(int i = 0; i < arr.length; i++) {
                ans = Integer.max(ans, arr[i]);
            }

            return ans;
        }

}
