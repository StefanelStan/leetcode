package com.ss.leetcode.LC2022.november;

public class StatisticsFromALargeSample {
    // https://leetcode.com/problems/statistics-from-a-large-sample
    /** Algorithm
         1. Traverse nums and keep track of min and max count, modeKey, number of elements and totalSum
         2. Format your answer by using the data gathered from this initial parse
         3. Median needs special attention: if nr of elements is odd, you need to find
            the nr/2+1 element, else nr/2 & nr/2 + 1 element
         4. Knowing what is the demand, retraverse the array start couting the elements so far.
            If your partial count reaches the targetCount (nr/2), then return current index OR
            go one step to the left and the next index that will make nr/2 + 1 element.
         5. Return all 5 pieces of data
     */
    public double[] sampleStats(int[] count) {
        int modeKey = 0, maxModeValue = -1;
        long totalSum = 0;
        int numberOfElements = 0;
        double min = -1;
        double max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                if (min == -1) {
                    min = i;
                }
                if (count[i] > maxModeValue) {
                    maxModeValue = count[i];
                    modeKey = i;
                }
                max = i;
                totalSum += (long)i * count[i];
                numberOfElements += count[i];
            }
        }
        return new double[]{min, max, totalSum/(double)numberOfElements, getMedian(numberOfElements, count), modeKey};
    }

    private double getMedian(int totalCount, int[] count) {
        if (totalCount % 2 == 1) {
            return getMedianOfOddElement(count, totalCount / 2 + 1);
        } else {
            return getMedianOfEvenElement(count, totalCount /2);
        }
    }

    private double getMedianOfOddElement(int[] count, int targetCount) {
        int countSoFar = 0;
        int median = -1;
        for (int i = 0; i < count.length; i++) {
            countSoFar += count[i];
            if (countSoFar >= targetCount) {
                median = i;
                break;
            }
        }
        return median;
    }

    private double getMedianOfEvenElement(int[] count, int targetCount) {
        double left = 0, right = 0;
        int countSoFar = 0;
        for (int i = 0; i < count.length; i++) {
            countSoFar += count[i];
            if (countSoFar >= targetCount + 1) {
                left = i;
                right = i;
                break;
            } else if (countSoFar == targetCount) {
                left = i;
                for (int k = i + 1; k < count.length; k++) {
                    if (count[k] != 0) {
                        right = k;
                        break;
                    }
                }
                break;
            }
        }
        return (left + right) / 2;
    }
}
