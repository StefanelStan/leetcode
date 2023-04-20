package com.ss.leetcode.LC2021;

import com.ss.leetcode.LC2021.july.*;
import com.ss.leetcode.shared.ListNode;
import com.ss.leetcode.shared.TreeNode;
import com.ss.leetcode.shared.Utils;

import java.util.Arrays;

public class StartJuly {
    public static void main(String[] args) {
        StartJuly start = new StartJuly();

//        start.buildArrayFromPermutation();
//        start.minimumTimeVisitingAllPoints();
//        start.minimumOperationsToMakeTheArrayIncreasing();
//        start.increasingDecreasingString();
//        start.kthSmallestElementInASortedMatrix();
//        start.breakAPalindrome();
//        start.generateAStringWithCharactersThatHaveOddCounts();
//        start.findMedianFromDataStream();
//        start.concatenationOfArray();
//        start.totalHammingDistance();
//        start.isomorphicStrings();
//        start.findPeakElement();
//        start.customSortString();
//        start.validTriangleNumber();
//        start.fourSum();
//        start.threeEqualParts();
//        start.reverseNodesInkGroup();
//        start.numberOfRectanglesFormLargestSquare();
//        start.lowestCommonAncestorOfaBST();
//        start.validParentheses();
//        start.shuffleAnArray();
//        start.pushDominoes();
//        start.partitionArrayIntoDisjointIntervals();
//        start.maximumPopulationYear();
        start.checkIfNAndDoubleExist();
//        start.binaryTreePruning();
//        start.longestCommonPrefix();
//        start.implementStrStr();
//        start.searchInsertPosition();
//        start.checkIfAllCharactersEqualOccurrences();
//        start.describeThePainting();
//        start.kthMissingPositiveNumber();
//        start.maximumProductOfTwoElementsInAnArray();
//        start.sqrtX();
//        start.topKFrequentWords();
//        start.deepestLeavesSum();
//        start.sumOfDigitsOfStringAfterConvert();
//        start.largestNumberAfterMutatingSubstring();
//        start.buddyStrings();
//        start.findCorrespondingNodeBinaryTreeInClone();
//        start.rangeSumOfBST();
//        start.constructBSTFromPreorderTraversal();
//        start.findCenterOfStarGraph();
//        start.heightChecker();
//        start.powXN();
//        start.numberOfStudentsDoingHomeworkAtAGivenTime();
//        start.excelSheetColumnTitle();
//        start.convertSortedArrayToBST();
//        start.designAStackWithIncrementOperation();
//        start.findNUniqueIntegersSumUpToZero();
//        start.binarySearchTreeToGreaterSumTree();
//        start.convertBSTToGreaterTree();
//        start.fibonacciNumber();
//        start.substringsOfSizeThreeDistinct();
//        start.threeSumClosest();
//        start.maximumNumberOfBallsInABox();
//        start.middleOfTheLinkedList();
//        start.beautifulArray();
//        start.palindromeNumber();
//        start.mergeTwoSortedLists();
//        start.minimumAbsoluteDifference();
//        start.removeDuplicatesFromSortedList();
//        start.zeroOneMatrix();
//        start.balanceABST();
//        start.allElementsInTwoBinarySearchTrees();
//        start.mapSumPairs();
//        start.removeAllOccurrencesOfASubstring();
//        start.groupThePeopleGivenGroupSize();
//        start.trappingRainWater();
//        start.maximumDepthOfBinaryTree();
    }

    public void buildArrayFromPermutation() {
        BuildArrayFromPermutation bafp = new BuildArrayFromPermutation();

        System.out.println("[0,1,2,4,5,3] == " + Arrays.toString(bafp.buildArray(new int[] { 0, 2, 1, 5, 3, 4 })));
        System.out.println("[4,5,0,1,2,3] == " + Arrays.toString(bafp.buildArray(new int[] { 5, 0, 1, 2, 3, 4 })));

    }

    public void minimumTimeVisitingAllPoints() {
        MinimumTimeVisitingAllPoints mtval = new MinimumTimeVisitingAllPoints();
        int[][] input1 = { { 220, -503 }, { 525, 533 }, { -121, -746 }, { 809, 529 }, { 594, 629 }, { 249, 199 }, { 20, 55 }, { -997, -877 }, { -465, -357 },
                { 445, -151 }, { 814, 719 }, { -349, -277 }, { 844, -598 }, { -262, -539 }, { -721, -596 }, { -883, 310 }, { -13, 113 }, { -869, -829 },
                { 817, 766 }, { -234, 794 }, { -438, -398 }, { 831, 626 }, { 0, -142 }, { 314, 65 }, { 161, 213 }, { -65, -325 }, { -336, -351 }, { -624, 370 },
                { -591, -23 }, { -886, 729 }, { 879, 336 }, { 743, -682 }, { 285, 38 }, { 460, 959 }, { -575, -613 }, { -795, -106 }, { -198, -696 }, { 206, 317 },
                { -785, -316 }, { 638, 593 }, { -439, 413 }, { 150, -633 }, { 752, 170 }, { 988, 713 }, { -554, 832 }, { 915, -453 }, { 794, -276 }, { 633, 75 },
                { 815, -992 }, { 290, -787 }, { 514, 708 }, { -571, -232 }, { 304, -821 }, { 850, -970 }, { -521, 984 }, { 479, -121 }, { -272, 135 }, { -480, 192 },
                { 126, -696 }, { 975, 444 }, { -385, -162 }, { -990, 480 }, { 279, -84 }, { 118, 122 }, { -981, 265 }, { -465, 350 }, { 517, 495 }, { -523, -944 },
                { -372, -557 }, { 103, -531 }, { 145, 383 }, { -98, -403 }, { 265, -958 }, { -515, -737 }, { -431, -904 }, { -457, 610 }, { -488, 495 }, { 757, -48 }, { -811, -632 } };

        System.out.println("68796 == " + mtval.minTimeToVisitAllPoints(input1));
        System.out.println("7 == " + mtval.minTimeToVisitAllPoints(new int[][] { { 1, 1 }, { 3, 4 }, { -1, 0 } }));
        System.out.println("5 == " + mtval.minTimeToVisitAllPoints(new int[][] { { 3, 2 }, { -2, 2 } }));
    }

