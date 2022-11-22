package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.november.AlphabetBoardPath;
import com.ss.leetcode.LC2022.november.ApplyOperationsToAnArray;
import com.ss.leetcode.LC2022.november.CheckIfWordIsValidAfterSubstitutions;
import com.ss.leetcode.LC2022.november.ConvertTheTemperature;
import com.ss.leetcode.LC2022.november.CountServersThatCommunicate;
import com.ss.leetcode.LC2022.november.DistanceBetweenBusStops;
import com.ss.leetcode.LC2022.november.GetEqualSubstringsWithinBudget;
import com.ss.leetcode.LC2022.november.ImageSmoother;
import com.ss.leetcode.LC2022.november.LRUCache;
import com.ss.leetcode.LC2022.november.LargestPositiveIntegerThatExistsWithItsNegative;
import com.ss.leetcode.LC2022.november.LongestPalindromeByConcatenatingTwoLetterWords;
import com.ss.leetcode.LC2022.november.MakeTheStringGreat;
import com.ss.leetcode.LC2022.november.MaskingPersonalInformation;
import com.ss.leetcode.LC2022.november.MaxChunksToMakeSorted;
import com.ss.leetcode.LC2022.november.MaximumSumOfDistinctSubarraysWithLengthK;
import com.ss.leetcode.LC2022.november.MinimumGeneticMutation;
import com.ss.leetcode.LC2022.november.MinimumNumberOfOperationsToSortABinaryTreeByLevel;
import com.ss.leetcode.LC2022.november.NearestExitFromEntranceInMaze;
import com.ss.leetcode.LC2022.november.NumberOfDistinctAverages;
import com.ss.leetcode.LC2022.november.NumberOfValidClockTimes;
import com.ss.leetcode.LC2022.november.OnlineStockSpan;
import com.ss.leetcode.LC2022.november.RectangleArea;
import com.ss.leetcode.LC2022.november.ReplaceWords;
import com.ss.leetcode.LC2022.november.StatisticsFromALargeSample;
import com.ss.leetcode.LC2022.november.ThreeDivisors;
import com.ss.leetcode.LC2022.november.WalkingRobotSimulation;
import com.ss.leetcode.shared.TreeNode;
import java.util.Arrays;
import java.util.List;

public class StartNovember {
    public static void main(String[] args) {
        StartNovember start = new StartNovember();

//        start.largestPositiveIntegerThatExistsWithItsNegative();
//        start.minimumGeneticMutation();
//        start.longestPalindromeByConcatenatingTwoLetterWords();
//        start.imageSmoother();
//        start.maximumSumOfDistinctSubarraysWithLengthK();
//        start.makeTheStringGreat();
//        start.applyOperationsToAnArray();
//        start.stockSpan();
//        start.numberOfValidClockTimes();
//        start.numberOfDistinctAverages();
//        start.convertTheTemperature();
//        start.threeDivisors();
//        start.minimumNumberOfOperationsToSortABinaryTreeByLevel();
//        start.replaceWords();
//        start.maskingPersonalInformation();
//        start.rectangleArea();
//        start.walkingRobotSimulation();
//        start.checkIfWordIsValidAfterSubstitutions();
//        start.getEqualSubstringsWithinBudget();
//        start.LRUCache();
//        start.maxChunksToMakeSorted();
//        start.statisticsFromALargeSample();
//        start.nearestExitFromEntranceInMaze();
//        start.alphabetBoardPath();
//        start.countServersThatCommunicate();
        start.distanceBetweenBusStops();
    }

    public void largestPositiveIntegerThatExistsWithItsNegative() {
        LargestPositiveIntegerThatExistsWithItsNegative lpitewin = new LargestPositiveIntegerThatExistsWithItsNegative();

        System.out.println("3 == " + lpitewin.findMaxK(new int[]{-1,2,-3,3}));
        System.out.println("7 == " + lpitewin.findMaxK(new int[]{-1,10,6,7,-7,1}));
        System.out.println("-1 == " + lpitewin.findMaxK(new int[]{-10,8,6,7,-2,-3}));
    }

