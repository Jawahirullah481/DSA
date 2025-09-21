package kunalsProblems.patterns;

public class Pattern13 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 1; i <= n; i++) {
            int st = n - i + 1;
            int end = n + i - 1;

            for(int j = 1; j <= 2 * n - 1; j++) {
                if(i == n || j == st || j == end) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /*
        1 -> 5, 5 -> 5 - 1(i) + 1, 5 + 1(i) - 1
        2 -> 4, 6 -> 5 - 2(i) + 1, 5 + 2(i) - 1
        3 -> 3, 7
        ..
        5 -> 1, 9
     */
}
