package kunalsProblems.patterns;

public class Pattern9 {
    public static void main(String[] args) {

        int n = 5;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 2 * n - 1; j++) {
                int st = i;
                int end = 2 * n - i;

                if(j >= st && j <= end) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    // 1 -> 1, 9  st = i, end = 2*n - i + 1
    // 2 -> 2, 8  st = 2, end = 9 - 2 + 1 (8)
    // 3 -> 3, 7, st = 3, end = 9 - 3 + 1 (7)
    // 4 -> 4, 6
    // 5 -> 5, 5
}
