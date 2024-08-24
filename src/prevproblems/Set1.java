package prevproblems;

import jdk.jfr.Description;

import java.util.Arrays;

/*
    Missed problems :
    ==================
    1. Set 2  -> Question 4 : Is Valid maths expression
    2. Set 5  -> Question 4 : Rotate matrix by 1
    3. Set 5  -> Question 5 : Find new friends in Social network
    4. Set 10 -> Question 4 : Pattern matching
    5. Set 17 -> Question 3 : No.Of.Children at nth level
    6. Set 21 -> Question 4 : Find word in diagonals
    7. Set 22, 25 -> All
    8. Binary tree
 */

public class Set1 {
    public static void main(String[] args) {

        // Problem 1 :
        printStringInCross("Jawahir");

        // Problem 2 :
        PrintWeightOfNumbers(new int[] {10, 36, 8, 49, 12});

        // Problem 3 :
        findTooInZoho();

        // Problem 4 :
        isPerfectSudoku();

        // Problem 5 :
        findGrandChilden();
    }

    @Description("Problem 1")
    public static void printStringInCross(String str) {
        System.out.println("Problem 1 : ");
        /*
            1. int st = 0, end = str.length - 1;
            2. iterate i from 0 till str.length - 1;
            3. for every i, iterate j from 0 till str.length - 1.
            4. if j == st || j == end, print j. else print space.
         */

        int st = 0, end = str.length() - 1;
        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < str.length(); j++) {
                if(j == st || j == end) {
                    System.out.print(str.charAt(j));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            st++;end--;
        }

        System.out.println();
    }

    @Description("Problem 2")
    private static void PrintWeightOfNumbers(int[] arr) {
        System.out.println("Problem 2 : ");
        /*
            1. 5 if a perfect square
            2. 4 if multiple of 4 and divisible by 6
            3. 3 if even number

            And sort the numbers based on the weight and print it as follows
         */
        int weight = 0;
        int[] weights = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            if(isPerfectSquare(arr[i])) {
                weight += 5;
            }

            if((arr[i] % 4 == 0) && (arr[i] % 6 == 0)) {
                weight += 4;
            }

            if(arr[i] % 2 == 0) {
                weight += 3;
            }

            weights[i] = weight;
            weight = 0;
        }

