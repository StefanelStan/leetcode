package com.ss.leetcode.august;

import java.util.Arrays;
import java.util.LinkedList;

public class NextGreaterElementI {
    // https://leetcode.com/problems/next-greater-element-i/

    /**
     * Algorithm: calculate nextGreaterElement for the entire num2 in one go and NOT for each nr from num1 as this will be redundant
     * Rather than using hashmaps<value, index> use int[10001]. Store the position of each element of under the key: eg: [6,3,8] => int[6] = 0, int[3]=1, int[8]=2 etc.
     * Calculate the nextGreaterElement for nums2 and store it in such structure. Thus, when referring from num1, simply nextGE[4]  will have the answer.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterElements = new int[10001]; //store the values of nextGreaterElements for each value of nums2
        Arrays.fill(nextGreaterElements, -1);
        LinkedList<Integer> higherElements = new LinkedList<>(); // use it as a stack
        findNextGreaterElements(nums2, nextGreaterElements, higherElements);

        return getNextGreaterElements(nums1, nextGreaterElements);
    }

    private int[] getNextGreaterElements(int[] nums1, int[] nextGreaterElements) {
        int[] answer = new int[nums1.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = nextGreaterElements[nums1[i]];
        }
        return answer;
    }

    private void findNextGreaterElements(int[] nums2, int[] nextGreaterElements, LinkedList<Integer> higherElements) {
        for (int i = 0; i < nums2.length -1; i++) {
            if (nums2[i] < nums2[i + 1]) {
                nextGreaterElements[nums2[i]] = nums2[i + 1];
                // check if this new element is also higher than anything in the queue
                if (!higherElements.isEmpty()) {
                    searchForLowerElementsInQueue(nextGreaterElements, nums2[i+1], higherElements);
                }
            } else {
                higherElements.add(nums2[i]);
            }
        }
    }

    private void searchForLowerElementsInQueue(int[] nextGreaterElements, int currentHigh, LinkedList<Integer> higherElements) {
        while(!higherElements.isEmpty()) {
            Integer lastFromQueue =  higherElements.peekLast();
            if (currentHigh > lastFromQueue) {
                nextGreaterElements[lastFromQueue] = currentHigh;
                higherElements.pollLast();
            } else {
                break;
            }
        }
    }
}
