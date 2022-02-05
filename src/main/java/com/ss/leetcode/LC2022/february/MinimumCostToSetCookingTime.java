package com.ss.leetcode.LC2022.february;

public class MinimumCostToSetCookingTime {
    // https://leetcode.com/contest/biweekly-contest-71/problems/minimum-cost-to-set-cooking-time/
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        if (targetSeconds % 60 == 0) {
            int minutesCost = getCostOfAction(startAt, moveCost, pushCost, String.valueOf( targetSeconds / 60 ));
            int secondCost =  getCostOfAction(((targetSeconds / 60) % 10), moveCost, pushCost, "00");
            return minutesCost + secondCost;
        }

        if (targetSeconds < 60) {
            return getCostOfAction(startAt, moveCost, pushCost, String.valueOf(targetSeconds));
        }

        // minutes and seconds / 60
        int minWayOne = 0;
        minWayOne += getCostOfAction(startAt, moveCost, pushCost, String.valueOf(targetSeconds / 60));
        minWayOne += getCostOfAction( (targetSeconds / 60) % 10, moveCost, pushCost, getSecondAppend(targetSeconds % 60));
        int minWayTwo = Integer.MAX_VALUE;
        if ( targetSeconds % 60 < 39) {
            minWayTwo = 0;
            minWayTwo += minWayOne += getCostOfAction(startAt, moveCost, pushCost, String.valueOf(targetSeconds / 60));
        }

        return Math.min(minWayOne, minWayTwo);

    }

//    private int getMinutesCost(int startAt, int moveCost, int pushCost, int minutes) {
//        if (minutes < 10) {
//            return minutes == startAt ? pushCost : pushCost + moveCost;
//        } else {
//            char[] minDigits = String.valueOf(minutes).toCharArray();
//            if (minDigits[0] - '0' == startAt ? )
//        }
//    }

    private int getCostOfAction(int startPosition, int moveCost, int pushCost, String units) {
        if (units.length() < 2) {
            return Integer.parseInt(units) == startPosition ? pushCost : pushCost + moveCost;
        } else {
            int cost = 0;
            if (units.charAt(0) - '0' == startPosition) {
                cost += pushCost;
            } else {
                cost += pushCost + moveCost;
            }
            if (units.charAt(0) != units.charAt(1)) {
                cost += moveCost + pushCost;
            } else {
                cost += pushCost;
            }
            return cost;
        }
    }

    private String getSecondAppend(int seconds) {
        if (seconds < 10) {
            return  "0" + seconds;
        } else {
            return String.valueOf(seconds);
        }
    }
}
