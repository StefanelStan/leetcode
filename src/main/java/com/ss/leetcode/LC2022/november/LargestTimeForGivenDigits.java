package com.ss.leetcode.LC2022.november;

public class LargestTimeForGivenDigits {
    // https://leetcode.com/problems/largest-time-for-given-digits
    /** Algorithm
        1. Count/map the digits in an int[10] to know how many 0s, 1s you have
        2. If you have more 2 numbers greater than 5, you cannot form any hour (eg: 0,6,6,6). Nothing can be formed
        3. If you have exactly 2 numbers greater than 6, you can try to find a smart combination by looking at
         this as two partitions: greater or lesser than 6: LMin, LMax, GMin, GMax
         - Look at the lesser than 6 partition: if the LMin is >=2, nothing can be formed (eg: 2,4,6,6)
         - if LMax is 1, you can build one it by LMax, GMax, LMin, GMin
            (eg: 7,9,0,1) -> seen as an orderd view : 0(LMin),1(LMax),7(GMin),9(GMax) ->  19:07
         - else is LMin, GMax, LMax, GMin
            eg: 6,7,0,2 -> 0,2],[6,7 -> 07:26
        4. Else try to build hours and minutes following the rule of AB:CD (A <=2 and B <4 or B<=9) and C <6 and D <= 9
     */
    public String largestTimeFromDigits(int[] arr) {
        int[] count = countDigits(arr);
        int countGreaterThanFive = countGreaterThan(count, 5);
        String largest = "";
        if (countGreaterThanFive == 2) {
            largest = getMixedDigits(count);
        } else if (countGreaterThanFive < 2) {
            largest = getOrderedDigits(count);
        }
        return largest;
    }

    private int[] countDigits(int[] nums) {
        int[] count = new int[10];
        for (int num : nums) {
            count[num]++;
        }
        return count;
    }

    private int countGreaterThan(int[] count, int from) {
        int total = 0;
        while(++from < count.length) {
            total += count[from];
        }
        return total;
    }

    private String getMixedDigits(int[] count) {
        // 2 are greater and 2 lesser
        int rightLow = getMaxFromCount(count, 5);
        int leftLow = getMaxFromCount(count, rightLow);
        if (leftLow >= 2) {
            return "";
        } else if (rightLow == 1) {
            return buildString(rightLow, getMaxFromCount(count, 9), leftLow, getMaxFromCount(count, 9));
        } else {
            return buildString(leftLow, getMaxFromCount(count, 9), rightLow, getMaxFromCount(count, 9));
        }
    }

    private String getOrderedDigits(int[] count) {
        StringBuilder largestTime = new StringBuilder(5);
        largestTime.append(getHours(count));
        largestTime.append(':');
        largestTime.append(getMinutes(count));
        return largestTime.length() == 5 ? largestTime.toString() : "";
    }

    private String getHours(int[] count) {
        int firstDigit = getMaxFromCount(count, 2);
        if (firstDigit == -1) {
            return "";
        }

        int secondDigit = firstDigit == 2 ? getMaxFromCount(count, 3) : getMaxFromCount(count, 9);
        if (secondDigit == -1) {
            return "";
        }
        char[] chrs = new char[2];
        chrs[0] = (char)(firstDigit + '0');
        chrs[1] = (char)(secondDigit + '0');
        return new String(chrs);
    }

    private String getMinutes(int[] count) {
        int firstDigit = getMaxFromCount(count, 5);
        if (firstDigit == -1) {
            return "";
        }
        int secondDigit = getMaxFromCount(count, 9);
        if (secondDigit == -1) {
            return "";
        }
        char[] chrs = new char[2];
        chrs[0] = (char)(firstDigit + '0');
        chrs[1] = (char)(secondDigit + '0');
        return new String(chrs);
    }

    private String buildString(int v1, int v2, int v3, int v4) {
        char[] chrs = new char[5];
        chrs[0] = (char)(v1 + '0');
        chrs[1] = (char)(v2 + '0');
        chrs[2] = ':';
        chrs[3] = (char)(v3 + '0');
        chrs[4] = (char)(v4 + '0');

        return new String(chrs);
    }

    private int getMaxFromCount(int[] count, int max) {
        while(max >= 0) {
            if (count[max] > 0) {
                count[max]--;
                break;
            }
            max--;
        }
        return max;
    }
}
