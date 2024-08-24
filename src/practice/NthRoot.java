package practice;

public class NthRoot {

    public static void main(String[] args) {
        int ans = NthRoot(4, 69);
        System.out.println("Answer : " + ans);
    }

    public static int NthRoot(int n, int m) {
        int start = 0;
        int end = m / 2;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            long value = (long)Math.pow(mid, n);

            if(value == m) {
                return mid;
            }

            if(value <= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
