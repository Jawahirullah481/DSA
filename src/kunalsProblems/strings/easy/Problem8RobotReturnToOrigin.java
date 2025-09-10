package kunalsProblems.strings.easy;

public class Problem8RobotReturnToOrigin {
    /*
        LeetCode No : 657, Problem Link : https://leetcode.com/problems/robot-return-to-origin/description/
     */

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') y++;
            else if (c == 'D') y--;
            else if (c == 'R') x++;
            else if (c == 'L') x--;
        }
        return x == 0 && y == 0;
    }

}
