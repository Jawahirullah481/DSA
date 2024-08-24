package prevproblems;

import jdk.jfr.Description;

public class Set27 {
    public static void main(String[] args) {
        // Problem 1
        extraElement();

        // Problem 2
        checkIfSubString();
    }

    public static void extraElement() {
        /*
            Extra element :
            ===============

            Input : [ 10, 20, 30, 12, 5 ]
            [ 10, 5, 30, 20 ]
            Output : 12 is the extra element in array 1 at index 4

            Input : [ -1, 0, 3, 2 ]
            [ 3, 4, 0, -1, 2 ]
            Output : 4 is the extra element in array 3 at index 5

         */
        int[] arr1 = {-1, 0, 3, 2};
        int[] arr2 = {3, 4, 0, -1, 2};

        int length = Math.min(arr1.length, arr2.length);
        int i = 0;
        int k = 0;

        while(i < length) {
            k = k ^ arr1[i];
            k = k ^ arr2[i];
            i++;
        }

        if(i == arr1.length) {
            k = k ^ arr2[i];
        } else {
            k = k ^ arr1[i];
        }

        // Until above we found the extra element. now we find index
        int extraIndex = -1;
        String arrayName = "";
        if(arr1.length > arr2.length) {
            arrayName = "Array 1";
            for(i = 0; i < arr1.length; i++) {
                if(arr1[i] == k) {
                    extraIndex = i;
                    break;
                }
            }
        } else {
            arrayName = "Array 2";
            for(i = 0; i < arr2.length; i++) {
                if(arr2[i] == k) {
                    extraIndex = i;
                    break;
                }
            }
        }

        System.out.println(k + " is the extra element in " + arrayName + " at index " + extraIndex);
    }

    @Description("Problem 2")
    public static void checkIfSubString() {
        String str1 = "Subline";
        String str2 = "*line";

        str2 = str2.replaceAll("\\*", ".*");
        if(str1.matches(str2) || str1.contains(str2)) {
            System.out.println("Is substring : " + true);
        } else {
            System.out.println("Is substring : " + false);
        }
    }
}
