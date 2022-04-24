package com.ss.leetcode.LC2021.march;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class DesignUndergroundSystem {
    // https://leetcode.com/problems/design-underground-system/
    Destination[] checkins;
    Map<String, int[]> trips;
    public DesignUndergroundSystem() {
        checkins = new Destination[1_000_001];
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkins[id] = new Destination(stationName, t);
    }

    public void checkOut(int id, String stationName, int t) {
        int[] avgs = trips.computeIfAbsent(checkins[id].from + "-" + stationName, k -> new int[]{0,0});
        avgs[0]++;
        avgs[1] += (t - checkins[id].time);
        checkins[id] = null;
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] avgs = trips.get(startStation + "-" + endStation);
        return (double)(avgs[1])/avgs[0];
    }

    private static class Destination {
        String from;
        int time;
        public Destination(String from, int time) {
            this.from = from;
            this.time = time;
        }
    }

    private Map<String, int[]> checkIns;
    private LinkedList<CheckIn> entries;

    public void DesignUndergroundSystem2() {
        checkIns = new HashMap<>();
        entries = new LinkedList<>();
    }

    public void checkIn2(int id, String stationName, int t) {
        entries.add(new CheckIn(id, stationName, t));
    }

    public void checkOut2(int id, String stationName, int t) {
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

    public double getAverageTime2(String startStation, String endStation) {
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
