package kunalsProblems.strings.easy;

public class Problem1DefangIPAddress {
    /*

        LeetCode No : 1108, Problem Link : https://leetcode.com/problems/defanging-an-ip-address/

        Refer : important_functions.md 6, 7, 8 functions

     */

    public String defangIPaddrOptimal(String address) {
        StringBuilder sb = new StringBuilder();

        for(char c : address.toCharArray()) {
            if(c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public String defangIPaddrBetter(String address) {
        return address.replace(".", "[.]");
    }
}
