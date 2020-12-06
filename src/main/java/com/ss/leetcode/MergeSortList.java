package com.ss.leetcode;

import java.util.LinkedList;
import java.util.List;

public class MergeSortList {
    public List<Integer> mergeArrays(List<Integer> list1, List<Integer> list2) {
        List<Integer> resultList = new LinkedList<>();
        mergeSort(list1, list2, resultList);
        return resultList;
    }

    private void mergeSort(List<Integer> list1, List<Integer> list2, List<Integer> resultList) {
        int i = 0;
        int j = 0;
        boolean finishedLoopOne = false;
        boolean finishedLoopTwo = false;
        int loopOneIndex, loopTwoIndex;
        while (resultList.size() < list1.size() + list2.size()) {
            while (i < list1.size() && !finishedLoopOne) {
                loopTwoIndex = finishedLoopTwo ? list2.size() -1 : j;
                if(finishedLoopTwo) {
                    resultList.add(list1.get(i));
                    i++;
                } else
                if (list1.get(i) <= list2.get(loopTwoIndex)) {
                    resultList.add(list1.get(i));
                    if (i + 1 == list1.size()) {
                        finishedLoopOne = true;
                        break;
                    } else {
                        i++;
                    }
                } else {
                    break;
                }
            }
            while (j < list2.size() && !finishedLoopTwo) {
                loopOneIndex = finishedLoopOne ? list1.size() -1 : i;
                if(finishedLoopOne) {
                    resultList.add(list2.get(j));
                    j++;
                } else
                if (list2.get(j) < list1.get(loopOneIndex)) {
                    resultList.add(list2.get(j));
                    if (j + 1 == list2.size()) {
                        finishedLoopTwo = true;
                        break;
                    } else {
                        j++;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