        sortBasedOnWeights(weights, arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print("<" + arr[i] + ", " + weights[i] + ">, ");
        }
        System.out.println();
        System.out.println();
    }

    private static boolean isPerfectSquare(int n) {
        for(int i = 2; i * i <= n; i++) {
            if(i * i == n) {
                return true;
            }
        }

        return false;
    }

    private static void sortBasedOnWeights(int[] weights, int[] arr) {
        for(int i = 0; i < weights.length - 1; i++) {
            for(int j = i + 1; j < weights.length; j++) {
                if(weights[i] < weights[j]) {
                    int temp = weights[j];
                    weights[j] = weights[i];
                    weights[i] = temp;

                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }


    @Description("Problem 3")
    public static void findTooInZoho() {
        System.out.println("Problem 3");

        String zoho = "welcometozohocorporation";
        int i = 0;
        // NOTE
        char[][] arr1 = new char[(int)Math.ceil(zoho.length() / 5.0)][5];

        for(int j = 0; j < arr1.length; j++) {
            for(int k = 0; k < arr1[0].length; k++) {
                if(i >= zoho.length()) {
                    arr1[j][k] = '0';
                } else {
                    arr1[j][k] = zoho.charAt(i);
                }
                i++;
            }
        }

        for(char[] a : arr1) {
            System.out.println(Arrays.toString(a));
        }

        String subString = "too";
        for(int x = 0; x < arr1.length; x++) {
            for(int y = 0; y <= arr1[0].length - subString.length(); y++) {
                int a = 0;
                while(a < subString.length() && arr1[x][y + a] == subString.charAt(a)) {
                    a++;
                }

                if(a == subString.length()) {
                    System.out.println("Start Index : " + x + ", " + y);
                    System.out.println("End Index : " + x + ", " + (y + a - 1));
                    break;
                }
            }
        }

        for(int x = 0; x <= arr1.length - subString.length(); x++) {
            for(int y = 0; y < arr1[0].length; y++) {
                int a = 0;
                while(a < subString.length() && arr1[x + a][y] == subString.charAt(a)) {
                    a++;
                }

                if(a == subString.length()) {
                    System.out.println("Start Index : " + x + ", " + y);
                    System.out.println("End Index : " + (x + a - 1)+ ", " + y);
                    break;
                }
            }
        }

        System.out.println();
    }


    @Description("Problem 4")
    public static void isPerfectSudoku() {
        System.out.println("Problem 4 : ");

        /*
            NOTE : Eventhough the duplicates are in the subgrid(3 X 3),
            finding duplicate in row and duplicate in column is enough.
         */

        boolean isPerfectSudoku = true;

        int[][] arr = new int[][] {
                { 5, 1, 3, 6, 8, 7, 2, 4, 9 },
                { 8, 4, 9, 5, 2, 1, 6, 3, 7 },
                { 2, 6, 7, 3, 4, 9, 5, 8, 1 },
                { 1, 5, 8, 4, 6, 3, 9, 7, 2 },
                { 9, 7, 4, 2, 1, 8, 3, 6, 5 },
                { 3, 2, 6, 7, 9, 5, 4, 1, 8 },
                { 7, 8, 2, 9, 3, 4, 1, 5, 6 },
                { 6, 3, 5, 1, 7, 2, 8, 9, 4 },
                { 4, 9, 1, 8, 5, 6, 7, 2, 2 }
        };



        for(int i = 0; i < arr.length; i++) {
            if(!checkPerfectSudokuRow(arr, i)) {
                isPerfectSudoku = false;
                break;
            }
        }

        for(int i = 0; i < arr[0].length && isPerfectSudoku; i++) {
            if(!checkPerfectSudokuColumn(arr, i)) {
                isPerfectSudoku = false;
                break;
            }
        }

        System.out.println("The given sudoku is Perfect : " + isPerfectSudoku);


    }

    public static boolean checkPerfectSudokuRow(int[][] arr, int row) {
        boolean[] nums = new boolean[arr[0].length];

        for(int i = 0; i < arr[0].length; i++) {
            int x = arr[row][i];
            if(nums[x - 1] == true) {
                return false;
            }
            nums[x - 1] = true;
        }

        return true;
    }

    public static boolean checkPerfectSudokuColumn(int[][] arr, int col) {
        boolean[] nums = new boolean[arr.length];

        for(int i = 0; i < arr.length; i++) {
            int x = arr[i][col];
            if(nums[x - 1] == true) {
                return false;
            }
            nums[x - 1] = true;
        }
        return true;
    }


    @Description("Problem 5")
    public static void findGrandChilden() {

        System.out.println("Problem 5 : ");
        String[][] arr ={{"luke", "shaw"},
                         {"wayne", "rooney"},
                         {"rooney", "ronaldo"},
                         {"shaw", "rooney"}};

        String grandPa = "ronaldo";

        /*
            Thought Process :
            =================
            Iterate the 2d array. Whenever you find ronaldo(whose grandchildren we want to find),
            then get the children. And iterate through the entire array to know what are the children of
            ronaldo's directive child. In that way you calculate grand children.
         */
        int grandChildren = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i][1].equals("ronaldo")) {
                String father = arr[i][0];
                for(int k = 0; k < arr.length; k++) {
                    if(arr[k][1].equals(father)) {
                        grandChildren++;
                    }
                }
            }
        }

        System.out.println("Number of Grandchildren Ronaldo has : " + grandChildren);
        System.out.println();
    }
}
