package com.ss.leetcode.LC2024.february;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindAllPeopleWithSecret {
    // https://leetcode.com/problems/find-all-people-with-secret
    /** Algorithm
        1. Sort the meeting by start time. This will cause the meetings for each person to be sorted by default
        2. Create a class Discussion (with, time) to hold the discussions of each person
        3. Use a List<Discussion>[] array to gather/group all the discussion of each person
            - discussion[0] must first contain the discussion with firstPerson at time 0
        4. Use a int[] lastTalked to flag/mark the last time person[index] has talked.
        5. DFS:
            - start from person 0 and get all the chats of that person (discussions)
            - recursively, apply dfs for each person from the list of discussions
            - if the current person has been talked with earlier (lastTalked[p] <= time), then do not dfs it
            - else, apply dfs for current person
        6. As you will check the discussions of a person, apply binary search to jump only to the index of
            time discussion that you are interested in.
     */
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> allPeople = new ArrayList<>();
        Arrays.sort(meetings, Comparator.comparingInt(m -> m[2]));
        List<Discussion>[] discussions = getDiscussions(n, meetings);
        if (discussions[0] == null) {
            discussions[0] = new ArrayList<>();
        }
        discussions[0].add(0, new Discussion(firstPerson, 0));
        int[] lastTalked = new int[n];
        Arrays.fill(lastTalked, 100_001);
        findPeople(0, 0, discussions, lastTalked, allPeople);
        if (lastTalked[0] == 100_001) {
            allPeople.add(0);
        }
        Collections.sort(allPeople);
        return allPeople;
    }

    private void findPeople(int person, int fromTime, List<Discussion>[] discussions, int[] lastTalked, List<Integer> allPeople) {
        if (lastTalked[person] <= fromTime) {
            return;
        }
        if (lastTalked[person] == 100_001) {
            allPeople.add(person);
        }
        lastTalked[person] = fromTime;
        if (discussions[person] != null) {
            for (int index = getNextDiscussion(fromTime, discussions[person]); index < discussions[person].size(); index++) {
                findPeople(discussions[person].get(index).with, discussions[person].get(index).time, discussions, lastTalked, allPeople);
            }
        }
    }

    private int getNextDiscussion(int fromTime, List<Discussion> discussions) {
        int low = 0, high = discussions.size() - 1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (discussions.get(pivot).time >= fromTime) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return low;
    }

    private List<Discussion>[] getDiscussions(int n, int[][] meetings) {
        List<Discussion>[] discussions = new List[n];
        for (int[] meeting : meetings) {
            if (discussions[meeting[0]] == null) {
                discussions[meeting[0]] = new ArrayList<>();
            }
            if (discussions[meeting[1]] == null) {
                discussions[meeting[1]] = new ArrayList<>();
            }
            discussions[meeting[0]].add(new Discussion(meeting[1], meeting[2]));
            discussions[meeting[1]].add(new Discussion(meeting[0], meeting[2]));
        }
        return discussions;
    }

    private static class Discussion {
        int with;
        int time;
        public Discussion(int with, int time) {
            this.with = with;
            this.time = time;
        }
    }
}
