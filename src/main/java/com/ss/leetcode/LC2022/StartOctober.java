package com.ss.leetcode.LC2022;

import com.ss.leetcode.LC2022.october.AverageValueOfEvenNumbersThatAreDivisibleByThree;
import com.ss.leetcode.LC2022.october.CountNumberOfDistinctIntegersAfterReverseOperations;
import com.ss.leetcode.LC2022.october.DeleteTheMiddleNodeOfALinkedList;
import com.ss.leetcode.LC2022.october.DetermineIfTwoEventsHaveConflict;
import com.ss.leetcode.LC2022.october.FindResultantArrayAfterRemovingAnagrams;
import com.ss.leetcode.LC2022.october.IncreasingTripletSubsequence;
import com.ss.leetcode.LC2022.october.MaximumRepeatingSubstring;
import com.ss.leetcode.LC2022.october.MostPopularVideoCreator;
import com.ss.leetcode.LC2022.october.NumberOfCommonFactors;
import com.ss.leetcode.LC2022.october.OddStringDifference;
import com.ss.leetcode.LC2022.october.ReverseOddLevelsOfBinaryTree;
import com.ss.leetcode.LC2022.october.TimeBasedKeyValueStore;
import com.ss.leetcode.LC2022.october.WordsWithinTwoEditsOfDictionary;
import com.ss.leetcode.shared.ListNode;
import com.ss.leetcode.shared.TreeNode;

public class StartOctober {
    public static void main(String[] args) {
        StartOctober start = new StartOctober();

//        start.timeBasedKeyValueStore();
//        start.increasingTripletSubsequence();
//        start.numberOfCommonFactors();
//        start.deleteTheMiddleNodeOfALinkedList();
//        start.maximumRepeatingSubstring();
//        start.findResultantArrayAfterRemovingAnagrams();
//        start.countNumberOfDistinctIntegersAfterReverseOperations();
//        start.determineIfTwoEventsHaveConflict();
//        start.reverseOddLevelsOfBinaryTree();
//        start.averageValueOfEvenNumbersThatAreDivisibleByThree();
//        start.oddStringDifference();
//        start.wordsWithinTwoEditsOfDictionary();
        start.mostPopularVideoCreator();
    }

    public void timeBasedKeyValueStore() {
        TimeBasedKeyValueStore tbkvs = new TimeBasedKeyValueStore();
//
//        tbkvs.set("foo", "bar", 1);
//        System.out.println("bar == " + tbkvs.get("foo", 1));
//        System.out.println("bar == " + tbkvs.get("foo", 3));
//        System.out.println("bar == " + tbkvs.get("foo", 0));
//        tbkvs.set("foo", "bar2", 4);
//        tbkvs.set("foo", "bar3", 8);
//        System.out.println("bar2 == " + tbkvs.get("foo", 4));
//        System.out.println("bar2 == " + tbkvs.get("foo", 5));
//        System.out.println("bar3 == " + tbkvs.get("foo", 10));
//        System.out.println("bar == " + tbkvs.get("foo", 0));

        tbkvs.set("love", "high", 10);
        tbkvs.set("love", "low", 20);
        System.out.println(" == " + tbkvs.get("love", 5));
        System.out.println("high == " + tbkvs.get("love", 10));
        System.out.println("high == " + tbkvs.get("love", 15));
        System.out.println("low == " + tbkvs.get("love", 20));
        System.out.println("low == " + tbkvs.get("love", 25));
    }

