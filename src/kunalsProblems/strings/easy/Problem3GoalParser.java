package kunalsProblems.strings.easy;

public class Problem3GoalParser {

    /*
        LeetCode No : 1678, Problem Link : https://leetcode.com/problems/goal-parser-interpretation/
     */

    public String interpretOptimal(String command) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < command.length(); ) {
            char c = command.charAt(i);

            if (c == 'G') {
                sb.append("G");
                i++;
            } else if (c == '(') {
                if (command.charAt(i + 1) == 'a') {   // "(al)"
                    sb.append("al");
                    i += 4;
                } else {                              // "()"
                    sb.append("o");
                    i += 2;
                }
            }
        }

        return sb.toString();
    }

    public String interpretShorter(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }


}
