package kunalsProblems.patterns;

public class Pattern34 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = n; i >= 1; i--) {
            for(int j = i; j >= 1; j--) {
                System.out.print((char)('A' + j - 1) + " ");
            }
            System.out.println();
        }
    }
}