    public void increasingTripletSubsequence() {
        IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();

        System.out.println("true == " + its.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println("false == " + its.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println("true == " + its.increasingTriplet(new int[]{2,1,5,0,4,6}));
        System.out.println("true == " + its.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println("false == " + its.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println("true == " + its.increasingTriplet(new int[]{5,4,3,2,1,3,4}));
        System.out.println("false == " + its.increasingTriplet(new int[]{1,2}));
        System.out.println("false == " + its.increasingTriplet(new int[]{3,2,1}));
        System.out.println("false == " + its.increasingTriplet(new int[]{3,2}));
        System.out.println("true == " + its.increasingTriplet(new int[]{1,2,3}));
        System.out.println("true == " + its.increasingTriplet(new int[]{0,100,10,12,5,13}));
        System.out.println("false == " + its.increasingTriplet(new int[]{6,7,1,2}));
        System.out.println("true == " + its.increasingTriplet(new int[]{100,3,101,2,102,1}));
    }

    public void numberOfCommonFactors() {
        NumberOfCommonFactors nocf = new NumberOfCommonFactors();

        System.out.println("4 == " + nocf.commonFactors(12, 6));
        System.out.println("2 == " + nocf.commonFactors(25, 30));
        System.out.println("1 == " + nocf.commonFactors(12, 1));
    }

    public void deleteTheMiddleNodeOfALinkedList() {
        DeleteTheMiddleNodeOfALinkedList dtmoall = new DeleteTheMiddleNodeOfALinkedList();

        System.out.println("[1,3,4,1,2,6] == " + dtmoall.deleteMiddle(ListNode.makeChain(new int[]{1,3,4,7,1,2,6})).getAsList());
        System.out.println("[1,2,4] == " + dtmoall.deleteMiddle(ListNode.makeChain(new int[]{1,2,3,4})).getAsList());
        System.out.println("[2] == " + dtmoall.deleteMiddle(ListNode.makeChain(new int[]{2,1})).getAsList());
        System.out.println("null == " + dtmoall.deleteMiddle(ListNode.makeChain(new int[]{1})));
    }

    public void maximumRepeatingSubstring() {
        MaximumRepeatingSubstring mrs = new MaximumRepeatingSubstring();

        System.out.println("2 == " + mrs.maxRepeating("ababc","ab"));
        System.out.println("1 == " + mrs.maxRepeating("ababc","ba"));
        System.out.println("0 == " + mrs.maxRepeating("ababc","ac"));
        System.out.println("1 == " + mrs.maxRepeating("aaabc","abc"));
        System.out.println("10 == " + mrs.maxRepeating("abababaaaacdababababababababababacab","ab"));
        System.out.println("6 == " + mrs.maxRepeating("aaaaaa","a"));
        System.out.println("0 == " + mrs.maxRepeating("aa","aaa"));
        System.out.println("1 == " + mrs.maxRepeating("aaabaaaacaaaaa","aaa"));
        System.out.println("5 == " + mrs.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba","aaaba"));
    }

    public void findResultantArrayAfterRemovingAnagrams() {
        FindResultantArrayAfterRemovingAnagrams fraara = new FindResultantArrayAfterRemovingAnagrams();

        System.out.println("[abba, cd] == " + fraara.removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"}));
        System.out.println("[a,b,c,d,e] == " + fraara.removeAnagrams(new String[]{"a","b","c","d","e"}));
        System.out.println("[abba,aaa,aa,aaa] == " + fraara.removeAnagrams(new String[]{"abba","aabb","aaa","aaa","aa","aaa"}));
    }

    public void countNumberOfDistinctIntegersAfterReverseOperations() {
        CountNumberOfDistinctIntegersAfterReverseOperations cnodiaro = new CountNumberOfDistinctIntegersAfterReverseOperations();

        System.out.println("6 == " + cnodiaro.countDistinctIntegers(new int[]{1,13,10,12,31}));
        System.out.println("1 == " + cnodiaro.countDistinctIntegers(new int[]{2,2,2}));
        System.out.println("35 == " + cnodiaro.countDistinctIntegers(new int[]{32,1212,232,3232,1212,7676,543,2323,1212,4545,232,2323,121,343,553,333,444,555,1,1,11,11,111,111,1,7,3,2,7,6,6,5,4,656,343,434,322,223,112,211}));
        System.out.println("1 == " + cnodiaro.countDistinctIntegers(new int[]{7}));
        System.out.println("2 == " + cnodiaro.countDistinctIntegers(new int[]{23,32}));
    }

    public void determineIfTwoEventsHaveConflict() {
        DetermineIfTwoEventsHaveConflict ditehc = new DetermineIfTwoEventsHaveConflict();

        System.out.println("true == " + ditehc.haveConflict(new String[]{"01:15","02:00"}, new String[]{"02:00","03:00"}));
        System.out.println("true == " + ditehc.haveConflict(new String[]{"01:00","02:00"}, new String[]{"01:20","03:00"}));
        System.out.println("false == " + ditehc.haveConflict(new String[]{"10:00","11:00"}, new String[]{"14:00","15:00"}));
    }

    public void reverseOddLevelsOfBinaryTree() {
        ReverseOddLevelsOfBinaryTree rolobt = new ReverseOddLevelsOfBinaryTree();

        TreeNode root1 = new TreeNode(2, new TreeNode(3, new TreeNode(8), new TreeNode(13)), new TreeNode(5, new TreeNode(21), new TreeNode(34)));
        TreeNode root2 = new TreeNode(7, new TreeNode(13), new TreeNode(11));
        TreeNode root3 = new TreeNode(0,
            new TreeNode(1, new TreeNode(0, new TreeNode(4), new TreeNode(2)), new TreeNode(0, new TreeNode(8), new TreeNode(1))),
            new TreeNode(2, new TreeNode(0, new TreeNode(7), new TreeNode(9)), new TreeNode(0, new TreeNode(3), new TreeNode(1))));

        System.out.println("[2,5,8,13,3,21,34] == " + TreeNode.preOrder(rolobt.reverseOddLevels(root1)));
        System.out.println("[7,11,13] == " + TreeNode.preOrder(rolobt.reverseOddLevels(root2)));
        System.out.println("[0,2,0,1,3,0,9,7,1,0,1,8,0,2,4] == " + TreeNode.preOrder(rolobt.reverseOddLevels(root3)));
    }

    public void averageValueOfEvenNumbersThatAreDivisibleByThree() {
        AverageValueOfEvenNumbersThatAreDivisibleByThree avoentadbt = new AverageValueOfEvenNumbersThatAreDivisibleByThree();

        System.out.println("9 == " + avoentadbt.averageValue(new int[]{1,3,6,10,12,15}));
        System.out.println("0 == " + avoentadbt.averageValue(new int[]{1,2,4,7,10}));
    }

    public void oddStringDifference() {
        OddStringDifference osd = new OddStringDifference();

        System.out.println("poo == " + osd.oddString(new String[]{"ddd","poo","baa","onn"}));
    }

    public void wordsWithinTwoEditsOfDictionary() {
        WordsWithinTwoEditsOfDictionary wwteod = new WordsWithinTwoEditsOfDictionary();

        System.out.println("[word, note, word] == " + wwteod.twoEditWords(new String[]{"word","note","ants","wood"}, new String[]{"wood","joke","moat"}));
        System.out.println("[] == " + wwteod.twoEditWords(new String[]{"yes"}, new String[]{"not"}));
    }

    public void mostPopularVideoCreator() {
        MostPopularVideoCreator mpvc = new MostPopularVideoCreator();

        System.out.println("[alice, one],[bob, two] == " + mpvc.mostPopularCreator(new String[]{"alice","bob","alice","chris"},
            new String[]{"one","two","three","four"}, new int[]{5,10,5,4}));

        System.out.println("[alice, b] == " + mpvc.mostPopularCreator(new String[]{"alice","alice","alice"},
            new String[]{"a","b","c"}, new int[]{1,2,2}));

        System.out.println("[a,a] == " + mpvc.mostPopularCreator(new String[]{"a"},
            new String[]{"a"}, new int[]{0}));
    }
}
