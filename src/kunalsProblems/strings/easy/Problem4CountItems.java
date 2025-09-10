package kunalsProblems.strings.easy;

import java.util.List;
import java.util.Map;

public class Problem4CountItems {
    /*
        LeetCode No : 1773, Problem Link : https://leetcode.com/problems/count-items-matching-a-rule/

        NOTE : See the solution for clean code.
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> map = Map.of(
                "type", 0,
                "color", 1,
                "name", 2
        );

        int validItems = 0;

        int index = map.get(ruleKey);
        for(List<String> item : items) {
            if(item.get(index).equals(ruleValue)) {
                validItems++;
            }
        }

        return validItems;
    }

    public int countMatchesStreamVersion(List<List<String>> items, String ruleKey, String ruleValue) {
        return (int) items.stream().filter(item -> {
            return (ruleKey.equals("type") && item.get(0).equals(ruleValue))
                    || (ruleKey.equals("color") && item.get(1).equals(ruleValue))
                    || (ruleKey.equals("name") && item.get(2).equals(ruleValue));
        }).count();
    }
}
