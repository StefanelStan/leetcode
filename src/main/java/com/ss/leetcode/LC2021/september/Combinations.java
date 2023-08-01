package com.ss.leetcode.LC2021.september;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    // https://leetcode.com/problems/combinations/
    /** Algorithm
        1. Supposing you need to make lists of 3 numbers with the first n = 10.
            Some of these lists will be like [1,9,10], others like [3,9,10].
        2. We observe the tail is repetitive. Why not caching the combinations that are possible by
            index y with length l.
        3. Use an List<List<Integer>> cache [n+1][k] that will store the possible combinations
            done by index i (1..n) of length j (0..k-1).
        4. The helper method will receive current/starting index (1), n, current length (0..k-1), k and cache
        5. If cache is null, you need to generate the combinations of index by given length
        6. If length == k-1, you can only add this index or skip it. You cannot add and continue building
        7. If length < k-1, you still have 2 spaces: so you can add current index and pass the remaining
            length+1 and index + 1 to next combination. Combining current index with what else can be build
        8. If current index allows you to skip current index (eg: you are at index 8/10 and list length is 7 out of 9. You cannot skip it as you won't have enough numbers to add to make the list of length 9.),
            then skip the index and fetch the list can be build by index+1, length +1.
        9. Add the two lists (addIt, skipIt) to the list of combinations possible at cache[index][length]
        10. Return cache[1][0]: all combinations possible starting with index 1 and that have a length of
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>[][] cache = new List[n+1][k];
        combine(1, n, 0, k, cache);
        return cache[1][0];
    }

    private List<List<Integer>> combine(int index, int n, int length, int k, List<List<Integer>>[][] cache) {
        if (cache[index][length] == null) {
            List<List<Integer>> combinations = new ArrayList<>();
            if (length == k - 1) {
                combinations.add(List.of(index));
            }
            if (length < k - 1) {
                List<List<Integer>> addIt = combine(index + 1, n, length + 1, k, cache);
                for (List<Integer> answer : addIt) {
                    List<Integer> comb = new ArrayList<>(1 + answer.size());
                    comb.add(index);
                    comb.addAll(answer);
                    combinations.add(comb);
                }
            }
            if (n - index >= k - length) {
                List<List<Integer>> skipIt = combine(index + 1, n, length, k, cache);
                combinations.addAll(skipIt);
            }
            cache[index][length] = combinations;
        }
        return cache[index][length];
    }


    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> combinations = new LinkedList<>();
        generateCombinations(combinations, new ArrayList<>(), 1, n, k);
        return combinations;
    }

    private void generateCombinations(List<List<Integer>> combinations, ArrayList<Integer> integers, int i, int n, int k) {
        if (integers.size() == k) {
            combinations.add(new ArrayList<>(integers));
            return;
        }
        for (int j = i; j <= n; j++) {
            integers.add(j);
            generateCombinations(combinations, integers, j + 1, n, k);
            integers.remove(integers.size() - 1);
        }
    }
}
