package com.ss.leetcode.LC2024.january;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation {
    /** Algorithm
        1. Use a Map<Integer, boolean[]> to make the taken seats of each taken row
        2. Each unused row will have room for 2 families. 2 * (n - map.size()).
        3. Try to determine how many familes fit on an used row
            - check LEFT side: if !used[2,3,4,5] , families ++
            - check RIGHT side:if !used[6,7,8,9], families ++
            - check MIDDLE only if no left/right was found if(families == 0 !used[4,5,6,7]) families++;
        4. Return total families
     */
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int numberOfFamilies = 0;
        Map<Integer, boolean[]> rows = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            rows.computeIfAbsent(reservedSeat[0], k -> new boolean[11])[reservedSeat[1]] = true;
        }
        numberOfFamilies += 2 * (n - rows.size());
        for (boolean[] usedSeats : rows.values()) {
            numberOfFamilies += findFreeRows(usedSeats);
        }
        return numberOfFamilies;
    }

    private int findFreeRows(boolean[] taken) {
        int families = 0;
        if (!taken[2] && !taken[3] && !taken[4] && !taken[5]) {
            families++;
        }
        if (!taken[6] && !taken[7] && !taken[8] && !taken[9]) {
            families++;
        }
        if (families == 0 && !taken[4] && !taken[5] && !taken[6] && !taken[7]) {
            families++;
        }
        return families;
    }

    public int maxNumberOfFamilies2(int n, int[][] reservedSeats) {
        int numberOfFamilies = 0;
        Arrays.sort(reservedSeats, (a,b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int[] lastOccupied = {1,0};
        if (reservedSeats[0][0] > 1) {
            numberOfFamilies += 2 * (reservedSeats[0][0] - 1);
            lastOccupied[0] = reservedSeats[0][0];
        }
        for (int[] reservedSeat : reservedSeats) {
            if (reservedSeat[0] > lastOccupied[0]) {
                numberOfFamilies += 2 * (reservedSeat[0] - lastOccupied[0] - 1);
                numberOfFamilies += (lastOccupied[1] == 1 ? 2 : lastOccupied[1] < 6 ? 1 : 0);
                lastOccupied[1] = 0;
            }
            numberOfFamilies += determineAvailableSeats(reservedSeat[1], lastOccupied[1]);
            lastOccupied = reservedSeat;
        }
        numberOfFamilies += (lastOccupied[1] == 1 ? 2 : lastOccupied[1] < 6 ? 1 : 0);
        numberOfFamilies += 2 * (n - lastOccupied[0]);
        return numberOfFamilies;
    }

    private int determineAvailableSeats(int lastReserved, int lastOccupied) {
        if (lastReserved <= 5) {
            return 0;
        } else if (lastReserved <= 7) {
            return lastOccupied <= 1 ? 1 : 0;
        } else if (lastReserved <= 9) {
            return lastOccupied <= 3 ? 1 : 0;
        } else if (lastReserved == 10) {
            return lastOccupied <= 1 ? 2 : lastOccupied <= 5 ? 1 : 0;
        }
        return 0;
    }
}
