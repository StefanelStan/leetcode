package com.ss.leetcode.LC2021.september;

import java.util.List;

public class KeysAndRooms {
    // https://leetcode.com/problems/keys-and-rooms/
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] existingKeys = new boolean[rooms.size()];
        boolean[] visitedRooms = new boolean[rooms.size()];
        existingKeys[0] = true;
        for (int i = 0; i < rooms.size(); i++) {
            if (!visitedRooms[i] && existingKeys[i]) {
                visitedRooms[i] = true;
                for (int key : rooms.get(i)) {
                    openDoor(visitedRooms, existingKeys, rooms, key);
                }
            }
        }
        for (boolean visited : visitedRooms) {
            if (!visited) {
                return false;
            }
        }
        return true;
    }

    private void openDoor(boolean[] visitedRooms, boolean[] existingKeys, List<List<Integer>> rooms, int key) {
        if (!visitedRooms[key]) {
            visitedRooms[key] = true;
            existingKeys[key] = true;
            for (int existingKey : rooms.get(key)) {
                openDoor(visitedRooms, existingKeys, rooms, existingKey);
            }
        }
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        boolean[] existingKeys = new boolean[rooms.size()];
        boolean[] visitedRooms = new boolean[rooms.size()];
        existingKeys[0] = true;
        boolean stillHasToVisit = true;
        while (stillHasToVisit) {
            stillHasToVisit = false;
            for (int i = 0; i < rooms.size(); i++) {
                if (!visitedRooms[i] && existingKeys[i]) {
                    visitedRooms[i] = true;
                    stillHasToVisit = true;
                    for (int key : rooms.get(i)) {
                        existingKeys[key] = true;
                    }
                }
            }
        }
        boolean answer = true;
        for (boolean visited : visitedRooms) {
            answer &= visited;
        }
        return answer;
    }
}
