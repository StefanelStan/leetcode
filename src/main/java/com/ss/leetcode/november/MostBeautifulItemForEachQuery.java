package com.ss.leetcode.november;

import com.ss.leetcode.shared.TreeNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MostBeautifulItemForEachQuery {
    // https://leetcode.com/contest/biweekly-contest-65/problems/most-beautiful-item-for-each-query/
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(i -> i[0]));
        TreeMap<Integer, Integer> princeBeauty = new TreeMap<>();
        int maxBeauty = 0;
        for (int[] item : items) {
            maxBeauty = Math.max(maxBeauty, item[1]);
            princeBeauty.put(item[0], maxBeauty);
        }

        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            results[i] = getMaxBeautyOf(queries[i], princeBeauty);
        }
        return results;
    }

    private int getMaxBeautyOf(int price, TreeMap<Integer, Integer> priceBeauty) {
        Map.Entry<Integer, Integer> entry = priceBeauty.floorEntry(price);
        if (entry != null) {
            return entry.getValue();
        }
        return 0;
    }
}
