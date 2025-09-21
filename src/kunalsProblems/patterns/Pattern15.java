package kunalsProblems.patterns;

public class Pattern15 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 1; i <= n; i++) {
            int st = n - i + 1;
            int end = n + i - 1;

            for(int j = 1; j <= 2 * n - 1; j++) {
                if(j == st || j == end) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for(int i = 1; i <= n; i++) {
            int st = i;
            int end = 2 * n - i;

            if(i == 1) continue;

            for(int j = 1; j <= 2 * n - 1; j++) {
                if(j == st || j == end) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