    public void minimumOperationsToMakeTheArrayIncreasing() {
        MinimumOperationsArrayIncreasing motmtai = new MinimumOperationsArrayIncreasing();

        System.out.println("3 == " + motmtai.minOperations(new int[] { 1, 1, 1 }));
        System.out.println("14 == " + motmtai.minOperations(new int[] { 1, 5, 2, 4, 1 }));
        System.out.println("0 == " + motmtai.minOperations(new int[] { 8 }));
    }

    public void increasingDecreasingString() {
        IncreasingDecreasingString ids = new IncreasingDecreasingString();

        System.out.println("abccbaabccba == " + ids.sortString("aaaabbbbcccc"));
        System.out.println("art == " + ids.sortString("rat"));
        System.out.println("cdelotee == " + ids.sortString("leetcode"));
        System.out.println("ggggggg == " + ids.sortString("ggggggg"));
        System.out.println("ops == " + ids.sortString("spo"));
    }

    public void kthSmallestElementInASortedMatrix() {
        KthSmallestElementInASortedMatrix kseiasm = new KthSmallestElementInASortedMatrix();

        System.out.println("13 == " + kseiasm.kthSmallest(new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, 8));
        System.out.println("-5  == " + kseiasm.kthSmallest(new int[][] { { -5 } }, 1));
    }

    public void breakAPalindrome() {
        BreakAPalindrome bap = new BreakAPalindrome();

        System.out.println("aaccba == " + bap.breakPalindrome("abccba"));
        System.out.println(" == " + bap.breakPalindrome("a"));
        System.out.println("ab == " + bap.breakPalindrome("aa"));
        System.out.println("abb == " + bap.breakPalindrome("aba"));
        System.out.println("azzz == " + bap.breakPalindrome("zzzz"));
    }

    public void generateAStringWithCharactersThatHaveOddCounts() {
        GenerateStringCharsOddCount gscod = new GenerateStringCharsOddCount();

        System.out.println("abbb == " + gscod.generateTheString(4));
        System.out.println("ab == " + gscod.generateTheString(2));
        System.out.println("aaaaaaa == " + gscod.generateTheString(7));
    }

    public void findMedianFromDataStream() {
        MedianFinder mf = new MedianFinder();

        mf.addNum(1);
        mf.addNum(2);
        System.out.println("1.5 == " + mf.findMedian());
        mf.addNum(3);
        System.out.println("2.0 == " + mf.findMedian());

        mf = new MedianFinder();
        mf.addNum(6);
        System.out.println("6.0 == " + mf.findMedian());
        mf.addNum(10);
        System.out.println("8.0 == " + mf.findMedian());
        mf.addNum(2);
        System.out.println("6.0 == " + mf.findMedian());
        mf.addNum(6);
        System.out.println("6.0 == " + mf.findMedian());
        mf.addNum(5);
        System.out.println("6.0 == " + mf.findMedian());
        mf.addNum(0);
        System.out.println("5.5 == " + mf.findMedian());
        mf.addNum(6);
        System.out.println("6.0 == " + mf.findMedian());
        mf.addNum(3);
        System.out.println("5.5 == " + mf.findMedian());
        mf.addNum(1);
        System.out.println("5.0 == " + mf.findMedian());
        mf.addNum(0);
        System.out.println("4.0 == " + mf.findMedian());
        mf.addNum(0);
        System.out.println("3.0 == " + mf.findMedian());

    }

    public void concatenationOfArray() {
        ConcatenationOfArray coa = new ConcatenationOfArray();

        System.out.println("[1,2,1,1,2,1] == " + Arrays.toString(coa.getConcatenation(new int[]{1,2,1})));
        System.out.println("[1,3,2,1,1,3,2,1] == " + Arrays.toString(coa.getConcatenation(new int[]{1,3,2,1})));
    }

    public void totalHammingDistance() {
        TotalHammingDistance thd = new TotalHammingDistance();

        System.out.println("6 == " + thd.totalHammingDistance(new int[]{4,14,2}));
        System.out.println("4 == " + thd.totalHammingDistance(new int[]{4,14,4}));
    }

