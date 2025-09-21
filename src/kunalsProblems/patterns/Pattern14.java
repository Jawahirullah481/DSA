package kunalsProblems.patterns;

public class Pattern14 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 1; i <= n; i++) {
            int st = i;
            int end = 2 * n - i;
            for(int j = 1; j <= 2 * n - 1; j++) {
                if(i == 1 || j == st || j == end) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    /*
        i = 5, 5, 5 => st, st
        i = 4, 4, 6 => st, n
        i = 3, 3, 7 => st, n + (n - i)
     */
}
