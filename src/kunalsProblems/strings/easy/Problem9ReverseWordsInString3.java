package kunalsProblems.strings.easy;

public class Problem9ReverseWordsInString3 {

    /*
        LeetCode No : 557, Problem Link : https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
     */

    public String reverseWordsOptimal(String s) {

        char[] c = s.toCharArray();

        int st = 0, end = 0;
        while (end <= c.length) {
            if (end == c.length || c[end] == ' ') {
                reverse(c, st, end - 1);
                st = end + 1;
            }
            end++;
        }

        return new String(c);

    }

    private void reverse(char[] arr, int st, int end) {
        while (st < end) {
            char temp = arr[end];
            arr[end--] = arr[st];
            arr[st++] = temp;
        }
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            sb.append(new StringBuilder(words[i]).reverse());
            if (i != words.length - 1) sb.append(" ");
        }

        return sb.toString();
    }

}
