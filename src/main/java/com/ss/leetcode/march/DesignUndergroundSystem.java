package com.ss.leetcode.march;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class DesignUndergroundSystem {
    private final Map<String, int[]> checkIns;
    private final LinkedList<CheckIn> entries;

    public DesignUndergroundSystem() {
        checkIns = new HashMap<>();
        entries = new LinkedList<>();
    }

    public void checkIn(int id, String stationName, int t) {
        entries.add(new CheckIn(id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Iterator<CheckIn> iterator = entries.descendingIterator();
        CheckIn c;
        while (iterator.hasNext()) {
            c = iterator.next();
            if (c.id == id) {
                String key = c.checkInStation + "-" + stationName;
                int[] times = checkIns.get(key);
                if (times == null) {
                    times = new int[] { t - c.checkInTime, 1 };
                    checkIns.put(key, times);
                } else {
                    times[0] += t - c.checkInTime;
                    times[1]++;
                }
                iterator.remove();
                break;
            }
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] records = checkIns.get(startStation + "-" + endStation);
        return (double) records[0] / records[1];
    }

    private static class CheckIn {
        private final int id;

        private int checkInTime = -1;
        private final String checkInStation;

        public CheckIn(int id, String stationName, int checkInTime) {
            this.id = id;
            this.checkInStation = stationName;
            this.checkInTime = checkInTime;
        }
    }
}
