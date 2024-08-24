package practice;

import java.util.List;
import java.util.ArrayList;

public class ArrayPermutation {

        public static void main(String[] args) {
            ArrayPermutation ap = new ArrayPermutation();
            List<List<Integer>> list = ap.permute(new int[] {1, 2, 3});
            System.out.println(list);
        }
        public List<List<Integer>> permute(int[] nums) {
            return permutation(new ArrayList<Integer>(), nums, 0, nums.length);
        }

        private static List<List<Integer>> permutation(List<Integer> p, int[] up, int st, int end) {
            System.out.println("Start : " + st + " -> End : " + end);
            if(st >= end) {
                List<List<Integer>> list = new ArrayList<>();
                list.add(p);
                return list;
            }

            int c = up[st];
            List<List<Integer>> outer = new ArrayList<>();
            for(int i = 0; i <= p.size(); i++) {
                List<Integer> inner = new ArrayList<>();
                for(int j = 0; j < i; j++) {
                    inner.add(p.get(j));
                }
                inner.add(c);
                for(int j = i; j < p.size(); j++) {
                    inner.add(p.get(j));
                }
                List<List<Integer>> list = permutation(inner, up, st + 1, end);
                outer.addAll(list);
            }

            return outer;
        }
}