    public void isomorphicStrings() {
        IsomorphicStrings is = new IsomorphicStrings();

        System.out.println("true == "+ is.isIsomorphic("egg", "add"));
        System.out.println("false == "+ is.isIsomorphic("foo", "bar"));
        System.out.println("true == "+ is.isIsomorphic("paper", "title"));
    }

    public void findPeakElement() {
        FindPeakElement fpe = new FindPeakElement();

        System.out.println("2 == " +fpe.findPeakElement(new int[]{1,2,3,1}));
        System.out.println("2 == " +fpe.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }

    public void customSortString() {
        CustomSortString css = new CustomSortString();

        System.out.println("cbad == " + css.customSortString("cba", "abcd"));
    }

    public void validTriangleNumber() {
        ValidTriangleNumber vtn = new ValidTriangleNumber();

        System.out.println("3 == " + vtn.triangleNumber(new int[]{2,2,3,4}));
        System.out.println("4 == " + vtn.triangleNumber(new int[]{4,2,3,4}));
    }

    public void fourSum() {
        FourSum fs = new FourSum();

        System.out.println("[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]] == " + fs.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println("[[2,2,2,2]] == " + fs.fourSum(new int[]{2,2,2,2,2}, 8));
    }

    public void threeEqualParts() {
        ThreeEqualParts tep = new ThreeEqualParts();

        System.out.println("[0, 3] == " + Arrays.toString(tep.threeEqualParts(new int[]{1,0,1,0,1})));
        System.out.println("[-1, -1] == " + Arrays.toString(tep.threeEqualParts(new int[]{1,1,0,1,1})));
        System.out.println("[0, 2] == " + Arrays.toString(tep.threeEqualParts(new int[]{1,1,0,0,1})));
        System.out.println("[-1, -1] == " + Arrays.toString(tep.threeEqualParts(new int[]{1,0,1,1,0})));
    }

    public void reverseNodesInkGroup() {
        ReverseNodesInkGroup rnikg = new ReverseNodesInkGroup();

        System.out.println("[2,1,4,3,5] == " +  rnikg.reverseKGroup(ListNode.makeChain(new int[]{1,2,3,4,5}), 2).getAsList());
        System.out.println("[3,2,1,4,5] == " + rnikg.reverseKGroup(ListNode.makeChain(new int[]{1,2,3,4,5}), 3).getAsList());
        System.out.println("[1,2,3,4,5] == " + rnikg.reverseKGroup(ListNode.makeChain(new int[]{1,2,3,4,5}), 1).getAsList());
        System.out.println("[1] == " + rnikg.reverseKGroup(ListNode.makeChain(new int[]{1}), 1).getAsList());
    }

    public void numberOfRectanglesFormLargestSquare() {
        NumberOfRectanglesFormLargestSquare norfls = new NumberOfRectanglesFormLargestSquare();

        System.out.println("3 == " + norfls.countGoodRectangles(new int[][]{{5,8}, {3,9}, {5,12}, {16,5}}));
        System.out.println("3 == " + norfls.countGoodRectangles(new int[][]{{2,3}, {3,7}, {4,3}, {3,7}}));
    }

    public void lowestCommonAncestorOfaBST() {
        LowestCommonAncestorOfaBST lcabst = new LowestCommonAncestorOfaBST();

        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        four.left = three;
        four.right = five;
        TreeNode zero = new TreeNode(0);
        TreeNode two = new TreeNode(2);
        two.left = zero;
        two.right = four;
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        TreeNode eight = new TreeNode(8);
        eight.left = seven;
        eight.right = nine;
        TreeNode root = new TreeNode(6);
        root.left = two;
        root.right = eight;

        System.out.println("6 == " + lcabst.lowestCommonAncestor(root, two, eight).val);
        System.out.println("2 == " + lcabst.lowestCommonAncestor(root, two, four).val);

    }

    public void validParentheses() {
        ValidParentheses vp = new ValidParentheses();

        System.out.println("true == " + vp.isValid("()"));
        System.out.println("true == " + vp.isValid("()[]{}"));
        System.out.println("false == " + vp.isValid("(]"));
        System.out.println("false == " + vp.isValid("([)]"));
        System.out.println("true == " + vp.isValid("{[]}"));
        System.out.println("false == " + vp.isValid("(("));
        System.out.println("false == " + vp.isValid("([]){"));
        System.out.println("false == " + vp.isValid("()))"));
    }

    public void shuffleAnArray() {
        ShuffleAnArray saa = new ShuffleAnArray(new int[]{1,2,3});

        System.out.println("Shuffle1 == " + Arrays.toString(saa.shuffle()));
        System.out.println("[1,2,3] == " + Arrays.toString(saa.reset()));
        System.out.println("Shuffle2 == " + Arrays.toString(saa.shuffle()));
    }

    public void pushDominoes() {
        PushDominoes pd = new PushDominoes();

        System.out.println("RR.L == " + pd.pushDominoes("RR.L"));
        System.out.println("LL.RR.LLRRLL.. == " + pd.pushDominoes(".L.R...LR..L.."));
        System.out.println(".RRLL. == " + pd.pushDominoes(".R..L."));
    }

    public void partitionArrayIntoDisjointIntervals() {
        PartitionArrayDisjoinedIntervals padi = new PartitionArrayDisjoinedIntervals();

        System.out.println("3 == " + padi.partitionDisjoint(new int[]{5,0,3,8,6}));
        System.out.println("4 == " + padi.partitionDisjoint(new int[]{1,1,1,0,6,12}));
    }

    public void maximumPopulationYear() {
        MaximumPopulationYear mpy = new MaximumPopulationYear();

        System.out.println("1993 == " + mpy.maximumPopulation(new int[][]{{1993, 1999}, {2000, 2010}}));
        System.out.println("1960 == " + mpy.maximumPopulation(new int[][]{{1950, 1961}, {1960,1971}, {1970,1981}}));
    }

    public void checkIfNAndDoubleExist() {
        CheckIfNAndDoubleExist cinade = new CheckIfNAndDoubleExist();

//        System.out.println("true == " + cinade.checkIfExist(new int[]{-766,259,203,601,896,-226,-844,168,126,-542,159,
//            -833,950,-454,-253,824,-395,155,94,894,-766,-63,836,-433,-780,611,-907,695,-395,-975,256,373,-971,-813,-154,
//            -765,691,812,617,-919,-616,-510,608,201,-138,-669,-764,-77,-658,394,-506,-675,523}));
//        System.out.println("false == " + cinade.checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));
//        System.out.println("true == " + cinade.checkIfExist(new int[]{-10,12,-20,-8,15}));
//        System.out.println("true == " + cinade.checkIfExist(new int[]{10,2,5,3}));
//        System.out.println("true == " + cinade.checkIfExist(new int[]{7,1,14,11}));
//        System.out.println("false == " + cinade.checkIfExist(new int[]{3,1,7,11}));
        System.out.println("false == " + cinade.checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));
    }

    public void binaryTreePruning() {
        BinaryTreePruning btp = new BinaryTreePruning();

        TreeNode node11 = new TreeNode(0);
        TreeNode node12 = new TreeNode(1);
        TreeNode node13 = new TreeNode(0);
        node13.left = node11;
        node13.right = node12;
        TreeNode root1 = new TreeNode(1);
        root1.right = node13;
        btp.pruneTree(root1);

        TreeNode node21 = new TreeNode(0);
        TreeNode node22 = new TreeNode(0);
        TreeNode node23 = new TreeNode(0);
        node23.left = node21;
        node23.right = node22;
        TreeNode node24 = new TreeNode(0);
        TreeNode node25 = new TreeNode(1);
        TreeNode node26 = new TreeNode(1);
        node26.left = node24;
        node26.right = node25;
        TreeNode root2 = new TreeNode(1);
        root2.left = node23;
        root2.right = node26;

        TreeNode node31 = new TreeNode(0);
        TreeNode node32 = new TreeNode(1);
        node32.left = node31;
        TreeNode node33 = new TreeNode(1);
        TreeNode node34 = new TreeNode(1);
        node34.left = node32;
        node34.right = node33;
        TreeNode node35 = new TreeNode(0);
        TreeNode node36 = new TreeNode(1);
        TreeNode node37 = new TreeNode(0);
        node37.left = node35;
        node37.right = node36;
        TreeNode root3 = new TreeNode(1);
        root3.left = node34;
        root3.right = node37;

        System.out.println("[1, null, 0, null, 1] == " + TreeNode.preOrder(btp.pruneTree(root1)));
        System.out.println("[1, null, 1, null, 1] == " + TreeNode.preOrder(btp.pruneTree(root2)));
        System.out.println("[1, null, 0, null, 1] == " + TreeNode.preOrder(btp.pruneTree(root3)));
    }

    public void longestCommonPrefix() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();

        System.out.println("fl == " + lcp.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println("[] == " + lcp.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public void implementStrStr() {
        ImplementStrStr iss = new ImplementStrStr();

        System.out.println("-1 == " + iss.strStr("mississippi", "issipi"));
        System.out.println("2 == " + iss.strStr("hello", "ll"));
        System.out.println("-1 == " + iss.strStr("aaaaa", "bba"));
        System.out.println("0 == " + iss.strStr("", ""));
    }

    public void searchInsertPosition() {
        SearchInsertPosition sip = new SearchInsertPosition();

        System.out.println("2 == " + sip.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println("1 == " + sip.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println("4 == " + sip.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println("0 == " + sip.searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println("0 == " + sip.searchInsert(new int[]{1}, 0));
    }

    public void checkIfAllCharactersEqualOccurrences() {
        CheckIfAllCharactersEqualOccurrences ciaceo = new CheckIfAllCharactersEqualOccurrences();

        System.out.println("true == " + ciaceo.areOccurrencesEqual("abacbc"));
        System.out.println("false == " + ciaceo.areOccurrencesEqual("aaabb"));
    }

    public void describeThePainting() {
        // TimeLimitExceeded
        DescribeThePainting dtp = new DescribeThePainting();

        System.out.println("[[1,4,14],[4,7,16]] == " + dtp.splitPainting(new int[][]{{1,4,5}, {4,7,7}, {1,7,9}}));
        System.out.println("[[1,6,9],[6,7,24],[7,8,15],[8,10,7]] == " + dtp.splitPainting(new int[][]{{1,7,9}, {6,8,15}, {8,10,7}}));
        System.out.println("[[1,4,12],[4,7,12]] == " + dtp.splitPainting(new int[][]{{1,4,5}, {1,4,7}, {4,7,1}, {4,7,11}}));
    }

    public void kthMissingPositiveNumber() {
        KthMissingPositiveNumber kmpn = new KthMissingPositiveNumber();

        System.out.println("1 == " + kmpn.findKthPositive(new int[]{2}, 1));
        System.out.println("9 == " + kmpn.findKthPositive(new int[]{2,3,4,7,11}, 5));
        System.out.println("6 == " + kmpn.findKthPositive(new int[]{1,2,3,4}, 2));
    }

    public void maximumProductOfTwoElementsInAnArray() {
        MaximumProductOfTwoElements mpote = new MaximumProductOfTwoElements();

        System.out.println("36 == " + mpote.maxProduct(new int[]{10,2,5,2}));
        System.out.println("12 == " + mpote.maxProduct(new int[]{3,4,5,2}));
        System.out.println("16 == " + mpote.maxProduct(new int[]{1,5,4,5}));
        System.out.println("12 == " + mpote.maxProduct(new int[]{3,7}));
    }

    public void sqrtX() {
        SqrtX sx = new SqrtX();

        System.out.println("2 == " + sx.mySqrt(4));
        System.out.println("2 == " + sx.mySqrt(8));
        System.out.println("4 == " + sx.mySqrt(23));
        System.out.println("46340 == " + sx.mySqrt(2147483647));
    }

    public void topKFrequentWords() {
        TopKFrequentWords tkfw = new TopKFrequentWords();

        System.out.println("[i, love, coding] == "+ tkfw.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3));
        System.out.println("[i, love] == "+ tkfw.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println("[the, is, sunny, day] == "+ tkfw.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    public void deepestLeavesSum() {
        DeepestLeavesSum dls = new DeepestLeavesSum();

        TreeNode four = new TreeNode(4, new TreeNode(7), null);
        TreeNode two = new TreeNode(2, four, new TreeNode(7));
        TreeNode three = new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8)));
        TreeNode root = new TreeNode(1, two, three);

        System.out.println("15 == " + dls.deepestLeavesSum(root));
    }

    public void sumOfDigitsOfStringAfterConvert() {
        SumOfDigitsAfterConvert sodac = new SumOfDigitsAfterConvert();

        System.out.println("17 == " + sodac.getLucky("zbax", 1));
        System.out.println("8 == " + sodac.getLucky("zbax", 2));
        System.out.println("36 == " + sodac.getLucky("iiii", 1));
        System.out.println("6 == " + sodac.getLucky("leetcode", 2));
        System.out.println("15 == " + sodac.getLucky("vbyytoijnbgtyrjlsc", 2));
    }

    public void largestNumberAfterMutatingSubstring() {
        LargestNumberAfterMutatingSubstring lnams = new LargestNumberAfterMutatingSubstring();

        System.out.println("974676 == " + lnams.maximumNumber("214010", new int[]{6,7,9,7,4,0,3,4,4,7}));
        System.out.println("334999 == " + lnams.maximumNumber("334111", new int[]{0,9,2,3,3,2,5,5,5,5}));
        System.out.println("832 == " + lnams.maximumNumber("132", new int[]{9,8,5,0,3,6,4,2,6,8}));
        System.out.println("934 == " + lnams.maximumNumber("021", new int[]{9,4,3,5,7,2,1,9,0,6}));
        System.out.println("5 == " + lnams.maximumNumber("5", new int[]{1,4,7,5,3,2,5,6,9,4}));
    }

    public void buddyStrings() {
        BuddyStrings bs = new BuddyStrings();

        System.out.println("false == " + bs.buddyStrings("abcd", "badc"));
        System.out.println("true == " + bs.buddyStrings("ab", "ba"));
        System.out.println("false == " + bs.buddyStrings("ab", "ab"));
        System.out.println("true == " + bs.buddyStrings("aa", "aa"));
        System.out.println("true == " + bs.buddyStrings("aaaaaaabc", "aaaaaaacb"));

    }

    public void findCorrespondingNodeBinaryTreeInClone() {
        FindCorrespondingNodeBTInClone fcnibtc = new FindCorrespondingNodeBTInClone();

        TreeNode node_o11 = new TreeNode(3, new TreeNode(6), new TreeNode(19));
        TreeNode root_o1 = new TreeNode(7, new TreeNode(4), node_o11);
        TreeNode node_c11 = new TreeNode(3, new TreeNode(6), new TreeNode(19));
        TreeNode root_c1 = new TreeNode(7, new TreeNode(4), node_c11);

        TreeNode root_o2 = new TreeNode(7);
        TreeNode root_c2 = new TreeNode(7);

        TreeNode node_o31 = new TreeNode(4, null, new TreeNode(3, null, new TreeNode(2, null, new TreeNode(1))));
        TreeNode root_o3 = new TreeNode(8, null, new TreeNode(6, null, new TreeNode(5, null, node_o31)));
        TreeNode node_c31 = new TreeNode(4, null, new TreeNode(3, null, new TreeNode(2, null, new TreeNode(1))));
        TreeNode root_c3 = new TreeNode(8, null, new TreeNode(6, null, new TreeNode(5, null, node_c31)));

        TreeNode node_o41 = new TreeNode(2, new TreeNode(3), null);
        TreeNode root_o4 = new TreeNode(1, node_o41, null);
        TreeNode node_c41 = new TreeNode(2, new TreeNode(3), null);
        TreeNode root_c4 = new TreeNode(1, node_c41, null);

        TreeNode node_o51 = new TreeNode(5, new TreeNode(10), null);
        TreeNode root_o5 = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), node_o51),
                                        new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        TreeNode node_c51 = new TreeNode(5, new TreeNode(10), null);
        TreeNode root_c5 = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), node_c51),
            new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        System.out.println("true == " + node_c11.equals(fcnibtc.getTargetCopy(root_o1, root_c1, node_o11)));
        System.out.println("true == " + root_c2.equals(fcnibtc.getTargetCopy(root_o2, root_c2, root_o2)));
        System.out.println("true == " + node_c31.equals(fcnibtc.getTargetCopy(root_o3, root_c3, node_o31)));
        System.out.println("true == " + node_c41.equals(fcnibtc.getTargetCopy(root_o4, root_c4, node_o41)));
        System.out.println("true == " + node_c51.equals(fcnibtc.getTargetCopy(root_o5, root_c5, node_o51)));
    }

    public void rangeSumOfBST() {
        RangeSumOfBST rsobst = new RangeSumOfBST();

        TreeNode root1 = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
        TreeNode root2 = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(1), null), new TreeNode(7, new TreeNode(6), null)),
                                      new TreeNode(15, new TreeNode(13), new TreeNode(18)));

