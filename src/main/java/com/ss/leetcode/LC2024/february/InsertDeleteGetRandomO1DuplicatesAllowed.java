package com.ss.leetcode.LC2024.february;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomO1DuplicatesAllowed {
    // https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed
    /** Algorithm
        1. Use a List<Integer> to store the number. a Random object will pick a random position and return it
        2. Use a Map<Integer, Set<Integer>> to map the positions of each number
        3. Insert
            - Add the number to the list
            - If number is not present in map, create and insert a new HashSet. Add the listSize -1 to this set,
            as the number has been added to the end of the list
        4. Random - return a random from list
        5. Remove
            - if number is not present in map, return false
            - pick the first element from the positionsSet from Map<Int, Set<Int>>.
            - if this position == list.size - 1, just delete it from set and from list
            - if it's different, then swap last element from list with this element and update the positions set inside map
     */
    private final List<Integer> numbers;
    private final Map<Integer, Set<Integer>> numPos;
    private final Random rand;
    public InsertDeleteGetRandomO1DuplicatesAllowed() {
        numbers = new ArrayList<>();
        numPos = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        Set<Integer> positions = numPos.computeIfAbsent(val, k -> new HashSet<>());
        positions.add(numbers.size());
        numbers.add(val);
        return positions.size() == 1;
    }

    public boolean remove(int val) {
        Set<Integer> positions = numPos.get(val);
        if (positions != null) {
            int positionToDelete = positions.iterator().next();
            if (positionToDelete != numbers.size() - 1) {
                // make swap and update
                Set<Integer> lastElementPos = numPos.get(numbers.get(numbers.size() - 1));
                positions.remove(positionToDelete);
                lastElementPos.remove(numbers.size() -1);
                lastElementPos.add(positionToDelete);
                numbers.set(positionToDelete, numbers.get(numbers.size() -1));
            } else {
                positions.remove(positionToDelete);
            }
            if (positions.isEmpty()) {
                numPos.remove(val);
            }
            numbers.remove(numbers.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return numbers.get(rand.nextInt(numbers.size()));
    }
}
