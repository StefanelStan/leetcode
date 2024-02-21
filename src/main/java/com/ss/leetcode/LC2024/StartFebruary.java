package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.february.AdditiveNumber;
import com.ss.leetcode.LC2024.february.AverageWaitingTime;
import com.ss.leetcode.LC2024.february.CountElementsWithMaximumFrequency;
import com.ss.leetcode.LC2024.february.CountGoodTriplets;
import com.ss.leetcode.LC2024.february.CountSubIslands;
import com.ss.leetcode.LC2024.february.CountVowelSubstringsOfAString;
import com.ss.leetcode.LC2024.february.DivideArrayIntoArraysWithMaxDifference;
import com.ss.leetcode.LC2024.february.FindPolygonWithTheLargestPerimeter;
import com.ss.leetcode.LC2024.february.FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance;
import com.ss.leetcode.LC2024.february.InsertDeleteGetRandomO1DuplicatesAllowed;
import com.ss.leetcode.LC2024.february.MaximumConsecutiveFloorsWithoutSpecialFloors;
import com.ss.leetcode.LC2024.february.MaximumSumOfAlmostUniqueSubarray;
import com.ss.leetcode.LC2024.february.MeetingRoomsIII;
import com.ss.leetcode.LC2024.february.MinimumWindowSubstring;
import com.ss.leetcode.LC2024.february.NumberOfSubarraysWithBoundedMaximum;
import com.ss.leetcode.LC2024.february.PartitionArrayForMaximumSum;
import com.ss.leetcode.LC2024.february.WaysToMakeAFairArray;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StartFebruary {
    public static void main(String[] args) {
        StartFebruary start = new StartFebruary();

//        start.divideArrayIntoArraysWithMaxDifference();
//        start.maximumConsecutiveFloorsWithoutSpecialFloors();
//        start.countVowelSubstringsOfAString();
//        start.partitionArrayForMaximumSum();
//        start.additiveNumber();
//        start.insertDeleteGetRandomO1DuplicatesAllowed();
//        start.minimumWindowSubstring();
//        start.numberOfSubarraysWithBoundedMaximum();
//        start.countElementsWithMaximumFrequency();
//        start.waysToMakeAFairArray();
//        start.countGoodTriplets();
//        start.maximumSumOfAlmostUniqueSubarray();
//        start.averageWaitingTime();
//        start.findPolygonWithTheLargestPerimeter();
//        start.findTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance();
//        start.meetingRoomsIII();
        start.countSubIslands();
    }

    public void divideArrayIntoArraysWithMaxDifference() {
        DivideArrayIntoArraysWithMaxDifference daiawmd = new DivideArrayIntoArraysWithMaxDifference();

        System.out.println("[[1,1,3],[3,4,5],[7,8,9]] == " + Arrays.deepToString(daiawmd.divideArray(new int[]{1,3,4,8,7,9,3,5,1}, 2)));
        System.out.println("[] == " + Arrays.deepToString(daiawmd.divideArray(new int[]{1,3,3,2,7,3}, 3)));
    }

    public void maximumConsecutiveFloorsWithoutSpecialFloors() {
        MaximumConsecutiveFloorsWithoutSpecialFloors mcfwsf = new MaximumConsecutiveFloorsWithoutSpecialFloors();

        System.out.println("3 == " + mcfwsf.maxConsecutive(2, 2, new int[]{4,6}));
        System.out.println("0 == " + mcfwsf.maxConsecutive(6, 8, new int[]{7,6,8}));
    }

    public void countVowelSubstringsOfAString() {
        CountVowelSubstringsOfAString cvsoas = new CountVowelSubstringsOfAString();

        System.out.println("2 == " + cvsoas.countVowelSubstrings("aeiouu"));
        System.out.println("0 == " + cvsoas.countVowelSubstrings("unicornarihan"));
        System.out.println("7 == " + cvsoas.countVowelSubstrings("cuaieuouac"));
    }

    public void partitionArrayForMaximumSum() {
        PartitionArrayForMaximumSum pafms = new PartitionArrayForMaximumSum();
        System.out.println("84 == " + pafms.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
        System.out.println("83 == " + pafms.maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));
        System.out.println("1 == " + pafms.maxSumAfterPartitioning(new int[]{1}, 1));
    }

    public void additiveNumber() {
        AdditiveNumber an = new AdditiveNumber();
        System.out.println("true == " + an.isAdditiveNumber("112358"));
        System.out.println("false == " + an.isAdditiveNumber("00123"));
        System.out.println("true == " + an.isAdditiveNumber("0000000000000"));
        System.out.println("false == " + an.isAdditiveNumber("0"));
        System.out.println("false == " + an.isAdditiveNumber("1023"));
        System.out.println("true == " + an.isAdditiveNumber("101"));
        System.out.println("true == " + an.isAdditiveNumber("101"));
        System.out.println("true == " + an.isAdditiveNumber("011235"));
        System.out.println("false == " + an.isAdditiveNumber("0235813"));
    }

    public void insertDeleteGetRandomO1DuplicatesAllowed() {
        InsertDeleteGetRandomO1DuplicatesAllowed idgro1da = new InsertDeleteGetRandomO1DuplicatesAllowed();

        System.out.println("true == " + idgro1da.insert(1));
        System.out.println("false == " + idgro1da.remove(2));
        System.out.println("true == " + idgro1da.insert(2));
        System.out.println("1/2 == " + idgro1da.getRandom());
        System.out.println("true == " + idgro1da.remove(1));
        System.out.println("false == " + idgro1da.insert(2));
        System.out.println("2 == " + idgro1da.getRandom());

        idgro1da = new InsertDeleteGetRandomO1DuplicatesAllowed();

        System.out.println("true == " + idgro1da.insert(4));
        System.out.println("true == " + idgro1da.insert(3));
        System.out.println("false == " + idgro1da.insert(4));
        System.out.println("true == " + idgro1da.insert(2));
        System.out.println("false == " + idgro1da.insert(4));
        System.out.println("true == " + idgro1da.remove(4));
        System.out.println("true == " + idgro1da.remove(3));
        System.out.println("true == " + idgro1da.remove(4));
        System.out.println("true == " + idgro1da.remove(4));

        idgro1da = new InsertDeleteGetRandomO1DuplicatesAllowed();

        System.out.println("true == " + idgro1da.insert(0));
        System.out.println("true == " + idgro1da.remove(0));
        System.out.println("true == " + idgro1da.insert(-1));
        System.out.println("false == " + idgro1da.remove(0));
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());
        System.out.println("-1 == " + idgro1da.getRandom());


    }

    public void minimumWindowSubstring() {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();

        System.out.println("BANC == " + mws.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("a == " + mws.minWindow("a", "a"));
        System.out.println(" == " + mws.minWindow("a", "aa"));
    }

    public void numberOfSubarraysWithBoundedMaximum() {
        NumberOfSubarraysWithBoundedMaximum noswbm = new NumberOfSubarraysWithBoundedMaximum();

        System.out.println("3 = " + noswbm.numSubarrayBoundedMax(new int[]{2,1,4,3}, 2, 3));
        System.out.println("7 = " + noswbm.numSubarrayBoundedMax(new int[]{2,9,2,5,6}, 2, 8));
        System.out.println("414 = " + noswbm.numSubarrayBoundedMax(new int[]{3,2,4,5,6,7,8,7,6,5,4,3,23,1,2,3,4,5,6,7,6,5,4,3,2,1,2,3,4,5,6,7,6,5,4,3,2,1,32,4,5,6,7,6,5,4,3,2}, 4, 14));
        System.out.println("1 = " + noswbm.numSubarrayBoundedMax(new int[]{2}, 0, 10));
    }

    public void countElementsWithMaximumFrequency() {
        CountElementsWithMaximumFrequency cewmf = new CountElementsWithMaximumFrequency();

        System.out.println("4 == " + cewmf.maxFrequencyElements(new int[]{1,2,2,3,1,4}));
        System.out.println("5 == " + cewmf.maxFrequencyElements(new int[]{1,2,3,4,5}));
        System.out.println("4 == " + cewmf.maxFrequencyElements(new int[]{1,2,3,4,5,6,7,8,7,6,5,6,7,6,5,4,3,2,1}));
        System.out.println("1 == " + cewmf.maxFrequencyElements(new int[]{1}));
        System.out.println("3 == " + cewmf.maxFrequencyElements(new int[]{1,1,1}));
        System.out.println("2 == " + cewmf.maxFrequencyElements(new int[]{1,2,3,4,1}));
    }

    public void waysToMakeAFairArray() {
        WaysToMakeAFairArray wtmafa = new WaysToMakeAFairArray();

        System.out.println("1 == " + wtmafa.waysToMakeFair(new int[]{2,1,6,4}));
        System.out.println("3 == " + wtmafa.waysToMakeFair(new int[]{1,1,1}));
        System.out.println("0 == " + wtmafa.waysToMakeFair(new int[]{1,2,3}));
        System.out.println("0 == " + wtmafa.waysToMakeFair(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}));
        System.out.println("23 == " + wtmafa.waysToMakeFair(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}));
        System.out.println("1 == " + wtmafa.waysToMakeFair(new int[]{1}));
    }

    public void countGoodTriplets() {
        CountGoodTriplets cgt = new CountGoodTriplets();

        System.out.println("4 ==" + cgt.countGoodTriplets(new int[]{3,0,1,1,9,7}, 7,2,3));
        System.out.println("0 ==" + cgt.countGoodTriplets(new int[]{1,1,2,2,3}, 0, 0, 1));
    }

    public void maximumSumOfAlmostUniqueSubarray() {
        MaximumSumOfAlmostUniqueSubarray msoaus = new MaximumSumOfAlmostUniqueSubarray();

        System.out.println("18 == " + msoaus.maxSum(List.of(2,6,7,3,1,7), 3, 4));
        System.out.println("23 == " + msoaus.maxSum(List.of(5,9,9,2,4,5,4), 1, 3));
        System.out.println("0 == " + msoaus.maxSum(List.of(1,2,1,2,1,2,1), 3, 3));
    }

    public void averageWaitingTime() {
        AverageWaitingTime awt = new AverageWaitingTime();

        System.out.println("5.0 == " + awt.averageWaitingTime(new int[][]{{1,2},{2,5},{4,3}}));
        System.out.println("3.25 == " + awt.averageWaitingTime(new int[][]{{5,2},{5,4},{10,3},{20,1}}));
    }

    public void findPolygonWithTheLargestPerimeter() {
        FindPolygonWithTheLargestPerimeter fpwtlp = new FindPolygonWithTheLargestPerimeter();

        System.out.println("15 == " + fpwtlp.largestPerimeter(new int[]{5,5,5}));
        System.out.println("12 == " + fpwtlp.largestPerimeter(new int[]{1,12,1,2,5,50,3}));
        System.out.println("-1 == " + fpwtlp.largestPerimeter(new int[]{5,5,50}));
        System.out.println("21 == " + fpwtlp.largestPerimeter(new int[]{1,2,3,4,5,6}));
        System.out.println("-1 == " + fpwtlp.largestPerimeter(new int[]{1,4,10}));
        System.out.println("17876942274 == " + fpwtlp.largestPerimeter(new int[]{300005055,352368231,311935527,315829776,327065463,388851949,319541150,397875604,311309167,391897750,366860048,359976490,325522439,390648914,359891976,369105322,350430086,398592583,354559219,372400239,344759294,379931363,308829137,335032174,336962933,380797651,378305476,336617902,393487098,301391791,394314232,387440261,316040738,388074503,396614889,331609633,374723367,380418460,349845809,318514711,308782485,308291996,375362898,397542455,397628325,392446446,368662132,378781533,372327607,378737987}));
    }

    public void findTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance() {
        FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance ftcwtsnonaatd = new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance();

        System.out.println("3 == " + ftcwtsnonaatd.findTheCity(4, new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}}, 4));
        System.out.println("0 == " + ftcwtsnonaatd.findTheCity(5, new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2));
    }

    public void meetingRoomsIII() {
        MeetingRoomsIII mriii = new MeetingRoomsIII();

        System.out.println("0 == " + mriii.mostBooked(2, new int[][]{{0,10},{1,5},{2,7},{3,4}}));
        System.out.println("1 == " + mriii.mostBooked(3, new int[][]{{1,20},{2,10},{3,5},{4,9},{6,8}}));
        System.out.println("0 == " + mriii.mostBooked(2, new int[][]{{1,3243},{2,6754},{3,56553},{4,123456},{5,12321},{6,3215},{7,23146}}));
    }

    public void countSubIslands() {
        CountSubIslands csi = new CountSubIslands();

        System.out.println("3 == " + csi.countSubIslands(new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}}, new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}}));
        System.out.println("2 == " + csi.countSubIslands(new int[][]{{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}}, new int[][]{{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}}));
    }
}
