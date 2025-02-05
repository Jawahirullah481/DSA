package prevproblems;

import jdk.jfr.Description;

import java.util.*;

public class Set23 {
    public static void main(String[] args) {
        // Problem 1
        pascalTriangle();

        // Problem 2
        printUniqueMatrix();

        // Problem 3
        longestContinuousArray();

        // Problem 4
        findMaxNumFormed();
    }

    @Description("Problem 1")
    public static void pascalTriangle() {
        /*
            1
           1 1
          1 2 1
         1 3 3 1
        1 4 6 4 1

        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1

         */

        int rows = 5;

        List<List<Integer>> pascal = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                } else {
                    List<Integer> prevList = pascal.get(i - 1);
                    list.add(prevList.get(j - 1) + prevList.get(j));
                }
            }
            pascal.add(list);
            printPascalRow(list, rows - i - 1);
        }
    }

    public static void printPascalRow(List<Integer> list, int sp) {
        for(int i = 0; i < sp; i++) {
            System.out.print(" ");
        }
        for(int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Description("Problem 2")
    public static void printUniqueMatrix() {
        /*
            Problem statement :
            ===================
            Given a two dimensional array which consists of only 0’s and 1’s.
            Print the matrix without duplication.

            Thought Process :
            =================
            As we have binary arrays, we can convert it into decimal values.
            And we can put it into set.
            If duplicate arises for any subarray, then don't print that array.

         */
        int[][] arr = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 1},
                {1, 0, 1}
        };

        Set<Integer> unique = new HashSet<>();
        int row = arr.length, col = arr[0].length;

        for (int i = 0; i < row; i++) {
            int num = 0;
            for (int j = 0; j < col; j++) {
                num += (Math.pow(2, j)) * (arr[i][j] & (1));
            }
            boolean isUnique = unique.add(num);
            if (isUnique) {
                System.out.println(Arrays.toString(arr[i]));
            }
        }
    }

    @Description("Problem 3")
    public static void longestContinuousArray() {
        int[] arr = {1, 3, 10, 7, 9, 2, 4, 6};
        arr = sort(arr);

        int st = 0, end = 0, tempSt = 0, tempEnd = 0;
        int i = 1;
        while (i < arr.length) {
            if (arr[i] - 1 == arr[i - 1]) {
                tempEnd++;
            } else {
                if (tempEnd - tempSt + 1 > end - st + 1) {
                    st = tempSt;
                    end = tempEnd;
                }
                tempSt = i;
                tempEnd = i;
            }
            i++;
        }

        for (i = st; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int n = arr.length / 2;
        int[] arr1 = sort(Arrays.copyOfRange(arr, 0, n));
        int[] arr2 = sort(Arrays.copyOfRange(arr, n, arr.length));

        return merge(arr1, arr2);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] res = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                res[k] = arr1[i];
                i++;
            } else {
                res[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            res[k] = arr1[i];
            k++;
            i++;
        }

        while (j < arr2.length) {
            res[k] = arr2[j];
            k++;
            j++;
        }

        return res;
    }


    @Description("Problem 4")
    public static void findMaxNumFormed() {
        /*
            Thought Process :
            =================
            1. Find all the list which can form 3 digit number.
            2. Find all the permutation for every list.
            3. Pick the maximum one.
         */
        int[] arr = {1, 4, 89, 73, 9, 7};
        int digit = 5;

        List<List<Integer>> all3DigitList = getAll3DigitList(new ArrayList<>(), arr, digit);
        System.out.println("All possibles : ");
        List<Integer> allPossibleNumbers = new ArrayList<>();
        all3DigitList.forEach(el -> {
            List<Integer> list = findAllPermutation(new ArrayList(), el);
            allPossibleNumbers.addAll(list);
        });
        // all3DigitList.forEach(System.out::print);
        System.out.println(allPossibleNumbers);
        System.out.println("Maximum value : " + (allPossibleNumbers.stream().max(Comparator.naturalOrder())).get());

    }

    public static List<List<Integer>> getAll3DigitList(List<Integer> p, int[] up, int digit) {
        if(up.length == 0) {
            List<List<Integer>> list = new ArrayList<>();
            if(isNDigitList(p, digit)) {
                list.add(p);
            }
            return list;
        }

        int n = up[0];

        List<List<Integer>> left = getAll3DigitList(p, Arrays.copyOfRange(up, 1, up.length), digit);
        p = new ArrayList<>(p);
        p.add(n);
        List<List<Integer>> right = getAll3DigitList(p, Arrays.copyOfRange(up, 1, up.length), digit);

        left.addAll(right);
        return left;
    }

    public static List<Integer> findAllPermutation(List<Integer> p, List<Integer> up) {
        if(up.size() == 0) {
            int n = getListAsInt(p);
            List<Integer> list = new ArrayList<>();
            list.add(n);
            return list;
        }

        int top = up.get(0);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= p.size(); i++) {
            List<Integer> inner = new ArrayList<>();
            for(int j = 0; j < i; j++) {
                inner.add(p.get(j));
            }
            inner.add(top);
            for(int j = i; j < p.size(); j++) {
                inner.add(p.get(j));
            }
            list.addAll(findAllPermutation(inner, up.subList(1, up.size())));
        }

        return list;
    }

    public static boolean isNDigitList(List<Integer> list, int digit) {
        String str = "";
        for(int i : list) {
            str += "" + i;
        }
        return str.length() == digit;
    }

    public static int getListAsInt(List<Integer> list) {
        String str = "";
        for(int i : list) {
            str += "" + i;
        }
        return Integer.parseInt(str);
    }
}