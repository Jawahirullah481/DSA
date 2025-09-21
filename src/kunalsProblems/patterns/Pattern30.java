package kunalsProblems.patterns;

public class Pattern30 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 1; i <= n; i++) {

            for(int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            int num = i;
            for(int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(num + " ");
                if(j < i) {
                    num--;
                } else {
                    num++;
                }
            }
            System.out.println();
        }
    }
}