        System.out.println("32 == " + rsobst.rangeSumBST(root1, 7, 15));
        System.out.println("23 == " + rsobst.rangeSumBST(root2, 6, 10));
    }

    public void constructBSTFromPreorderTraversal() {
        // wrong answer on LeetCode.
        ConstructBSTFromPreorderTraversal cbstfpt = new ConstructBSTFromPreorderTraversal();

        System.out.println(cbstfpt.bstFromPreorder(new int[]{8,5,1,7,10,12}).val);
        System.out.println(cbstfpt.bstFromPreorder(new int[]{1,3}).val);
    }

    public void findCenterOfStarGraph() {
        FindCenterOfStarGraph fcosg = new FindCenterOfStarGraph();

        System.out.println("2 == " + fcosg.findCenter(new int[][]{{1,2}, {2,3}, {4,2}}));
        System.out.println("1 == " + fcosg.findCenter(new int[][]{{1,2}, {5,1}, {1,3}, {1,4}}));
    }

    public void heightChecker() {
        HeightChecker hc = new HeightChecker();

        System.out.println("3 == " + hc.heightChecker(new int[]{1,1,4,2,1,3}));
        System.out.println("5 == " + hc.heightChecker(new int[]{5,1,2,3,4}));
        System.out.println("0 == " + hc.heightChecker(new int[]{1,2,3,4,5}));
    }

    public void powXN() {
        PowXN powXN = new PowXN();

        System.out.println("1024.00000 == " + powXN.myPow(2.00000, 10));
        System.out.println("9.26100 == " + powXN.myPow(2.10000, 3));
        System.out.println("0.25000 == " + powXN.myPow(2.00000, -2));
    }

    public void numberOfStudentsDoingHomeworkAtAGivenTime() {
        NumberOfStudentDoingHomehork nosdh = new NumberOfStudentDoingHomehork();

        System.out.println("1 == " + nosdh.busyStudent(new int[]{1,2,3}, new int[]{3,2,7}, 4));
        System.out.println("1 == " + nosdh.busyStudent(new int[]{4}, new int[]{4}, 4));
        System.out.println("0 == " + nosdh.busyStudent(new int[]{4}, new int[]{4}, 5));
        System.out.println("0 == " + nosdh.busyStudent(new int[]{1,1,1,1}, new int[]{1,3,2,4}, 7));
        System.out.println("5 == " + nosdh.busyStudent(new int[]{9,8,7,6,5,4,3,2,1}, new int[]{10,10,10,10,10,10,10,10,10}, 5));
    }

    public void excelSheetColumnTitle() {
        ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();

        System.out.println("AZ == " + esct.convertToTitle(52));
        System.out.println("A == " + esct.convertToTitle(1));
        System.out.println("AB == " + esct.convertToTitle(28));
        System.out.println("ZY == " + esct.convertToTitle(701));
        System.out.println("FXSHRXW == " + esct.convertToTitle(2147483647));
    }

    public void convertSortedArrayToBST() {
        ConvertSortedArrayToBST csotobst = new ConvertSortedArrayToBST();

        System.out.println("0 == " + csotobst.sortedArrayToBST(new int[]{-10,-3,0,5,9}).val);
        System.out.println("3/1 == " + csotobst.sortedArrayToBST(new int[]{1,3}).val);
    }

    public void designAStackWithIncrementOperation() {
        DesignAStackWithIncrementOperation daswio = new DesignAStackWithIncrementOperation(3);

        daswio.push(1);                             // stack becomes [1]
        daswio.push(2);                             // stack becomes [1, 2]
        System.out.println("2 == " + daswio.pop()); // return 2 --> Return top of the stack 2, stack becomes [1]
        daswio.push(2);                             // stack becomes [1, 2]
        daswio.push(3);                             // stack becomes [1, 2, 3]
        daswio.push(4);                             // stack still [1, 2, 3], Don't add another elements as size is 4
        daswio.increment(5, 100);                   // stack becomes [101, 102, 103]
        daswio.increment(2, 100);                   // stack becomes [201, 202, 103]
        System.out.println("103 == " + daswio.pop()); // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        System.out.println("202 == " + daswio.pop()); // return 202 --> Return top of the stack 102, stack becomes [201]
        System.out.println("201 == " + daswio.pop()); // return 201 --> Return top of the stack 101, stack becomes []
        System.out.println("-1 == " + daswio.pop());  // return -1 --> Stack is empty return -1.
    }

    public void findNUniqueIntegersSumUpToZero() {
        FindNUniqueIntegersSumUpToZero fnuisutz = new FindNUniqueIntegersSumUpToZero();

        System.out.println("0 == " + Utils.sumOfArray(fnuisutz.sumZero(2)));
        System.out.println("0 == " + Utils.sumOfArray(fnuisutz.sumZero(4)));
        System.out.println("0 == " + Utils.sumOfArray(fnuisutz.sumZero(6)));
    }

    public void binarySearchTreeToGreaterSumTree() {
        BinarySearchTreeToGreaterSumTree bsttgst = new BinarySearchTreeToGreaterSumTree();

        TreeNode root1 = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))),
                                      new TreeNode(6, new TreeNode(5), new TreeNode((7), null, new TreeNode(8))));
        
        TreeNode root2 = new TreeNode(0, null, new TreeNode(1));
        TreeNode root3 = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        TreeNode root4 = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4));

        System.out.println("30 == " + bsttgst.bstToGst(root1).val);
        System.out.println("1 == " + bsttgst.bstToGst(root2).val);
        System.out.println("3 == " + bsttgst.bstToGst(root3).val);
        System.out.println("7 == " + bsttgst.bstToGst(root4).val);
    }

    public void convertBSTToGreaterTree() {
        ConvertBSTToGreaterTree cbsttgt = new ConvertBSTToGreaterTree();

        TreeNode root1 = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))),
            new TreeNode(6, new TreeNode(5), new TreeNode((7), null, new TreeNode(8))));

        TreeNode root2 = new TreeNode(0, null, new TreeNode(1));
        TreeNode root3 = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        TreeNode root4 = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4));

        System.out.println("30 == " + cbsttgt.convertBST(root1).val);
