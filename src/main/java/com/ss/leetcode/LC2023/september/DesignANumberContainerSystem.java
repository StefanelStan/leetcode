package com.ss.leetcode.LC2023.september;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignANumberContainerSystem {
    // https://leetcode.com/problems/design-a-number-container-system
    /** Algorithm
        1. Use a Map<Index, Number> indexToNumber to map each index to each number
        2. Use a Map<Number, TreeSet<Indices>> numberIndices to map each number to its set of indices
        3. find(number)
            - if numberIndices contains the given number, return the first entry of the TreeSet
        4. change
            - Integer oldNumber = indexToNumber.put(index, number).
            - If indexToNumber DID contain another number at that index, then you have to remove that index
            from the set of indices:   numberIndices.get(oldNumber).remove(index).
            - Add the new index to map & TreeSet of numberIndices: numberIndices.get(number).add(index)
     */
    private final Map<Integer, Integer> indexToNumber;
    private final Map<Integer, TreeSet<Integer>> numberIndices;
    public DesignANumberContainerSystem() {
        indexToNumber = new HashMap<>();
        numberIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        Integer oldNumber = indexToNumber.put(index, number);
        if (oldNumber != null) {
            // remove from set
            TreeSet<Integer> oldNumberSet = numberIndices.get(oldNumber);
            if (oldNumberSet.size() == 1) {
                numberIndices.remove(oldNumber);
            } else {
                oldNumberSet.remove(index);
            }
        }
        // add to new index set
        numberIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        TreeSet<Integer> indices = numberIndices.get(number);
        if (indices != null) {
            return indices.first();
        }
        return -1;
    }
}