    public void minimumGeneticMutation() {
        MinimumGeneticMutation mgm = new MinimumGeneticMutation();

        System.out.println("1 == " + mgm.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println("2 == " + mgm.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
        System.out.println("3 == " + mgm.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"}));
        System.out.println("-1 == " + mgm.minMutation("AAAAAAAA", "CCCCCCCC", new String[]{"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA"}));
        System.out.println("4 == " + mgm.minMutation("AAAACCCC", "CCCCCCCC", new String[]{"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"}));
    }

    public void longestPalindromeByConcatenatingTwoLetterWords() {
        LongestPalindromeByConcatenatingTwoLetterWords lpbctlw = new LongestPalindromeByConcatenatingTwoLetterWords();

        System.out.println("6 == " + lpbctlw.longestPalindrome(new String[]{"lc","cl","gg"}));
        System.out.println("8 == " + lpbctlw.longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"}));
        System.out.println("2 == " + lpbctlw.longestPalindrome(new String[]{"cc","ll","xx"}));
        System.out.println("0 == " + lpbctlw.longestPalindrome(new String[]{"cu","lz","xa"}));
        System.out.println("22 == " + lpbctlw.longestPalindrome(new String[]{"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"}));
    }

    public void imageSmoother() {
        ImageSmoother is = new ImageSmoother();

        System.out.println("[[0,0,0],[0,0,0],[0,0,0]] == " + Arrays.deepToString(is.imageSmoother(new int[][]{{1,1,1},{1,0,1},{1,1,1}})));
        System.out.println("[[137,141,137],[141,138,141],[137,141,137]] == " + Arrays.deepToString(is.imageSmoother(new int[][]{{100,200,100},{200,50,200},{100,200,100}})));
        System.out.println("[[1]] == " + Arrays.deepToString(is.imageSmoother(new int[][]{{1}})));
    }

    public void maximumSumOfDistinctSubarraysWithLengthK() {
        MaximumSumOfDistinctSubarraysWithLengthK msaodswlk = new MaximumSumOfDistinctSubarraysWithLengthK();

        System.out.println("15 == " + msaodswlk.maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
        System.out.println("0 == " + msaodswlk.maximumSubarraySum(new int[]{4,4,4}, 3));
        System.out.println("0 == " + msaodswlk.maximumSubarraySum(new int[]{4}, 1));
        System.out.println("9 == " + msaodswlk.maximumSubarraySum(new int[]{4,5,5}, 2));
        System.out.println("0 == " + msaodswlk.maximumSubarraySum(new int[]{4,5,5,6}, 3));
        System.out.println("24 == " + msaodswlk.maximumSubarraySum(new int[]{1,1,1,7,8,9}, 3));
    }

    public void makeTheStringGreat() {
        MakeTheStringGreat mtsg = new MakeTheStringGreat();

        System.out.println("leetcode == " + mtsg.makeGood("leEeetcode"));
        System.out.println(" == " + mtsg.makeGood("abBAcC"));
        System.out.println("s == " + mtsg.makeGood("s"));
        System.out.println(" == " + mtsg.makeGood("pP"));
        System.out.println(" == " + mtsg.makeGood("Pp"));
    }

    public void applyOperationsToAnArray() {
        ApplyOperationsToAnArray aotaa = new ApplyOperationsToAnArray();

        System.out.println("[4,4,2,0] == " + Arrays.toString(aotaa.applyOperations(new int[]{4,2,2,2})));
        System.out.println("[1,0] == " + Arrays.toString(aotaa.applyOperations(new int[]{0,1})));
        System.out.println("[5,4,3,2,2,2,3,4,5,12,12,7,8,9,0,0,0,0,0] == " + Arrays.toString(aotaa.applyOperations(new int[]{5,4,3,2,1,1,2,3,4,5,6,6,6,6,7,8,9,0,0})));
        System.out.println("[2,0] == " + Arrays.toString(aotaa.applyOperations(new int[]{1,1})));
        System.out.println("[2,2,0,0] == " + Arrays.toString(aotaa.applyOperations(new int[]{1,1,1,1})));
        System.out.println("[2,4,0,0] == " + Arrays.toString(aotaa.applyOperations(new int[]{1,1,2,2})));
    }

    public void stockSpan() {
        OnlineStockSpan oss = new OnlineStockSpan();

        System.out.println("1 == " + oss.next(100));
        System.out.println("1 == " + oss.next(80));
        System.out.println("1 == " + oss.next(60));
        System.out.println("2 == " + oss.next(70));
        System.out.println("3 == " + oss.next(70));
        System.out.println("1 == " + oss.next(60));
        System.out.println("5 == " + oss.next(75));
        System.out.println("7 == " + oss.next(85));

        oss = new OnlineStockSpan();
        System.out.println("1 == " + oss.next(31));
        System.out.println("2 == " + oss.next(41));
        System.out.println("3 == " + oss.next(48));
        System.out.println("4 == " + oss.next(59));
        System.out.println("5 == " + oss.next(79));
    }

    public void numberOfValidClockTimes() {
        NumberOfValidClockTimes novct = new NumberOfValidClockTimes();

        System.out.println("2 == " + novct.countTime("?5:00"));
        System.out.println("100 == " + novct.countTime("0?:0?"));
        System.out.println("1440 == " + novct.countTime("??:??"));
    }

    public void numberOfDistinctAverages() {
        NumberOfDistinctAverages noda = new NumberOfDistinctAverages();

        System.out.println("2 == " + noda.distinctAverages(new int[]{4,1,4,0,3,5}));
        System.out.println("1 == " + noda.distinctAverages(new int[]{1,100}));
        System.out.println("10 == " + noda.distinctAverages(new int[]{4,1,7,3,1,7,23,54,23,15,23,11,11,11,11,11,22,33,44,55,66,0,8,7,6,5,4,3,2,1,2,3,4,5,6,7,8,9,4,0,3,5}));
    }

    public void convertTheTemperature() {
        ConvertTheTemperature ctt = new ConvertTheTemperature();

        System.out.println("[309.65000,97.70000] == " + Arrays.toString(ctt.convertTemperature(36.5)));
        System.out.println("[395.26000,251.79800] == " + Arrays.toString(ctt.convertTemperature(122.11)));
    }

    public void threeDivisors() {
        ThreeDivisors td = new ThreeDivisors();

        System.out.println("false == " + td.isThree(2));
        System.out.println("true == " + td.isThree(4));
        System.out.println("false == " + td.isThree(14));
    }

    public void minimumNumberOfOperationsToSortABinaryTreeByLevel() {
        MinimumNumberOfOperationsToSortABinaryTreeByLevel mnootsabtbl = new MinimumNumberOfOperationsToSortABinaryTreeByLevel();

        TreeNode root1 = new TreeNode(1,
            new TreeNode(4, new TreeNode(7), new TreeNode(6)),
            new TreeNode(3, new TreeNode(8, new TreeNode(9), null), new TreeNode(5, new TreeNode(10), null)));
        TreeNode root2 = new TreeNode(1, new TreeNode(3, new TreeNode(7), new TreeNode(6)), new TreeNode(2, new TreeNode(5), new TreeNode(4)));
        TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));

        System.out.println("3 == " + mnootsabtbl.minimumOperations(root1));
        System.out.println("3 == " + mnootsabtbl.minimumOperations(root2));
        System.out.println("0 == " + mnootsabtbl.minimumOperations(root3));
    }

    public void replaceWords() {
        ReplaceWords rw = new ReplaceWords();

        System.out.println("the cat was rat by the bat == " + rw.replaceWords(List.of("cat","bat","rat"), "the cattle was rattled by the battery"));
        System.out.println("a a b c == " + rw.replaceWords(List.of("a","b","c"), "aadsfasf absbs bbab cadsfafs"));
    }

    public void maskingPersonalInformation() {
        MaskingPersonalInformation mpi = new MaskingPersonalInformation();

        System.out.println("l*****e@leetcode.com == " + mpi.maskPII("LeetCode@LeetCode.com"));
        System.out.println("a*****b@qq.com == " + mpi.maskPII("AB@qq.com"));
        System.out.println("***-***-7890 == " + mpi.maskPII("1(234)567-890"));
        System.out.println("+***-***-***-7890 == " + mpi.maskPII("+141+(1)(234)567-890"));
    }

    public void rectangleArea() {
        RectangleArea ra = new RectangleArea();
        System.out.println("45 == " + ra.computeArea(-3,0,3,4,0,-1,9,2));
        System.out.println("16 == " + ra.computeArea(-2,-2,2,2,-2,-2,2,2));
    }

    public void walkingRobotSimulation() {
        WalkingRobotSimulation wrs = new WalkingRobotSimulation();

        System.out.println("25 == " + wrs.robotSim(new int[]{4,-1,3}, new int[0][0]));
        System.out.println("65 == " + wrs.robotSim(new int[]{4,-1,4,-2,4}, new int[][]{{2,4}}));
        System.out.println("36 == " + wrs.robotSim(new int[]{6,-1,-1,6}, new int[0][0]));
        System.out.println("4 == " + wrs.robotSim(new int[]{7,-2,-2,7,5}, new int[][]{{-3,2},{-2,1},{0,1},{-2,4},{-1,0},{-2,-3},{0,-3},{4,4},{-3,3},{2,2}}));
        System.out.println("4842 == " + wrs.robotSim(new int[]{1,2,-2,5,-1,-2,-1,8,3,-1,9,4,-2,1,3,-2,4,1,4,-1,1,9,-1,-2,5,-1,5,5,-2,6,6,7,7,2,8},
            new int[][]{{-57,-58},{-72,91},{-55,35},{-20,29},{51,70},{-61,88},{-62,99},{52,17},{-75,-32},{91,-22},{54,33},{-45,-59},{47,-48},{53,-98},{-91,83},{81,12},{-34,-90},{-79,-82},{-15,-86},{-24,66},{-35,35},{3,31},{87,93},{2,-19},{87,-93},{24,-10},{84,-53},{86,87},{-88,-18},{-51,89},{96,66},{-77,-94},{-39,-1},{89,51},{-23,-72},{27,24},{53,-80},{52,-33},{32,4},{78,-55},{-25,18},{-23,47},{79,-5},{-23,-22}}));
        System.out.println("5265 == " + wrs.robotSim(new int[]{1,2,-2,5,-1,-2,-1,8,3,-1,9,4,-2,3,2,4,3,9,2,-1,-1,-2,1,3,-2,4,1,4,-1,1,9,-1,-2,5,-1,5,5,-2,6,6,7,7,2,8},
            new int[][]{{-57,-58},{-72,91},{-55,35},{-20,29},{51,70},{-61,88},{-62,99},{52,17},{-75,-32},{91,-22},{54,33},{-45,-59},{47,-48},{53,-98},{-91,83},{81,12},{-34,-90},{-79,-82},{-15,-86},{-24,66},{-35,35},{3,31},{87,93},{2,-19},{87,-93},{24,-10},{84,-53},{86,87},{-88,-18},{-51,89},{96,66},{-77,-94},{-39,-1},{89,51},{-23,-72},{27,24},{53,-80},{52,-33},{32,4},{78,-55},{-25,18},{-23,47},{79,-5},{-23,-22}}));
    }

    public void checkIfWordIsValidAfterSubstitutions() {
        CheckIfWordIsValidAfterSubstitutions ciwivas = new CheckIfWordIsValidAfterSubstitutions();

        System.out.println("true == " + ciwivas.isValid("aabcbc"));
        System.out.println("true == " + ciwivas.isValid("abcabcababcc"));
        System.out.println("false == " + ciwivas.isValid("abccba"));
    }

    public void getEqualSubstringsWithinBudget() {
        GetEqualSubstringsWithinBudget geswb = new GetEqualSubstringsWithinBudget();

        System.out.println("3 == " + geswb.equalSubstring("abcd", "bcdf", 3));
        System.out.println("1 == " + geswb.equalSubstring("abcd", "cdef", 3));
        System.out.println("1 == " + geswb.equalSubstring("abcd", "acde", 0));
    }

    public void LRUCache() {
        LRUCache lruc = new LRUCache(2);

        lruc.put(1,1);
        lruc.put(2,2);
        System.out.println("1 == " + lruc.get(1));
        lruc.put(3,3);
        System.out.println("1 == " + lruc.get(2));
        lruc.put(4,4);
        System.out.println("-1 == " + lruc.get(1));
        System.out.println("3 == " + lruc.get(3));
        System.out.println("4 == " + lruc.get(4));

    }

    public void maxChunksToMakeSorted() {
        MaxChunksToMakeSorted mctms = new MaxChunksToMakeSorted();

        System.out.println("1 == " + mctms.maxChunksToSorted(new int[]{4,3,2,1,0}));
        System.out.println("4 == " + mctms.maxChunksToSorted(new int[]{1,0,2,3,4}));
        System.out.println("4 == " + mctms.maxChunksToSorted(new int[]{0,1,4,2,3,5}));
    }

    public void statisticsFromALargeSample() {
        StatisticsFromALargeSample sfals = new StatisticsFromALargeSample();

        System.out.println("[1.00000,3.00000,2.37500,2.50000,3.00000] == " + sfals.sampleStats(new int[]{0,1,3,4,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));

        System.out.println("[1.00000,3.00000,2.37500,2.50000,3.00000] == " + sfals.sampleStats(new int[]{0,4,3,2,
            2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }

    public void nearestExitFromEntranceInMaze() {
        NearestExitFromEntranceInMaze nefeim = new NearestExitFromEntranceInMaze();

        System.out.println("1 == " + nefeim.nearestExit(new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}}, new int[]{1,2}));
        System.out.println("2 == " + nefeim.nearestExit(new char[][]{{'+','+','+'},{'.','.','.'},{'+','+','+'}}, new int[]{1,0}));
        System.out.println("-1 == " + nefeim.nearestExit(new char[][]{{'.','+'}}, new int[]{0,0}));
    }

    public void alphabetBoardPath() {
        AlphabetBoardPath abp = new AlphabetBoardPath();

        System.out.println("DDR!UURRR!!DDD! == " + abp.alphabetBoardPath("leet"));
        System.out.println("RR!DDRR!UUL!R! == " + abp.alphabetBoardPath("code"));
    }

    public void countServersThatCommunicate() {
        CountServersThatCommunicate cstc = new CountServersThatCommunicate();

        System.out.println("0 == " + cstc.countServers(new int[][]{{1,0},{0,1}}));
        System.out.println("3 == " + cstc.countServers(new int[][]{{1,0},{1,1}}));
        System.out.println("4 == " + cstc.countServers(new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}}));
    }

    public void distanceBetweenBusStops() {
        DistanceBetweenBusStops dbbs = new DistanceBetweenBusStops();

        System.out.println("1 == " + dbbs.distanceBetweenBusStops(new int[]{1,2,3,4}, 0, 1));
        System.out.println("3 == " + dbbs.distanceBetweenBusStops(new int[]{1,2,3,4}, 0, 2));
        System.out.println("4 == " + dbbs.distanceBetweenBusStops(new int[]{1,2,3,4}, 0, 3));
    }

}
