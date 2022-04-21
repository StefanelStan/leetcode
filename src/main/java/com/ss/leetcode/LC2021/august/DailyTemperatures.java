package com.ss.leetcode.LC2021.august;

import java.util.LinkedList;

public class DailyTemperatures {
    // https://leetcode.com/problems/daily-temperatures/
    // Aka NextGreaterElement
    public int[] dailyTemperatures(int[] temperatures) {
        int[] dailyTemperatures = new int[temperatures.length];
        LinkedList<Integer> biggerTemps = new LinkedList<>();
        int temp;
        for (int i = 0; i < temperatures.length -1; i++) {
            if(temperatures[i] < temperatures[i + 1]) {
                dailyTemperatures[i] = 1;
                while(!biggerTemps.isEmpty() && temperatures[biggerTemps.peekLast()] < temperatures[i+1]) {
                    temp = biggerTemps.pollLast();
                    dailyTemperatures[temp] = i + 1 - temp;
                }
            } else {
                biggerTemps.add(i);
            }
        }
        return dailyTemperatures;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int[] waiting = new int[temperatures.length];
        waiting[waiting.length -1] = 0;
        LinkedList<int[]> highers = new LinkedList<>(); // int[0] - store temp value, int[1] - store index
        for (int i = 0; i < temperatures.length -1 ; i++) {
            // if current temp is lower than next one, happy path, we put 1 in waiting periods.
            // If next temp is LOWER than current one, than current one is to be macthed against a future higher one. We save it into a linked list/stack
            if (temperatures[i] < temperatures[i + 1]) {
                waiting[i] = 1;
                // if next one is higher, let's check in the queue for any other high temps that could be lower than this high one i + 1
                if (!highers.isEmpty()) {
                    checkForOtherHigherTemperatures(temperatures[i + 1], i + 1, waiting, highers);
                }
            } else { //if next temp is lower than current one, then add current one to the list so we can check in the future for higher temps.
                highers.add(new int[]{temperatures[i], i});
            }
        }
        return waiting;
    }

    private void checkForOtherHigherTemperatures(int temperature, int i, int[] waiting, LinkedList<int[]> highers) {
        int[] currentHighTemp;
        // verify if the given temp is higher than any of the temps in the list
        while (!highers.isEmpty()) {
            currentHighTemp = highers.peekLast();
            if (currentHighTemp[0] < temperature) {
                // if given temp is higher than the last one from list/queue, remove it from list AND update the waiting index: i - temp[1];
                waiting[currentHighTemp[1]] = i - currentHighTemp[1];
                highers.pollLast();
            } else {
                break;
            }
        }
    }
}
