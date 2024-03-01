package com.ss.leetcode.LC2024;

import com.ss.leetcode.LC2024.february.AdditiveNumber;
import com.ss.leetcode.LC2024.february.AverageWaitingTime;
import com.ss.leetcode.LC2024.february.CountElementsWithMaximumFrequency;
import com.ss.leetcode.LC2024.february.CountGoodTriplets;
import com.ss.leetcode.LC2024.february.CountSubIslands;
import com.ss.leetcode.LC2024.february.CountVowelSubstringsOfAString;
import com.ss.leetcode.LC2024.february.DivideArrayIntoArraysWithMaxDifference;
import com.ss.leetcode.LC2024.february.FindAllPeopleWithSecret;
import com.ss.leetcode.LC2024.february.FindAndReplaceInString;
import com.ss.leetcode.LC2024.february.FindPolygonWithTheLargestPerimeter;
import com.ss.leetcode.LC2024.february.FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance;
import com.ss.leetcode.LC2024.february.FindTheLengthOfTheLongestCommonPrefix;
import com.ss.leetcode.LC2024.february.GreatestCommonDivisorTraversal;
import com.ss.leetcode.LC2024.february.InsertDeleteGetRandomO1DuplicatesAllowed;
import com.ss.leetcode.LC2024.february.LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit;
import com.ss.leetcode.LC2024.february.MaximumConsecutiveFloorsWithoutSpecialFloors;
import com.ss.leetcode.LC2024.february.MaximumSumOfAlmostUniqueSubarray;
import com.ss.leetcode.LC2024.february.MeetingRoomsIII;
import com.ss.leetcode.LC2024.february.MinimizeHammingDistanceAfterSwapOperations;
import com.ss.leetcode.LC2024.february.MinimumWindowSubstring;
import com.ss.leetcode.LC2024.february.NumberOfSubarraysWithBoundedMaximum;
import com.ss.leetcode.LC2024.february.PartitionArrayForMaximumSum;
import com.ss.leetcode.LC2024.february.WaysToMakeAFairArray;
import java.util.Arrays;
import java.util.List;

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
//        start.countSubIslands();
//        start.minimizeHammingDistanceAfterSwapOperations();
//        start.findTheLengthOfTheLongestCommonPrefix();
//        start.findAllPeopleWithSecret();
//        start.greatestCommonDivisorTraversal();
//        start.longestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();
        start.findAndReplaceInString();
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

    public void minimizeHammingDistanceAfterSwapOperations() {
        MinimizeHammingDistanceAfterSwapOperations mhdaso = new MinimizeHammingDistanceAfterSwapOperations();

        System.out.println("1 == " + mhdaso.minimumHammingDistance(new int[]{1,2,3,4}, new int[]{2,1,4,5}, new int[][]{{0,1},{2,3}}));
        System.out.println("2 == " + mhdaso.minimumHammingDistance(new int[]{1,2,3,4}, new int[]{1,3,2,4}, new int[0][0]));
        System.out.println("0 == " + mhdaso.minimumHammingDistance(new int[]{5,1,2,4,3}, new int[]{1,5,4,2,3}, new int[][]{{0,4},{4,2},{1,3},{1,4}}));
    }

    public void findTheLengthOfTheLongestCommonPrefix() {
        FindTheLengthOfTheLongestCommonPrefix ftlotlcp = new FindTheLengthOfTheLongestCommonPrefix();

        System.out.println("3 == " + ftlotlcp.longestCommonPrefix(new int[]{1,10,100}, new int[]{1000}));
        System.out.println("0 == " + ftlotlcp.longestCommonPrefix(new int[]{1,2,3}, new int[]{4,4,4}));
    }

    public void findAllPeopleWithSecret() {
        FindAllPeopleWithSecret fapws = new FindAllPeopleWithSecret();

        System.out.println("[0,1,2,3,5] == " + fapws.findAllPeople(6, new int[][]{{1,2,5},{2,3,8},{1,5,10}}, 1));
        System.out.println("[0,1,3] == " + fapws.findAllPeople(6, new int[][]{{3,1,3},{1,2,2},{0,3,3}}, 3));
        System.out.println("[0,1,2,3,4] == " + fapws.findAllPeople(5, new int[][]{{3,4,2},{1,2,1},{2,3,1}}, 1));
        System.out.println("[0,3,12,17,24,28,37,38,42,43,45,46,48,51,52,53,55,56,62,63,68,69,77,81,83,87,88,93,95,96,98,100,101,105,111,115,117,121,126,129,133,134,135,145,148,152,153,158,162,166,170,172,174,178,180,186,188,189,194,198] == "
            + fapws.findAllPeople(199, new int[][]{{38,56,716},{4,176,731},{70,11,751},{75,107,744},{81,152,718},{35,171,749},{186,126,734},{55,17,749},{125,150,709},{63,80,716},{100,38,711},{152,135,715},{129,111,754},{170,24,714},{196,104,740},{117,172,713},{150,181,708},{99,183,739},{150,99,712},{25,103,737},{69,121,748},{178,170,713},{105,68,733},{79,176,717},{79,119,723},{28,198,749},{63,166,753},{72,71,745},{115,186,718},{51,42,727},{126,37,756},{93,56,707},{120,76,731},{56,0,706},{80,113,713},{0,145,752},{51,81,735},{71,81,716},{175,147,739},{20,94,722},{152,56,708},{115,45,706},{178,166,720},{152,111,748},{68,119,729},{77,87,741},{87,17,735},{153,93,711},{172,134,729},{198,105,748},{186,87,726},{174,172,718},{93,117,709},{95,93,708},{100,3,708},{96,125,710},{29,76,739},{180,68,745},{101,100,729},{76,158,732},{117,88,712},{43,179,745},{179,189,719},{121,45,706},{115,188,743},{174,148,729},{83,105,740},{48,52,739},{170,38,712},{119,36,745},{194,178,716},{32,193,737},{63,168,721},{184,43,728},{98,93,750},{43,170,750},{0,53,749},{42,152,712},{95,148,722},{75,71,723},{46,166,722},{73,20,746},{99,31,718},{158,68,736},{12,189,727},{81,133,756},{95,48,710},{162,48,720},{113,68,730},{121,3,706},{158,174,735},{181,116,720},{133,11,711},{152,0,710},{80,71,723},{168,113,754},{121,56,706},{194,148,736},{121,101,745},{105,45,707},{24,96,740},{81,12,722},{12,62,736},{57,72,730}}, 53));
    }

    public void greatestCommonDivisorTraversal() {
        GreatestCommonDivisorTraversal gcdt = new GreatestCommonDivisorTraversal();

        System.out.println("true == " + gcdt.canTraverseAllPairs(new int[]{2,3,6}));
        System.out.println("false == " + gcdt.canTraverseAllPairs(new int[]{3,5,9}));
        System.out.println("true == " + gcdt.canTraverseAllPairs(new int[]{4,3,12,8}));
    }

    public void longestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit() {
        LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit lcswadltoetl = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();

        System.out.println("2 == " + lcswadltoetl.longestSubarray(new int[]{8,2,4,7}, 4));
        System.out.println("4 == " + lcswadltoetl.longestSubarray(new int[]{10,1,2,4,7,2}, 5));
        System.out.println("3 == " + lcswadltoetl.longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0));
    }

    public void findAndReplaceInString() {
        FindAndReplaceInString faris = new FindAndReplaceInString();

        System.out.println("eeebffff == " + faris.findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee","ffff"}));
        System.out.println("eeecd == " + faris.findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee","ffff"}));
        System.out.println("asasaeeeeeooo == " + faris.findReplaceString("aaa", new int[]{0,1,2}, new String[]{"a","b","a"}, new String[]{"asas","uuu","eeeeeooo"}));
    }
}
