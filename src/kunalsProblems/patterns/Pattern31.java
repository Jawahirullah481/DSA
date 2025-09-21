package kunalsProblems.patterns;

public class Pattern31 {
    public static void main(String[] args) {
        int n = 4;

        for(int i = 1; i <= 2 * n - 1; i++) {
            for(int j = 1; j <= 2 * n - 1; j++) {
                int fromTop = i;
                int fromLeft = j;
                int fromBottom = (2 * n - 1) - i + 1;
                int fromRight = (2 * n - 1) - j + 1;

                int min = Math.min(Math.min(fromTop, fromLeft), Math.min(fromBottom, fromRight));
                System.out.print(n - min + 1 + " ");
            }
            System.out.println();
        }
    }
}
