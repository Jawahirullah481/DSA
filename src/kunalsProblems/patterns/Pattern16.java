package kunalsProblems.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pattern16 {
    public static void main(String[] args) {

        int n = 5;
        List<Integer> prevList = Arrays.asList(1);

        for(int i = 0; i < n; i++) {
            List<Integer> currList = new ArrayList<>();

            for(int j = 0; j <= i; j++) {
                int cross = 0;
                int above = 0;

                if(j != 0) {
                    cross = prevList.get(j - 1);
                }

                if(j < i || i == 0) {
                    above = prevList.get(j);
                }

                int sum = cross + above;
                currList.add(sum);
            }

            print(currList, n, i);
            prevList = currList;
        }

    }

    public static void print(List<Integer> list, int n, int r) {
        int sp = n - 1 - r;

        for(int i = 1; i <= sp; i++) {
            System.out.print("  ");
        }

        for(int num : list) {
            System.out.print(num + "   ");
        }
        System.out.println();
    }

    /*
        1
        11
        121
        1331
        14641
     */
}
