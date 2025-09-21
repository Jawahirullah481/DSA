package kunalsProblems.patterns;

public class Pattern29 {

    public static void main(String[] args) {
        int n = 9;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {

                int left = Math.min(i, n - i + 1);
                int right = Math.max(i, n - i + 1);

                if(j <= left || j >= right) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

}
