package com.ss.leetcode.LC2022.april;

import java.util.ArrayList;
import java.util.List;

public class TimeNeededToInformAllEmployees {
    // https://leetcode.com/problems/time-needed-to-inform-all-employees/
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Integer[] responseTime = new Integer[n];
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            if (informTime[i] == 0) {
                maxTime = Math.max(maxTime, getInformTimeOfEmployee(manager, informTime, responseTime, i));
            }
        }
        return maxTime;
    }

    private int getInformTimeOfEmployee(int[] manager, int[] informTime, Integer[] responseTime, int i) {
        if (i == -1) {
            return 0;
        }
        if (responseTime[i] == null) {
            responseTime[i] = informTime[i] + getInformTimeOfEmployee(manager, informTime, responseTime, manager[i]);
        }
        return responseTime[i];
    }


    public int numOfMinutes2(int n, int headID, int[] manager, int[] informTime) {
        int numOfMinutes;
        if (informTime.length == 1) {
            numOfMinutes = informTime[0];
        } else if (informTime.length == 2) {
            numOfMinutes = informTime[0] + informTime[1];
        } else {
            numOfMinutes = getNumOfMinutes(n, headID, manager, informTime);
        }
        return numOfMinutes;
    }

    private int getNumOfMinutes(int n, int headId, int[] managers, int[] informTimes) {
        List[] managedPeople = getManagedPeople(n, headId, managers);
        int[] maxInformTime = {Integer.MIN_VALUE};
        traverseTree(headId, informTimes[headId], managedPeople, informTimes, maxInformTime);
        return maxInformTime[0];
    }

    private List[] getManagedPeople(int n, int headId, int[] managers) {
        List[] managedPeople = new List[n];
        for (int i = 0; i < managers.length; i++) {
            if (managers[i] != -1) {
                if (managedPeople[managers[i]] == null) {
                    managedPeople[managers[i]] = new ArrayList<>();
                }
                managedPeople[managers[i]].add(i);
            }
        }
        return managedPeople;
    }

    private void traverseTree(int boss, int carriedTime, List[] managedPeople, int[] informTimes, int[] maxInformTime) {
        if (managedPeople[boss] == null) {
            maxInformTime[0] = Math.max(maxInformTime[0], carriedTime);
            return;
        }
        List<Integer> people = managedPeople[boss];
        for (int managed : people) {
            traverseTree(managed, carriedTime + informTimes[managed], managedPeople, informTimes, maxInformTime);
        }
    }
}
