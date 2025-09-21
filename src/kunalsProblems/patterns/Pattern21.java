package kunalsProblems.patterns;

public class Pattern21 {
    public static void main(String[] args) {
        int n = 5;

        int num = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++, num++) {
                System.out.printf("%-3d", num);
            }
            System.out.println();
        }
    }
}
