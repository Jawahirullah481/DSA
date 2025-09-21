package kunalsProblems.patterns;

public class Pattern19 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 2 * n - 1; j++) {
                int st = i;
                int end = 2 * n - i;

                if(j <= st || j >= end) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for(int i = n - 1; i >= 1; i--) {
            for(int j = 1; j <= 2 * n - 1; j++) {
                int st = i;
                int end = 2 * n - i;

                if(j <= st || j >= end) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
