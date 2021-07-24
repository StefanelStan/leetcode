package com.ss.leetcode;

import com.ss.leetcode.july.BinaryTreePruning;
import com.ss.leetcode.july.BreakAPalindrome;
import com.ss.leetcode.july.BuildArrayFromPermutation;
import com.ss.leetcode.july.CheckIfAllCharactersEqualOccurrences;
import com.ss.leetcode.july.CheckIfNAndDoubleExist;
import com.ss.leetcode.july.ConcatenationOfArray;
import com.ss.leetcode.july.CustomSortString;
import com.ss.leetcode.july.DeepestLeavesSum;
import com.ss.leetcode.july.DescribeThePainting;
import com.ss.leetcode.july.FindPeakElement;
import com.ss.leetcode.july.FourSum;
import com.ss.leetcode.july.GenerateStringCharsOddCount;
import com.ss.leetcode.july.ImplementStrStr;
import com.ss.leetcode.july.IncreasingDecreasingString;
import com.ss.leetcode.july.IsomorphicStrings;
import com.ss.leetcode.july.KthMissingPositiveNumber;
import com.ss.leetcode.july.KthSmallestElementInASortedMatrix;
import com.ss.leetcode.july.LongestCommonPrefix;
import com.ss.leetcode.july.LowestCommonAncestorOfaBST;
import com.ss.leetcode.july.MaximumPopulationYear;
import com.ss.leetcode.july.MaximumProductOfTwoElements;
import com.ss.leetcode.july.MedianFinder;
import com.ss.leetcode.july.MinimumOperationsArrayIncreasing;
import com.ss.leetcode.july.MinimumTimeVisitingAllPoints;
import com.ss.leetcode.july.NumberOfRectanglesFormLargestSquare;
import com.ss.leetcode.july.PartitionArrayDisjoinedIntervals;
import com.ss.leetcode.july.PushDominoes;
import com.ss.leetcode.july.ReverseNodesInkGroup;
import com.ss.leetcode.july.SearchInsertPosition;
import com.ss.leetcode.july.ShuffleAnArray;
import com.ss.leetcode.july.SqrtX;
import com.ss.leetcode.july.ThreeEqualParts;
import com.ss.leetcode.july.TopKFrequentWords;
import com.ss.leetcode.july.TotalHammingDistance;
import com.ss.leetcode.july.ValidParentheses;
import com.ss.leetcode.july.ValidTriangleNumber;
import com.ss.leetcode.shared.ListNode;
import com.ss.leetcode.shared.TreeNode;
import com.sun.source.tree.Tree;

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
//        start.checkIfNAndDoubleExist();
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
        start.deepestLeavesSum();
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

        System.out.println("true == " + cinade.checkIfExist(new int[]{-766,259,203,601,896,-226,-844,168,126,-542,159,
            -833,950,-454,-253,824,-395,155,94,894,-766,-63,836,-433,-780,611,-907,695,-395,-975,256,373,-971,-813,-154,
            -765,691,812,617,-919,-616,-510,608,201,-138,-669,-764,-77,-658,394,-506,-675,523}));
        System.out.println("false == " + cinade.checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));
        System.out.println("true == " + cinade.checkIfExist(new int[]{-10,12,-20,-8,15}));
        System.out.println("true == " + cinade.checkIfExist(new int[]{10,2,5,3}));
        System.out.println("true == " + cinade.checkIfExist(new int[]{7,1,14,11}));
        System.out.println("false == " + cinade.checkIfExist(new int[]{3,1,7,11}));
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

        System.out.println("[1, null, 0, null, 1] == " + TreeNode.extractValues(btp.pruneTree(root1)));
        System.out.println("[1, null, 1, null, 1] == " + TreeNode.extractValues(btp.pruneTree(root2)));
        System.out.println("[1, null, 0, null, 1] == " + TreeNode.extractValues(btp.pruneTree(root3)));
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
}
