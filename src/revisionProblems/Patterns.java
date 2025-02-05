package revisionProblems;

public class Patterns {

    public static void main(String[] args) {
         pattern1();
         pattern2();
         pattern3();
         pattern4();
         pattern5();
         pattern6();
         pattern7();
         pattern8();
         pattern9();
       //  pattern10(); 12 not solved
         pattern11();
         pattern12();
         pattern13();
        pattern14();
        pattern15();
    }

    private static void pattern15() {
        /*
         4 4 4 4 4 4 4
         4 3 3 3 3 3 4
         4 3 2 2 2 3 4
         4 3 2 1 2 3 4
         4 3 2 2 2 3 4
         4 3 3 3 3 3 4
         4 4 4 4 4 4 4
         */

        System.out.println("\nPATTERN 15 : \n");

        int n = 4;

        for(int i = 1; i < 2 * n; i++) {
            for(int j = 1; j < 2 * n; j++) {
                int left = Math.abs(1 - j);
                int right = Math.abs(2 * n - 1 - j);
                int top = Math.abs(1 - i);
                int bottom = Math.abs(2 * n - 1 - i);

                int x = Math.min(Math.min(left, right), Math.min(top, bottom));
                x = 4 - x;
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    private static void pattern14() {
        /*

              1
            1   1
          1   2   1
        1   3   3   1
      1   4   6   4   1


      1(1, 1)
      1(2, 1)   1(2, 2)
      1(3, 1)   2(3, 2)   1(3, 3)
      1(4, 1)   3(4, 2)   3(4, 3)   1(4, 4)
      1(5, 1)   4(5, 2)   6(5, 3)   4(5, 4)   1*5,

         */
    }

    private static void pattern13() {
        /*

         *
        * *
       *   *
      *     *
       *   *
        * *
         *

         // Whenever the pattern is like a triangle, then it would be
         // n, -> 1st row
         // n-1, n+1 -> 2nd row
         // n-2, n+2 -> 3rd row
         // n-3, n+3 -> 4th row

         */

        System.out.println("\nPATTERN 13 : \n");

        int n = 5;

        // Upper triangle
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= (2 * n - 1); j++) {
                if(j == (n - i) || j == (n + i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // Lower triangle
        n--;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= (2 * n); j++) {
                if(j == i + 1 || j == n + (n - i + 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    private static void pattern12() {
        /*

        *********
         *     *
          *   *
           * *
            *

            1 -> 2, 9 - 1
            2 -> 3, 9 - 2
            3 -> 4, 9 - 3
            4 -> 5, 9 - 4

         */

        System.out.println("\nPATTERN 12 : \n");

        int n = 5;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= (2 * n - 1); j++) {
                if(j == i || j == (2 * n - i) || i == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void pattern11() {

        System.out.println("\nPATTERN 11 : \n");

        int n = 5;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= (2 * n - 1); j++) {
                if(j == (n - i) || j == (n + i) || i == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void pattern10() {

    /*
        0 - 0 - 5
        1 - 1 - 4
        2 - 2 - 3
        3 - 3 - 2
        4 - 4 - 1
        5 - 4 - 1   (10 - 9)
        6 - 3 - 2   (10 - 8)
        7 - 2 - 3   (10 - 7)
        8 - 1 - 4   (10 - 6)
        9 - 0 - 5 - (10 - 5)

     */


    }

    private static void pattern9() {
        /*

        0 - 9 - (10 - 1 - 0)
        1 - 7 - (10 - 1 - 2)
        2 - 5 - (10 - 1 - 4)
        3 - 3 - (10 - 1 - 6)
        4 - 1

         */

        System.out.println("\nPATTERN 9 : \n");

        int n = 5;
        for(int i = 0; i < n; i++) {
            for(int sp = 0; sp < i; sp++) {
                System.out.print(" ");
            }

            for(int st = 0; st < ((2 * n - 1) - 2 * i); st++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern8() {

        /*

             *
            ***
           *****
          *******
         *********

         i = 1, star = 1, st = 5, end = 5
         i = 2, star = 3, st = 4, end = 6
         i = 3, star = 5, st = 3, end = 7
         i = 4, star = 7, st = 2, end = 8
         i = 5, star = 9, st = 1, end = 9

         */

        System.out.println("\nPATTERN 8 : \n");

        int n = 5;
        for(int i = 1; i <= n; i++) {
            for(int sp = 1; sp <= (n - i); sp++) {
                System.out.print(" ");
            }
            for(int st = 1; st <= 2 * (i - 1) + 1; st++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern7() {

        System.out.println("\nPATTERN 7 : \n");

        int n = 5;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= n; j++) {
                if(j <= i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    private static void pattern6() {

        System.out.println("\nPATTERN 6: \n");

        int n = 5;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <=n; j++) {
                if(j <= n - i) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    private static void pattern5() {

        /*

         *
         **
         ***
         ****
         *****
         ****
         ***
         **
         *

         1-1
         2-2
         3-3
         4-4
         5-5 -> n
         6-4
         7-3
         8-2
         9-1
         10-0 -> n*2


         */

        System.out.println("\nPATTERN 5 : \n");

        int n = 6;
        for(int i = 1; i <= (2 * n); i++) {
            int columns = (i <= n) ? i : ((2 * n) - i);
            for(int j = 1; j <= columns; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern4() {

        System.out.println("\nPATTERN 4 : \n");

        int n = 5;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void pattern3() {

        System.out.println("\nPATTERN 3 : \n");

        int n = 5;
        for(int i = 0; i < n; i++) {
            for(int j = n - i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern2() {

        System.out.println("\nPATTERN 2 : \n");

        int n = 5;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern1() {

        System.out.println("\nPATTERN 1 : \n");

        int row = 5; int col = 6;
        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
