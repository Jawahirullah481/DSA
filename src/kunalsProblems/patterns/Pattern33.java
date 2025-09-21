package kunalsProblems.patterns;

public class Pattern33 {
    public static void main(String[] args) {
        int n = 5;
        int num = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++, num++) {
                if(num % 2 == 1) {
                    System.out.print((char)('A' + num) + " ");
                } else {
                    System.out.print((char)('a' + num) + " ");
                }
            }
            System.out.println();
        }
    }
}
