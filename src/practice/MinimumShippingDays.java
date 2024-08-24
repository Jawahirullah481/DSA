package practice;

public class MinimumShippingDays {

    public static void main(String[] args) {
        int[] weights = {5,4,5,2,3,4,5,6};
        int days = calculateDaysToShip(weights, 20);
        System.out.println(days);
    }

    public static int leastWeightCapacity(int[] weights, int d) {

        int start = findMax(weights), end = count(weights);
        while(start <= end) {
            int currentCapacity = start + (end - start) / 2;
            int days = calculateDaysToShip(weights, currentCapacity);
            if(days <= d) {
                end = currentCapacity - 1;
            } else {
                start = currentCapacity + 1;
            }
        }

        return start;
    }

    static int calculateDaysToShip(int [] weights, int capacity) {
        int days = 0;
        int currentShippingWeight = 0;
        for(int i = 0; i < weights.length; i++) {
            currentShippingWeight += weights[i];
            if(currentShippingWeight >= capacity) {
                days++;
                if(currentShippingWeight > capacity) {
                    currentShippingWeight = weights[i];
                }
                else {
                    currentShippingWeight = 0;
                }
            }
        }

        if(currentShippingWeight > 0) {
            days++;
        }

        return days;
    }

    static int findMax(int[] weights) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < weights.length; i++) {
            max = Math.max(max, weights[i]);
        }

        return max;
    }

    static int count(int[] weights) {
        int total = 0;
        for(int i = 0; i < weights.length; i++) {
            total += weights[i];
        }

        return total;
    }
}
