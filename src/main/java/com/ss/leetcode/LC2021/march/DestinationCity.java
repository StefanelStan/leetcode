package com.ss.leetcode.LC2021.march;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity {
    // https://leetcode.com/problems/destination-city/
    public String destCity(List<List<String>> paths) {
        final Map<String, Integer> cityMap = new HashMap<>();
        paths.forEach(path -> {
            cityMap.merge(path.get(0), 2, Integer::sum);
            cityMap.merge(path.get(1), 1, Integer::sum);
        });

        for(Map.Entry<String, Integer> entry: cityMap.entrySet()) {
            if (entry.getValue() ==1 ) {
                return entry.getKey();
            }
        }
        return null;
    }
}
