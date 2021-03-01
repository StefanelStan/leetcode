package com.ss.leetcode.march;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalTraverseII {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if(nums.size() == 1) {
            return toArray(nums.get(0));
        }

        Map<Integer, List<Integer>> elements = new TreeMap<>();
        putElementsIntoDiagonals(nums, elements);
        List<Integer> orderedDiagonalElements = orderElements(elements);
        return toArray(orderedDiagonalElements);
    }

    // pay attention as we have to add the elements into a reverse order
    private List<Integer> orderElements(Map<Integer, List<Integer>> elements) {
        List<Integer> orderedElements = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> entry : elements.entrySet()) {
            ListIterator<Integer> li = entry.getValue().listIterator(entry.getValue().size());
            while(li.hasPrevious()) {
                orderedElements.add(li.previous());
            }
        }
        return orderedElements;
    }

    private void putElementsIntoDiagonals(List<List<Integer>> nums, Map<Integer, List<Integer>> elements) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                List<Integer> element = elements.get(i + j);
                if (element == null) {
                    element = new LinkedList<>();
                    element.add(nums.get(i).get(j));
                    elements.put(i + j, element);
                } else {
                    element.add(nums.get(i).get(j));
                }
            }
        }
    }

    private int[] toArray(List<Integer> integers) {
        final int[] nums = new int[integers.size()];
        int i = 0;
        for (Integer integer : integers) {
            nums[i++] = integer;
        }
        return nums;
    }

    /** Too slow
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
         if(nums.size() == 1) {
             return toArray(nums.get(0));
         }
         List<Integer> diagonal = new LinkedList<>();
         for (int i = 0;; i++) {
             if(!addDiagonalToList(i, nums, diagonal)) {
                 break;
             }
         }
         return toArray(diagonal);
    }

    private boolean addDiagonalToList(int diagNo, List<List<Integer>> nums, List<Integer> diagonals) {
        boolean added = false;
        for (int i = diagNo, col = 0; i >= 0; i--, col++) {
            if (i < nums.size() && nums.get(i).size() > col) {
                diagonals.add(nums.get(i).get(col));
                added = true;
            }
        }
        return added;
    }


    too slow */
}
