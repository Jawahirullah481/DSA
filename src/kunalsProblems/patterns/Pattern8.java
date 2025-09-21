package kunalsProblems.patterns;

public class Pattern8 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 2 * n - 1; j++) {
                int st = n - i + 1;
                int end = n + i - 1;

                if(j >= st && j <= end) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /*
        1 -> 5, 5  5 - 1 + 1, 5 + 1 - 1
        2 -> 4, 6   5 - 2 + 1, 5 + 2 - 1
        3 - > 3, 7  5 - 3 + 1, 5 + 3 - 1
        4 -> 2, 8
        5 -> 1, 9
     */
}
