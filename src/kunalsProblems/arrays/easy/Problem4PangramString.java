package kunalsProblems.arrays.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem4PangramString {
    public static void main(String[] args) {
        String str = "thequickbrownfoxjumpsoverthelazydog";

        checkIfPangramSolution1(str);
        checkIfPanrgramSolution2(str);
    }

    public static boolean checkIfPangramSolution1(String sentence) {
        int[] arr = new int[26];
        for(char c : sentence.toCharArray()) {
            arr[c - 'a']++;
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfPanrgramSolution2(String sentence) {
        Set<Character> set = new HashSet<>();
        for(char c : sentence.toCharArray()) {
            set.add(c);
        }
        return set.size() == 26;
    }
}
