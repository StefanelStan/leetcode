package com.ss.leetcode.LC2024.august;

import java.util.ArrayList;
import java.util.List;

public class OnlineElection {
    /** Algorithm
        1. Times[] is sorted in ASC. From the perspective, traversing it in this order can help you determine who had the max votes at each time.
        2. Use a class VotingStatus(time, person) and an array of it to hold the statuses for each time[i].
        3. Traverse time and keep track of max votes / person[i]. Set the Votingstatus for that time[i]
        4. For each query, apply binary search and find the time in the list of voting statuses.
     */
    private final List<VotingStatus> votes;

    public OnlineElection(int[] persons, int[] times) {
        votes = getVotes(persons, times);
    }

    public int q(int t) {
        int index = binarySearch(t);
        return votes.get(index).bestCandidate;
    }

    private int binarySearch(int target) {
        int low = 0, high = votes.size() - 1;
        int pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (target == votes.get(pivot).time) {
                return pivot;
            } else if (target > votes.get(pivot).time) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low - 1;
    }

    private List<VotingStatus> getVotes(int[] persons, int[] time) {
        List<VotingStatus> votingStatuses = new ArrayList<>();
        int[] votingCount = new int[persons.length];
        int maxVotes = 0, lastMaxPerson = 0;
        votingCount[persons[0]]++;
        if (votingCount[persons[0]] >= maxVotes) {
            maxVotes = votingCount[persons[0]];
            lastMaxPerson = persons[0];
        }
        for (int i = 1; i < time.length; i++) {
            if (time[i] != time[i-1]) {
                votingStatuses.add(new VotingStatus(time[i-1], lastMaxPerson));
            }
            votingCount[persons[i]]++;
            if (votingCount[persons[i]] >= maxVotes) {
                maxVotes = votingCount[persons[i]];
                lastMaxPerson = persons[i];
            }
        }
        votingStatuses.add(new VotingStatus(time[time.length - 1], lastMaxPerson));
        return votingStatuses;
    }

    private record VotingStatus(int time, int bestCandidate) {}
}
