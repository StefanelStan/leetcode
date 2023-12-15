package com.ss.leetcode.LC2021.march;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DestinationCity {
    // https://leetcode.com/problems/destination-city/
    public String destCity(List<List<String>> paths) {
        Set<String> from = new HashSet<>();
        Set<String> to = new HashSet<>();
        for (List<String> path : paths) {
            from.add(path.get(0));
            to.add(path.get(1));
        }
        for (String destination : to) {
            if (!from.contains(destination)) {
                return destination;
            }
        }
        return "";
    }

    public String destCity2(List<List<String>> paths) {
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
