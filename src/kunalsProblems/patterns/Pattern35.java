package kunalsProblems.patterns;

public class Pattern35 {
    public static void main(String[] args) {
        int n = 4;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 2 * n; j++) {
                if(j <= i || j >= (2 * n - i) + 1) {
                    int num = j <= n ? j : (2 * n + 1) - j;
                    System.out.print(num + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
