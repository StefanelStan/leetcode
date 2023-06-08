package com.ss.leetcode.LC2023.june;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFloodInTheCity {
    // https://leetcode.com/problems/avoid-flood-in-the-city
    /** Algorithm
        1. Keep track of the full lakes in a Map<Integer, Integer>: lake and index
        2. Also keep track of the days with 0 rains to know their index (treeset)
        3. If a dry day, add it to treeset
        4. If rainy day, add it to map. (and set answer[i] = -1)
            - If the entry (lake and index) was already there, it means the lake was full.
            Look inside the treeset of days to dry for a day with index >= entry lake.
            If a day past that lake full day is found, then dry the lake so that it can be filled now.
            (answer[entry.value]= current_day)
            If no such day is present (eg: all dry days were before that day), we cannot dry that lake.
            Return []
        5. Populate answer[] with 1 for the rest of dry days from the tree set.
     */
    public int[] avoidFlood(int[] rains) {
        int[] answer =  new int[rains.length];
        Map<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> daysToDry = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                daysToDry.add(i);
            } else {
                answer[i] = -1;
                Integer index = fullLakes.put(rains[i], i);
                if (index != null) {
                    if (daysToDry.isEmpty()) {
                        return new int[0];
                    }
                    Integer nextDayToDry = daysToDry.ceiling(index);
                    if (nextDayToDry == null) {
                        return new int[0];
                    } else {
                        daysToDry.remove(nextDayToDry);
                        answer[nextDayToDry] = rains[i];
                    }
                }
            }
        }
        daysToDry.forEach(entry -> answer[entry] = 1);
        return answer;
    }
}