//        System.out.println("1 == " + cbsttgt.convertBST(root2).val);
//        System.out.println("3 == " + cbsttgt.convertBST(root3).val);
//        System.out.println("7 == " + cbsttgt.convertBST(root4).val);
    }

    public void fibonacciNumber() {
        FibonacciNumber fn = new FibonacciNumber();

        System.out.println("5 == " + fn.fib(5));
        System.out.println("8 == " + fn.fib(6));
        System.out.println("13 == " + fn.fib(7));
    }

    public void substringsOfSizeThreeDistinct() {
        SubstringsOfSizeThreeDistinct sostd =  new SubstringsOfSizeThreeDistinct();

        System.out.println("1 == " + sostd.countGoodSubstrings("xyzzaz"));
        System.out.println("4 == " + sostd.countGoodSubstrings("aababcabc"));
    }

    public void threeSumClosest() {
        ThreeSumClosest tsc = new ThreeSumClosest();

        System.out.println("2 == " + tsc.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println("0 == " + tsc.threeSumClosest(new int[]{-10, 24, 10, -2, -5, 7}, 1));
        System.out.println("3 == " + tsc.threeSumClosest(new int[]{1,1,1,1}, 100));

    }

    public void maximumNumberOfBallsInABox() {
        MaximumNumberOfBallsInABox mnobiab = new MaximumNumberOfBallsInABox();

        System.out.println("2 == " + mnobiab.countBalls(1, 10));
        System.out.println("2 == " + mnobiab.countBalls(5, 15));
    }

    public void middleOfTheLinkedList() {
        MiddleOfTheLinkedList mofll = new MiddleOfTheLinkedList();

        System.out.println("[3, 4, 5] == " + mofll.middleNode(new ListNode(1, new ListNode(2, new ListNode(3,
                                                              new ListNode(4, new ListNode(5)))))).getAsList());
        System.out.println("[4, 5, 6] == " + mofll.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                                                              new ListNode(5, new ListNode(6))))))).getAsList());
    }

    public void beautifulArray() {
        BeautifulArray ba = new BeautifulArray();

        System.out.println("[2,1,4,3] == " + Arrays.toString(ba.beautifulArray(4)));
        System.out.println("[3,1,2,5,4] == " + Arrays.toString(ba.beautifulArray(5)));
    }

    public void palindromeNumber() {
        PalindromeNumber pn = new PalindromeNumber();

        System.out.println("true == " + pn.isPalindrome(121));
        System.out.println("false == " + pn.isPalindrome(-121));
    }

    public void mergeTwoSortedLists() {
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();

        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode head3 = new ListNode(3, new ListNode(6, new ListNode(7)));
        ListNode head4 = new ListNode(2, new ListNode(3, new ListNode(9)));
        System.out.println("[1,1,2,3,4,4] == " + mtsl.mergeTwoLists(head1, head2).getAsList());
        System.out.println("[] == " + mtsl.mergeTwoLists(null, null));
        System.out.println("[0] == " + mtsl.mergeTwoLists(null, new ListNode(0)).getAsList());
        System.out.println("[2,3,3,6,7,9] == " + mtsl.mergeTwoLists(head3, head4).getAsList());
    }

    public void minimumAbsoluteDifference() {
        MinimumAbsoluteDifference mad = new MinimumAbsoluteDifference();

        System.out.println(("[[1,2],[2,3],[3,4]] == " + mad.minimumAbsDifference(new int[]{4,2,1,3})));
        System.out.println(("[[1,3]] == " + mad.minimumAbsDifference(new int[]{1,3,6,10,15})));
        System.out.println(("[[-14,-10],[19,23],[23,27]] == " + mad.minimumAbsDifference(new int[]{3,8,-10,23,19,-4,-14,27})));
    }

    public void removeDuplicatesFromSortedList() {
        RemoveDuplicatesFromSortedList rdfss = new RemoveDuplicatesFromSortedList();

        ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode head3 = new ListNode(1, new ListNode(1, new ListNode(1)));

        System.out.println("[1,2] == " + rdfss.deleteDuplicates(head1).getAsList());
        System.out.println("[1,2,3] == " + rdfss.deleteDuplicates(head2).getAsList());
        System.out.println("[1] == " + rdfss.deleteDuplicates(head3).getAsList());
    }

    public void zeroOneMatrix() {
        ZeroOneMatrix zoMatrix = new ZeroOneMatrix();

        System.out.println("[[0,0,0],[0,1,0],[0,0,0]] == " + Arrays.deepToString(zoMatrix.updateMatrix(new int[][]{{0,0,0}, {0,1,0}, {0,0,0}})));
        System.out.println("[[0,0,0],[0,1,0],[1,2,1]] == " + Arrays.deepToString(zoMatrix.updateMatrix(new int[][]{{0,0,0}, {0,1,0}, {1,1,1}})));
    }

    public void balanceABST() {
        BalanceABST babst = new BalanceABST();

        TreeNode root = babst.balanceBST(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null,
                                    new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6, null, new TreeNode(7))))))));
        System.out.println("4 == " + root.val);
        System.out.println("2 == " + root.left.val);
        System.out.println("6 == " + root.right.val);
    }

    public void allElementsInTwoBinarySearchTrees() {
        AllElementsInTwoBST aeitbst = new AllElementsInTwoBST();

        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(4));
        TreeNode root2 = new TreeNode(1, new TreeNode(0), new TreeNode(3));

        System.out.println("[0,1,1,2,3,4] == " + aeitbst.getAllElements(root1, root2));
    }

    public void mapSumPairs() {
//        MapSumPairs msp = new MapSumPairs();
        MapSumPairs2 msp = new MapSumPairs2();

        MapSumPairs mapSum = new MapSumPairs();
        msp.insert("apple", 3);
        System.out.println("3 == "+ msp.sum("ap"));           // return 3 (apple = 3)
        msp.insert("app", 2);
        System.out.println("5 == "+ msp.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)

        // override the values
        msp.insert("apple", 7);
        System.out.println("9 == "+ msp.sum("ap")); // return 9 (apple + app = 7 + 2 =  5)
    }

    public void removeAllOccurrencesOfASubstring() {
        RemoveAllOccureencesOfASubstring raooas = new RemoveAllOccureencesOfASubstring();

        System.out.println("dab == " + raooas.removeOccurrences2("daabcbaabcbc", "abc"));
        System.out.println("ab == " + raooas.removeOccurrences2("axxxxyyyyb", "xy"));
    }

    public void groupThePeopleGivenGroupSize() {
        GroupThePeopleGivenGroupSize gtpggs = new GroupThePeopleGivenGroupSize();

        System.out.println("[[5],[0,1,2],[3,4,6]] == " + gtpggs.groupThePeople(new int[]{3,3,3,3,3,1,3}));
        System.out.println("[[1],[0,5],[2,3,4]] == " + gtpggs.groupThePeople(new int[]{2,1,3,3,3,2}));
    }

    public void trappingRainWater() {
        TrappingRainWater trw = new TrappingRainWater();

        System.out.println("83 == " + trw.trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}));
//        System.out.println("6 == " + trw.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println("9 == " + trw.trap(new int[]{4,2,0,3,2,5}));
    }

    public void maximumDepthOfBinaryTree() {
        MaximumDepthOfBinaryTree mdobt = new MaximumDepthOfBinaryTree();

        TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        TreeNode root3 = null;
        TreeNode root4 = new TreeNode(0);

        System.out.println("3 == " + mdobt.maxDepth(root1));
        System.out.println("2 == " + mdobt.maxDepth(root2));
        System.out.println("0 == " + mdobt.maxDepth(root3));
        System.out.println("1 == " + mdobt.maxDepth(root4));
    }
}
