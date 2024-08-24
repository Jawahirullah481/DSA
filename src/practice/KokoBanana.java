package practice;

public class KokoBanana {

    public static void main(String[] args) {
        int[] v = {7, 15, 6, 3};
        int h = 8;
        System.out.println("Answer : " + minimumRateToEatBananas(v, h));
    }

    public static int minimumRateToEatBananas(int []v, int h) {
        int min = 1;
        int max = findMax(v);
        int ans = 0;

        while(min <= max) {
            // Here mid, is the no.of banana eat in an hour
            int mid = min + (max - min) / 2;
            int timeTaken = calculateHoursToEat(v, mid);


            if(timeTaken <= h) {
                ans = mid;
                max = mid - 1;
            } else {
                // As the monkey eats less bananas, the time is increase
                // So, we need to increase no.of.bananas eaten.
                min = mid + 1;
            }
        }

        return ans;
    }

    static int calculateHoursToEat(int[] piles, int banana) {
        int totalHour = 0;
        for(int i = 0; i < piles.length; i++) {
            totalHour += Math.ceil((double)piles[i] / (double)banana);
            System.out.println("No of Banans : " + piles[i] + "totalHour : " + Math.ceil((double)piles[i] / banana));
        }

        return totalHour;
    }

    static int findMax(int[] v) {
        int max = 0;
        for(int i = 0; i < v.length; i++) {
            if(v[i] > max) {
                max = v[i];
            }
        }

        return max;
    }

}
