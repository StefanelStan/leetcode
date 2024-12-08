package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.december.BeautifulTowersI;
import com.ss.leetcode.LC2024.december.CountCompleteSubarraysInAnArray;
import com.ss.leetcode.LC2024.december.FindScoreOfAnArrayAfterMarkingAllElements;
import com.ss.leetcode.LC2024.december.LexicographicallySmallestStringAfterOperationsWithConstraint;
import com.ss.leetcode.LC2024.december.MinimizeMalwareSpread;
import com.ss.leetcode.LC2024.december.MinimumLimitOfBallsInABag;
import com.ss.leetcode.LC2024.december.ValidWord;
import java.util.Arrays;
import java.util.Comparator;

public class StartDecember {
    public static void main(String[] args) {
        StartDecember start = new StartDecember();

//        start.lexicographicallySmallestStringAfterOperationsWithConstraint();
//        start.beautifulTowersI();
//        start.validWord();
//        start.minimizeMalwareSpread();
//        start.countCompleteSubarraysInAnArray();
//        start.minimumLimitOfBallsInABag();
//        start.findScoreOfAnArrayAfterMarkingAllElements();
        System.out.println("165 == " + start.maxTwoEvents(new int[][]{{66,97,90},{98,98,68},{38,49,63},{91,100,42},{92,100,22},{1,77,50},{64,72,97}}));
    }

    public void lexicographicallySmallestStringAfterOperationsWithConstraint() {
        LexicographicallySmallestStringAfterOperationsWithConstraint lssaowc = new LexicographicallySmallestStringAfterOperationsWithConstraint();

        System.out.println("aaaz == " + lssaowc.getSmallestString("zbbz", 3));
        System.out.println("aawcd == " + lssaowc.getSmallestString("xaxcd", 4));
        System.out.println("lol == " + lssaowc.getSmallestString("lol", 0));
        System.out.println("aaaaaaaaaaaaaaaaaaaaajdsjdsds == " + lssaowc.getSmallestString("skhfadsfuhdskfdsfhsdfjdsjdsds", 124));
        System.out.println("aaaaaaaaaaaaa == " + lssaowc.getSmallestString("yhgffddsgfdgd", 74));
        System.out.println("addsguasuhisdhgfsdjf == " + lssaowc.getSmallestString("gldsguasuhisdhgfsdjf", 14));
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab == " + lssaowc.getSmallestString("dsfdhyjjghgfhgfhsgregtyjthgglierjf", 217));
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa == " + lssaowc.getSmallestString("fdgfdhgsregtrhrtsghtrghrrt", 631));
    }

    public void beautifulTowersI() {
        BeautifulTowersI bti = new BeautifulTowersI();

        System.out.println("13 == " + bti.maximumSumOfHeights(new int[]{5,3,4,1,1}));
        System.out.println("22 == " + bti.maximumSumOfHeights(new int[]{6,5,3,9,2,7}));
        System.out.println("18 == " + bti.maximumSumOfHeights(new int[]{3,2,5,5,2,3}));
    }

    public void validWord() {
        ValidWord vw = new ValidWord();

        System.out.println("true == " + vw.isValid("234Adas"));
        System.out.println("false == " + vw.isValid("b3"));
        System.out.println("false == " + vw.isValid("a3$e"));
    }

    public void minimizeMalwareSpread() {
        MinimizeMalwareSpread mms = new MinimizeMalwareSpread();

        System.out.println("0 == " + mms.minMalwareSpread(new int[][]{{1,1,0},{1,1,0},{0,0,1}}, new int[]{0,1}));
        System.out.println("0 == " + mms.minMalwareSpread(new int[][]{{1,0,0},{0,1,0},{0,0,1}}, new int[]{0,2}));
        System.out.println("1 == " + mms.minMalwareSpread(new int[][]{{1,1,1},{1,1,1},{1,1,1}}, new int[]{1,2}));
    }

    public void countCompleteSubarraysInAnArray() {
        CountCompleteSubarraysInAnArray ccsiaa = new CountCompleteSubarraysInAnArray();

        System.out.println("4 == " + ccsiaa.countCompleteSubarrays(new int[]{1,3,1,2,2}));
        System.out.println("10 == " + ccsiaa.countCompleteSubarrays(new int[]{5,5,5,5}));
    }

   public void minimumLimitOfBallsInABag() {
       MinimumLimitOfBallsInABag mlobiab = new MinimumLimitOfBallsInABag();

       System.out.println("3 == " + mlobiab.minimumSize(new int[]{9}, 2));
       System.out.println("2 == " + mlobiab.minimumSize(new int[]{2,4,8,2}, 4));
       System.out.println("4 == " + mlobiab.minimumSize(new int[]{5,4,3,3,4,5,6,7,8}, 7));
       System.out.println("6 == " + mlobiab.minimumSize(new int[]{5,4,3,3,4,5,6,7,8}, 2));
       System.out.println("3 == " + mlobiab.minimumSize(new int[]{5,4,3,3,4,5,6,7,8}, 12));
       System.out.println("8 == " + mlobiab.minimumSize(new int[]{7,6,5,56,6,7,8,9,7,6,5,4,3,2,3,5,67}, 16));
       System.out.println("12 == " + mlobiab.minimumSize(new int[]{7,6,5,56,6,7,8,9,7,6,5,4,3,2,3,5,67}, 9));
       System.out.println("10 == " + mlobiab.minimumSize(new int[]{7,6,5,56,6,7,8,9,7,6,5,4,3,2,3,5,67}, 11));
   }

   public void findScoreOfAnArrayAfterMarkingAllElements() {
       FindScoreOfAnArrayAfterMarkingAllElements fsoaaamae = new FindScoreOfAnArrayAfterMarkingAllElements();

       System.out.println("7 == " + fsoaaamae.findScore(new int[]{2,1,3,4,5,2}));
       System.out.println("5 == " + fsoaaamae.findScore(new int[]{2,3,5,1,3,2}));
   }

    public int maxTwoEvents(int[][] events) {
        int maxValue = 0;
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int[] bestValue = getBestValue(events);
        for (int i = 0; i < events.length; i++) {
            maxValue = Math.max(maxValue, events[i][2] + findNextBestEvent(events, bestValue, events[i][1] + 1, i + 1));
        }
        return maxValue;
    }

    private int findNextBestEvent(int[][] events, int[] bestValue, int target, int low) {
        int high = events.length -1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (events[pivot][0] >= target) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return low == events.length ? 0 : bestValue[low];
    }

    private int[] getBestValue(int[][] events) {
        int[] bestValue = new int[events.length];
        bestValue[bestValue.length - 1] = events[events.length -1][2];
        for (int i = bestValue.length - 2; i >= 0; i--) {
            bestValue[i] = Math.max(bestValue[i+1], events[i][2]);
        }
        return bestValue;
    }
}
