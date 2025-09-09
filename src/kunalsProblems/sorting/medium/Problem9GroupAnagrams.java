package kunalsProblems.sorting.medium;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem9GroupAnagrams {
    /*
        LeetCode No : 49, Problem Link : https://leetcode.com/problems/group-anagrams/description/

        Youtube Link : https://youtu.be/tqIpulXFjSA?si=cJ5t60yjQY5q7oUV

        NOTE : In this problem, we use BigInteger instead of long/int. Because, Leetcode's test cases overflow for int/long. Hence, we used BigInteger.

        INTUITION BEHIND USING PRIMES :
        ===============================
        # Because, a number 'x' is obtained only by multiplying prime numbers 'a', 'b' and 'c'.
        # 'x' cannot be obtained by multiplying other prime numbers.

        * Every integer greater than 1 has a unique prime factorization — it can be written as a product of prime numbers in one and only one way (ignoring order).
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};

        Map<BigInteger, List<String>> map = new HashMap<>();

        for (String str : strs) {
            BigInteger prod = BigInteger.ONE;  // use long to avoid overflow
            for (char c : str.toCharArray()) {
                prod = prod.multiply(BigInteger.valueOf(primes[c - 'a']));
            }

            if (!map.containsKey(prod)) {
                map.put(prod, new ArrayList<>());
            }
            map.get(prod).add(str);
        }

        List<List<String>> list = new ArrayList<>();
        for(List<String> innerList : map.values()) {
            list.add(innerList);
        }

        return list;
    }
}
