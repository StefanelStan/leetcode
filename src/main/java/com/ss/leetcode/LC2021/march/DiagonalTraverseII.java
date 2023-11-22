package com.ss.leetcode.LC2021.march;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalTraverseII {
    // https://leetcode.com/problems/diagonal-traverse-ii
    /** Algorithm - EG: [1,2,3],[4,5,6],[7,8,9]]
        1. Looking at the given diagram, we observe that the 1st element of the 1st line is part of the 1st diagonal.
            - The 2nd element of 1st line is part of 2nd diagonal..and so on
             - The 1st element of 2nd line is part of 2nd diagonal
        2. The rowIndex + colIndex gives you the diagonal number of which the cell belongs to
            - the element [0,1] - value = 2 belongs do diagonal 2
            - the element [1,0] - value = 4 belongs to diagonal 2.
        3. If we are to traverse each row and column, we observe that we can pull/ MAP the elements of each diagonal in REVERSE order.
        4. Traverse the rows one by one and use a List<List<Integer>> to put the elements at their correct index.
            - at the end, the List.get(1) will contain [2,4], List.get(2) will have (3,5,7)
        5. Traverse each list of this result in reverse order and put the numbers in answer[]
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int[] total = {0};
        List<List<Integer>> inverseTraversal = getInversalTraversal(nums, total);
        return getDiagonalOrder(inverseTraversal, total[0]);
    }

    private int[] getDiagonalOrder(List<List<Integer>> inverseTraversal, int total) {
        int[] diagonalOrder = new int[total];
        int insertIndex = 0;
        for (List<Integer> traversal : inverseTraversal) {
            for (int j = traversal.size() - 1; j >= 0; j--) {
                diagonalOrder[insertIndex++] = traversal.get(j);
            }
        }
        return diagonalOrder;
    }

    private List<List<Integer>> getInversalTraversal(List<List<Integer>> nums, int[] total) {
        List<List<Integer>> inverseTraversal = new ArrayList<>(nums.size());
        int rowIndex = 0;
        for (List<Integer> row : nums) {
            for (int j = 0; j < row.size(); j++) {
                if ((rowIndex + j) == inverseTraversal.size()) {
                    inverseTraversal.add(new ArrayList<>());
                }
                inverseTraversal.get(rowIndex + j).add(row.get(j));
                total[0]++;
            }
            rowIndex++;
        }
        return inverseTraversal;
    }



    public int[] findDiagonalOrder2(List<List<Integer>> nums) {
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
