package com.ss.leetcode.LC2024.february;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsIII {
    // https://leetcode.com/problems/meeting-rooms-iii
    /** Algorithm
        1. If n == 1 return 0, as 1 single room exists
        2. Sort the meeting be start time
        3. Each of the n rooms will have an available time. Initially, all rooms are available
        4. When a room gets booked, it's available time will be increased by end + start time.
            - If the last room was available at time 10 and a new booking [24, 36], then that room
            will next be available at time 36.
            - If next available room is at moment 50, then this room will be booked till moment 62 (50 + 36 - 24)
        5. Use a long[] nextAvailable to flag when the room will be availablew next
        6. Loop with i from, 0 to n and find next available room. If found (available[i] <= start),
            use that room and increase the next available slot
        7. If no available room is found, then find the smallest next available spot and increment that
     */
    public int mostBooked(int n, int[][] meetings) {
        if (n == 1) {
            return 0;
        }
        int[] usedRooms = getUsedRooms(n, meetings);
        int busiestRoom = 0, busiestRoomIndex = 0;
        for (int i = 0; i < usedRooms.length; i++) {
            if (usedRooms[i] > busiestRoom) {
                busiestRoom = usedRooms[i];
                busiestRoomIndex = i;
            }
        }
        return busiestRoomIndex;
    }

    private int[] getUsedRooms(int n, int[][] meetings) {
        int[] usedRooms = new int[n];
        long[] nextAvailable = new long[n];
        Arrays.sort(meetings, Comparator.comparingInt(m -> m[0]));
        for (int[] meeting : meetings) {
            scheduleMeeting(meeting[0], meeting[1], usedRooms, nextAvailable);
        }
        return usedRooms;
    }

    private void scheduleMeeting(int start, int end, int[] usedRooms, long[] nextAvailable) {
        long earliestAvailable = Long.MAX_VALUE;
        int earliestAvailableIndex = -1;
        for (int i = 0; i < nextAvailable.length; i++) {
            if (nextAvailable[i] <= start) {
                nextAvailable[i] = end;
                usedRooms[i]++;
                return;
            } else if(nextAvailable[i] < earliestAvailable) {
                earliestAvailable = nextAvailable[i];
                earliestAvailableIndex = i;
            }
        }
        nextAvailable[earliestAvailableIndex] += (end - start);
        usedRooms[earliestAvailableIndex]++;
    }
}
