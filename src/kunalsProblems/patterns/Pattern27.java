package kunalsProblems.patterns;

public class Pattern27 {
    public static void main(String[] args) {
        int n = 4;
        int num = 1;

        int sum = (n * (n + 1)) / 2;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(j >= i) {
                    System.out.printf("%-3d", num++);
                } else {
                    System.out.print("   ");
                }
            }

            int num2 = (sum * 2) + 1 - (num - 1);

            for(int j = 1; j <= n - i + 1; j++) {
                System.out.printf("%-3d", num2++);
            }

            System.out.println();
        }
    }
}
